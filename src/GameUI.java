import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import sun.net.www.content.audio.x_aiff;

/**
 * Class for the game UI.
 * @author Dylan
 *
 */
public class GameUI {
	
	private Pane content;
	private ToolBar toolBar;
	private Button fullScreenButton;
	private Button startButton;
	private Button pauseButton;
	private Button settingsButton;
	private String difficulty;
	private Label test;
	private Timeline timeline;
	private boolean isPaused;
	private double x;
	private NumberCatcher numberCatcher;
	private EventHandler<KeyEvent> kEventHandler = new EventHandler<KeyEvent>() {
		public void handle(KeyEvent event) {
			if (!isPaused) {
				if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
					numberCatcher.setX(x - 15);
					x -= 10;
				}
				if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
					numberCatcher.setX(x + 15);
					x += 10;
				} 
			}
			if (event.getCode() == KeyCode.P) {
				if (isPaused == false) {
					pauseGame();
				}
				else {
					resumeGame();
				}

			}
		}
	};

	/**
	 * Constructor for the game UI - builds the screen for the gameplay.
	 */
	public GameUI(String difficulty) {
		isPaused = false;
		this.difficulty = difficulty;
		content = new Pane();
		toolBar = new ToolBar();
		fullScreenButton = new Button("Full Screen");
		startButton = new Button("Resume");
		startButton.setDisable(true);
		pauseButton = new Button("Pause");
		settingsButton = new Button("Settings");
		toolBar.getItems().addAll(fullScreenButton, startButton, pauseButton, settingsButton);
		toolBar.setPrefWidth(800);
		content.getChildren().addAll(toolBar);
		test = new Label("Test");
		test.setStyle("-fx-font-size: 20px");
		numberCatcher = NumberCatcher.getInstance();
		numberCatcher.setFitWidth(50);
		numberCatcher.setFitHeight(50);
		x = numberCatcher.getX();
		content.getChildren().add(numberCatcher);
		content.setOnKeyPressed(kEventHandler);
		content.getChildren().addAll(test);
		timeline = new Timeline();
		timeline.setCycleCount(timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		KeyValue keyValue = new KeyValue(test.layoutYProperty(), 800);
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		content.requestFocus();
		content.setFocusTraversable(false);
		pauseButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				pauseGame();
			}
		});
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resumeGame();
			}
		});
		AdditionNumberProblem additionNumberProblem= new AdditionNumberProblem();
		test.setText(String.valueOf(additionNumberProblem.getNumberGenerator().nextInt(100) + 1));
	}

	/**
	 * Returns the content of the game UI.
	 * @return the content
	 */
	public Pane getContent() {
		return content;
	}

	/**
	 * Sets the content of the game UI.
	 * @param content the content to set
	 */
	public void setContent(Pane content) {
		this.content = content;
	}
	
	/**
	 * Pauses the game.
	 */
	public void pauseGame() {
		timeline.pause();
		startButton.setDisable(false);
		pauseButton.setDisable(true);
		isPaused = true;
	}
	
	/**
	 * Resumes the game.
	 */
	public void resumeGame() {
		timeline.play();
		pauseButton.setDisable(false);
		startButton.setDisable(true);
		content.setOnKeyPressed(kEventHandler);
		isPaused = false;
	}
	
	
}
