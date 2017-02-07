import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 * Class for the main menu UI screen.
 * @author Dylan
 *
 */
public class MainMenuUI {

  	private Button playButton;
  	private Button helpButton;
  	private Button quitButton;
  	private Pane content;
  	
  	/**
  	 * Constructor for the main menu - builds the main menu screen.
  	 */
  	public MainMenuUI() {
  		// Instantiates the buttons on the main menu.
		playButton = new Button("Play Game");
		helpButton = new Button("Instructions");
		quitButton = new Button("Quit");
		content = new Pane();
		// Creates and adds a new background image to the main menu screen.
		Image image = new Image(GameUI.class.getResource("resources/background.jpg").toExternalForm());
		BackgroundPosition backgroundPosition = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, 0, false);
		BackgroundSize backgroundSize = new BackgroundSize(800, 600, false, false, true, true);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, backgroundPosition, backgroundSize);
		Background background = new Background(backgroundImage);
		content.setBackground(background);
		// Styling and positioning for the buttons.
	  	playButton.setLayoutY(100);
	  	helpButton.setLayoutY(250);
	  	quitButton.setLayoutY(400);
	  	playButton.setLayoutX(300);
	  	helpButton.setLayoutX(300);
	  	quitButton.setLayoutX(300);
	  	playButton.setStyle("-fx-background-color: #1aff1a; -fx-font-size: 20px; -fx-cursor: hand");
	  	playButton.setPrefHeight(100);
	  	playButton.setPrefWidth(200);
	  	helpButton.setStyle("-fx-background-color: #1aff1a; -fx-font-size: 20px; -fx-cursor: hand");
	  	helpButton.setPrefHeight(100);
	  	helpButton.setPrefWidth(200);
	  	quitButton.setStyle("-fx-background-color: #1aff1a; -fx-font-size: 20px; -fx-cursor: hand");
	  	quitButton.setPrefHeight(100);
	  	quitButton.setPrefWidth(200);
		// Adds the buttons to the main menu pane.
		content.getChildren().addAll(playButton, helpButton, quitButton);
	}

	/**
	 * Gets the play button from the main menu.
	 * @return the playButton
	 */
	public Button getPlayButton() {
		return playButton;
	}

	/**
	 * Gets the help button from the main menu.
	 * @return the helpButton
	 */
	public Button getHelpButton() {
		return helpButton;
	}

	/**
	 * Gets the quit button from the main menu.
	 * @return the quitButton
	 */
	public Button getQuitButton() {
		return quitButton;
	}

	/**
	 * Gets the content of the main menu.
	 * @return the content
	 */
	public Pane getContent() {
		return content;
	}

	/**
	 * Sets the play button for the main menu.
	 * @param playButton the playButton to set
	 */
	public void setPlayButton(Button playButton) {
		this.playButton = playButton;
	}

	/**
	 * Sets the help button for the main menu.
	 * @param helpButton the helpButton to set
	 */
	public void setHelpButton(Button helpButton) {
		this.helpButton = helpButton;
	}

	/**
	 * Sets the quit button for the main menu.
	 * @param quitButton the quitButton to set
	 */
	public void setQuitButton(Button quitButton) {
		this.quitButton = quitButton;
	}

	/**
	 * Sets the content for the main menu.
	 * @param content the content to set
	 */
	public void setContent(Pane content) {
		this.content = content;
	}
	
}
