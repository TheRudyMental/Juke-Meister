package screen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * Remove song screen to search and remove songs
 * @author Saige Pattel
 * @version 4/29/16
 */
public class Screen_2B3 extends GridPane implements ScreenInterface {

	private static Screen_2B3 instance;
	Button back;

	Screen_2B3(){
		setConstraints();
		makeComponents();
	}

	public static ScreenInterface getInstance(){
		if(instance != null){
			return instance;
		}
		else{
			instance = new Screen_2B3();
			return instance;
		}
	}

	private void setConstraints(){
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(60);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(20);

		RowConstraints row0 = new RowConstraints();
		row0.setPercentHeight(10);
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(80);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(10);

		this.getColumnConstraints().addAll(col0, col1, col2);
		this.getRowConstraints().addAll(row0, row1, row2);

	}

	private void makeScale(Button b){
		b.setMinHeight(0);
		b.setMaxHeight(Double.MAX_VALUE);
		b.setMinWidth(0);
		b.setMaxWidth(Double.MAX_VALUE);
	}
	private void makeScale(TextField t){
		t.setMinHeight(0);
		t.setMaxHeight(Double.MAX_VALUE);
		t.setMinWidth(0);
		t.setMaxWidth(Double.MAX_VALUE);
	}

	private void makeComponents(){
		back = new Button("Back");
		back.setOnAction(buttonHandler);
		back.getStyleClass().add("but");
		this.add(back,0,0);

		TextField search = new TextField();
		search.setPromptText("Search...");
		//Listener
		makeScale(search);
		search.getStyleClass().add("but");
		this.add(search,1,0);

		Button sort = new Button("Sort by Popularity");
		//add handler
		makeScale(sort);
		sort.getStyleClass().add("but");
		this.add(sort, 2, 0);


		GridPane atoz = new GridPane();
		ColumnConstraints third = new ColumnConstraints();
		third.setPercentWidth(33);
		atoz.getColumnConstraints().addAll(third,third,third);
		for(int i=0; i<26; i++){
			RowConstraints arow = new RowConstraints();
			arow.setPercentHeight(4);
			atoz.getRowConstraints().add(arow);
			Label l = new Label(((char)('A'+i))+"");
			setHalignment(l, HPos.CENTER);
			//AddInvisButtonsHere
			atoz.add(l , 1, i);
		}
		this.add(atoz,0,1);


		ScrollPane songlist = new ScrollPane();
		songlist.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		songlist.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.add(songlist,1,1,2,1);

		Button delete = new Button("Delete");
		makeScale(delete);
		delete.getStyleClass().add("but");
		this.add(delete, 2, 2);

	}
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        Stage temp = (Stage)((Node) event.getSource()).getScene().getWindow();
        if(event.getSource()==back){
        	temp.setScene(ScreenBuilder.buildScreen2b());

        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };



}
