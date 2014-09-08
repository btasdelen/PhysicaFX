package controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import stages.Stage;
import view.InGamePane;
import view.TimeLabel;
import model.GameObject;

/**
 * @author furkan
 *
 */

public class InGameController implements EventHandler<ActionEvent> {
	
	private InGamePane scene;
	private Stage stage;
	private TimeLabel view;
	private int min;
	private int sec;
	private int ms;
	private float timeStep = 1.0f / 60.f;
	private int velocityIterations = 8;
	private int positionIterations = 3;
	private boolean isWon = false;

	public InGameController(InGamePane inGameScene, Stage st, TimeLabel view)
	{
		stage = st;
		this.scene = inGameScene;
		this.view = view;
		min = 0;
		sec = 0;
		ms = 0;
	}
	
	
	public void incrementTime() {
		//increment second and then check if necessary to increment label
		ms += 1;

		if ( ms == 60) {
			sec++;
			ms = 0;
		}
		if (sec == 60){
			min++;
			sec = 0;
		}
	}
	
	public void resetTime() {
		min = 0;
		sec = 0;
	}

	// Simulates the world and checks for required conditions
	@Override
	public void handle(ActionEvent event) {
		boolean isMainReplaced = false;

		// JBox2D calculations

		stage.getWorldController().getWorld().step(timeStep, velocityIterations, positionIterations);
		for (GameObject obj: stage.getWorldController().getObjects()) {
			obj.setPos(obj.body.getPosition());
			obj.rotate(obj.body.getAngle());
			if ( obj.isMain() && !obj.isInside())
				isMainReplaced = true;
		}
		
		// Destroy objects outside of the screen
		destroyOutside();
		// add listeners to new main ball
		if (isMainReplaced){
			scene.restoreMain();

		}
		// Checks finish condition		
		if(stage.getFlag().isFinished(stage.getMainBall()) && !isWon){
			scene.won();
			isWon = true;
		}
		
		// Checks if main ball captured by launcher
		if(stage.getLauncher() != null ) {
				if(stage.getLauncher().isCaptured(stage.getMainBall().getPos())){
					scene.startLaunchMode();
				}
		}
		//update the time view
		if( !view.isPaused()) {
			incrementTime();
			view.setTime(min, sec);
		}
	}
	
	public void destroyOutside() {
		//destroy the object when it is outside of the screen
		for (int i = 0; i < stage.getWorldController().getObjects().size(); i++){
			if (!stage.getWorldController().getObjects().get(i).isInside()){
				scene.removeObject(stage.getWorldController().getObjects().get(i));
				stage.getWorldController().getWorld().destroyBody(stage.getWorldController().getObjects().get(i).body);
				WorldController.deleteObject(stage.getWorldController().getObjects().get(i));
			}
		}
	}

}
