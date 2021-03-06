package control;

import java.net.MalformedURLException;

import Database.SongIF;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/*
 * This class is to define the user interface elements that the songs will
 * 	be made of
 * @author Grant Brown
 */
public class SongUI extends HBox implements SongUIIF{
	/*Song object that contains the info about the song*/
	SongIF song;
	/*Picture for the song to be displayed*/
	ImageView pic;
	/*The title of the song*/
	Label title;
	/*The artist of the song*/
	Label artist;
	/*The release year of the song*/
	Label year;

	public SongUI(SongIF s){
		song = s;
		try {
			pic=new ImageView(new Image(s.getPicture().toURI().toURL().toString()));
			pic.setFitHeight(30);
			pic.setFitWidth(100);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		title = new Label();
		artist= new Label();
		year = new Label();
		this.getChildren().addAll(pic,title,artist,year);
		this.setSpacing(250);
		setText(song.getTitle(), song.getArtist(), song.getYear());
		this.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				PlayControlInf play = PlayControl.getInstance();
				CreditsIF check = Credits.getInstance();
				if(check.getTotalCredits() <= 0){
					Alert alert = new Alert(AlertType.INFORMATION);
	        		alert.setTitle("No Credits!");
	        		alert.setContentText("You must have credit in the" +
	        							" machine before playing a song.");
	        		alert.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
	        		alert.showAndWait();
				}
				else{
					play.playSong(song);
					check.removeWhenPlay();
				}
			}
		});
		this.getStyleClass().add("song");
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
