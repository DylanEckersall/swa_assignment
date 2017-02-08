/**
 * SubtractionNumberProblem class represents a subtraction sum.
 * @author Dylan
 *
 */
public class SubtractionNumberProblem extends NumberProblem{
	
	/**
	 * Creates an instance of a subtraction number problem.
	 */
	public SubtractionNumberProblem() {
		super();
	}

	/**
	 * Generates an easy difficulty subtraction number problem.
	 * Easy difficulty will generate a subtraction problem with a max of 10-10.
	 */
	public void easyNumberProblem() {
		int firstNumber = this.getNumberGenerator().nextInt(9) + 1;
		int secondNumber = this.getNumberGenerator().nextInt(9) + 1;
		int leftOperator = Math.max(firstNumber, secondNumber);
		int rightOperator = Math.min(firstNumber, secondNumber);
		setAnswer(leftOperator - rightOperator);
		setProblem(String.valueOf(leftOperator) + " - " + String.valueOf(rightOperator));
	}

	/**
	 * Generates a medium difficulty subtraction number problem.
	 * Medium difficulty will generate a subtraction problem with a max of 100-100.
	 */
	public void mediumNumberProblem() {
		int firstNumber = this.getNumberGenerator().nextInt(99) + 1;
		int secondNumber = this.getNumberGenerator().nextInt(99) + 1;
		int leftOperator = Math.max(firstNumber, secondNumber);
		int rightOperator = Math.min(firstNumber, secondNumber);
		setAnswer(leftOperator - rightOperator);
		setProblem(String.valueOf(leftOperator) + " - " + String.valueOf(rightOperator));
	}

	/**
	 * Generates a hard difficulty subtraction number problem.
	 * Hard difficulty will generate a subtraction problem with a max of 500-500.
	 */
	public void hardNumberProblem() {
		int firstNumber = this.getNumberGenerator().nextInt(499) + 1;
		int secondNumber = this.getNumberGenerator().nextInt(499) + 1;
		int leftOperator = Math.max(firstNumber, secondNumber);
		int rightOperator = Math.min(firstNumber, secondNumber);
		setAnswer(leftOperator - rightOperator);
		setProblem(String.valueOf(leftOperator) + " - " + String.valueOf(rightOperator));
	}

}
