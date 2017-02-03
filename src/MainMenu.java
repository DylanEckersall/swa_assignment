import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Class for the main menu UI screen.
 * @author Dylan
 *
 */
public class MainMenu {

  	private Button playButton;
  	private Button helpButton;
  	private Button quitButton;
  	private Pane content;
  	
  	/**
  	 * Constructor for the main menu - builds the main menu screen.
  	 */
  	public MainMenu() {
  		// Instantiates the buttons on the main menu.
		playButton = new Button("Play Game");
		helpButton = new Button("Instructions");
		quitButton = new Button("Quit");
		content = new Pane();
		// Styling and positioning for the buttons.
	  	playButton.setLayoutY(100);
	  	helpButton.setLayoutY(250);
	  	quitButton.setLayoutY(400);
	  	playButton.setLayoutX(300);
	  	helpButton.setLayoutX(300);
	  	quitButton.setLayoutX(300);
	  	playButton.setStyle("-fx-background-color: #1aff1a; -fx-font-size: 30px; -fx-cursor: hand");
	  	playButton.setPrefHeight(100);
	  	playButton.setPrefWidth(200);
	  	helpButton.setStyle("-fx-background-color: #1aff1a; -fx-font-size: 30px; -fx-cursor: hand");
	  	helpButton.setPrefHeight(100);
	  	helpButton.setPrefWidth(200);
	  	quitButton.setStyle("-fx-background-color: #1aff1a; -fx-font-size: 30px; -fx-cursor: hand");
	  	quitButton.setPrefHeight(100);
	  	quitButton.setPrefWidth(200);
		// Adds the buttons to the main menu pane.
		content.getChildren().addAll(playButton, helpButton, quitButton);
		// Sets the background of the content area to black.
		content.setStyle("-fx-background-color: #000000");
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
