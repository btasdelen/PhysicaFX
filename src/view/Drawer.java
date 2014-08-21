/**
 * 
 */
package view;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

/**
 * @author lubuntu
 *
 */
public class Drawer {
	
	private static Point2D p2;
	private static Point2D p1;
	private static InGameScene scene;
	private static Circle crc = new Circle(40, 40, 40);
	private static double radius;

	public Drawer(InGameScene scn) {
		scene = scn;
		scene.objects.getChildren().add(crc);
		crc.setVisible(false);
	}

	public static void show() {
		if (!crc.isVisible()){
			crc.setVisible(true);
		}
		
		radius = p1.distance(p2)/2;
		crc.relocate(p1.getX()-radius, p1.getY()-radius);
		crc.setRadius(radius);
	}
	
	public static void setP1(Point2D pressed){
		p1 = pressed;
	}

	public static void setP2(Point2D pressed) {
		p2 = pressed;
		
	}

	public static void draw() {
		// TODO Auto-generated method stub
		
	}

	public static Point2D getP1() {
		return p1;
	}

}
