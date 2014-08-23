/**
 * 
 */
package view;


import controller.BallController;
import controller.InGameController;
import draw.Dragging;
import draw.FirstPoint;
import draw.LastPoint;
import stages.Stage;
import model.GameObject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;
import javafx.util.Duration;

/**
 * @author bilal
 *
 */

public class InGameScene extends Scene{
	
	model.MainBall mainBall;
	private Stage stage;
	private static Pane root = new Pane();
	private static Pane gaming = new Pane();
	Group objects = new Group();
	private TimeLabel tl = new TimeLabel();
	private final static GridPane sp = new GridPane();
	private final Button menuBut = new Button();
	public static final Border border = new Border(new BorderStroke(Color.CORNFLOWERBLUE, 
			new BorderStrokeStyle(null, StrokeLineJoin.ROUND, null, 10, 0, null),
	new CornerRadii(10), new BorderWidths(8), null));
	private InGameMenu menu;
	private Timeline timeline = new Timeline();
	private Drawer drawer;
	
	public InGameScene(Stage st) {
		super(root);
		root.setCache(true);
		Image back = new Image("file:images/back.jpg");
		root.setBackground(new Background(new BackgroundImage(back, null, null, null,
				new BackgroundSize(GameObject.SCREEN_WIDTH, GameObject.SCREEN_HEIGHT, false, false, true, true))));
		
		//Not the javafx stage
		stage = st;
		if (Platform.isSupported(ConditionalFeature.SCENE3D))
			set3DScene();
		else
			set2DScene();
		
		this.setCamera(new javafx.scene.PerspectiveCamera());
		
        Duration duration = Duration.seconds(1.0/60.0);      
        KeyFrame frame = new KeyFrame(duration, new InGameController(this, stage, tl), null,null);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(frame);
        
		gaming.getChildren().add(stage.getFlag().getTexture());
		gaming.getChildren().add(objects);
		gaming.getChildren().add(tl);
		root.getChildren().add(gaming);
		gaming.setOnMousePressed(new FirstPoint(stage, drawer));
		gaming.setOnMouseDragged(new Dragging());
		gaming.setOnMouseReleased(new LastPoint());
		setSidePanel();
		setMenuButton();
		menu = new InGameMenu(this);
		menu.setVisible(false);
		root.getChildren().add(menu);


		timeline.playFromStart();
	}
	
	public void set3DScene() {
		for (GameObject obj: stage.getWorldController().getObjects()) {
			objects.getChildren().add(obj.shape3D());
			if (obj.isMain()) {
				mainBall = (model.MainBall) obj;
			}
		}		
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
		// TODO Auto-generated method stub
		timeline.pause();
	}

	public void pause() {
		menu.setVisible(true);
		gaming.setEffect(new GaussianBlur());
		timeline.pause();
		tl.pause();
		
	}
	
	public void resume() {
		gaming.setEffect(null);
		timeline.play();
		tl.resume();
		menu.setVisible(false);
	}

	public void launch() {
		// TODO Auto-generated method stub
		
	}
	
	private void setSidePanel() {
		gaming.getChildren().add(sp);
		ToggleGroup sideGroup = new ToggleGroup();
		ToggleButton rectBut = new ToggleButton();

		ImageView rectImg = new ImageView("file:images/rectangle.png");
		
		rectImg.setFitHeight(44);
		rectImg.setPreserveRatio(true);
		rectImg.setCache(true);
		rectImg.setSmooth(true);
		rectBut.setGraphic(rectImg);
		rectBut.setShape(new Rectangle());
		rectBut.setToggleGroup(sideGroup);
		
		ToggleButton circBut = new ToggleButton();
		
		ImageView circImg = new ImageView("file:images/circle.png");
		
		circImg.setFitHeight(44);
		circImg.setPreserveRatio(true);
		circImg.setCache(true);
		circImg.setSmooth(true);
		circBut.setGraphic(circImg);
		circBut.setShape(new Rectangle());
		circBut.setToggleGroup(sideGroup);

		
		sp.relocate(-6, GameObject.SCREEN_HEIGHT/2);
		sp.setBorder(border);
		sp.addRow(0, rectBut);
		sp.addRow(1, circBut);
		
	}
	
	private void setMenuButton() {
		gaming.getChildren().add(menuBut);
		menuBut.relocate(GameObject.SCREEN_WIDTH-50, GameObject.SCREEN_HEIGHT-50);
		menuBut.setShape(new Circle());
		menuBut.setGraphic(new ImageView("file:images/gear.png"));
		menuBut.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				pause();
			}
			
		});		
		
	}
	
	public void completeDraw() {
		
	}

	public void restoreMain() {
		objects.getChildren().remove(mainBall.shape2D());
		stage.addMainBall();
		for (GameObject obj: stage.getWorldController().getObjects()) {
			if (obj.isMain()){
				mainBall = (model.MainBall) obj;
				objects.getChildren().add(mainBall.shape2D());

			}
		}
		
	}

}
