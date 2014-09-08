/**
 * 
 */
package model;

import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import org.jbox2d.common.Vec2;

/**
 * @author bilal
 *
 */
public class Launcher extends GameObject { 

	private final ImageView img = new ImageView("file:images/launcher.png");
	private final ImageView plt = new ImageView("file:images/launcherplat.png");
	public Launcher( Vec2 p)  { 
		super(p, null, null);
		img.setPreserveRatio(true);
		plt.setPreserveRatio(true);
		img.setFitHeight(200);
		img.setFitWidth(200);
		plt.setFitHeight(120);
		plt.setFitWidth(120);
		setPos(p);
	} 
	
	public ImageView getTexture() {
		return img;
	}
	
	public ImageView getPlatform() {
		return plt;
	}
	@Override
	public void rotate(float ang) {
		img.getTransforms().clear();
		img.getTransforms().add(new Rotate((double)ang, (double)30, (double)180));
	}
	
	@Override
	public void setPos(Vec2 pos) {
		super.setPos(pos);
		img.relocate(boxToJavaX(pos.x), boxToJavaY(pos.y) - 120);
		img.setTranslateZ(-300);
		plt.relocate(boxToJavaX(pos.x) - 15, boxToJavaY(pos.y) - 10);
		plt.setTranslateZ(-300);
	}
	

	public boolean isCaptured(Vec2 p) {
		//if mainball's position is overlapping with launcher return true
		if ((p.x >= pos.x + GameObject.javaToBoxWidth(6) && p.x <= pos.x + GameObject.javaToBoxWidth(8)) 
				&& (p.y <= pos.y && p.y >= pos.y - GameObject.javaToBoxHeight(300)))
			return true;
		return false;
	}

	@Override
	public boolean isSelected(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}
}
