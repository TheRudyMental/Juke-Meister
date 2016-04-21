package screen;

import javafx.scene.layout.Pane;

public class UIBuilder {
	private static Screen_1 screen1;
	private static Screen_1A screen1a;
	private static Screen_2 screen2;
	private static Screen_2A screen2a;
	private static Screen_2A1 screen2a1;
	private static Screen_2b screen2b;
	private static Screen_2B1 screen2b1;
	private static Screen_2B2 screen2b2;
	private static Screen_2C screen2c;
	private static Screen_2D screen2d;
	private static Screen_2D1 screen2d1;
	private static Screen_2b3 screen2b3;

	public static Pane getScreen_1(){
		if(screen1 == null)
			screen1 = new Screen_1();
		return screen1;
	}

	public static Screen_1A getScreen_1A(){
		if(screen1a == null)
			screen1a = new Screen_1A();
		return screen1a;
	}

	public static Screen_2 getScreen_2(){
		if(screen2 == null)
			screen2 = new Screen_2();
		return screen2;
	}
	public static Screen_2A getScreen_2A(){
		if(screen2a == null)
			screen2a = new Screen_2A();
		return screen2a;
	}
	public static Screen_2A1 getScreen_2A1(){
		if(screen2a1 == null)
			screen2a1 = new Screen_2A1();
		return screen2a1;
	}
	//Screen_2B
	public static Screen_2b getScreen_2B(){
		if(screen2b == null){
			screen2b = new Screen_2b();
		}
		return screen2b;
	}
	public static Screen_2B1 getScreen_2B1(){
		if(screen2b1 == null)
			screen2b1= new Screen_2B1();
		return screen2b1;
	}

	public static Screen_2B2 getScreen_2B2(){
		if(screen2b2 == null)
			screen2b2 = new Screen_2B2();
		return screen2b2;
	}

	public static Screen_2b3 getScreen_2b3(){
		if(screen2b3 == null)
			screen2b3 = new Screen_2b3();
		return screen2b3;
	}
	public static Screen_2C getScreen_2C(){
		if(screen2c == null)
			screen2c = new Screen_2C();
		return screen2c;
	}
	public static Screen_2D getScreen_2D(){
		if(screen2d == null)
			screen2d = new Screen_2D();
		return screen2d;
	}
	public static Screen_2D1 getScreen_2D1(){
		if(screen2d1 == null)
			screen2d1 = new Screen_2D1();
		return screen2d1;
	}

}
