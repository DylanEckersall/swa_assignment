import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
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
	private Label answerLabel;
	private Label timerLabel;
	private Label scoreLabel;
	private boolean isPaused;
	private boolean intersectFlag;
	private double x;
	private int timeTaken;
	private int score;
	private Duration fallingDuration;
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
					content.getChildren().remove(label);
					toDelete.add(label);
					int sum = 0;
					String firstNumber = "";
					String secondNumber = "";
					Pattern pattern = Pattern.compile("^([0-9]*)");
					Pattern pattern2 = Pattern.compile("([0-9]*)$");
					Matcher matcher = pattern.matcher(label.getText());
					Matcher matcher2 = pattern2.matcher(label.getText());
					if (matcher.find() && matcher2.find()) {
						firstNumber = matcher.group(1);
						secondNumber = matcher2.group(1);
					}
					if (problemType.equalsIgnoreCase("addition")) {
						sum = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
					}
					if (problemType.equalsIgnoreCase("division")) {
						sum = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
					}
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
					for (Label label2 : fallingSums) {
						content.getChildren().remove(label2);
					}
					fallingSums.clear();
					System.out.println("True");
					generateNumberProblem();
					fallingDuration = fallingDuration.subtract(Duration.millis(250));
					System.out.println(fallingDuration.toString());
					if (timeTaken < 10) {
						score += 50;
						scoreLabel.setText("Score: " + String.valueOf(score));
						timeTaken = 0;
					}
					if (timeTaken >= 10 && timeTaken < 20) {
						score += 40;
						scoreLabel.setText("Score: " + String.valueOf(score));
						timeTaken = 0;
					}
					if (timeTaken >= 20 && timeTaken < 30) {
						score += 30;
						scoreLabel.setText("Score: " + String.valueOf(score));
						timeTaken = 0;
					}
					if (timeTaken >= 30 && timeTaken < 40) {
						score += 20;
						scoreLabel.setText("Score: " + String.valueOf(score));
						timeTaken = 0;
					}
					if (timeTaken >= 40) {
						score += 10;
						scoreLabel.setText("Score: " + String.valueOf(score));
						timeTaken = 0;
					}
					progressBar.setProgress(progressBar.getProgress() + .10);
				}
				else if (!correctAnswer) {
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
		timeTaken = 0;
		score = 0;
		fallingDuration = Duration.seconds(10);
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
					Platform.runLater(new Runnable() {
						public void run() {
							Random random = new Random();
							Label number = new Label(numberProblem.getProblem());
							number.setLayoutY(75);
							number.setLayoutX(random.nextInt(750) + 1);
							number.setStyle("-fx-font-size: 18px");
							content.getChildren().add(number);
							fallingSums.add(number);
							Timeline timeline = new Timeline(60);
							timeline.setCycleCount(1);
							KeyValue keyValue = new KeyValue(number.layoutYProperty(), 800);
							KeyFrame keyFrame = new KeyFrame(fallingDuration, keyValue);
							timeline.getKeyFrames().add(keyFrame);
							timeline.play();
						}
					});
				}
		};
		// Sets the task to run every 10 seconds.
		timer.scheduleAtFixedRate(checkAnswerIsFalling, 10000, 10000);
		// Creates a new timertask for generating falling numbers.
		TimerTask createFallingNumber = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						Random random = new Random();
						Label number = new Label(generateFallingNumber());
						number.setLayoutY(75);
						number.setLayoutX(random.nextInt(750) + 1);
						number.setStyle("-fx-font-size: 18px");
						content.getChildren().add(number);
						fallingSums.add(number);
						Timeline timeline = new Timeline(60);
						KeyValue keyValue = new KeyValue(number.layoutYProperty(), 800);
						KeyFrame keyFrame = new KeyFrame(fallingDuration, keyValue);
						timeline.setCycleCount(1);
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
					}
				});
			}
		};
		// Sets the task to run every 3 seconds.
		timer.scheduleAtFixedRate(createFallingNumber, 1, 3000);
		// Creates a timer task to represent a timer.
		TimerTask timerTask = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						timeTaken += 1;
						timerLabel.setText(String.valueOf(timeTaken));
						System.out.println(timeTaken);
					}
				});
			}
		};
		// Sets the timer task to run every second.
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
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
		// Creates an image for the timer icon.
		ImageView timerIcon = new ImageView(new Image(GameUI.class.getResource("resources/alarm-clock.png").toExternalForm()));
		timerIcon.setX(10);
		timerIcon.setY(50);
		content.getChildren().add(timerIcon);
		// Creates a label representing the timer
		timerLabel = new Label("0");
		timerLabel.setStyle("-fx-font-size: 24px");
		timerLabel.setLayoutX(40);
		timerLabel.setLayoutY(50);
		content.getChildren().add(timerLabel);
		// Creates a new label representing the score.
		scoreLabel = new Label("Score: " + String.valueOf(score));
		scoreLabel.setStyle("-fx-font-size: 20px");
		scoreLabel.setLayoutY(50);
		scoreLabel.setLayoutX(650);
		content.getChildren().add(scoreLabel);
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
		answerLabel.setText(String.valueOf((int)numberProblem.getAnswer()));
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
				fallingSum = (random.nextInt(49)+1) + " + " + (random.nextInt(49)+1);
			}
			if (difficulty.equalsIgnoreCase("hard")) {
				fallingSum = (random.nextInt(499)+1) + " + " + (random.nextInt(499)+1);
			}
		}
		if (numberProblem.getProblem().contains("/")) {
			if (difficulty.equalsIgnoreCase("easy")) {
				int leftOperator = random.nextInt(9) + 1;
				int rightOperator = random.nextInt(4) + 1;
				int total = leftOperator * rightOperator;
				fallingSum = String.valueOf(total) + " / " + String.valueOf(rightOperator);
			}
			if (difficulty.equalsIgnoreCase("medium")) {
				int leftOperator = random.nextInt(9) + 1;
				int rightOperator = random.nextInt(9) + 1;
				int total = leftOperator * rightOperator;
				fallingSum = String.valueOf(total) + " / " + String.valueOf(rightOperator);
			}
			if (difficulty.equalsIgnoreCase("hard")) {
				int leftOperator = random.nextInt(49) + 1;
				int rightOperator = random.nextInt(9) + 1;
				int total = leftOperator * rightOperator;
				fallingSum = String.valueOf(total) + " / " + String.valueOf(rightOperator);
			}
		}
		return fallingSum;
	}
	
	/**
	 * Ends the current game.
	 */
	public void endGame() {
		
	}
	
	
}
