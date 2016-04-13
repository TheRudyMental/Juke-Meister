package application;



import Screen.Screen_1A;
import Screen.Screen_2A;
import Screen.Screen_2A1;
import Screen.Screen_2B1;
import Screen.Screen_2B2;
import Screen.Screen_2C;
import Screen.Screen_2D;
import Screen.Screen_2D1;
import Screen.UIBuilder;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {

	private Pane root;

	private Scene scene;
	
	private static Main instance;
	
	boolean runOnce = true;

	public enum S {SCREEN_1,SCREEN_1A,SCREEN_2,SCREEN_2A,SCREEN_2A1,SCREEN_2B,SCREEN_2B1,SCREEN_2B2,
					SCREEN_2B3,SCREEN_2C,SCREEN_2D,SCREEN_2D1};
	@Override
	public void start(Stage primaryStage) {
		try{ 
			Pane root = UIBuilder.getScreen_1();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}


	
}
