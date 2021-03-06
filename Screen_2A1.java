package screen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 * Table of previous weeks screen
 * @author Zachary Lorenzo
 * @version 4/29/16
 */
public class Screen_2A1 extends GridPane implements ScreenInterface {
	//Singleton instance of screen
	private static Screen_2A1 instance;
	
	//Button for going to previous screen
	private Button back;
	
	/**
	 * initializes the screen
	 */
	Screen_2A1(){
		setConstraints();
		makeComponents();
	}
	
	/**
	 * Singleton method to return screen
	 * @return instance
	 * ?
	 */ 
	public static ScreenInterface getInstance(){
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_2A1();
			return instance;
		}
	}
	
	/**
	 * Defines rows and columns of the screen's grid
	 */
	private void setConstraints(){
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(60);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(20);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(10);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(10);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(70);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(10);
		
		this.getColumnConstraints().setAll(col1,col2,col3);
		this.getRowConstraints().setAll(row1,row2,row3);
	}
	
	/**
	 * Resizes button to fit available size
	 * @param b the button to resize
	 */
	private void setup(Button b){
		b.setMinSize(0, 0);
		b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	
	/**
	 * Creates and adds components to the screen
	 */
	private void makeComponents(){
		
		back = new Button("Back");
		setup(back);
		back.setOnAction(buttonHandler);
		back.getStyleClass().add("but");
		this.add(back, 0, 0);
		
		Label text = new Label("Table of Previous Weeks");
		GridPane.setHalignment(text, HPos.CENTER);
		text.getStyleClass().add("label");
		this.add(text, 1, 1);
		
		TableView<Object> statistics = new TableView<Object>();
		ObservableList<Object> data = FXCollections.observableArrayList();
		//add data
		statistics.setItems(data);
		this.add(statistics, 1, 2);
		
		
		
		
		
	}
	
	//Allows the admin to go to previous screen
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2a());
 
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };

}
