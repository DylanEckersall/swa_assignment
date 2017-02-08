import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
	private Timeline timeline;
	private Timer timer;
	private NumberProblem numberProblem;
	private Label numberProblemLabel;
	private Label answerLabel;
	private boolean isPaused;
	private boolean intersectFlag;
	private double x;
	private ArrayList<Label> fallingSums; 
	private ArrayList<Label> toDelete;
	private ArrayList<KeyFrame> keyFrames;
	private int health;
	private NumberCatcher numberCatcher;
	private NumberProblemFactory numberProblemFactory;
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
			boolean correctAnswer = false;
			for (Label label : fallingSums) {
				label.setShape(new Rectangle(label.getLayoutX(), label.getLayoutY(), label.getWidth(), label.getHeight()));
				if (label.getShape().intersects(numberCatcher.getRectangle().getX(), numberCatcher.getRectangle().getY(),
						numberCatcher.getRectangle().getWidth(), numberCatcher.getRectangle().getHeight()) && fallingSums.contains(label)) {
					intersectFlag = true;
					toDelete.add(label);
					int sum = 0;
					for (int i = 0; i < label.getText().length(); i++) {
						Character character = label.getText().charAt(i);
						if (Character.isDigit(character)) {
							sum += Character.getNumericValue(character);
						}
					}
					System.out.println(sum);
					if (sum == (int) numberProblem.getAnswer()) {
						correctAnswer = true;
					}
				}
				if (label.getLayoutY() > 600) {
					toDelete.add(label);
				}
			}
			for (Label toRemove : toDelete) {
				fallingSums.remove(toRemove);
			}
			for (KeyFrame keyFrame : keyFrames) {
				timeline.getKeyFrames().remove(keyFrame);
			}
			toDelete.clear();
			if (intersectFlag == true) {
				if (correctAnswer) {
					System.out.println("True");
					generateNumberProblem();
					progressBar.setProgress(progressBar.getProgress() + .10);
				}
				else {
					progressBar.setProgress(progressBar.getProgress() - .10);
					healthLabel.setText(String.valueOf((int)(progressBar.getProgress() * 100)));
					intersectFlag = false;
				}
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
		keyFrames = new ArrayList<KeyFrame>();
		toDelete = new ArrayList<Label>();
		intersectFlag = false;
		settingsButton = new Button("Settings");
		numberProblemFactory = new NumberProblemFactory();
		numberProblemLabel = new Label();
		timer = new Timer();
		answerLabel = new Label();
		answerLabel.setStyle("-fx-font-size: 24px");
		answerLabel.setLayoutX(375);
		answerLabel.setLayoutY(50);
		// Adds the answer label to the content pane.
		content.getChildren().add(answerLabel);
		// Creates the number problem for the game.
		generateNumberProblem();
		System.out.println(numberProblem.getProblem());
		System.out.println(numberProblem.getAnswer());
		// Creates a new timertask for checking if the correct answer exists in the ArrayList.
		 TimerTask checkAnswerIsFalling = new TimerTask() {
			public void run() {
				if (!fallingSums.contains(numberProblemLabel)) {
					fallingSums.add(numberProblemLabel);
				}
			}
		};
		// Sets the task to run every 10 seconds.
		timer.schedule(checkAnswerIsFalling, 10000);
		// Creates a new timertask for generating falling numbers.
		TimerTask createFallingNumber = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						Random random = new Random();
						Label number = new Label(generateFallingNumber());
						number.setLayoutX(random.nextInt(799) + 1);
						number.setStyle("-fx-font-size: 18px");
						content.getChildren().add(number);
						fallingSums.add(number);
						Timeline timeline = new Timeline(60);
						KeyValue keyValue = new KeyValue(number.layoutYProperty(), 800);
						KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), keyValue);
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
						System.out.println(numberProblem.getProblem());
					}
				});
			}
		};
		// Sets the task to run every 3 seconds.
		timer.scheduleAtFixedRate(createFallingNumber, 1, 3000);
		// Creates a timer task to represent a timer.
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
		numberCatcher = NumberCatcher.getInstance(); // getInstance() is used as NumberCatcher is a singleton.
		x = numberCatcher.getX();
		content.getChildren().add(numberCatcher);
		content.setOnKeyPressed(kEventHandler);
		// Requests focus on the game tab.
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
		try {
			this.wait();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
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
	
	/**
	 * Generates the number problem for the game.
	 */
	public void generateNumberProblem() {
		// Uses the factory to create a number problem based on the users choice.
		if (problemType.equalsIgnoreCase("addition")) {
			numberProblem = numberProblemFactory.createNumberProblem("addition");
		}
		if (problemType.equalsIgnoreCase("subtraction")) {
			numberProblem = numberProblemFactory.createNumberProblem("subtraction");
		}
		if (problemType.equalsIgnoreCase("multiplication")) {
			numberProblem = numberProblemFactory.createNumberProblem("multiplication");
		}
		if (problemType.equalsIgnoreCase("division")) {
			numberProblem = numberProblemFactory.createNumberProblem("division");
		}
		// Mixed option generates a random number to choose a random problem.
		if (problemType.equalsIgnoreCase("mixed")) {
			int type = 0;
			Random random = new Random();
			type = random.nextInt(3) + 1;
			if (type == 1) {
				numberProblem = numberProblemFactory.createNumberProblem("addition");
			}
			if (type == 2) {
				numberProblem = numberProblemFactory.createNumberProblem("subtraction");
			}
			if (type == 3) {
				numberProblem = numberProblemFactory.createNumberProblem("multiplication");
			}
			if (type == 4) {
				numberProblem = numberProblemFactory.createNumberProblem("division");
			}
		}
		// Generates a number problem based on the difficulty.
		if (difficulty.equalsIgnoreCase("easy")) {
			numberProblem.easyNumberProblem();
		}
		if (difficulty.equalsIgnoreCase("medium")) {
			numberProblem.mediumNumberProblem();
		}
		if (difficulty.equalsIgnoreCase("hard")) {
			numberProblem.hardNumberProblem();
		}
		// Sets the text of the associated labels.
		numberProblemLabel.setText(numberProblem.getProblem());
		answerLabel.setText(String.valueOf(numberProblem.getAnswer()));
	}
	
	/**
	 * Generates a falling number based on difficulty and type.
	 * @return
	 */
	public String generateFallingNumber() {
		Random random = new Random();
		String fallingSum = "";
		if (numberProblem.getProblem().contains("+")) {
			if (difficulty.equalsIgnoreCase("easy")) {
				fallingSum = (random.nextInt(4)+1) + " + " + (random.nextInt(4)+1);
			}
			if (difficulty.equalsIgnoreCase("medium")) {
				fallingSum = random.nextInt(49)+1 + " + " + random.nextInt(49)+1;
			}
			if (difficulty.equalsIgnoreCase("hard")) {
				fallingSum = random.nextInt(499)+1 + " + " + random.nextInt(499)+1;
			}
		}
		return fallingSum;
	}
	
	
}
