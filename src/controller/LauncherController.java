/**
 * 
 */
package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.jbox2d.common.Vec2;

import view.InGamePanel;
import model.MainBall;

/**
 * @author bilal
 *
 */
public class LauncherController implements MouseListener {

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	private Point p1;
	private Point p2;
	private MainBall mb;
	private InGamePanel igp;
	
	public LauncherController(InGamePanel igp,MainBall mb) {
		this.igp = igp;

		this.mb = mb;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		p1 = e.getLocationOnScreen();

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		//if p1 != p2 launch
		if (e.getLocationOnScreen() != p1) {
			p2 = e.getLocationOnScreen();
			launch();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void launch() {
		//launch the ball and resume game
		mb.body.applyForceToCenter(new Vec2(-100*(p2.x - p1.x), -100*(p2.y - p1.y)));
		igp.resume();
		
	}

}
