import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Class for the high scores UI.
 * @author Dylan
 *
 */
public class HighScoresUI {

	private Pane content;
	private Button returnToMenu;
	
	/**
	 * HighScoresUI constructor - builds the high scores UI screen.
	 */
	public HighScoresUI() {
		
	}

	/**
	 * Returns the content pane for the UI screen.
	 * @return the content
	 */
	public Pane getContent() {
		return content;
	}

	/**
	 * Returns the return to menu button for the UI screen.
	 * @return the returnToMenu
	 */
	public Button getReturnToMenu() {
		return returnToMenu;
	}

	/**
	 * Sets the content pane for the UI screen.
	 * @param content the content to set
	 */
	public void setContent(Pane content) {
		this.content = content;
	}

	/**
	 * Sets the main menu button for the UI screen.
	 * @param returnToMenu the returnToMenu to set
	 */
	public void setReturnToMenu(Button returnToMenu) {
		this.returnToMenu = returnToMenu;
	}
	
}
