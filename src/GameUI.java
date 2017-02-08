import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Class for the game UI.
 * @author Dylan
 *
 */
public class GameUI {
	
	private Pane content;
	private ToolBar toolBar;
	private Button resumeButton;
	private Button pauseButton;
	private Button settingsButton;
	private String difficulty;
	private String problemType;
	private Label test;
	private Timeline timeline;
	private boolean isPaused;
	private boolean intersectFlag;
	private double x;
	private ArrayList<Label> fallingSums; 
	private ArrayList<Label> toDelete;
	private int health;
	private NumberCatcher numberCatcher;
	// KeyEvent handler handles the catcher movement and UI shortcuts.
	private EventHandler<KeyEvent> kEventHandler = new EventHandler<KeyEvent>() {
		public void handle(KeyEvent event) {
			if (!isPaused) {
				if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
					numberCatcher.setX(x - 15);
					numberCatcher.getRectangle().setX(x - 15);
					x -= 15;
				}
				if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
					numberCatcher.setX(x + 15);
					numberCatcher.getRectangle().setX(x + 15);
					x += 15;
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
	private ProgressBar progressBar;
	private Label healthLabel;
	// Animation timer checks for intersects and handles sums which go off the screen.
	private AnimationTimer animationTimer = new AnimationTimer() {
		public void handle(long now) {
			for (Label label : fallingSums) {
				label.setShape(new Rectangle(label.getLayoutX(), label.getLayoutY(), label.getWidth(), label.getHeight()));
				if (label.getShape().intersects(numberCatcher.getRectangle().getX(), numberCatcher.getRectangle().getY(),
						numberCatcher.getRectangle().getWidth(), numberCatcher.getRectangle().getHeight()) && fallingSums.contains(label)) {
					intersectFlag = true;
					toDelete.add(label);
				}
				if (label.getLayoutY() > 600) {
					toDelete.add(label);
				}
			}
			for (Label toRemove : toDelete) {
				fallingSums.remove(toRemove);
			}
			toDelete.clear();
			if (intersectFlag == true) {
				progressBar.setProgress(progressBar.getProgress() - .10);
				healthLabel.setText(String.valueOf((int)(progressBar.getProgress() * 100)));
				intersectFlag = false;
			}
			if (progressBar.getProgress() <= 0) {
				System.out.println("Game over!");
			}
		}
	};

	/**
	 * Constructor for the game UI - builds the screen for the gameplay.
	 */
	public GameUI(String difficulty, String problemType) {
		// Initializes fields
		isPaused = false;
		health = 100;
		this.difficulty = difficulty;
		this.problemType = problemType;
		content = new Pane();
		toolBar = new ToolBar();
		resumeButton = new Button("Resume");
		resumeButton.setDisable(true); 
		pauseButton = new Button("Pause");
		healthLabel = new Label(String.valueOf(health));
		fallingSums = new ArrayList<Label>();
		toDelete = new ArrayList<Label>();
		intersectFlag = false;
		settingsButton = new Button("Settings");
		// Adds UI buttons to the toolbar.
		toolBar.getItems().addAll(resumeButton, pauseButton, settingsButton);
		toolBar.setPrefWidth(800);
		// Creates a new progress bar to represent the players health.
		progressBar = new ProgressBar(1);
		progressBar.setPrefWidth(700);
		progressBar.setStyle("-fx-accent: #71F514");
		progressBar.setLayoutY(540);
		progressBar.setLayoutX(100);
		progressBar.setPrefHeight(30);
		content.getChildren().addAll(toolBar, progressBar);
		test = new Label("Test");
		test.setStyle("-fx-font-size: 20px");
		fallingSums.add(test);
		numberCatcher = NumberCatcher.getInstance(); // getInstance() is used as NumberCatcher is a singleton.
		x = numberCatcher.getX();
		content.getChildren().add(numberCatcher);
		content.setOnKeyPressed(kEventHandler);
		content.getChildren().addAll(test);
		// Creates a new timeline to animate the falling sums.
		timeline = new Timeline();
		timeline.setCycleCount(timeline.INDEFINITE);
		// Timeline uses KeyValues and KeyFrames for animations.
		KeyValue keyValue = new KeyValue(test.layoutYProperty(), 800);
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		content.requestFocus();
		content.setFocusTraversable(false);
		// Event handler for the pause button.
		pauseButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				pauseGame();
			}
		});
		// Event handler for the resume button.
		resumeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resumeGame();
			}
		});
		AdditionNumberProblem additionNumberProblem= new AdditionNumberProblem();
		test.setText(String.valueOf(additionNumberProblem.getNumberGenerator().nextInt(100) + 1));
		// Creates an image for the players health icon.
		ImageView healthIcon = new ImageView(new Image(GameUI.class.getResource("resources/health_icon.png").toExternalForm()));
		// Styling and positioning of the health icon and health number.
		healthIcon.setLayoutY(540);
		healthIcon.setLayoutX(10);
		healthLabel.setStyle("-fx-font-size: 20px");
		healthLabel.setLayoutY(540);
		healthLabel.setLayoutX(45);
		content.getChildren().addAll(healthIcon, healthLabel);
		// Starts the animation timer.
		animationTimer.start();
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
		animationTimer.stop();
		resumeButton.setDisable(false);
		pauseButton.setDisable(true);
		isPaused = true;
	}
	
	/**
	 * Resumes the game.
	 */
	public void resumeGame() {
		timeline.play();
		animationTimer.start();
		pauseButton.setDisable(false);
		resumeButton.setDisable(true);
		content.setOnKeyPressed(kEventHandler);
		isPaused = false;
	}
	
	
}
