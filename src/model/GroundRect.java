/**
 * 
 */
package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

/**
 * @author Bilal
 *
 */


public class GroundRect extends Rectangle {

	/**
	 * @param p
	 * @param w
	 * @param l
	 * @param colour
	 * @param t
	 */
	
	private final Image diffuseMap = new Image("file:images/grass.jpg");

	public GroundRect(Vec2 p, float w, float l) {
		super(p, w, l, Color.BLUE, BodyType.STATIC);
		if (Settings.isGraphics3D()) {
			shape3D.setTranslateZ(-100);
			shape3D.setScaleZ(2);
			texture = new PhongMaterial(Color.WHITE, diffuseMap, null, null, null);
			shape3D.setMaterial(texture);
		}
			
	}

}
