/**
 * Number catcher class represents the "bucket" used
 * to catch the numbers.
 * @author Dylan
 *
 */
public class NumberCatcher {

	private int x;
	private int y;
	private static NumberCatcher instance = null;
	
	/**
	 * Creates a new number catcher object in the bottom middle of the screen.
	 */
	private NumberCatcher() {
		x = 350;
		y = 700;
	}

	/**
	 * Returns the current X position of the number catcher.
	 * @return the x position.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the current Y position of the number catcher. 
	 * @return the y position.
	 */
	public int getY() {
		return y;
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
	 * Sets the X position of the number catcher.
	 * @param x the x position to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the Y position of the number catcher. 
	 * @param y the y position to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
