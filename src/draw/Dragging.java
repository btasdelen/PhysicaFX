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
public class Dragging implements EventHandler<MouseEvent> {
	
	
	public Dragging() {
	}
	
	@Override
	public void handle(MouseEvent event) {

		Point2D pressed = new Point2D(event.getScreenX(), event.getScreenY());
		if( FirstPoint.isValid() && (!Drawer.getP1().equals(pressed)))
		{
			Drawer.setP2(pressed);
			Drawer.show();

		}
		
	}

}
