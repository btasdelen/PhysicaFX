/**
 * 
 */
package view;

import model.GameObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * @author lubuntu
 *
 */
public class InGameMenu extends Pane {
	private final GridPane mp = new GridPane();
	protected InGameScene scene;
	
	public InGameMenu(InGameScene scene) {
		this.scene = scene;
		resize(GameObject.SCREEN_WIDTH, GameObject.SCREEN_HEIGHT);		
		setMenu();
	}
	
	private void setMenu() {
		mp.setBorder(InGameScene.border);
		Label menuText = new Label("MENU");
		Button resumeBut = new Button("Resume");
		resumeBut.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				scene.resume();
			}
			
		});
		Button optionsBut = new Button("Options");
		Button exitBut = new Button("Quit");
		mp.relocate(GameObject.SCREEN_WIDTH/2, GameObject.SCREEN_HEIGHT/2);
		mp.addRow(0, menuText);
		mp.addRow(1, resumeBut);
		mp.addRow(2, optionsBut);
		mp.addRow(3, exitBut);


		getChildren().add(mp);

	}

}
