
/**
 * Number problem abstract class declares common methods
 * which all NumberProblems must implement. 
 * @author Dylan
 *
 */
public abstract class NumberProblem {
	
	/**
	 * Easy number problem - generates an equation/problem for
	 * an easy difficulty.
	 */
	public abstract void easyNumberProblem();
	
	/**
	 * Medium number problem - generates an equation/problem for
	 * a medium difficulty.
	 */
	public abstract void mediumNumberProblem();
	
	/**
	 * Hard number problem - generates an equation/problem for
	 * a hard difficulty.
	 */
	public abstract void hardNumberProblem();
	
}
