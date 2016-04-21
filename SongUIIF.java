package control;

import javafx.scene.control.Label;

/*
 * @author Grant Brown
 * The SongUIIF is an interface utilized by the SongUI class in order
 *    for the classes that use it to have certainty with what methods
 *    will be implemented in that class
 */
public interface SongUIIF {

	/*
	 * The makeElement method is a statc factory method to decrease
	 *    dependency on classes that use the Song User Interface
	 *    element defined by the SongUI class
	 *    @param song the song to make an element of
	 *    @return the element of that song
	 */
	public static SongUI makeElement(SongIF song){
		SongUI result = new SongUI(song);

		return result;
	}

}
