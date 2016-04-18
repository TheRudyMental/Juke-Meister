package Screen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class Screen_2B extends GridPane implements ScreenInterface{

	private static Screen_2B instance;
	
	Button back;
	Button single;
	Button album;
	Button song;

	Screen_2B() {
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
			instance = new Screen_2B();
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
	     col1.setPercentWidth(15);
	     ColumnConstraints col2 = new ColumnConstraints();
	     col2.setPercentWidth(15);
	     ColumnConstraints col3 = new ColumnConstraints();
	     col3.setPercentWidth(40);
	     ColumnConstraints col4 = new ColumnConstraints();
	     col4.setPercentWidth(30);
	     this.getColumnConstraints().addAll(col1,col2,col3,col4);

	     RowConstraints row1 = new RowConstraints();
	     row1.setPercentHeight(10);
	     RowConstraints row2 = new RowConstraints();
	     row2.setPercentHeight(10);
	     RowConstraints row3 = new RowConstraints();
	     row3.setPercentHeight(60);
	     RowConstraints row4 = new RowConstraints();
	     row4.setPercentHeight(30);
	    
	     this.getRowConstraints().addAll(row1,row2,row3,row4);

	}

	/**
	 * This method defines the components on the screen and adds them to it.
	 */
	private void makeComponents(){

		back = new Button("Back");
		back.setOnAction(buttonHandler);
		back.setMinSize(0, 0);
		back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.add(back,0,0);
	
		

		GridPane gridpane2 = new GridPane();
		
		//another grid layout inside the grid
		RowConstraints subrow1 = new RowConstraints();
		subrow1.setPercentHeight(20);
		RowConstraints subrow2 = new RowConstraints();
		subrow2.setPercentHeight(20);
		RowConstraints subrow3 = new RowConstraints();
		subrow3.setPercentHeight(20);
		RowConstraints subrow4 = new RowConstraints();
		subrow4.setPercentHeight(20);
		RowConstraints subrow5 = new RowConstraints();
		subrow5.setPercentHeight(20);
	    gridpane2.getRowConstraints().addAll(subrow1,subrow2,subrow3,subrow4,subrow5);
		
	    ColumnConstraints subcol = new ColumnConstraints();
	    subcol.setPercentWidth(100);
	    gridpane2.getColumnConstraints().addAll(subcol);
	 
		single = new Button("Add Single");
		single.setOnAction(buttonHandler);
		single.setMinSize(0, 0);
		single.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		single.setWrapText(true);
		gridpane2.add(single,0,0);
		
		
		album = new Button("Add Album");
		album.setOnAction(buttonHandler);
		album.setMinSize(0, 0);
		album.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		album.setWrapText(true);
		gridpane2.add(album,0,2);
		
		
		song = new Button("Remove Song");
		song.setOnAction(buttonHandler);
		song.setMinSize(0, 0);
		song.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		song.setWrapText(true);
		gridpane2.add(song,0,4);
		
		
		
		this.add(gridpane2,2,2);
		
	
	}//end makeComponents
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2());
        }
        if(event.getSource()==single){
        	temp.setScene(ScreenBuilder.buildScreen2b1());
        }
        if(event.getSource()==album){
        	temp.setScene(ScreenBuilder.buildScreen2b2());
        }
        temp.setFullScreen(true);
        temp.show();
        }
    };
}
