
/**
 * AdditionNumberProblem class represents an addition sum.
 * @author Dylan
 *
 */
public class AdditionNumberProblem extends NumberProblem {
	
	/**
	 * Creates an instance of an addition number problem.
	 */
	public AdditionNumberProblem() {
		super();
	}

	/**
	 * Generates an easy difficulty addition number problem.
	 * Easy difficulty will generate an addition problem with a max sum of 10.
	 */
	public void easyNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(4) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(4) + 1;
		this.setAnswer((double) leftOperator + (double) rightOperator);
		this.setProblem(leftOperator + " + " + rightOperator);
	}

	/**
	 * Generates a medium difficulty addition number problem.
	 * Medium difficulty will generate an addition problem with a max sum of 100.
	 */
	public void mediumNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(49) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(49) + 1;
		this.setAnswer((double) leftOperator + (double) rightOperator);
		this.setProblem(leftOperator + " + " + rightOperator);
	}

	/**
	 * Generates a hard difficulty addition number problem.
	 * Medium difficulty will generate an addition problem with a max sum of 1000.
	 */
	public void hardNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(499) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(499) + 1;
		this.setAnswer((double) leftOperator + (double) rightOperator);
		this.setProblem(leftOperator + " + " + rightOperator);
	}

}
