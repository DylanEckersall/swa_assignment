import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Number catcher class represents the bucket used
 * to catch the numbers.
 * @author Dylan
 *
 */
public class NumberCatcher extends ImageView {

	private static NumberCatcher instance = null;
	
	/**
	 * Creates a new number catcher object in the bottom middle of the screen.
	 */
	private NumberCatcher() {
		setX(375);
		setY(500);
		setImage(new Image(NumberCatcher.class.getResource("resources/bucket_black.png").toExternalForm()));
	}
	
	/**
	 * Returns the instance of the NumberCatcher.
	 * @return the instance of the NumberCatcher.
	 */
	public static NumberCatcher getInstance() {
		if (instance == null) {
			instance = new NumberCatcher();
		}
		return instance;
	}
	
}
