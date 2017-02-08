import com.sun.org.apache.xpath.internal.operations.Div;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * The AssignmentTemplate class used for running the application.
 * @author Dylan Eckersall
 *
 */
public class AssignmentTemplate extends Application {
	
	private Scene scene; 
	private TabPane root; 
	private Tab tab1, tab2;
	
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
	  	
	  	// Creates objects for all of the UI components.
	  	MainMenuUI mainMenuUI = new MainMenuUI();
	  	HelpScreenUI helpScreen = new HelpScreenUI();
	  	GameUI gameUI = new GameUI("Test");
	  	
	  	// Implements the event handler for the quit button on the main menu.
	  	mainMenuUI.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);	
			}
		});
	  	
	  	// Implements the event handler for the help button on the main menu.
	  	mainMenuUI.getHelpButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tab1.setContent(helpScreen.getContent());	
			}
		});
	  	
	  	// Implements the event handler for the play game button on the main menu.
	  	mainMenuUI.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tab1.setContent(gameUI.getContent());
			}
		});
	  	
	  	// Implements the event handler for the main menu button on the help screen.
	  	helpScreen.getMainMenuButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tab1.setContent(mainMenuUI.getContent());
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
//	  	tab2.setContent();
	  	root.getTabs().add(tab2);
	  	
	  	DivisionNumberProblem divisionNumberProblem = new DivisionNumberProblem();
	  	divisionNumberProblem.hardNumberProblem();
	  	System.out.println(divisionNumberProblem.getProblem() + " = " + divisionNumberProblem.getAnswer());
	  	SubtractionNumberProblem subtractionNumberProblem = new SubtractionNumberProblem();
	  	subtractionNumberProblem.hardNumberProblem();
	  	System.out.println(subtractionNumberProblem.getProblem() + " = " + subtractionNumberProblem.getAnswer());
	  	
	  	stage.setResizable(false);
		stage.show();
	}
}
