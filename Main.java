package application;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import screen.ScreenBuilder;


public class Main extends Application {

	private Scene scene;
	
	private static Main instance;
	
	boolean runOnce = true;
	
	@Override
	public void start(Stage primaryStage) {
		try{ 
			scene = ScreenBuilder.buildScreen1();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.setOnKeyPressed(keyHandler);
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
	EventHandler<InputEvent> keyHandler = new EventHandler<InputEvent>() {
        @Override
        public void handle(InputEvent event) {
        Stage temp = (Stage) scene.getWindow();
        if(event instanceof KeyEvent){
        	KeyEvent key = (KeyEvent) event;
        	if(key.getCode()==KeyCode.A){
        		temp.setScene(ScreenBuilder.buildScreen2());
        		
        	}
        }
        temp.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        temp.setFullScreen(true);
        temp.show();
        }
    };


	
}
