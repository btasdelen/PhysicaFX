/**
 * 
 */
package model;

import javafx.scene.image.ImageView;

import org.jbox2d.common.Vec2;

/**
 * @author bilal
 *
 */
public class FinishFlag extends GameObject {

	private final ImageView iv = new ImageView("file:images/flag.png");
	
	public FinishFlag(Vec2 p) throws Exception {
		super(p, null, null);
	}
	
	public ImageView getTexture() {
		return iv;
	}
	
	@Override
	public void setPos(Vec2 pos) {
		super.setPos(pos);
		iv.relocate(pos.x, pos.y);
	}
	
	public boolean isFinished(Vec2 p) {
		//if main ball's position overlap with flag's area decide to finish the stage

		if (GameObject.boxToJavaX(p.x) < (pos.x + 100) 
				&& GameObject.boxToJavaX(p.x) > (pos.x)
				&& GameObject.boxToJavaY(p.y) < (pos.y + 100) 
				&& GameObject.boxToJavaY(p.y) > (pos.y)) {
			return true;

		}
		return false;
	}
	


}
