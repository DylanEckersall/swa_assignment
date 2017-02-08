/**
 * DivisionNumberProblem class represents a division sum.
 * @author Dylan
 *
 */
public class DivisionNumberProblem extends NumberProblem {

	/**
	 * Creates an instance of a division number problem.
	 */
	public DivisionNumberProblem() {
		super();
	}
	
	/**
	 * Generates an easy difficulty division number problem.
	 * Easy difficulty will generate an easy division problem with a max
	 * division of 50/10. 
	 */
	public void easyNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(9) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(4) + 1;
		int total = leftOperator * rightOperator;
		this.setAnswer(rightOperator);
		this.setProblem(total + "/" + leftOperator);
	}

	/**
	 * Generates a medium difficulty number problem.
	 * Medium difficulty will generate a medium problem with a max division
	 * of 100/10.
	 */
	public void mediumNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(9) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(9) + 1;
		int total = leftOperator * rightOperator;
		this.setAnswer(rightOperator);
		this.setProblem(total + "/" + leftOperator);
	}

	/**
	 * Generates a hard difficulty number problem.
	 * Hard difficulty will generate a hard problem with a max division
	 * of 500/10.
	 */
	public void hardNumberProblem() {
		int leftOperator = this.getNumberGenerator().nextInt(49) + 1;
		int rightOperator = this.getNumberGenerator().nextInt(9) + 1;
		int total = leftOperator * rightOperator;
		this.setAnswer(rightOperator);
		this.setProblem(total + "/" + leftOperator);
	}

}
