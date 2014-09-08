package view;

import java.io.IOException;

import model.Settings;
import javafx.application.Application;
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

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setFullScreen(true);
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		stage.setTitle("Physica");
		stage.setScene(new Menu());
		stage.show();
	}
	
	public static void main(String[] args) {launch(args);}
}
