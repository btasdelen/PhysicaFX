/**
 * 
 */
package stages;

import javafx.scene.paint.Color;

import model.Circle;
import model.Rectangle;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import controller.WorldController;

/**
 * @author bilal
 *
 */
public class StageFive extends Stage {
	


	private Rectangle rect;
	private Rectangle rect2;
	private Circle cr;
	

	public StageFive() {
		super(new Vec2(25, 70));
		
		//setMainBallPos();
		addMainBall();

		ff.setPos(new Vec2(95 ,56.5f));


		cr = new Circle(new Vec2(55, 50), 30, Color.CYAN, BodyType.STATIC);
		rect = new Rectangle(new Vec2(25, 50), 600, 15, Color.GRAY, BodyType.STATIC);
		rect2 = new Rectangle(new Vec2(54, 51), 600, 5, Color.GREEN, BodyType.DYNAMIC);


		WorldController.addObject(cr);
		WorldController.addObject(rect);
		WorldController.addObject(rect2);





	}
	


}
