package screen;



import java.util.Collections;
import java.util.List;

import control.DB_Controller;
import Database.SongCountSorter;
import Database.SongDateSorter;
import control.CreditObserver;
import control.Credits;
import control.SongUIIF;
import control.CreditsIF;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Screen_1 extends GridPane implements ScreenInterface,CreditObserver,control.VenueAndMessageListener{

	private static Screen_1 instance;
	/*Button used for browsing*/
	private Button browse;
	/*Label to tell user the amount of credits they have*/
	private Label credit;
	/*Label to hold the venue name, blank by default*/
	private Label vName;
	/*Label to hold message entered by admin, blank by default*/
	private Label message;

	Label nowPlaying;

	Screen_1() {
		setConstraints();
		makeComponents();
		Credits.register(this);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void makeComponents(){
		Screen_2D1.register(this);
		this.setOnKeyPressed(keyHandler);
		vName = new Label("");
		vName.getStyleClass().add("label");
		message = new Label("");
		message.getStyleClass().add("label");
	    credit = new Label("Credits: ");
	    credit.getStyleClass().add("label");

		this.add(vName,1,0,1,1);
		this.add(message,1,1,1,1);
		this.add(credit, 1, 2, 1, 1);

		browse = new Button("Browse");
		browse.setOnAction(buttonHandler);
		browse.getStyleClass().add("but");
		this.add(browse,1,4,1,1);


		Label pop = new Label("Popular Songs");
		pop.getStyleClass().add("label");
		Label newSongs = new Label("New Songs");
		newSongs.getStyleClass().add("label");

		this.add(pop,0,2,1,1);
		this.add(newSongs,2,2,1,1);

		DB_Controller db = new DB_Controller();

		VBox poplist = new VBox();
		Collections.sort((List) db.songs,new SongCountSorter());
		for(int i=0; i<9; i++){
			if(db.songs.size()!=0)
			poplist.getChildren().add(SongUIIF.makeElement(db.songs.get(i)));
		}

		VBox newlist = new VBox();
		Collections.sort((List)db.songs,new SongDateSorter());
		for(int i=0; i<9; i++){
			if(db.songs.size()!=0)
			newlist.getChildren().add(SongUIIF.makeElement(db.songs.get(i)));
		}

		nowPlaying = new Label(""); //make this its own component later
		this.add(nowPlaying,1,5,1,1);

		ScrollPane sc1 = new ScrollPane(poplist);
		ScrollPane sc2 = new ScrollPane(newlist);

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

    /**
     * sets all of the elements to be aligned to the center of the row
     * 		and column that it is in
     */
	void setCenterAlignment(){
		ObservableList<Node> elements = this.getChildren();
		for(Node i:elements){
			GridPane.setHalignment(i,HPos.CENTER);
		}
	}

	EventHandler<InputEvent> keyHandler = new EventHandler<InputEvent>() {
        @Override
        public void handle(InputEvent event) {
        	CreditsIF control = Credits.getInstance();
        	if(event instanceof KeyEvent){
        		KeyEvent key = (KeyEvent) event;
        		switch(key.getCode()){
        			case X:
        				control.insertMoney(0.05);
        				break;
        			case C:
        				control.insertMoney(0.1);
        				break;
        			case V:
        				control.insertMoney(0.25);
        				break;
        			case B:
        				control.insertMoney(1.0);
        				break;
        			case N:
        				control.insertMoney(5.0);
        				break;
        			default:
						break;

        		}
        	}
        }
    };

	@Override
	public void update(int credits) {
		credit.setText("Credits: " + credits);
	}

	@Override
	public void updateVenueName(String newName) {
		System.out.println("Venue name is now: " + newName);
		vName.setText(newName);
	}

	@Override
	public void updateMessage(String newMessage) {
		System.out.println("Message is now: " + newMessage);
		message.setText(newMessage);
	}
	public void updateNowPlaying(String playing){
		nowPlaying.setText(playing);
	}
}
