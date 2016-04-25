package Screen;



import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Screen_1 extends GridPane implements ScreenInterface{

	private static Screen_1 instance;
	
	private Button browse;

	Screen_1() {
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
			instance = new Screen_1();
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
		int rowNumber = 6;
		for(int i = 0; i < columnNumber;i++){
			ColumnConstraints col0 = new ColumnConstraints();
			col0.setPercentWidth(40);
			if(i == 1){
				col0.setPercentWidth(20);
			}//end if
			this.getColumnConstraints().add(col0);
		}//end for

		for(int i = 0; i<rowNumber;i++){
			RowConstraints row0 = new RowConstraints();
			row0.setPercentHeight(10);
			if(i == 1){//if its the message row
				row0.setPercentHeight(5);
			}
			else if(i == 3){//the list's row
				row0.setPercentHeight(50);
			}
			else if(i == 4){//the browse button
				row0.setPercentHeight(15);
			}
			this.getRowConstraints().add(row0);
		}//end for
	}//end setConstraints


	/**
	 * This method defines the components on the screen and adds them to it.
	 */
	private void makeComponents(){
		Label vName = new Label("Venue Name");
		Label message = new Label("Message");

		this.add(vName,1,0,1,1);
		this.add(message,1,1,1,1);


		Label pop = new Label("Popular Songs");
		Label newSongs = new Label("New Songs");

		this.add(pop,0,2,1,1);
		this.add(newSongs,2,2,1,1);
		
		

		//The list stuff will go here, empty for now

		browse = new Button("Browse");
		browse.setOnAction(buttonHandler);
		browse.getStyleClass().add("but");
		this.add(browse,1,4,1,1);

		Label nowPlaying = new Label("Now Playing"); //make this its own component later
		this.add(nowPlaying,1,5,1,1);

		ScrollPane sc1 = new ScrollPane();
		ScrollPane sc2 = new ScrollPane();

		sc1.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sc1.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		sc2.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sc2.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		this.add(sc1,0,3,1,1);


		this.add(sc2,2,3,1,1);

		setCenterAlignment();
	}//end makeComponents
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==browse){
        	temp.setScene(ScreenBuilder.buildScreen1a());
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };

	void setCenterAlignment(){
		ObservableList<Node> elements = this.getChildren();
		for(Node i:elements){
			GridPane.setHalignment(i,HPos.CENTER);
		}
	}

}
