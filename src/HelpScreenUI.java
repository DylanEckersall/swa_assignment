import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Class for the help screen UI.
 * @author Dylan
 *
 */
public class HelpScreenUI {

  	private Pane content;
  	private Button mainMenuButton;
  	private Text instructions;
  	
  	/**
  	 * Constructor for the help screen UI - builds the help screen.
  	 */
  	public HelpScreenUI() {
		content = new Pane();
		mainMenuButton = new Button("Back to menu");
		mainMenuButton.setStyle("-fx-background-color: #00ffff; -fx-font-size: 20px; -fx-cursor: hand");
		mainMenuButton.setLayoutY(15);
		mainMenuButton.setLayoutX(15);
	  	mainMenuButton.setPrefHeight(75);
	  	mainMenuButton.setPrefWidth(175);
	  	instructions = new Text();
	  	instructions.setStyle("-fx-font-size: 20px");
	  	instructions.setText("1. Click \"Play Game\" on the main menu. \n"
	  					+ "2. Select a problem type. \n"
	  					+ "3. Select a difficulty. \n"
	  					+ "4. You will be given a number in the top middle of your screen. \n"
	  					+ "5. Correct the correct sum that makes the number in the top middle. \n"
	  					+ "6. Move the bucket using the arrow keys or A,D. \n"
	  					+ "7. The game ends when you run out of health. \n");
	  	instructions.setX(50);
	  	instructions.setY(150);
	  	instructions.setFill(Color.BLUE);
	  	content.getChildren().addAll(mainMenuButton, instructions);
		// Creates and adds a new background image to the help screen.
		Image image = new Image(GameUI.class.getResource("resources/background.jpg").toExternalForm());
		BackgroundPosition backgroundPosition = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, 0, false);
		BackgroundSize backgroundSize = new BackgroundSize(800, 600, false, false, true, true);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, backgroundPosition, backgroundSize);
		Background background = new Background(backgroundImage);
		content.setBackground(background);
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
