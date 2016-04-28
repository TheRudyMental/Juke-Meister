package screen;

import java.util.ArrayList;

import control.Credits;
import control.VenueAndMessageListener;
import controller.CreditsIF;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * @author Grant Brown
 * This class is to define the advanced options screen for the screen saver
 */
public class Screen_2D1 extends BorderPane implements ScreenInterface,control.VenueAndMessageSubject{

	private static Screen_2D1 instance;
	/*Back button for this screen*/
	private Button back;
	/*Text field for the venue name*/
	private TextField vName;
	/*Text field for the message to be displayed*/
	private TextField message;

	private static ArrayList<VenueAndMessageListener> o;
	Screen_2D1() {
		makeComponents();
		o = new ArrayList<VenueAndMessageListener>();
	}

	/**
	 * This method returns the singleton instance of this screen
	 * @return the singleton instance of this screen
	 */
	public static ScreenInterface getInstance() {
		if(instance == null){
			instance = new Screen_2D1();
			return instance;
		}
		else{
			return instance;
		}
	}

	/**
	 * Creates all the components on the screen at once
	 */
	private void makeComponents(){
		this.setOnKeyPressed(keyHandler);

		back = new Button("Back");
		back.setMaxSize(75, Integer.MAX_VALUE);
		back.setOnAction(buttonHandler);
		back.getStyleClass().add("but");
		this.setTop(back);


		VBox contain = new VBox();//thing to put in center

		VBox fields = new VBox();//box to put text fields in
		TextField time = new TextField();
		time.setPromptText("Enter Timer (In Minutes):");
		time.getStyleClass().add("text");

		vName = new TextField();
		vName.setPromptText("Enter Venue Name:");
		vName.getStyleClass().add("text");

		message = new TextField();
		message.setPromptText("Enter Message:");
		message.getStyleClass().add("text");

		fields.getChildren().addAll(time,vName,message);
		fields.setSpacing(20);
		fields.setAlignment(Pos.CENTER);

		HBox picture = new HBox(); // thing to hold picture label and button
		Label pic = new Label("Picture: ");
		Button fileUpload = new Button("Browse");
		fileUpload.getStyleClass().add("but");

		picture.getChildren().addAll(pic,fileUpload);
		picture.setSpacing(75);

		contain.getChildren().addAll(fields,picture);
		contain.setFillWidth(false);
		contain.setSpacing(20);
		contain.setPadding(new Insets( 250, 0, 0, 600));
		this.setCenter(contain);


	}

	/**
	 * Set up the keyboard for all the text fields
	 */
	public void setUpKeyboard(){
		vName.getProperties().put("vkType", "full");
		message.getProperties().put("vkyType", "full");
	}
	/**
	 * Handler for the buttons on screen
	 */
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2d());
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };

    EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
        		if(event.getCode() == KeyCode.ENTER){
        			System.out.println("Enter Pressed");
        			System.out.println("notifying");
        			notifyListeners(vName.getText(),message.getText());
        		}
        }
    };

    /**
     * @see VenueAndMessageSubject
     */
	@Override
	public void notifyListeners(String venueName, String message) {
		for(VenueAndMessageListener vml : o){
			System.out.println("Notifying all ");
			if(venueName != null){
				System.out.println("Setting Venue Name");
				vml.updateVenueName(venueName);
			}
			if(message != null){
				System.out.println("Setting message");
				vml.updateMessage(message);
			}
		}
	}

	public static void register(VenueAndMessageListener vml){
		getInstance();
		System.out.println("Adding");
		o.add(vml);
	}

}
