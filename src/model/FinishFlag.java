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
	
	public FinishFlag(Vec2 p) {
		super(p, null, null);
	}
	
	public ImageView getTexture() {
		return iv;
	}
	
	@Override
	public void setPos(Vec2 pos) {
		super.setPos(pos);
		iv.relocate(boxToJavaX(pos.x), boxToJavaY(pos.y));
		iv.setTranslateZ(-100);
	}
	
	public boolean isFinished(GameObject obj) {
		//if main ball's position overlap with flag's area decide to finish the stage
		if (obj.getPos().x < (pos.x + 10) 
				&& obj.getPos().x > (pos.x)
				&& obj.getPos().y < (pos.y) 
				&& obj.getPos().y > (pos.y-10)) {
			return true;

		}
		return false;
	}

	@Override
	public boolean isSelected(double x, double y) {
		return false;
	}
	


}
