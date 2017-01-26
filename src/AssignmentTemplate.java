import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class AssignmentTemplate extends Application {
	public static void main(String[] args) {
			launch(args);
	}

Scene scene;
	TabPane root;
	Tab tab1, tab2;

	public void start(Stage stage) throws Exception {
	  	stage.setTitle("Software Architectures – Dylan Eckersall");
	  	root = new TabPane();
	    	scene = new Scene(root, 800, 600);
	  	stage.setScene(scene);

	  	tab1 = new Tab();
	  	tab1.setText("First Tab");
	  	tab1.setClosable(false);
	  	root.getTabs().add(tab1);

	  	tab2 = new Tab();
	  	tab2.setText("Second Tab");
	  	tab2.setClosable(false);
	  	root.getTabs().add(tab2);
	  	
	  	stage.show();
	}
}
