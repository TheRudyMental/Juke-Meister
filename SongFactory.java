package control;

import java.io.File;

import control.Song;

public class SongFactory {
	public static Song makeSong(String title, String artist, int year, File song, File picture){
		return new Song(title, artist, year, song, picture);
	}

}
