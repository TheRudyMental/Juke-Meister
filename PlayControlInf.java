package control;

/**
 *
 * @author Grant
 * This interface is to correspond to the PlayControl class that will
 *   handle the playing of the songs.
 */
public interface PlayControlInf {
	/**
	 * The playSong method is to either play the song if no other song is playing
	 *   or to add it to a queue if one is
	 * @param s the song to be played
	 */
	public void playSong(SongIF s);

	/**
	 * This method is to change the volume that the song is being played at
	 * @param volume the new volume of the song
	 */
	public void changeSongVolume(double volume);
}
