/**
 * 
 */
package stages;

import model.GroundRect;
import model.Launcher;
import model.Rectangle;

import org.jbox2d.common.Vec2;
import controller.WorldController;

/**
 * @author bilal
 *
 */
public class StageThree extends Stage {
	

	private Rectangle rect;
	public StageThree() {
		super(new Vec2(25, 70));

	}
	
	@Override
	public void setupStage() {
		super.setupStage();

		addMainBall();

		ff.setPos(new Vec2(90 ,56.5f));
		launcher = new Launcher(new Vec2(40, 55));

		rect = new GroundRect(new Vec2(25, 50), 20, 1);



		WorldController.addObject(rect);

	}


}
