package view;

import model.GameObject;
import stages.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class StageMenu extends Pane {
	
	private Stage[] stages = {new StageOne(), new StageTwo(), new StageThree(),new StageFour(),
			new StageFive(),new StageSix(), new StageSeven(),new StageEight(),new StageNine(),new StageTen()};
	private static final GridPane pane = new GridPane(); 
	
	public StageMenu() {
		setId("stageMenu");
		getChildren().add(pane);
		
		pane.setLayoutX(GameObject.SCREEN_WIDTH/7);
		pane.setLayoutY(GameObject.SCREEN_HEIGHT/7);
		
		pane.setHgap(GameObject.SCREEN_WIDTH/15);
		pane.setVgap(GameObject.SCREEN_HEIGHT/10);

		Button menuBtn = new Button("Menu");
		menuBtn.setOnAction(event -> getScene().setRoot(new MainMenu()));
		
		getChildren().add(menuBtn);
		menuBtn.setLayoutX(GameObject.SCREEN_WIDTH*9/10);
		menuBtn.setLayoutY(GameObject.SCREEN_HEIGHT*9/10);

		for (int i = 0; i < 10; i++) {
			int num = i;
			Button btn = new Button("Stage: " + (i + 1));
			btn.setTextFill(Color.BLUE);
			btn.setOnAction(event -> {stages[num].setupStage();
			getScene().setRoot(new InGamePane(stages[num]));});
			
			if (i < 5) pane.add(btn, i, 0);
			else pane.add(btn, i - 5, 1);
		}
	}
}
