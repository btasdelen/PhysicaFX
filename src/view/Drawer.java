/**
 * 
 */
package view;

import model.GameObject;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import controller.WorldController;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author lubuntu
 *
 */
public class Drawer {
	
	private static Point2D p2;
	private static Point2D p1;
	private static InGamePane scene;
	private static Circle crc = new Circle(1, 1, 1);
	private static Rectangle rect = new Rectangle(1, 1);
	private static double radius;
	private static double width;
	private static double height;
	private static boolean isRect;
	private static boolean isPaused;

	public Drawer(InGamePane scn) {
		scene = scn;
		scene.objects.getChildren().addAll(crc, rect);
		crc.setVisible(false);
		crc.setFill(Color.DARKRED);
		rect.setVisible(false);
		rect.setFill(Color.DARKRED);
		isRect = true;
	}

	public static void show() {
		if (!isPaused) {
			if (isRect)
				showRect();
			else
				showCirc();
		}
	}
	
	
	private static void showRect() {
		if (!rect.isVisible()){
			rect.setVisible(true);
		}
		
		width = Math.abs(p1.getX() - p2.getX());
		height = Math.abs(p1.getY() - p2.getY());
		rect.relocate(Math.max(p1.getX(), p2.getX()) - width/2, Math.max(p1.getY(), p2.getY()) - height/2);
		rect.setScaleX(width);
		rect.setScaleY(height);
		
		
	}
	
	private static void showCirc() {
		if (!crc.isVisible()){
			crc.setVisible(true);
		}
		
		radius = p1.distance(p2) / 2;
		crc.relocate((p1.getX() + p2.getX())/2 - radius, (p1.getY() + p2.getY())/2 - radius);
		crc.setRadius(radius);
	}
	
	public static void setP1(Point2D pressed){
		p1 = pressed;
	}

	public static void setP2(Point2D pressed) {
		p2 = pressed;
		
	}

	public static void draw() {
		if (!isPaused) {
			if (isRect)
				drawRect();
			else
				drawCirc();
		}
	}
	
	private static void drawRect() {
		rect.setVisible(false);
		model.Rectangle obj = (new model.Rectangle(new Vec2(GameObject.javaToBoxX((float) ((p1.getX() + p2.getX())/2f)), 
				GameObject.javaToBoxY((float) (p1.getY() + p2.getY())/2f)), 
				GameObject.javaToBoxWidth((float) (width)),  GameObject.javaToBoxHeight((float) (height)),
				Color.BLUE, BodyType.DYNAMIC));
		WorldController.addObject(obj);
		scene.objects.getChildren().add(obj.shape3D());
	}
	
	private static void drawCirc() {
		crc.setVisible(false);
		model.Circle obj = (new model.Circle(new Vec2(GameObject.javaToBoxX((float) ((p1.getX() + p2.getX())/2f)), 
				GameObject.javaToBoxY((float) (p1.getY() + p2.getY())/2f)), GameObject.javaToBoxRadius((float) (radius)), 
				Color.BLUE, BodyType.DYNAMIC));
		WorldController.addObject(obj);
		scene.objects.getChildren().add(obj.shape3D());
	}


	public static Point2D getP1() {
		return p1;
	}

	public void setRect() {
		isRect = true;
	}
	
	public void setCirc() {
		isRect = false;
	}

	public void pause() {
		isPaused = true;
	}
	
	public  void resume()  {
		isPaused = false;
	}

}
