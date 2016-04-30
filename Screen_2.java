package screen;



import control.PlayControl;
import control.SongUIIF;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


 /**
  * Admin main screen
  * @author saige.kittel, zachary.lorenzo
  * @version 4/29/16
  */
 public class Screen_2 extends GridPane implements ScreenInterface{\
 	//A singleton instance of screen
	 private static Screen_2 instance;
	 
	 //Buttons to change screen
	 private Button back;
 	 //private Button stat;
 	 private Button lib;
 	 private Button credit;
 	 private Button extra;


/**
 * Initiates the screen
 */
 Screen_2() {
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
 			instance = new Screen_2();
 			return instance;
 		}
 	}



 	/**

 	 * This method is a helper to the constructor of the class to make itself

 	 * without having an extremely long constructor

 	 *

 	 */

 	private void setConstraints(){
 	     ColumnConstraints col1 = new ColumnConstraints();
 	     col1.setPercentWidth(20);
 	     ColumnConstraints col2 = new ColumnConstraints();
 	     col2.setPercentWidth(60);
 	     ColumnConstraints col3 = new ColumnConstraints();
 	     col3.setPercentWidth(20);
 	     this.getColumnConstraints().addAll(col1,col2,col3);

 	     RowConstraints row1 = new RowConstraints();
 	     row1.setPercentHeight(10);
 	     RowConstraints row2 = new RowConstraints();
 	     row2.setPercentHeight(60);
 	     RowConstraints row3 = new RowConstraints();
 	     row3.setPercentHeight(30);
 	     this.getRowConstraints().addAll(row1,row2,row3);
 	}



 	/**

 	 * This method defines the components on the screen and adds them to it.

 	 */

 	private void makeComponents(){

 		back = new Button("Back");
 		back.setOnAction(buttonHandler);
 		back.setMinSize(0, 0);
 		back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
 		back.getStyleClass().add("but");
 		this.add(back,0,0);

 		VBox vbox = new VBox();
        	vbox.setAlignment(Pos.CENTER);

 		Label volume = new Label("Volume");
 		volume.getStyleClass().add("label");
 		vbox.getChildren().add(volume);

 		Slider volumeSlider = new Slider();
 		volumeSlider.setPrefWidth(70);
 		volumeSlider.setMaxWidth(Double.MAX_VALUE);
 		volumeSlider.setMinWidth(0);
 		volumeSlider.adjustValue(50);
 		volumeSlider.valueProperty().addListener(valueHandler);
 		vbox.getChildren().add(volumeSlider);

 		VBox.setVgrow(vbox, Priority.ALWAYS);
 		this.add(vbox, 1, 2);

 		GridPane gridpane2 = new GridPane();//another grid layout inside the grid
 		ColumnConstraints subcol1 = new ColumnConstraints();
 		subcol1.setPercentWidth(40);
 		ColumnConstraints subcol2 = new ColumnConstraints();
 		subcol2.setPercentWidth(20);
 		ColumnConstraints subcol3 = new ColumnConstraints();
 		subcol3.setPercentWidth(40);

 	    gridpane2.getColumnConstraints().addAll(subcol1,subcol2,subcol3);


 	    RowConstraints subrow1 = new RowConstraints();
 		subrow1.setPercentHeight(40);
 		RowConstraints subrow2 = new RowConstraints();
 		subrow2.setPercentHeight(20);
 		RowConstraints subrow3 = new RowConstraints();
 		subrow3.setPercentHeight(40);

 		gridpane2.getRowConstraints().addAll(subrow1,subrow2,subrow3);

 		/*stat = new Button("Statistics Screen");
 		stat.setMinSize(0, 0);
		stat.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
 		stat.setWrapText(true);
 		stat.setOnAction(buttonHandler);
 		stat.getStyleClass().add("but");
 		gridpane2.add(stat,0,0);*/

 		lib = new Button("Song Library");
 		lib.setOnAction(buttonHandler);
 		lib.setMinSize(0, 0);
 		lib.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
 		lib.setWrapText(true);
 		lib.getStyleClass().add("but");
 		gridpane2.add(lib,2,0);

 		credit = new Button("Credit Options");
 		credit.setOnAction(buttonHandler);
 		credit.setMinSize(0, 0);
 		credit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
 		credit.setWrapText(true);
 		credit.getStyleClass().add("but");
 		gridpane2.add(credit,0,2);

 		extra = new Button("Extra Options");
 		extra.setOnAction(buttonHandler);
 		extra.setMinSize(0, 0);
 		extra.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
 		extra.setWrapText(true);
 		extra.getStyleClass().add("but");
 		gridpane2.add(extra,2,2);
 		this.add(gridpane2,1,1);





 	}//end makeComponents
 	
 	/**Eventhandler to allow the user to press buttons and switch screens
 	 * @author zachary.lorenzo
 	 */
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen1());
        }
        /*if(event.getSource()==stat){
        	temp.setScene(ScreenBuilder.buildScreen2a());
        }*/
        if(event.getSource()==lib){
        	temp.setScene(ScreenBuilder.buildScreen2b());
        }
        if(event.getSource()==credit){
        	temp.setScene(ScreenBuilder.buildScreen2c());
        }
        if(event.getSource()==extra){
        	temp.setScene(ScreenBuilder.buildScreen2d1());
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };
    //Allows admin to change the song volume
    ChangeListener<Number> valueHandler = new ChangeListener<Number>(){

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			if(!oldValue.equals(newValue))
			   PlayControl.getInstance().changeSongVolume(newValue.intValue());

		}
    };

 }


