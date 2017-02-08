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
 * The UI screen for choosing addition, subtraction etc.
 * @author Dylan
 *
 */
public class ProblemSelectionUI {
	
	private Pane content;
	private Button additionButton;
	private Button subtractionButton;
	private Button multiplicationButton;
	private Button divisionButton;
	private Button mixedButton;
	
	/**
	 * Builds the problem selection UI screen.
	 */
	public ProblemSelectionUI() {
		content = new Pane();
		// Styling for the addition button.
		additionButton = new Button("Addition");
		additionButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		additionButton.setLayoutY(15);
		additionButton.setLayoutX(15);
	  	additionButton.setPrefHeight(75);
	  	additionButton.setPrefWidth(175);
	  	// Styling for the subtraction button.
		subtractionButton = new Button("Subtraction");
		subtractionButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		subtractionButton.setLayoutY(15);
		subtractionButton.setLayoutX(600);
	  	subtractionButton.setPrefHeight(75);
	  	subtractionButton.setPrefWidth(175);
	  	// Styling for the multiplication button.
		multiplicationButton = new Button("Multiplication");
		multiplicationButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		multiplicationButton.setLayoutY(475);
		multiplicationButton.setLayoutX(15);
	  	multiplicationButton.setPrefHeight(75);
	  	multiplicationButton.setPrefWidth(175);
		// Styling for the division button.
		divisionButton = new Button("Division");
		divisionButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		divisionButton.setLayoutY(475);
		divisionButton.setLayoutX(600);
	  	divisionButton.setPrefHeight(75);
	  	divisionButton.setPrefWidth(175);
		// Styling for the mixed button.
		mixedButton = new Button("Mixed");
		mixedButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		mixedButton.setLayoutY(250);
		mixedButton.setLayoutX(315);
	  	mixedButton.setPrefHeight(75);
	  	mixedButton.setPrefWidth(175);
	  	// Adds an instruction label to the pane.
	  	Label instructionLabel = new Label("Choose your type of sums...");
	  	instructionLabel.setStyle("-fx-font-size: 24px;");
	  	instructionLabel.setLayoutX(220);
	  	instructionLabel.setLayoutY(10);
	  	instructionLabel.setTextFill(Color.BLUE);
	  	content.getChildren().add(instructionLabel);
		// Adds all of the buttons to the pane.
		content.getChildren().addAll(additionButton, subtractionButton, multiplicationButton, divisionButton, mixedButton);
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
	 * @return the content pane.
	 */
	public Pane getContent() {
		return content;
	}

	/**
	 * Returns the addition button for the UI screen.
	 * @return the additionButton
	 */
	public Button getAdditionButton() {
		return additionButton;
	}

	/**
	 * Returns the subtraction button for the UI screen.
	 * @return the subtractionButton
	 */
	public Button getSubtractionButton() {
		return subtractionButton;
	}

	/**
	 * Returns the multiplication button for the UI screen.
	 * @return the multiplicationButton
	 */
	public Button getMultiplicationButton() {
		return multiplicationButton;
	}

	/**
	 * Returns the division button for the UI screen.
	 * @return the divisionButton
	 */
	public Button getDivisionButton() {
		return divisionButton;
	}

	/**
	 * Returns the mixed button for the UI screen.
	 * @return the mixedButton
	 */
	public Button getMixedButton() {
		return mixedButton;
	}

	/**
	 * Sets the content pane for the UI screen.
	 * @param content the content to set
	 */
	public void setContent(Pane content) {
		this.content = content;
	}

	/**
	 * Sets the addition button for the UI screen.
	 * @param additionButton the additionButton to set
	 */
	public void setAdditionButton(Button additionButton) {
		this.additionButton = additionButton;
	}

	/**
	 * Sets the subtraction button for the UI screen.
	 * @param subtractionButton the subtractionButton to set
	 */
	public void setSubtractionButton(Button subtractionButton) {
		this.subtractionButton = subtractionButton;
	}

	/**
	 * Sets the multiplication button for the UI screen.
	 * @param multiplicationButton the multiplicationButton to set
	 */
	public void setMultiplicationButton(Button multiplicationButton) {
		this.multiplicationButton = multiplicationButton;
	}

	/**
	 * Sets the division button for the UI screen.
	 * @param divisionButton the divisionButton to set
	 */
	public void setDivisionButton(Button divisionButton) {
		this.divisionButton = divisionButton;
	}

	/**
	 * Sets the mixed button for the UI screen.
	 * @param mixedButton the mixedButton to set
	 */
	public void setMixedButton(Button mixedButton) {
		this.mixedButton = mixedButton;
	}
	
	
}
