/**
 * 
 */
package model;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import org.jbox2d.common.Vec2;

/**
 * @author bilal
 *
 */
public class Launcher extends GameObject { 

	private final Image img = ImageIO.read(new File("backgrounds/launcher.png"));

	public Launcher( Vec2 p) throws Exception { 
		super(p, null, null);
	} 
	
	public Image getTexture() {
		return img;
	}

	public boolean isCaptured(Vec2 p) {
		//if mainball's position is overlapping with launcher return true
		if ((p.x >= pos.x && p.x <= pos.x + GameObject.javaToBoxWidth(2)) && (p.y <= pos.y && p.y >= pos.y - GameObject.javaToBoxHeight(180)))
			return true;
		return false;
	}
}
