/**
 * 
 */
package draw;

import java.util.ArrayList;

import stages.Stage;
import view.Drawer;
import model.GameObject;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * @author lubuntu
 *
 */
public class FirstPoint implements EventHandler<MouseEvent> {
	private Stage stg;
	private static Point2D p1;
	private static boolean valid = false;
	private static boolean isPaused = false;
	
	public FirstPoint(Stage stg, Drawer draw) {
		super();
		this.stg = stg;
		//drawer = draw;
	}
	
	@Override
	public void handle(MouseEvent event) {
		valid = false;
		boolean isOut = true;

		Point2D pressed = new Point2D(event.getScreenX(), event.getScreenY());

		ArrayList<GameObject> objects = stg.getWorldController().getObjects();
		 
		// is clicked on another object
		for(int i = 0; i < objects.size() && isOut; i++)
		{
			if( objects.get(i).isSelected(pressed.getX(), pressed.getY()))
			{
				isOut = false;
			}
		}
		
		// holds the point if it is proper one
		if( isOut && !isPaused)
		{
			valid = true;
			Drawer.setP1(pressed);
		}
		
	}
	
	public static boolean isValid() {
		return valid;
	}
	
	public static boolean isPaused() {
		return isPaused;
	}
	
	public static Point2D getPoint() {
		return p1;
	}

}
