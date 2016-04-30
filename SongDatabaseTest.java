package testing;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import control.DB_Controller;
import Database.SongIF;
import control.SongFactory;


//#############################################################################
/**
 *
 * @author Saige Kittel
 *
 * A simple test class to test the operation of DB_Controller class.
 *
 */
//#############################################################################


public class SongDatabaseTest {

	static DB_Controller songDB;/**The Song  for testing**/
	static SongIF song;

	/**
	 * One time set up.
	 */
	//=======================================================================
	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("@BeforeClass - oneTimeSetUp");
		songDB = new DB_Controller();
		song = SongFactory.makeSong("Want You Back", "Jackson 5", 2061,
				new File("wantYouBack.mp3"), new File("saigeSelfie.jpg"));

	}//=====================================================================

	//=======================================================================
	/**
	 * One time tear down.
	 */
	//=======================================================================
	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
		songDB = null;
	}//=====================================================================

	/**
	 * Test that a song is added to the database
	 */
	//=======================================================================
	@Test
	public void testAdd1() {
		songDB.add(song);
		System.out.println("Test that adds 1 song to the database.");
		assertEquals(1, songDB.getSize());
	}//=======================================================================

	/**
	 * Test that a song is added to the database
	 */
	//=======================================================================
	@Test
	public void testAddMany() {
		songDB.add(song);
		songDB.add(song);
		System.out.println("Test that adds 1 song to the database.");
		assertEquals(2, songDB.getSize());
	}//=======================================================================


	/**
	 * Test that a song is removed
	 */
	//=======================================================================
	@Test
	public void testRemove() {
		songDB.remove(song);
		System.out.println("Test that removes a song");
		assertEquals(1, songDB.getSize());
	}//=======================================================================


	/**
	 * Test that a song is removed from the database
	 */
	//=======================================================================
	@Test
	public void testRemoveByTitle() {
		songDB.removeByTitle(song.getTitle());
		System.out.println("Test that removes 1 song to the database.");
		assertEquals(0, songDB.getSize());
	}//=======================================================================







}
