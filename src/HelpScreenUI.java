import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Class for the help screen UI.
 * @author Dylan
 *
 */
public class HelpScreenUI {

  	Pane content;
  	Button mainMenuButton;
  	
  	/**
  	 * Constructor for the help screen UI - builds the help screen.
  	 */
  	public HelpScreenUI() {
		content = new Pane();
		content.setStyle("-fx-background-color: #000000");
		mainMenuButton = new Button("Back to menu");
		mainMenuButton.setStyle("-fx-background-color: #1aff1a; -fx-font-size: 20px; -fx-cursor: hand");
		mainMenuButton.setLayoutY(15);
		mainMenuButton.setLayoutX(15);
	  	mainMenuButton.setPrefHeight(100);
	  	mainMenuButton.setPrefWidth(200);
	  	content.getChildren().addAll(mainMenuButton);
	}

	/**
	 * Returns the content for the help screen.
	 * @return the content
	 */
	public Pane getContent() {
		return content;
	}

	/**
	 * Returns the main menu button for the help screen.
	 * @return the mainMenuButton
	 */
	public Button getMainMenuButton() {
		return mainMenuButton;
	}

	/**
	 * Sets the content for the help screen.
	 * @param content the content to set
	 */
	public void setContent(Pane content) {
		this.content = content;
	}

	/**
	 * Sets the main menu button for the help screen.
	 * @param mainMenuButton the mainMenuButton to set
	 */
	public void setMainMenuButton(Button mainMenuButton) {
		this.mainMenuButton = mainMenuButton;
	}
	
}
