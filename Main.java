package application;

import Screen.ScreenInterface;
import Screen.Screen_1;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	private Pane root;

	private Scene scene;

	public enum Screens {SCREEN_1, SCREEN_1A,SCREEN_2,SCREEN_2A, SCREEN_2A1,SCREEN_2B,SCREEN_2B1,SCREEN_2B2,
					SCREEN_2B3,SCREEN_2C,SCREEN_2D,SCREEN_2D1};
	@Override
	public void start(Stage primaryStage) {
		try {
			switchUI(Screens.SCREEN_1);
			scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void switchUI(Screens screen){
		switch(screen){
			case SCREEN_1:
					root = (Pane) Screen_1.getInstance();
					break;
			case SCREEN_1A:
					root = (Pane) Screen_1A.getInstance();
					break;
			case SCREEN_2:
				break;
			case SCREEN_2A:
					root = (Pane) Screen_2A.getInstance();
					break;
			case SCREEN_2A1:
				break;
			case SCREEN_2B:
				break;
			case SCREEN_2B1:
					root = (Pane) Screen_2B1.getInstance();
					break;
			case SCREEN_2B2:
				break;
			case SCREEN_2B3:
				break;
			case SCREEN_2C:
					root = (Pane) Screen_2C.getInstance();
					break;
			case SCREEN_2D:
					root = (Pane) Screen_2D.getInstance();
					break;
			case SCREEN_2D1:
					root = (Pane) Screen_2D1.getInstance();
					break;
			default:
				break;
		}

		if(scene == null){
			scene = new Scene(root,400,400);
		}
		else{
			scene.setRoot(root);
		}
	}
}
