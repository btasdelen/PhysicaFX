/**
 * 
 */
package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Stop;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

/**
 * @author bilal
 *
 */
public class MainBall extends Circle implements Controllable {

	private final static int RADIUS = 2; 
	
	private final static Paint COLOUR = Color.WHITE;
	
	private final Image diffuseMap = new Image("file:images/ball.jpg");
	public MainBall(Vec2 p) {
		super(p, RADIUS, COLOUR, BodyType.DYNAMIC);
		radius = RADIUS;
		pos = p;
		isMain = true;
		if (!Settings.isGraphics3D()) {
			shape2D.setFill(new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new
					Stop[]{
					new Stop(0, Color.web("#f8bd55")),
					new Stop(0.14, Color.web("#c0fe56")),
					new Stop(0.28, Color.web("#5dfbc1")),
					new Stop(0.43, Color.web("#64c2f8")),
					new Stop(0.57, Color.web("#be4af7")),
					new Stop(0.71, Color.web("#ed5fc2")),
					new Stop(0.85, Color.web("#ef504c")),
					new Stop(1, Color.web("#f2660f"))}));
		}
		
		else {
			texture = new PhongMaterial(Color.WHITE, diffuseMap, null, null, null);
			shape3D.setMaterial(texture);
		}
	}
}
