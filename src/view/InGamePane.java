/**
 * 
 */
package view;

import controller.BallController;
import controller.InGameController;
import controller.WorldController;
import draw.Dragging;
import draw.FirstPoint;
import draw.LastPoint;
import stages.Stage;
import model.GameObject;
import model.Settings;
import model.WonRectangle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineJoin;
import javafx.util.Duration;;

/**
 * @author bilal
 *
 */

public class InGamePane extends Pane{
	
	model.MainBall mainBall;
	private Stage stage;
	private Pane gaming = new Pane();
	Group objects = new Group();
	private TimeLabel tl = new TimeLabel();
	private final GridPane sp = new GridPane();
	private final Button menuBut = new Button();
	public static final Border border = new Border(new BorderStroke(Color.CORNFLOWERBLUE, 
			new BorderStrokeStyle(null, StrokeLineJoin.ROUND, null, 10, 0, null),
	new CornerRadii(10), new BorderWidths(8), null));
	private InGameMenu menu;
	private Timeline timeline = new Timeline();
	private Drawer drawer;
	private boolean is3D = Settings.isGraphics3D();
	private PerspectiveCamera camera = new PerspectiveCamera();
	private WonRectangle won;
	private SubScene sub;

	
	public InGamePane(Stage st) {
		this.setCache(true);
		sub = new SubScene(gaming, GameObject.SCREEN_WIDTH, GameObject.SCREEN_HEIGHT, true, SceneAntialiasing.BALANCED);
		this.getChildren().add(sub);
		gaming.setId("gaming");

		//Not the javafx stage
		stage = st;
		if (Platform.isSupported(ConditionalFeature.SCENE3D) && is3D) {
			set3DScene();
		}
		else {
			set2DScene();
		}
		PointLight light = new PointLight();
		light.setColor(Color.WHITE);
		
		light.relocate(GameObject.SCREEN_WIDTH/2, 0);
		light.setTranslateZ(-300);
		light.getScope().add(gaming);

		gaming.getChildren().add(light);
		sub.setCamera(camera);
        Duration duration = Duration.seconds(1.0/60.0);      
        KeyFrame frame = new KeyFrame(duration, new InGameController(this, stage, tl), null,null);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(frame);
        gaming.setPickOnBounds(false);
		gaming.getChildren().add(stage.getFlag().getTexture());
		if (stage.getLauncher() != null) 
			gaming.getChildren().addAll(stage.getLauncher().getTexture(), stage.getLauncher().getPlatform());
			
		gaming.getChildren().add(objects);
		this.getChildren().add(tl);
		this.setOnMousePressed(new FirstPoint(stage));
		this.setOnMouseDragged(new Dragging());
		this.setOnMouseReleased(new LastPoint());
		setSidePanel();
		setMenuButton();
		menu = new InGameMenu(this);
		menu.setVisible(false);
		this.getChildren().add(menu);

		timeline.playFromStart();
	}
	
	public void set3DScene() {
		for (GameObject obj: stage.getWorldController().getObjects()) {
			objects.getChildren().add(obj.shape3D());
			if (obj.isMain()) {
				mainBall = (model.MainBall) obj;
			}
		}	
		
		drawer = new Drawer(this);
		mainBall.shape3D().setOnMouseClicked(new BallController(mainBall));
	}
	
	public void set2DScene() {
		for (GameObject obj: stage.getWorldController().getObjects()) {
			objects.getChildren().add(obj.shape2D());
			if (obj.isMain()) {
				mainBall = (model.MainBall) obj;
			}
		}
		drawer = new Drawer(this);
		
		mainBall.shape2D().setOnMouseClicked(new BallController(mainBall));
	}

	public void won() {
		won = new WonRectangle();
		WorldController.addObject(won);
		addObject(won);
		tl.pause();
		
		Button stgBtn = new Button("Return to the Stages");
		stgBtn.setBorder(border);
		stgBtn.relocate(800, 450);
		this.getChildren().add(stgBtn);
	}

	public void pause() {
		menu.setVisible(true);
		gaming.setEffect(new GaussianBlur());
		drawer.pause();
		timeline.pause();
		tl.pause();
	}

	
	public void resume() {
		gaming.setEffect(null);
		drawer.resume();
		timeline.play();
		tl.resume();
		menu.setVisible(false);
	}

	public void launch() {
	}
	
	public void startLaunchMode() {
		mainBall.shape3D().setVisible(false);
		timeline.pause();
		drawer.setLauncher(mainBall);
	}
	
	public void finishLaunchMode() {
		mainBall.shape3D().setVisible(true);
		timeline.play();
		
	}
	
	private void setSidePanel() {
		gaming.getChildren().add(sp);
		ToggleGroup sideGroup = new ToggleGroup();
		ToggleButton rectBut = new ToggleButton();
		rectBut.setId("rectBut");
		rectBut.setToggleGroup(sideGroup);
		
		ToggleButton circBut = new ToggleButton();
		circBut.setId("circBut");
		circBut.setToggleGroup(sideGroup);

		
		sp.relocate(-6, GameObject.SCREEN_HEIGHT/2);
		sp.setBorder(border);
		sp.addRow(0, rectBut);
		sp.addRow(1, circBut);
		
		rectBut.setOnAction(event -> drawer.setRect()); 
		
		circBut.setOnAction(event -> drawer.setCirc()); 
	}
	
	private void setMenuButton() {
		getChildren().add(menuBut);
		
		menuBut.relocate(GameObject.SCREEN_WIDTH-80, GameObject.SCREEN_HEIGHT-80);
		menuBut.setShape(new Circle());
		menuBut.setId("menuBut");
		menuBut.setOnAction(event -> pause());		
		
	}
	
	
	public void addObject(GameObject obj) {
		if (is3D)
			objects.getChildren().add(obj.shape3D());
		else
			objects.getChildren().add(obj.shape2D());

	}
	
	public void removeObject(GameObject obj) {
		objects.getChildren().remove(obj.shape3D());
	}

	public void restoreMain() {
		stage.addMainBall();

		if (Platform.isSupported(ConditionalFeature.SCENE3D) && is3D) {
			objects.getChildren().remove(mainBall.shape3D());
			for (GameObject obj: stage.getWorldController().getObjects()) {
				if (obj.isMain()){
					mainBall = (model.MainBall) obj;
					objects.getChildren().add(mainBall.shape3D());
					mainBall.shape3D().setOnMouseClicked(new BallController(mainBall));

				}
			}
		}
		
		else {
			objects.getChildren().remove(mainBall.shape2D());
			for (GameObject obj: stage.getWorldController().getObjects()) {
				if (obj.isMain()){
					mainBall = (model.MainBall) obj;
					objects.getChildren().add(mainBall.shape2D());
					mainBall.shape2D().setOnMouseClicked(new BallController(mainBall));

				}
			}
		}
		
	}
	public void destroy () {
		getChildren().clear();
		WorldController.destroy();
	}

	public void rotateLauncher(float ang) {
		stage.getLauncher().rotate(ang);
	}



}
