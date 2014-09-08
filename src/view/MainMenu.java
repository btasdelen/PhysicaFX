package view;

import model.GameObject;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainMenu extends Pane {
	
	private VBox butPane = new VBox();
	
	public MainMenu() {
		getChildren().add(butPane);
		
		butPane.setLayoutX(GameObject.SCREEN_WIDTH/10);
		butPane.setLayoutY(GameObject.SCREEN_HEIGHT/6);
		butPane.setSpacing(30);

		Button stageBtn = new Button();
		stageBtn.setText("Stages");
		stageBtn.setId("stageBtn");
		stageBtn.setOnAction(event -> getScene().setRoot(new StageMenu()));
		
		Button optionBtn = new Button();
		optionBtn.setText("Options");
		optionBtn.setId("optionBtn");
		optionBtn.setOnAction(event -> System.out.println("Hello World!"));
		
		Button exitBtn = new Button();
		exitBtn.setText("Exit");
		exitBtn.setId("exitBtn");
		exitBtn.setOnAction(event -> System.exit(0));
	
		butPane.getChildren().add(0, stageBtn);
		butPane.getChildren().add(1, optionBtn);
		butPane.getChildren().add(2, exitBtn);
	}
}