package view;

import stages.StageOne;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StageMenu extends Pane {

	public StageMenu() {
		getStylesheets().add("file:styling/StagesMenuStyle.css");
		
		Button btn = new Button("Start");
		getChildren().add(btn);
		
		btn.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				getScene().setRoot(new InGamePane(new StageOne()));
			}
			
		});
	}


}
