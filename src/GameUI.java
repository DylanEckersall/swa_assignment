import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;

/**
 * Class for the game UI.
 * @author Dylan
 *
 */
public class GameUI {
	
	private Pane content;
	private ToolBar toolBar;
	private Button fullScreenButton;
	private Button startButton;
	private Button pauseButton;
	private Button settingsButton;

	/**
	 * Constructor for the game UI - builds the screen for the gameplay.
	 */
	public GameUI() {
		content = new Pane();
		toolBar = new ToolBar();
		fullScreenButton = new Button("Full Screen");
		startButton = new Button("Start");
		pauseButton = new Button("Pause");
		settingsButton = new Button("Settings");
		toolBar.getItems().addAll(fullScreenButton, startButton, pauseButton, settingsButton);
		toolBar.setPrefWidth(800);
		content.getChildren().addAll(toolBar);
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
	
	
}
