package screen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * Credit Options screen
 * 
 * @author JamieBurchette
 * @version 4/29/16
 *
 */
public class Screen_2C extends GridPane implements ScreenInterface{
	//Singleton instance of screen
	private static Screen_2C instance;
	
	//Button to return to previous screen
	private Button back;

	/**
	 * initiates the screen
	 */
	Screen_2C() {
		setConstraints();
		makeComponents();
	}

	/**
	 * The getInstance method returns the singleton instance of the screen
	 *  @return instance
	 */
	public static ScreenInterface getInstance(){
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_2C();
			return instance;
		}
	}

	/**
	 * This method is a helper to the constructor of the class to make itself
	 * without having an extremely long constructor
	 *
	 */
	private void setConstraints(){
		int columnNumber = 3;
		int rowNumber = 5;
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


	/**
	 * This method defines the components on the screen and adds them to it.
	 */
	private void makeComponents(){
		back = new Button("Back");
		this.add(back,0,0,1,1);
		GridPane.setHalignment(back, HPos.LEFT);
		GridPane.setValignment(back, VPos.TOP);
		back.setMinSize(0, 0);
		back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		back.setOnAction(buttonHandler);
		back.getStyleClass().add("but");
		
		TextField pricePerCredit = new TextField();
		TextField buy = new TextField();
		TextField get = new TextField();
		
		pricePerCredit.setPromptText("Price Per Credit");
		pricePerCredit.getStyleClass().add("text");
		buy.setPromptText("Buy:");
		buy.getStyleClass().add("text");
		get.setPromptText("Get:");
		get.getStyleClass().add("text");
		
		this.add(pricePerCredit, 1,1,1,1);
		this.add(buy, 1,3,1,1);
		this.add(get, 1,4,1,1);
		
		Label creditsPerBonus = new Label("Credits Per Bonus:");
		creditsPerBonus.getStyleClass().add("label");
		GridPane.setHalignment(creditsPerBonus, HPos.CENTER);
		this.add(creditsPerBonus, 1,2,1,1);
		}
	//Lets the back button go to previous screen	
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2());
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };
}

