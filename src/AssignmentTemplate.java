import com.sun.org.apache.xpath.internal.operations.Div;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * The AssignmentTemplate class used for running the application.
 * @author Dylan Eckersall
 *
 */
public class AssignmentTemplate extends Application {
	
	private Scene scene; 
	private TabPane root; 
	private Tab tab1, tab2;
	private MainMenuUI mainMenuUI;
	private HelpScreenUI helpScreenUI;
	private ProblemSelectionUI problemSelectionUI;
	private DifficultyUI difficultyUI;
	private HighScoresUI highScoresUI;
	private SaveHighScoreUI saveHighScoreUI;
	private GameUI gameUI;
  	private String problemType; 
  	private String difficulty;
  	private ChangeListener<String> playerHealthListener = new ChangeListener<String>() {
        public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
           if (Integer.parseInt(newValue) == 0) {
        	   saveHighScoreUI = new SaveHighScoreUI(gameUI.getScore());
        	   tab1.setContent(saveHighScoreUI.getContent());
        	   saveHighScoreUI.getSaveScore().setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					if (saveHighScoreUI.getNameField().getText().length() >= 7) {
						highScoresUI.insertDatabaseResults(saveHighScoreUI.getNameField().getText().substring(0, 6), gameUI.getScore());
					}
					else {
						highScoresUI.insertDatabaseResults(saveHighScoreUI.getNameField().getText(), gameUI.getScore());
					}
					highScoresUI.getDatabaseResults();
					tab1.setContent(highScoresUI.getContent());
				}
			});
           }
        }
	};
	
	public static void main(String[] args) {
			launch(args);
	}

	/**
	 * Concrete implementation of the start method from the Application class
	 * @param stage 
	 */
	public void start(Stage stage) throws Exception {
	  	stage.setTitle("Software Architectures – Dylan Eckersall"); // Sets the title of the window.
	  	
	  	// Declares and instantiates the content area for the application.
	  	root = new TabPane();
	  	root.setFocusTraversable(false);
	    scene = new Scene(root, 800, 600);
	  	stage.setScene(scene);
	  	
		String background = AssignmentTemplate.class.getResource("resources/background.jpg").toExternalForm();
	  	
	  	// Creates objects for all of the UI components except the game.
	  	mainMenuUI = new MainMenuUI();
	  	helpScreenUI = new HelpScreenUI();
	  	problemSelectionUI = new ProblemSelectionUI();
	  	difficultyUI = new DifficultyUI();
	  	highScoresUI = new HighScoresUI();
	  	highScoresUI.getDatabaseResults();
	  	
	  	// Implements the event handler for the quit button on the main menu.
	  	mainMenuUI.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.exit(0);	
			}
		});
	  	
	  	// Implements the event handler for the help button on the main menu.
	  	mainMenuUI.getHelpButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tab1.setContent(helpScreenUI.getContent());	
			}
		});
	  	
	  	// Implements the event handler for the play game button on the main menu.
	  	mainMenuUI.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tab1.setContent(problemSelectionUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the main menu button on the help screen.
	  	helpScreenUI.getMainMenuButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tab1.setContent(mainMenuUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the addition button on the problem selection screen.
	  	problemSelectionUI.getAdditionButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				problemType = "Addition";
				tab1.setContent(difficultyUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the subtraction button on the problem selection screen.
	  	problemSelectionUI.getSubtractionButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				problemType = "Subtraction";
				tab1.setContent(difficultyUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the multiplication button on the problem selection screen.
	  	problemSelectionUI.getMultiplicationButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				problemType = "Multiplication";
				tab1.setContent(difficultyUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the division button on the problem selection screen.
	  	problemSelectionUI.getDivisionButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				problemType = "Division";
				tab1.setContent(difficultyUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the mixed button on the problem selection screen.
	  	problemSelectionUI.getMixedButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				problemType = "Mixed";
				tab1.setContent(difficultyUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the easy button on the difficulty screen.
	  	difficultyUI.getEasyButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				difficulty = "Easy";
				gameUI = new GameUI(difficulty, problemType);
				tab1.setContent(gameUI.getContent());
				gameUI.getHealthLabel().textProperty().addListener(playerHealthListener);
			}
		});
	  	
	  	// Implements the event handler for the medium button on the difficulty screen.
	  	difficultyUI.getMediumButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				difficulty = "Medium";
				gameUI = new GameUI(difficulty, problemType);
				tab1.setContent(gameUI.getContent());
				gameUI.getHealthLabel().textProperty().addListener(playerHealthListener);
			}
		});
	  	
	  	// Implements the event handler for the hard button on the difficulty screen.
	  	difficultyUI.getHardButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				difficulty = "Hard";
				gameUI = new GameUI(difficulty, problemType);
				tab1.setContent(gameUI.getContent());
				gameUI.getHealthLabel().textProperty().addListener(playerHealthListener);
			}
		});
	  	
	  	// Instantiates the first tab and makes it so that the tab cannot be closed.
	  	tab1 = new Tab();
	  	tab1.setText("Play");
	  	tab1.setClosable(false); 
	  	// Sets the content for this tab as the content from tab1Pane.
	  	tab1.setContent(mainMenuUI.getContent());
	  	// Adds the tab to the TabPane.
	  	root.getTabs().add(tab1);
	  	// This process is repeated for the second tab.
	  	tab2 = new Tab();
	  	tab2.setText("High Scores");
	  	tab2.setClosable(false);
	  	tab2.setContent(highScoresUI.getContent());
	  	root.getTabs().add(tab2);
	  	
	  	// Stops timers from running when the application has been closed.
	  	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
	  	
	  	stage.setResizable(false);
		stage.show();
	}
}
