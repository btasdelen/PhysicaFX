/**
 * 
 */
package model;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

/**
 * Basic world data
 * @author bilal
 *
 */
public class WorldPhysica {

	private final Vec2 GRAVITY = new Vec2(0.0f, -9.8f);
	public static World world; 
	
	public WorldPhysica() {
		world = new World(GRAVITY);
		world.setAllowSleep(true);
	}
	
	public static Body createBody(BodyDef bd) {
		return world.createBody(bd);
	}
	
	public void setGravity(Vec2 v){
		world.setGravity(v);
	}
	
	public static World getWorld() {
		return world;
	}
	
	public void clearWorld(ArrayList<GameObject> obj) {
		for (GameObject go: obj)
			world.destroyBody(go.body);
	}
	
	
	
	

}
