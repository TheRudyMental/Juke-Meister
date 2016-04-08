package Screen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * @author Grant Brown
 * This class is to define the advanced options screen for the screen saver
 */
public class Screen_2D1 extends BorderPane implements ScreenInterface{

	private static Screen_2D1 instance;

	private Screen_2D1() {
		makeComponents();
	}

	public static ScreenInterface getInstance() {
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_2D1();
			return instance;
		}
	}

	private void makeComponents(){
		Button back = new Button("Back");
		back.setMaxSize(75, Integer.MAX_VALUE);
		this.setTop(back);


		VBox contain = new VBox();//thing to put in center

		VBox fields = new VBox();//box to put text fields in
		TextField time = new TextField();
		time.setPromptText("Enter Timer (In Minutes):");

		TextField vName = new TextField();
		vName.setPromptText("Enter Venue Name:");

		TextField message = new TextField();
		message.setPromptText("Enter Message:");

		fields.getChildren().addAll(time,vName,message);
		fields.setSpacing(20);
		fields.setAlignment(Pos.CENTER);

		HBox picture = new HBox(); // thing to hold picture label and button
		Label pic = new Label("Picture: ");
		Button fileUpload = new Button("Browse");

		picture.getChildren().addAll(pic,fileUpload);
		picture.setSpacing(75);

		contain.getChildren().addAll(fields,picture);
		contain.setFillWidth(false);
		contain.setSpacing(20);
		contain.setPadding(new Insets( 250, 0, 0, 600));
		this.setCenter(contain);

	}

}
