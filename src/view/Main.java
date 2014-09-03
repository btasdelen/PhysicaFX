package view;

import java.io.IOException;

import model.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {
	
	static Stage stage;
	{
		try {
			Settings.readSettings();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static Scene current = new Menu();//new InGameScene(new StageOne());

	
	public static void setScene(Scene scn) {
		current = scn;
		//stage.setScene(current);
		//stage.setFullScreen(true);


	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setFullScreen(true);
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		stage.setTitle("Physica");
		stage.setScene(current);
		stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
