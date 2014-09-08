/**
 * 
 */
package view;

import model.GameObject;
import javafx.scene.control.Label;

/**
 * @author bilal
 *
 */
public class TimeLabel extends Label {
	boolean isPaused;
	public TimeLabel() {
		super("0:00");
		setId("timeLabel");
		relocate(GameObject.SCREEN_WIDTH - 170, 40);
		isPaused = false;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setTime(int min, int sec) {
		if (sec < 10) setText(min + ":0" + sec);
		else setText(min + ":" + sec);
	}

	public void pause() {
		isPaused = true;

		setText("Paused");
	}

	public void resume() {
		isPaused = false;		
	}
}