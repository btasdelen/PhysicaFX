/**
 * 
 */
package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import org.jbox2d.common.Vec2;

import model.MainBall;

/**
 * @author bilal revised by furkan
 *
 */
public class BallController implements EventHandler<MouseEvent> {
	private MainBall mb;
	
	public BallController(MainBall mb) {
		this.mb = mb;
	}
	
	// Apply force to ball by clicking it with mouse

	@Override
	public void handle(MouseEvent event) {
		//Determine which way to apply force
		if(event.getButton().equals(MouseButton.PRIMARY))
			mb.body.applyForceToCenter(new Vec2(1000, 0));
		
		else if(event.getButton().equals(MouseButton.SECONDARY))
			mb.body.applyForceToCenter(new Vec2(-1000, 0));

	}
}
