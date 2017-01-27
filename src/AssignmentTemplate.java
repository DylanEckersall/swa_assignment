import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	/**
	 * The main method used to run the application.
	 * @param args
	 */
	public static void main(String[] args) {
			launch(args);
	}

	private Scene scene; // The scene for the application.
	private TabPane root; // The TabPane for the application to allow multiple tabs.
	private Tab tab1, tab2; // The tabs for the TabPane.

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
	  	Pane tab1Pane = new Pane();
	  	Pane tab2Pane = new Pane();
//	  	Button button = new Button();
//	  	button.setText("Test");
//	  	tab1Pane.getChildren().add(button);
	  	
	  	// Instantiates the first tab and makes it so that the tab cannot be closed.
	  	tab1 = new Tab();
	  	tab1.setText("First Tab");
	  	tab1.setClosable(false);
	  	tab1.setContent(tab1Pane); // Sets the content for this tab as the content from tab1Pane.
	  	tab1Pane.setStyle("-fx-background-color: #000000"); // Sets the background of the content area to black.
	  	root.getTabs().add(tab1); // Adds the tab to the TabPane.
	  	
	  	// This process is repeated for the second tab.
	  	tab2 = new Tab();
	  	tab2.setText("Second Tab");
	  	tab2.setClosable(false);
	  	tab2.setContent(tab2Pane);
	  	root.getTabs().add(tab2);
	  	
	  	
	  	stage.show();
	}
}
