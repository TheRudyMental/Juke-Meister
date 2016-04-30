package control;

import java.io.File;

import Database.Song;

/**
 * Creates a song object
 * @author Zacharay Larenzo
 * @version 4/29/16
 */
public class SongFactory {
	
	/**
	 * Returns a song based on the given values
	 * @param title title of song
	 * @param artist artist who performed song
	 * @param year year song was released
	 * @param songFile File that contains song
	 * @param picture image file to accompany song
	 */
	public static Song makeSong(String title, String artist, int year, File song, File picture){
		return new Song(title, artist, year, song, picture);
	}

}
