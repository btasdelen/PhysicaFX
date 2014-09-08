/**
 * 
 */
package view;

import model.GameObject;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * @author lubuntu
 *
 */
public class InGameMenu extends VBox {
	protected InGamePane pane;
	private static final int HEIGHT = 300;
	private static final int WIDTH = 200;

	
	public InGameMenu(InGamePane pane) {
		this.pane = pane;
		setMenu();
	}
	
	private void setMenu() {
		setId("inGameMenu");
		this.setManaged(false);
		this.setBorder(InGamePane.border);

		this.resize(WIDTH, HEIGHT);

		Label menuText = new Label("MENU");
		menuText.setId("menuText");
		
		Button resumeBut = new Button("Resume");
		resumeBut.setOnAction(event -> {pane.resume();setVisible(false);});
		resumeBut.setId("resumeBut");
		
		Button optionsBut = new Button("Options");
		optionsBut.setId("optionsBut");
		
		Button exitBut = new Button("Quit");
		exitBut.setId("exitBut");
		exitBut.setOnAction(event -> {getScene().setRoot(new MainMenu());pane.destroy();});
		
		this.relocate((GameObject.SCREEN_WIDTH - WIDTH)/2, (GameObject.SCREEN_HEIGHT - HEIGHT)/2);
		this.getChildren().add(0, menuText);
		this.getChildren().add(1, resumeBut);
		this.getChildren().add(2, optionsBut);
		this.getChildren().add(3, exitBut);

	}

}
