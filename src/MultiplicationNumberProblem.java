/**
 * MultiplicationNumberProblem class represents a multiplication sum.
 * @author Dylan
 *
 */
public class MultiplicationNumberProblem extends NumberProblem {

	/**
	 * Creates an instance of a multiplication number problem.
	 */
	public MultiplicationNumberProblem() {
		super();
	}
	
	/**
	 * Generates an easy difficulty multiplication number problem.
	 * Easy difficulty will generate an easy multiplication problem with a max
	 * of 5*5. 
	 */
	public void easyNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(4) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(4) + 1;
		this.setAnswer((double) leftOperator * (double) rightOperator);
		this.setProblem(leftOperator + " * " + rightOperator);	
	}

	/**
	 * Generates a medium difficulty multiplication number problem.
	 * Medium difficulty will generate a multiplication problem with a max
	 * of 10*10. 
	 */
	public void mediumNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(9) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(9) + 1;
		this.setAnswer((double) leftOperator * (double) rightOperator);
		this.setProblem(leftOperator + " * " + rightOperator);	
	}

	/**
	 * Generates a hard difficulty multiplication number problem.
	 * Hard difficulty will generate a hard multiplication problem with a max
	 * of 10*15. 
	 */
	public void hardNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(9) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(14) + 1;
		this.setAnswer((double) leftOperator * (double) rightOperator);
		this.setProblem(leftOperator + " * " + rightOperator);	
	}

}
