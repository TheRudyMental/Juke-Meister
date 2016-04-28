package Screen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * @author Grant Brown
 * This class is to define the Extra Options screen
 */

public class Screen_2D extends GridPane implements ScreenInterface{

	private static Screen_2D instance;

	private Button back;

	private Button advanced;

	Screen_2D() {
		setContraints();
		setupComponents();
	}

	public static ScreenInterface getInstance() {
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_2D();
			return instance;
		}
	}

	private void setContraints(){
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(80);
		this.getColumnConstraints().addAll(col0,col1);

		RowConstraints row0 = new RowConstraints();
		row0.setPercentHeight(20);
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(80);
		this.getRowConstraints().addAll(row0,row1);
	}

	private void setupComponents(){
		back = new Button("Back");
		back.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		back.setOnAction(buttonHandler);
		back.getStyleClass().add("but");
		this.add(back, 0, 0);




		HBox attract = new HBox();
		Label at = new Label("Attract: ");
		at.getStyleClass().add("label")
		Button toggle1 = new Button("On/Off"); //TODO: add toggle functionality later
		toggle1.setPrefSize(200,25);
		toggle1.getStyleClass().add("but");
		attract.getChildren().addAll(at,toggle1);
		attract.setSpacing(30);

		TextField minutes = new TextField();
		minutes.setPromptText("Enter Timer (In minutes):");//TODO: add data entry functionality
		minutes.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		minutes.getStyleClass().add("text");

		HBox screenSaver = new HBox();
		Label screen = new Label("Screen Saver: ");
		screen.getStyleClass().add("label");
		Button toggle2 = new Button("On/Off");
		toggle2.setPrefSize(200, 25);
		toggle2.getStyleClass().add("but")
		screenSaver.getChildren().addAll(screen,toggle2);
		screenSaver.setSpacing(30);

		advanced = new Button("Advanced Options");
		advanced.setWrapText(true);
		advanced.setPrefSize(150,100);
		advanced.setOnAction(buttonHandler);
		advanced.getStyleClass().add("but");

		VBox whole = new VBox();
		whole.getChildren().addAll(attract,minutes,screenSaver,advanced);
		whole.setFillWidth(false);
		whole.setSpacing(30);
		whole.setPadding(new Insets(150, 0, 0, 300));
		this.add(whole, 1, 1,1,1);

		setHalignment(whole, HPos.CENTER);
		setValignment(whole, VPos.CENTER);
	}
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2());
        }
        if(event.getSource()==advanced){
        	temp.setScene(ScreenBuilder.buildScreen2d1());
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };
}
