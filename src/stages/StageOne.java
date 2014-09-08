/**
 * 
 */
package stages;

import javafx.scene.paint.Color;
import model.Circle;
import model.GroundRect;
import model.Rectangle;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import controller.WorldController;

/**
 * @author bilal
 *
 */
public class StageOne extends Stage {
	

	private Rectangle rect;
	private Rectangle rect2;
	private Rectangle rect3;

	private Circle cr;
	

	public StageOne() {
		super(new Vec2(25, 70));


	}
	
	@Override
	public void setupStage() {
		super.setupStage();
		addMainBall();

		ff.setPos(new Vec2(85 , 57));


		cr = new Circle(new Vec2(50, 50), 2, Color.CYAN, BodyType.STATIC);
		rect = new GroundRect(new Vec2(20, 50), 15, 0.5f);
		rect3= new GroundRect(new Vec2(75, 50), 15, 0.5f);

		rect2 = new Rectangle(new Vec2(49, 51), 15, 0.1f, Color.GREEN, BodyType.DYNAMIC);

		WorldController.addObject(cr);
		WorldController.addObject(rect);
		WorldController.addObject(rect2);
		WorldController.addObject(rect3);
	}
	


}
