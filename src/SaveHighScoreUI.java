import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SaveHighScoreUI {

	private Pane content;
	private Button saveScore;
	private Button dontSaveScore;
	private TextField nameField;
	
	public SaveHighScoreUI(int score) {
		content = new Pane();
		nameField = new TextField();
		nameField.setPrefWidth(500);
		nameField.setPrefHeight(40);
		nameField.setStyle("-fx-font-size: 24px");
		nameField.setLayoutY(375);
		nameField.setLayoutX(150);
		saveScore = new Button("Save my score");
		saveScore.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		saveScore.setLayoutY(475);
		saveScore.setLayoutX(600);
	  	saveScore.setPrefHeight(75);
	  	saveScore.setPrefWidth(175);
		dontSaveScore = new Button("No thanks");
		dontSaveScore.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		dontSaveScore.setLayoutY(475);
		dontSaveScore.setLayoutX(15);
	  	dontSaveScore.setPrefHeight(75);
	  	dontSaveScore.setPrefWidth(175);
		Label highScoreLabel = new Label("Game Over! Your score was: ");
		highScoreLabel.setTextFill(Color.BLUE);
		highScoreLabel.setStyle("-fx-font-size: 30px");
		highScoreLabel.setLayoutY(20);
		highScoreLabel.setLayoutX(150);
		Label scoreLabel = new Label(String.valueOf(score));
		scoreLabel.setTextFill(Color.BLUE);
		scoreLabel.setStyle("-fx-font-size: 26px");
		scoreLabel.setLayoutY(60);
		scoreLabel.setLayoutX(400);
		Label saveScoreLabel = new Label("Enter your name to save your score");
		saveScoreLabel.setTextFill(Color.BLUE);
		saveScoreLabel.setStyle("-fx-font-size: 30px");
		saveScoreLabel.setLayoutY(100);
		saveScoreLabel.setLayoutX(150);
		content.getChildren().addAll(highScoreLabel, scoreLabel, saveScoreLabel, saveScore, dontSaveScore, nameField);
		// Creates and adds a new background image to the save high score screen.
		Image image = new Image(GameUI.class.getResource("resources/background.jpg").toExternalForm());
		BackgroundPosition backgroundPosition = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, 0, false);
		BackgroundSize backgroundSize = new BackgroundSize(800, 600, false, false, true, true);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, backgroundPosition, backgroundSize);
		Background background = new Background(backgroundImage);
		content.setBackground(background);
	}

	/**
	 * Returns the content pane for the UI screen.
	 * @return the content
	 */
	public Pane getContent() {
		return content;
	}

	/**
	 * Returns the save score button for the UI screen.
	 * @return the saveScore
	 */
	public Button getSaveScore() {
		return saveScore;
	}

	/**
	 * Returns the dont save score button for the UI screen.
	 * @return the dontSaveScore
	 */
	public Button getDontSaveScore() {
		return dontSaveScore;
	}

	/**
	 * Returns the name field for the UI screen.
	 * @return the nameField
	 */
	public TextField getNameField() {
		return nameField;
	}

	/**
	 * Sets the content pane for the UI screen.
	 * @param content the content to set
	 */
	public void setContent(Pane content) {
		this.content = content;
	}

	/**
	 * Sets the save score button for the UI screen.
	 * @param saveScore the saveScore to set
	 */
	public void setSaveScore(Button saveScore) {
		this.saveScore = saveScore;
	}

	/**
	 * Sets the dont save score button for the UI screen.
	 * @param dontSaveScore the dontSaveScore to set
	 */
	public void setDontSaveScore(Button dontSaveScore) {
		this.dontSaveScore = dontSaveScore;
	}

	/**
	 * Sets the name field for the UI screen.
	 * @param nameField the nameField to set
	 */
	public void setNameField(TextField nameField) {
		this.nameField = nameField;
	}
	
	
	
}
