package control;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
/*
 * This class is to define the user interface elements that the songs will
 * 	be made of
 * @author Grant Brown
 */
public class SongUI extends HBox implements SongUIIF{
	/*Song object that contains the info about the song*/
	SongIF song;
	/*The title of the song*/
	Label title;
	/*The artist of the song*/
	Label artist;
	/*The release year of the song*/
	Label year;

	SongUI(SongIF s){
		song = s;
		title = new Label();
		artist= new Label();
		year = new Label();
		this.getChildren().addAll(title,artist,year);
		this.setSpacing(30);
		setText(song.getTitle(), song.getArtist(), song.getYear());
		this.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				//TODO: Add to prompt for play song
			}
		});
	}

	/*
	 * The purpose of this method is to set the text for the labels
	 *    that make up the UI element defined by this class
	 * @param name the name of the song
	 * @param art the name of the artist
	 * @param yr the integer value representing the release year of the song
	 */
	private void setText(String name, String art, int yr){
		title.setText(name);
		artist.setText(art);
		year.setText("" + yr);
	}


}
