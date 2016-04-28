package screen;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Screen_2B2 extends Screen_add implements ScreenInterface {
	
	private static Screen_add instance;

	Screen_2B2() {
		new Screen_add();
		Button addAlbum = new Button("Add Album");
		this.add(addAlbum, 1,1,1,1);
		GridPane.setHalignment(addAlbum, HPos.CENTER);
		addAlbum.setPrefSize(400, 75);
		addAlbum.setMinSize(0, 0);
		addAlbum.getStyleClass().add("but");
	}
	public static ScreenInterface getInstance(){
		if(instance != null){
			return instance;
		}
		else{
			instance =  new Screen_2B2();
			return instance;
		}
	}
	
	
}




