/**
 * 
 */
package view;

import model.GameObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author lubuntu
 *
 */
public class InGameMenu extends VBox {
	protected InGamePane scene;
	private static final int HEIGHT = 300;
	private static final int WIDTH = 200;

	
	public InGameMenu(InGamePane scene) {
		this.scene = scene;
		setMenu();
	}
	
	private void setMenu() {
		this.setManaged(false);
		this.setBorder(InGamePane.border);
		DropShadow dropShadow = new DropShadow();
		dropShadow.setBlurType(BlurType.GAUSSIAN);
		dropShadow.setColor(Color.BLACK);
		dropShadow.setRadius(25);
		dropShadow.setSpread(0.7);
		setEffect(dropShadow);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		this.setSpacing(15);
		this.resize(WIDTH, HEIGHT);

		Label menuText = new Label("MENU");
		Font fnt = new Font(40);
		menuText.setFont(fnt);
		menuText.setTextFill(Color.ORANGE);
		Button resumeBut = new Button("Resume");
		resumeBut.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				scene.resume();
			}
			
		});
		resumeBut.setFont(new Font(25));
		resumeBut.setTextFill(Color.GREEN);
		Button optionsBut = new Button("Options");
		optionsBut.setFont(new Font(20));
		Button exitBut = new Button("Quit");
		exitBut.setFont(new Font(15));
		exitBut.setTextFill(Color.RED);
		this.relocate((GameObject.SCREEN_WIDTH - WIDTH)/2, (GameObject.SCREEN_HEIGHT - HEIGHT)/2);
		this.getChildren().add(0, menuText);
		this.getChildren().add(1, resumeBut);
		this.getChildren().add(2, optionsBut);
		this.getChildren().add(3, exitBut);

	}

}
