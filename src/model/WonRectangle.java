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
public class WonRectangle extends Rectangle {

	/**
	 * @param p
	 * @param w
	 * @param l
	 * @param colour
	 * @param t
	 */
	
	private Image img = new Image("file:images/complete.png");
	
	public WonRectangle() {
		super(new Vec2(javaToBoxWidth(SCREEN_WIDTH/2) + 20, 110), 20, 3, Color.TRANSPARENT, BodyType.DYNAMIC);
		if (Settings.isGraphics3D()) {
			texture = new PhongMaterial(Color.WHITE, img, null, null, null);
			shape3D.setMaterial(texture);
		}
	}

}
