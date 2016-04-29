package screen;

import control.Credits;
import control.CreditsIF;
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
 * Stats screen
 *
 * @author JamieBurchette
 * @version 4/8/16
 *
 */
public class Screen_2A extends GridPane implements ScreenInterface,control.MoneyListener{

	private static Screen_2A instance;

	private Button back;

	private Button table;

	TextField currentFunds;

	Screen_2A() {
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
			instance = new Screen_2A();
			return instance;
		}
	}

	/**
	 * This method is a helper to the constructor of the class to make itself
	 * without having an extremely long constructor
	 *
	 */
	private void setConstraints(){
		int columnNumber = 4;
		int rowNumber = 6;
		for(int i = 0; i < columnNumber;i++){
			ColumnConstraints col0 = new ColumnConstraints();
			if(i == 0 || i == 3){
				col0.setPercentWidth(20);
			}
			else {
				col0.setPercentWidth(30);
			}
			this.getColumnConstraints().add(col0);
		}

		for(int i = 0; i<rowNumber;i++){
			RowConstraints row0 = new RowConstraints();
			if(i == 0 || i == 1 || i == 3 || i == 4 || i == 5){
				row0.setPercentHeight(10);
			}
			else if(i == 2){
				row0.setPercentHeight(50);
			}
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
		back.getStyleClass().add("but");
		back.setOnAction(buttonHandler);

		Label topTracks = new Label("Top Tracks");
		topTracks.getStyleClass().add("label");

		Label leastPlayed = new Label("Least Played");
		leastPlayed.getStyleClass().add("label");

		this.add(topTracks,1,1,1,1);
		this.add(leastPlayed,2,1,1,1);

		GridPane.setHalignment(topTracks, HPos.CENTER);
		GridPane.setHalignment(leastPlayed,HPos.CENTER);

		Label totalFunds = new Label("Total Funds:");

		GridPane textGrid = new GridPane();
		for(int i = 0; i < 3; i++){
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth(33);
			textGrid.getColumnConstraints().add(col);
		}

		currentFunds = new TextField();
		currentFunds.getStyleClass().add("text");
		currentFunds.setEditable(false);

		this.add(totalFunds,1,3,2,1);
		textGrid.add(currentFunds,1,0,1,1);
		this.add(textGrid, 1,4,2,1);

		GridPane.setHalignment(totalFunds,HPos.CENTER);
		GridPane.setHalignment(currentFunds,HPos.CENTER);

		table = new Button("Table of Previous Weeks");
		this.add(table,1,5,2,1);
		GridPane.setHalignment(table,HPos.CENTER);
		table.setPrefSize(200, Double.MAX_VALUE);
		table.setMinSize(0, 0);
		table.setOnAction(buttonHandler);
		table.getStyleClass().add("but");
	}
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2());

        }
        if(event.getSource()==table){
        	temp.setScene(ScreenBuilder.buildScreen2a1());
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };

	@Override
	public void updateMoney(double money){
		currentFunds.setText("" + money);
	}

}
