package Screen;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Stats screen
 * 
 * @author JamieBurchette
 * @version 4/8/16
 *
 */
public class Screen_2A extends GridPane implements ScreenInterface{

	private static Screen_2A instance;

	private Screen_2A() {
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
		Button backButton = new Button("Back");
		this.add(backButton,0,0,1,1);
		GridPane.setHalignment(backButton, HPos.LEFT);
		GridPane.setValignment(backButton, VPos.TOP);
		backButton.setMinSize(0, 0);
		backButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				
		Label topTracks = new Label("Top Tracks");
		Label leastPlayed = new Label("Least Played");

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
		
		TextField currentFunds = new TextField();
		currentFunds.setEditable(false);

		this.add(totalFunds,1,3,2,1);
		textGrid.add(currentFunds,1,0,1,1);
		this.add(textGrid, 1,4,2,1);
		
		GridPane.setHalignment(totalFunds,HPos.CENTER);
		GridPane.setHalignment(currentFunds,HPos.CENTER);
		
		Button table = new Button("Table of Previous Weeks");
		this.add(table,1,5,2,1);
		GridPane.setHalignment(table,HPos.CENTER);
		table.setPrefSize(200, Double.MAX_VALUE);
		table.setMinSize(0, 0);
	}

}
