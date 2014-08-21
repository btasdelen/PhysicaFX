package view;

import stages.StageOne;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage stage;
	Scene current = new InGameScene(new StageOne());
	
	public void setScene(Scene scn) {
		current = scn;
		stage.setScene(current);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage = primaryStage;
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.setTitle("Physica");
		stage.setScene(current);
		stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
