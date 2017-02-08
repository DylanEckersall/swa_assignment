import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Class for the difficulty UI screen.
 * @author Dylan
 *
 */
public class DifficultyUI {

	private Pane content;
	private Button easyButton;
	private Button mediumButton;
	private Button hardButton;
	
	/**
	 * Constructor for the difficulty UI - builds the diffulty
	 * selection screen.
	 */
	public DifficultyUI() {
		content = new Pane();
		// Styling for the easy button.
		easyButton = new Button("Easy");
		easyButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		easyButton.setLayoutY(100);
		easyButton.setLayoutX(300);
	  	easyButton.setPrefHeight(75);
	  	easyButton.setPrefWidth(175);
		// Styling for the medium button.
		mediumButton = new Button("Medium");
		mediumButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		mediumButton.setLayoutY(250);
		mediumButton.setLayoutX(300);
	  	mediumButton.setPrefHeight(75);
	  	mediumButton.setPrefWidth(175);
		// Styling for the hard button.
		hardButton = new Button("Hard");
		hardButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		hardButton.setLayoutY(400);
		hardButton.setLayoutX(300);
	  	hardButton.setPrefHeight(75);
	  	hardButton.setPrefWidth(175);
	  	// Adds an instruction label to the pane.
	  	Label instructionLabel = new Label("Choose a difficulty...");
	  	instructionLabel.setStyle("-fx-font-size: 24px;");
	  	instructionLabel.setLayoutX(220);
	  	instructionLabel.setLayoutY(10);
	  	instructionLabel.setTextFill(Color.BLUE);
	  	content.getChildren().add(instructionLabel);
	  	// Adds all of the buttons to the pane.
	  	content.getChildren().addAll(easyButton, mediumButton, hardButton);
		// Creates and adds a new background image to the problem selection screen.
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
	 * Returns the easy button for the UI screen.
	 * @return the easyButton
	 */
	public Button getEasyButton() {
		return easyButton;
	}

	/** Returns the medium button for the UI screen.
	 * @return the mediumButton
	 */
	public Button getMediumButton() {
		return mediumButton;
	}

	/**
	 * Returns the hard button for the UI screen.
	 * @return the hardButton
	 */
	public Button getHardButton() {
		return hardButton;
	}

	/**
	 * Sets the content pane for the UI screen.
	 * @param content the content to set
	 */
	public void setContent(Pane content) {
		this.content = content;
	}

	/**
	 * Sets the easy button for the UI screen.
	 * @param easyButton the easyButton to set
	 */
	public void setEasyButton(Button easyButton) {
		this.easyButton = easyButton;
	}

	/**
	 * Sets the medium button for the UI screen.
	 * @param mediumButton the mediumButton to set
	 */
	public void setMediumButton(Button mediumButton) {
		this.mediumButton = mediumButton;
	}

	/**
	 * Sets the hard button for the UI screen.
	 * @param hardButton the hardButton to set
	 */
	public void setHardButton(Button hardButton) {
		this.hardButton = hardButton;
	}
	
}
