/**
 * 
 */
package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author Bilal
 *
 */
public class Menu extends Scene {
	private static Pane cur = new MainMenu();
	public Menu() {
		super(cur);
	}
	
	public void changeMenu(Pane menu) {
		setRoot(menu);
		cur = menu;
	}
}
