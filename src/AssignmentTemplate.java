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
			System.out.println(event.toString());
//			stage.setFullScreen(true);
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
	  	Pane mainMenu = new Pane();
	  	Pane tab2Content = new Pane();
	  	// Creates 3 buttons and adds them to the tab1Content pane.
	  	Button playButton = new Button("Play Game");
	  	Button helpButton = new Button("Help");
	  	Button quitButton = new Button("Quit");
	  	mainMenu.getChildren().addAll(playButton, helpButton, quitButton);
	  	// Positioning and styling for the buttons
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
	  	// Creates the pane for the help screen.
	  	Pane helpScreen = new Pane();
	  	Label test = new Label("Test");
	  	test.setLayoutY(100);
	  	helpScreen.getChildren().add(test);
	  	// Implements the event handler for the quit button.
	  	quitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);	
			}
		});
	  	// Implements the event handler for the help button.
	  	helpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tab1.setContent(helpScreen);	
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
	  	mainMenu.getChildren().add(menuBar);
	  	// Instantiates the first tab and makes it so that the tab cannot be closed.
	  	tab1 = new Tab();
	  	tab1.setText("Play");
	  	tab1.setClosable(false);
	  	tab1.setContent(mainMenu); // Sets the content for this tab as the content from tab1Pane.
	  	mainMenu.setStyle("-fx-background-color: #000000"); // Sets the background of the content area to black.
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
