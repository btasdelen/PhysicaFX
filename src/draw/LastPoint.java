/**
 * 
 */
package draw;

import view.Drawer;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * @author lubuntu
 *
 */
public class LastPoint implements EventHandler<MouseEvent> {
	
	
	@Override
	public void handle(MouseEvent event) {
		//if not overlapping and not
		Point2D pressed = new Point2D(event.getScreenX(), event.getScreenY());
		if( FirstPoint.isValid() && (!Drawer.getP1().equals(pressed)) && !FirstPoint.isPaused()) {
			Drawer.setP2(pressed);
			Drawer.draw();

		}
				
		//panel.setShowNull();
		
	}

}
