package Screen;

import javafx.scene.Scene;

public class ScreenBuilder {
	private static Scene screen1;
	private static Scene screen1a;
	private static Scene screen2;
	private static Scene screen2a;
	private static Scene screen2a1;
	private static Scene screen2b;
	private static Scene screen2b1;
	private static Scene screen2b2;
	private static Scene screen2c;
	private static Scene screen2d;
	private static Scene screen2d1;
	
	public static Scene buildScreen1(){
		if(screen1 == null){
			screen1 = new Scene(UIBuilder.getScreen_1());
		}
		return screen1;
	}
	
	public static Scene buildScreen1a(){
		if(screen1a == null){
			screen1a = new Scene(UIBuilder.getScreen_1A());
		}
		return screen1a;
	}
	public static Scene buildScreen2(){
		if(screen2 == null){
			screen2 = new Scene(UIBuilder.getScreen_2());
		}
		return screen2;
	}
	public static Scene buildScreen2a(){
		if(screen2a == null){
			screen2a = new Scene(UIBuilder.getScreen_2A());
		}
		return screen2a;
	}
	public static Scene buildScreen2a1(){
		if(screen2a1 == null){
			screen2a1 = new Scene(UIBuilder.getScreen_2A1());
		}
		return screen2a1;
	}
	public static Scene buildScreen2b(){
		if(screen2b == null){
			screen2b = new Scene(UIBuilder.getScreen_1());
		}
		return screen2b;
	}
	public static Scene buildScreen2b1(){
		if(screen2b1 == null){
			screen2b1 = new Scene(UIBuilder.getScreen_2B1());
		}
		return screen2b1;
	}
	public static Scene buildScreen2b2(){
		if(screen2b2 == null){
			screen2b2 = new Scene(UIBuilder.getScreen_2B2());
		}
		return screen2b2;
	}
	public static Scene buildScreen2c(){
		if(screen2c == null){
			screen2c = new Scene(UIBuilder.getScreen_2C());
		}
		return screen2c;
	}
	public static Scene buildScreen2d(){
		if(screen2d == null){
			screen2d = new Scene(UIBuilder.getScreen_2D());
		}
		return screen2d;
	}
	public static Scene buildScreen2d1(){
		if(screen2d1 == null){
			screen2d1 = new Scene(UIBuilder.getScreen_2D1());
		}
		return screen2d1;
	}

}
