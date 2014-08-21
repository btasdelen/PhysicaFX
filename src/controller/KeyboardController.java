package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.MainBall;

import org.jbox2d.common.Vec2;


/**
 * @author furkan
 *
 */

public class KeyboardController extends KeyAdapter{

	private MainBall mb;
	
	public KeyboardController(MainBall mb) 
	{
		this.mb = mb;
	}
	
	// Controls main ball by pressing arrow buttons
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		// Left arrow
		if(key == KeyEvent.VK_LEFT) {
			mb.body.applyForceToCenter(new Vec2(-1000, 0));
	    }
		// Right arrow
	    if(key == KeyEvent.VK_RIGHT) {
	    	mb.body.applyForceToCenter(new Vec2(1000, 0));
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{

	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
