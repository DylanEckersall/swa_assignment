import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The AssignmentTemplate class used for running the application.
 * @author Dylan Eckersall
 *
 */
public class AssignmentTemplate extends Application {
	
	public static void main(String[] args) {
			launch(args);
	}

	private Stage stage;
	private MenuBar menuBar;
	private Scene scene; 
	private TabPane root; 
	private Tab tab1, tab2;
	private EventHandler<ActionEvent> aEventHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			
			
		}
	};

	/**
	 * Concrete implementation of the start method from the Application class
	 * @param stage 
	 */
	public void start(Stage stage) throws Exception {
	  	stage.setTitle("Software Architectures – Dylan Eckersall"); // Sets the title of the window.
	  	// Declares and instantiates the content area for the application.
	  	root = new TabPane();
	    scene = new Scene(root, 800, 600);
	  	stage.setScene(scene);
	  	// The panes to store the content for each tab.
	  	Pane tab1Content = new Pane();
	  	Pane tab2Pane = new Pane();
	  	menuBar = new MenuBar();
	  	Menu pauseMenu = new Menu();
	  	pauseMenu.setText("Test");
	  	Menu fullScreenMenu = new Menu();
	  	fullScreenMenu.setText("Full Screen");
	  	fullScreenMenu.setOnAction(aEventHandler);
	  	Menu settingsMenu = new Menu();
	  	settingsMenu.setText("Settings");
	  	menuBar.getMenus().addAll(pauseMenu, fullScreenMenu, settingsMenu);
	  	menuBar.setPrefWidth(800);
	  	tab1Content.getChildren().add(menuBar);
	  	// Instantiates the first tab and makes it so that the tab cannot be closed.
	  	tab1 = new Tab();
	  	tab1.setText("Play");
	  	tab1.setClosable(false);
	  	tab1.setContent(tab1Content); // Sets the content for this tab as the content from tab1Pane.
	  	tab1Content.setStyle("-fx-background-color: #000000"); // Sets the background of the content area to black.
	  	root.getTabs().add(tab1); // Adds the tab to the TabPane.
	  	
	  	// This process is repeated for the second tab.
	  	tab2 = new Tab();
	  	tab2.setText("High Scores");
	  	tab2.setClosable(false);
	  	tab2.setContent(tab2Pane);
	  	root.getTabs().add(tab2);
	  	
	  	stage.setResizable(false);
		stage.show();
	}
}
