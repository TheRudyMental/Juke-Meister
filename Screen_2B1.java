package Screen;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


/**
 * Add Single screen
 * 
 * @author JamieBurchette, ZacharyLorenzo
 * @version 4/11/16
 *
 */
public class Screen_2B1 extends Screen_add implements ScreenInterface{

	private static Screen_add instance;

	Screen_2B1() {
		new Screen_add();
		Button addSingle = new Button("Add Single");
		this.add(addSingle, 1,1,1,1);
		GridPane.setHalignment(addSingle, HPos.CENTER);
		addSingle.setPrefSize(400, 75);
		addSingle.setMinSize(0, 0);
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
			instance = new Screen_2B1();
			return instance;
		}
	}

}