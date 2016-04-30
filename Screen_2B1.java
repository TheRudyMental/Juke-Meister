package screen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Add Single screen adds a single song to the database
 *
 * @author JamieBurchette, ZacharyLorenzo
 * @version 4/29/16
 *
 */
public class Screen_2B1 extends Screen_add implements ScreenInterface{

	//Singleton instance of the screen
	private static Screen_add instance;

	/**
	 * Initiates the screen and adds the addSingle button
	 */
	Screen_2B1() {
		new Screen_add();
		Button addSingle = new Button("Add Single");
		this.add(addSingle, 1,1,1,1);
		GridPane.setHalignment(addSingle, HPos.CENTER);
		addSingle.setPrefSize(400, 75);
		addSingle.setMinSize(0, 0);
		addSingle.setOnAction(add);
		addSingle.getStyleClass().add("but");
	}

	//Eventhandler to send song information to the database
	EventHandler<ActionEvent> add = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	if(!(title == null || artist == null ||
        			year == null) && !(title.getText().isEmpty()||
        		    artist.getText().isEmpty()|| year.getText().isEmpty())){
        		db.addRecord(title.getText(), artist.getText(), Integer.parseInt(year.getText()),file, picture);
        	}
        	else{
        		//Alerts the admin if necessary information is missing
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Error!");
        		alert.setContentText("The title, artist, and year fields cannot be empty!");
        		alert.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
        		alert.showAndWait();
        	}
        }
    };
	/**
	 * The getInstance method returns the singleton instance of the screen
	 *  @return instance
	 */
	public static ScreenInterface getInstance(){
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_2B1();
			return instance;
		}
	}

}
