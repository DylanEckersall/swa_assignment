import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Number catcher class represents the bucket used
 * to catch the numbers.
 * @author Dylan
 *
 */
public class NumberCatcher extends ImageView {

	private static NumberCatcher instance = null;
	private Rectangle rectangle;
	
	/**
	 * Creates a new number catcher object in the bottom middle of the screen.
	 */
	private NumberCatcher() {
		setX(375);
		setY(490);
		setImage(new Image(NumberCatcher.class.getResource("resources/bucket_black.png").toExternalForm()));
		setFitHeight(50);
		setFitWidth(50);
		rectangle = new Rectangle(50, 50);
		rectangle.setX(375);
		rectangle.setY(490);
		System.out.println(rectangle.getWidth() + " - " + rectangle.getHeight());
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
	
	/**
	 * Returns the rectangle for the numberCatcher object.
	 * @return the rectangle for the number catcher.
	 */
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	/**
	 * Sets the rectangle for the numberCatcher object.
	 * @param rectangle the rectangle to set.
	 */
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
}
