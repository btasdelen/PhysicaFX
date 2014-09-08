/**
 * 
 */
package view;

import model.GameObject;
import model.MainBall;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import controller.WorldController;
import javafx.geometry.Point2D;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author lubuntu
 *
 */
public class Drawer {
    public enum DrawType {
        LAUNCHER, RECTANGLE, CIRCLE}
    
    private static DrawType dt;
    private static MainBall mb;
	
	private static Point2D p2;
	private static Point2D p1;
	private static InGamePane scene;
	private static Circle crc = new Circle(1, 1, 1);
	private static Rectangle rect = new Rectangle(1, 1);
	private static final Arc bar = new Arc();

	private static double radius;
	private static double width;
	private static double height;
	private static boolean isPaused;
	
	private static final Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.33, Color.RED), new Stop(0.66, Color.YELLOW), new Stop(1, Color.GREEN)};
	private static RadialGradient rg;
	public Drawer(InGamePane scn) {
		scene = scn;
		scene.objects.getChildren().addAll(crc, rect, bar);
		crc.setVisible(false);
		crc.setFill(Color.DARKRED);
		rect.setVisible(false);
		rect.setFill(Color.DARKRED);
		bar.setVisible(false);
		bar.setType(ArcType.ROUND);
		bar.setEffect(new DropShadow(5, 5, 5, Color.BLACK));

		setRect();
		isPaused = false;
	}

	public static void show() {
		if (!isPaused) {

			switch (dt) {
			case RECTANGLE: 
				showRect();
				break;
			case CIRCLE:
				showCirc();
				break;
			case LAUNCHER:
				showLauncherBar();
				break;

			}
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
	
	private static void showLauncherBar() {
		if(!bar.isVisible())
			bar.setVisible(true);
		
		rg = new RadialGradient(0, .1, p2.getX(), p2.getY(), p1.distance(p2), false, CycleMethod.NO_CYCLE, stops);

		bar.setFill(rg);

		bar.setCenterX(p2.getX());
		bar.setCenterY(p2.getY());
		bar.setRadiusX(p1.distance(p2));
		bar.setRadiusY(p1.distance(p2));
		bar.setLength(10);
		bar.setStartAngle(Math.toDegrees(Math.PI - Math.atan2(p2.getY()-p1.getY(), p2.getX() - p1.getX())) - 5);
		scene.rotateLauncher((float) (Math.toDegrees(Math.PI + Math.atan2(p2.getY()-p1.getY(), p2.getX() - p1.getX()))));
		
	}
	
	public static void setP1(Point2D pressed){
		p1 = pressed;
	}

	public static void setP2(Point2D pressed) {
		p2 = pressed;
		
	}

	public static void draw() {
		if (!isPaused) {
			switch (dt) {
			case CIRCLE:
				drawCirc();
				break;
			case LAUNCHER:
				launch();
				break;
			case RECTANGLE:
				drawRect();
				break;

			}
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
		dt = DrawType.RECTANGLE;
	}
	
	public void setCirc() {
		dt = DrawType.CIRCLE;
	}
	
	public void setLauncher(MainBall mb) {
		Drawer.mb = mb;
		dt = DrawType.LAUNCHER;
	}

	public static void launch() {
		bar.setVisible(false);
		mb.body.applyForceToCenter(new Vec2((float) (100*(p1.getX()-p2.getX())), (float) (-100*(p1.getY() - p2.getY()))));
		dt = DrawType.RECTANGLE;
		scene.finishLaunchMode();
	}
	
	public void pause() {
		isPaused = true;
	}
	
	public  void resume()  {
		isPaused = false;
	}

}
