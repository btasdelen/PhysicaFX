/**
 * 
 */
package stages;

import javafx.scene.paint.Color;

import model.Launcher;
import model.Rectangle;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import controller.WorldController;

/**
 * @author bilal
 *
 */
public class StageThree extends Stage {
	

	private Rectangle rect;
	public StageThree() {
		super(new Vec2(25, 70));
		
		//setMainBallPos();
		addMainBall();

		ff.setPos(new Vec2(95 ,56.5f));

		try {
			haveLauncher = new Launcher(new Vec2(30, 55));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rect = new Rectangle(new Vec2(25, 50), 600, 15, Color.GRAY, BodyType.STATIC);



		WorldController.addObject(rect);





	}
	


}
