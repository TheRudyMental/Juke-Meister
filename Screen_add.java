package screen;

import java.io.File;

import control.DB_Controller;
import Database.SongDatabaseIF;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
/**
 *
 * @author JamieBurchette
 *
 * This method was created by Zachary Lorenzo, but logic was created by Jamie. credit where credit is due
 *
 */
public class Screen_add extends GridPane implements ScreenInterface {
	private static Screen_add instance;
	protected SongDatabaseIF db;
	private Button back;
	private Button pictureButton;
	private Button fileButton;
	private FileChooser fileChooser;
	protected TextField title;
	protected TextField artist;
	protected TextField year;
	protected File picture;
	protected File file;

	protected Screen_add() {
		setConstraints();
		makeComponents();
	}
	public static ScreenInterface getInstance(){
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_add();
			return instance;
		}
	}
	private void setConstraints(){
		int columnNumber = 3;
		int rowNumber = 7;
		for(int i = 0; i < columnNumber;i++){
			ColumnConstraints col0 = new ColumnConstraints();
			if(i == 1){
				col0.setPercentWidth(60);
			}
			else {
				col0.setPercentWidth(20);
			}
			this.getColumnConstraints().add(col0);
		}

		for(int i = 0; i<rowNumber;i++){
			RowConstraints row0 = new RowConstraints();
			row0.setPercentHeight(10);
			this.getRowConstraints().add(row0);
		}
	}
	private void makeComponents(){
		back = new Button("Back");
		GridPane.setHalignment(back, HPos.LEFT);
		GridPane.setValignment(back, VPos.TOP);
		back.setMinSize(0, 0);
		back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		back.getStyleClass().add("but");
		this.add(back,0,0,1,1);

		fileChooser = new FileChooser();
   	 	fileChooser.setTitle("Open Resource File");

   	 	db=new DB_Controller();

		title = new TextField();
		artist = new TextField();
		year = new TextField();

		title.setPromptText("Enter Title");
		title.getStyleClass().add("text");
		artist.setPromptText("Enter Artist");
		artist.getStyleClass().add("text");
		year.setPromptText("Enter Release Year");
		year.getStyleClass().add("text");

		this.add(title, 1,2,1,1);
		this.add(artist, 1,3,1,1);
		this.add(year, 1,4,1,1);

		Label pictureLabel = new Label("Picture:");
		pictureLabel.getStyleClass().add("label");
		Label fileLabel = new Label("File:");
		fileLabel.getStyleClass().add("label");

		this.add(pictureLabel, 0,5,1,1);
		this.add(fileLabel, 0,6,1,1);
		GridPane.setHalignment(pictureLabel, HPos.RIGHT);
		GridPane.setHalignment(fileLabel, HPos.RIGHT);

		pictureButton = new Button("Browse");
		pictureButton.getStyleClass().add("but");
		pictureButton.setOnAction(buttonHandler);
		fileButton = new Button("Browse");
		fileButton.getStyleClass().add("but");
		fileButton.setOnAction(buttonHandler);

		pictureButton.setPrefSize(200, 50);
		pictureButton.setMinSize(0, 0);

		fileButton.setPrefSize(200, 50);
		fileButton.setMinSize(0, 0);

		this.add(pictureButton, 2,5,1,1);
		this.add(fileButton, 2,6,1,1);
		back.setOnAction(buttonHandler);
	}
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()== back){
        	temp.setScene(ScreenBuilder.buildScreen2b());
        	temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            temp.setFullScreen(true);
            temp.show();
        }
        else if(event.getSource() == fileButton){
        	fileChooser.getExtensionFilters().clear();
        	fileChooser.getExtensionFilters().addAll(
        	         new ExtensionFilter("Audio Files", "*.wav", "*.mp3"));
        	file = fileChooser.showOpenDialog(temp);

        }
        else if(event.getSource() == pictureButton){
        	fileChooser.getExtensionFilters().clear();
        	fileChooser.getExtensionFilters().addAll(
        	         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        	picture = fileChooser.showOpenDialog(temp);
        }
        }

    };
    EventHandler<InputEvent> keyHandler = new EventHandler<InputEvent>(){
    	public void handle(InputEvent e){
    		if(e instanceof KeyEvent){
            	KeyEvent key = (KeyEvent) e;
            	if(key.getCode()==KeyCode.Q){
            		db.dropTable();
            		System.out.println("cleared");
            	}
    	}
    	}
    };
}

