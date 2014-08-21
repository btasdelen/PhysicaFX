/**
 * 
 */
package view;


import model.GameObject;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author lubuntu
 *
 */
public class TimeLabel extends Label {
	boolean isPaused;
	Font font = new Font("Ubuntu", 40);
	public TimeLabel() {
		super("0:00");

		relocate((GameObject.SCREEN_WIDTH/100)*95, (GameObject.SCREEN_HEIGHT/30));
		isPaused = false;
		//setFont(model.Settings.getFont());
		setFont(font);
		setTextFill(Color.ANTIQUEWHITE);
	
	}

	public boolean isPaused() {
		return isPaused;

	}

	public void setTime(int min, int sec) {
		if (sec < 10)
			setText(min + ":0" + sec);
		else
			setText(min + ":" + sec);

	}

	public void pause() {
		isPaused = true;

		setText("Paused");

	}

	public void resume() {
		isPaused = false;		
	}
}
