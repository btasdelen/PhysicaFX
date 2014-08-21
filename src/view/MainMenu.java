package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainMenu extends Scene {
	static Pane root = new Pane();
	public MainMenu() {
		super(root, 640, 480);
		
		Button stageBtn = new Button();
		stageBtn.setText("Stages");
		stageBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		stageBtn.setLayoutX(50);
		
		Button optionBtn = new Button();
		optionBtn.setText("Options");
		optionBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		
		Button exitBtn = new Button();
		exitBtn.setText("Exit");
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
	
		
		root.getChildren().add(stageBtn);
		root.getChildren().add(optionBtn);
		root.getChildren().add(exitBtn);


	}

}
