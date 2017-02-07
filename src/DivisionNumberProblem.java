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

	@Override
	public void mediumNumberProblem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hardNumberProblem() {
		// TODO Auto-generated method stub
		
	}

}
