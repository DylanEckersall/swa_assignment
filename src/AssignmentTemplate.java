import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
	// Declares and instantiates the event handler for all action events. 
	private EventHandler<ActionEvent> aEventHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
			double height = dimensions.getHeight();
			double width = dimensions.getWidth();
			stage.setFullScreenExitHint("Press ESC to exit full screen.");
			stage.setFullScreen(true);
			stage.setX(0);
			stage.setY(0);
			stage.setHeight(height);
			stage.setWidth(width);
			menuBar.setPrefWidth(width);
		}
	};

	/**
	 * Concrete implementation of the start method from the Application class
	 * @param stage 
	 */
	public void start(Stage stage) throws Exception {
		this.stage = stage;
	  	stage.setTitle("Software Architectures – Dylan Eckersall"); // Sets the title of the window.
	  	// Declares and instantiates the content area for the application.
	  	root = new TabPane();
	    scene = new Scene(root, 800, 600);
	  	stage.setScene(scene);
	  	// The panes to store the content for each tab.
	  	Pane tab2Content = new Pane();
	  	// Creates objects for all of the UI components.
	  	MainMenuUI mainMenuUI = new MainMenuUI();
	  	HelpScreenUI helpScreen = new HelpScreenUI();
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
	  	// Implements the event handler for the main menu button on the help screen.
	  	helpScreen.getMainMenuButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tab1.setContent(mainMenuUI.getContent());
			}
		});
	  	menuBar = new MenuBar();
	  	Menu menu = new Menu();
	  	menu.setText("Options");
	  	MenuItem fullScreen = new MenuItem();
	  	fullScreen.setText("Enter full screen..");
	  	fullScreen.setOnAction(aEventHandler);
	  	menu.getItems().add(fullScreen);
	  	menuBar.getMenus().addAll(menu);
	  	menuBar.setPrefWidth(800);
	  	mainMenuUI.getContent().getChildren().add(menuBar);
	  	// Instantiates the first tab and makes it so that the tab cannot be closed.
	  	tab1 = new Tab();
	  	tab1.setText("Play");
	  	tab1.setClosable(false); 
	  	tab1.setContent(mainMenuUI.getContent()); // Sets the content for this tab as the content from tab1Pane.
	  	root.getTabs().add(tab1); // Adds the tab to the TabPane.
	  	// This process is repeated for the second tab.
	  	tab2 = new Tab();
	  	tab2.setText("High Scores");
	  	tab2.setClosable(false);
	  	tab2.setContent(tab2Content);
	  	root.getTabs().add(tab2);
	  	
	  	stage.setResizable(false);
		stage.show();
	}
}
