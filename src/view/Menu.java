/**
 * 
 */
package view;

import javafx.scene.Scene;

/**
 * @author Bilal
 *
 */
public class Menu extends Scene {

	public Menu() {
		super(new MainMenu());
		getStylesheets().add("file:styling/Style.css");
	}
}