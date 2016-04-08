package Screen;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/*
 * @author Grant Brown
 * This class is to define the Extra Options screen
 */

public class Screen_2D extends GridPane implements ScreenInterface{

	private static Screen_2D instance;

	private Screen_2D() {
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
		Button back = new Button("Back");
		back.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		this.add(back, 0, 0);




		HBox attract = new HBox();
		Label at = new Label("Attract: ");
		Button toggle1 = new Button("On/Off"); //TODO: add toggle functionality later
		toggle1.setPrefSize(200,25);
		attract.getChildren().addAll(at,toggle1);
		attract.setSpacing(30);

		TextField minutes = new TextField();
		minutes.setPromptText("Enter Timer (In minutes):");//TODO: add data entry functionality
		minutes.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		HBox screenSaver = new HBox();
		Label screen = new Label("Screen Saver: ");
		Button toggle2 = new Button("On/Off");
		toggle2.setPrefSize(200, 25);
		screenSaver.getChildren().addAll(screen,toggle2);
		screenSaver.setSpacing(30);

		Button advanced = new Button("Advanced Options");
		advanced.setWrapText(true);
		advanced.setPrefSize(150,100);

		VBox whole = new VBox();
		whole.getChildren().addAll(attract,minutes,screenSaver,advanced);
		whole.setFillWidth(false);
		whole.setSpacing(30);
		whole.setPadding(new Insets(150, 0, 0, 300));
		this.add(whole, 1, 1,1,1);

		setHalignment(whole, HPos.CENTER);
		setValignment(whole, VPos.CENTER);
	}
}
