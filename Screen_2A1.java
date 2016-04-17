package Screen;

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

public class Screen_2A1 extends GridPane implements ScreenInterface {
	
	private static Screen_2A1 instance;
	
	private Button back;
	
	Screen_2A1(){
		setConstraints();
		makeComponents();
	}
	
	public static ScreenInterface getInstance(){
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_2A1();
			return instance;
		}
	}
	
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
	
	private void setup(Button b){
		b.setMinSize(0, 0);
		b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	private void makeComponents(){
		
		back = new Button("Back");
		setup(back);
		back.setOnAction(buttonHandler);
		this.add(back, 0, 0);
		
		Label text = new Label("Table of Previous Weeks");
		GridPane.setHalignment(text, HPos.CENTER);
		this.add(text, 1, 1);
		
		TableView<Object> statistics = new TableView<Object>();
		ObservableList<Object> data = FXCollections.observableArrayList();
		//add data
		statistics.setItems(data);
		this.add(statistics, 1, 2);
		
		
		
		
		
	}
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2a());
 
        }
        temp.setFullScreen(true);
        temp.show();
        }
    };

}
