/**
 * 
 */
package stages;

import org.jbox2d.common.Vec2;

import model.FinishFlag;
import model.Launcher;
import model.MainBall;
import controller.WorldController;

/**
 * @author bilal
 *
 */
public class Stage {
	
	protected WorldController world;
	protected MainBall mb;
	protected FinishFlag ff;
	protected Vec2 mbPos;
	protected Launcher launcher;


	public Stage(Vec2 mbPos) {
		this.mbPos = mbPos;
	}
	
	public void setupStage() {
		world = new WorldController();
		ff = new FinishFlag(new Vec2(0,0));



	}
	
	public MainBall getMainBall() {
		return mb;
	}
	
	public FinishFlag getFlag() {
		return ff;
	}
	
	public WorldController getWorldController() 
	{ 
		return world; 
	}

	public void destroyWorld() {
		WorldController.destroy();
		
	}
	
	public void keepInside(MainBall mb) {
		if (!mb.isInside()) {
			world.getWorld().destroyBody(mb.body);
			addMainBall();
		}
			
	}
	
	public Vec2 getMainBallPos() {
		return mbPos;
	}
	
	public void setMainBallPos(Vec2 v) {
		mbPos = v;
	}
	
	public void addMainBall() {
		//add main ball to its initial position
		mb = new MainBall(new Vec2(mbPos.x, mbPos.y));
		WorldController.addObject(mb);
	}
	
	
	public Launcher getLauncher() {
		return launcher;
	}
	

}
