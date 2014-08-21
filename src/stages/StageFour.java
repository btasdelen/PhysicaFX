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
public class StageFour extends Stage {
	


	private Rectangle rect;
	private Rectangle rect2;
	private Rectangle rect3;

	

	public StageFour() {
		super(new Vec2(25, 70));
		
		addMainBall();

		ff.setPos(new Vec2(95 ,56.5f));


		rect = new Rectangle(new Vec2(20, 50), 600, 15, Color.GRAY, BodyType.STATIC);
		rect2 = new Rectangle(new Vec2(52, 51), 440, 5, Color.GREEN, BodyType.KINEMATIC);
		rect3 = new Rectangle(new Vec2(85, 50), 600, 15, Color.GRAY, BodyType.STATIC);

		
		rect2.body.m_angularVelocity = -.5f;

		WorldController.addObject(rect);
		WorldController.addObject(rect3);

		WorldController.addObject(rect2);





	}
	


}
