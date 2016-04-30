package testing;

import static org.junit.Assert.*;



import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import Database.SongIF;
import control.SongFactory;

//#############################################################################
/**
 * 
 * @author Saige Kittel
 * 
 * A simple test class to test the operation of Song class.
 *
 */
//#############################################################################

public class SongTesting {



	static SongIF song;/**The Song  for testing**/

	//=======================================================================
	/**
	 * One time set up.
	 */
	//=======================================================================
	@BeforeClass
	public static void oneTimeSetUp() {

		System.out.println("@BeforeClass - oneTimeSetUp");
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
		song = null;
	}//=====================================================================

	
	/**
	 * Test that getWeekCount is initially 0.
	 */
	//=======================================================================  
	@Test
	public void testFirstGetWeekCount(){
		System.out.println("Test that weekCount is initially set to 0");
		assertEquals(0,song.getWeekCount());
	}//=======================================================================  

	/**
	 * Test setWeekCount to 30.
	 */
	//=======================================================================  
	@Test
	public void testSetWeekCount(){
		System.out.println("Test setWeekCount to 30.");
		song.setWeekCount(30);
		assertEquals(30,song.getWeekCount());
	}//=======================================================================  

	/**
	 * Test that checks reset week counter.
	 */
	//=======================================================================  
	@Test
	public void testResetWeek(){
		song.setWeekCount(552);
		System.out.println("Test that resets week counter");
		song.resetWeek();
		assertEquals(0,song.getWeekCount());
	}//=======================================================================  

	/**
	 * Test that getMonthCount is initially 0.
	 */
	//=======================================================================  
	@Test
	public void testFirstGetMonthCount(){
		System.out.println("Test that month count is initially set to 0");
		assertEquals(0,song.getMonthCount());
	}//=======================================================================  

	/**
	 * Test setMonthCount to 78.
	 */
	//=======================================================================  
	@Test
	public void testSetMonthCount(){
		System.out.println("Test setMonthCount to 78.");
		song.setMonthCount(78);
		assertEquals(78,song.getMonthCount());
	}//=======================================================================  

	/**
	 * Test that checks reset month  counter.
	 */
	//=======================================================================  
	@Test
	public void testResetMonth(){
		song.setMonthCount(65);
		System.out.println("Test that resets month counter");
		song.resetMonth();
		assertEquals(0,song.getMonthCount());
	}//=======================================================================  

	/**
	 * Test that add count adds 1 to weekcounter and monthcounter
	 */
	//=======================================================================  
	@Test
	public void testAddCount(){
		song.resetMonth();
		song.resetWeek();
		System.out.println("Test that adds one to month and week counter");
		song.addCount();
		assertEquals(1,song.getMonthCount());
		assertEquals(1,song.getWeekCount());
	}//=======================================================================  
		
	/**
	 * Test set Title
	 */
	//=======================================================================  
	@Test
	public void testSetTitle(){
		song.setTitle("New title");
		System.out.println("Test that makes sure the title is correctly set.");
		assertSame("New title",song.getTitle());
	}//=======================================================================  
	
	/**
	 * Test set Artist
	 */
	//=======================================================================  
	@Test
	public void testSetArtist(){
		song.setArtist("New artist");
		System.out.println("Test that makes sure the artist is correctly set.");
		assertSame("New artist",song.getArtist());
	}//=======================================================================  
	
	/**
	 * Test set year
	 */
	//=======================================================================  
	@Test
	public void testSetYear(){
		song.setYear(8542);
		System.out.println("Test that makes sure the year is correctly set.");
		assertEquals(8542,song.getYear());
	}//=======================================================================  
	
	/**
	 * Test set Song File
	 */
	//=======================================================================  
	@Test
	public void testSetSongFile(){
		File songFile = new File("Newsongfile.mp3");
		song.setSongFile(songFile);
		System.out.println("Test that makes sure the new song file is "
				+ "correctly set.");
		assertSame(songFile,song.getSongFile());
	}//=======================================================================  
	
	/**
	 * Test set Picture File
	 */
	//=======================================================================  
	@Test
	public void testSetPictureFile(){
		File picFile = new File("Newpicfile.jpg");
		song.setPicture(picFile);
		System.out.println("Test that makes sure the new picture file"
				+ " is correctly set.");
		assertEquals(picFile,song.getPicture());
	}//=======================================================================  
	
	
	/**
	 * Test that compares two identical songs with the equals method
	 */
	//=======================================================================  
	@Test
	public void testEqualsTrue(){
		SongIF song1 = song;
		
		System.out.println("Test that ompares song and song1 with"
				+  " equals method");
		assertTrue(song.equals(song1));
	}//=======================================================================  
		
	/**
	 * Test that compares two different songs with the equals method
	 */
	//=======================================================================  
	@Test
	public void testEqualsFalse(){
		SongIF song1 = SongFactory.makeSong("Steal Your Heart", "Augustana", 1973, 
				new File("stealyourheart.mp3"), new File("mountains.jpg"));
		
		System.out.println("Test that compares song and song1 with"
				+  " equals method");
		assertFalse(song.equals(song1));
	}//=======================================================================  
		
	
}
