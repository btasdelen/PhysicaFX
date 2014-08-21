/**
 * 
 */
package stages;

import javafx.scene.paint.Color;

import model.Rectangle;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import controller.WorldController;

/**
 * @author bilal
 *
 */
public class StageTwo extends Stage {
	


	private Rectangle rect;
	private Rectangle rect2;
	

	public StageTwo() {
		super(new Vec2(20, 90));
		
		addMainBall();

		ff.setPos(new Vec2(83 ,56.5f));


		rect = new Rectangle(new Vec2(15, 85), 300, 30, Color.GRAY, BodyType.STATIC);
		rect2 = new Rectangle(new Vec2(80, 50), 300, 30, Color.GREEN, BodyType.STATIC);


		WorldController.addObject(rect);
		WorldController.addObject(rect2);


	}
	


}
