package control;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import screen.ScreenInterface;
import screen.Screen_1;
import screen.Screen_1A;
import screen.UIBuilder;

/**
 *
 * @author Grant
 * This class handles the playing of songs
 */
public class PlayControl implements PlayControlInf{
	//Tells if there is a song playing currently or not
	private boolean playing;
	//Singleton instance of the play control
	private static PlayControl instance;
	//Holds all the songs to play
	ArrayList<MediaPlayer> toPlay;

	private MediaPlayer current;

	private PlayControl() {
		playing = false;
		toPlay = new ArrayList<MediaPlayer>();
	}

	public static PlayControlInf getInstance(){
		if(instance == null){
			instance = new PlayControl();
		}
		return instance;
	}

	/**
	 * @see PlayControlInf
	 */
	@Override
	public void playSong(SongIF s) {
		//SongDatabaseIF db = new DB_Controller();
		s.addCount();
		//db.update(s);
		MediaPlayer temp = new MediaPlayer(new Media((s.getSongFile().toURI()).toString()));
		toPlay.add(temp);

		if(!playing){
			play();
		}
	}

	/**
	 * Plays the first song in the list to play
	 */
	public void play(){
		current = pop();
		current.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				play();
			}
		});
		current.setOnPlaying(new Runnable(){
			@Override
			public void run() {
				playing = true;
				Screen_1 sc = (Screen_1) Screen_1.getInstance();
				Screen_1A sca = (Screen_1A) Screen_1A.getInstance();
				String st = current.getMedia().getSource();
				File tmp = new File(st);
				String name = (tmp.getName().replace("%20", " "));
				sc.updateNowPlaying(name.substring(0, (name.length()-4)));
				sca.updateNowPlaying(name.substring(0, (name.length()-4)));
			}
		});
		current.play();
	}

	/**
	 * @see PlayControlInf
	 */
	@Override
	public void changeSongVolume(double volume) {
		if(current != null){
			current.setVolume(volume);
		}
	}

	public MediaPlayer pop(){
		MediaPlayer play = toPlay.get(0);
		toPlay.remove(0); //get the thing from front of list then remove it
		return play;
	}
}
