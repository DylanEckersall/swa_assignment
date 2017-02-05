
/**
 * Number problem abstract class declares common methods
 * which all NumberProblems must implement. 
 * @author Dylan
 *
 */
public abstract class NumberProblem {
	
	private double answer;
	private String problem;
	
	/**
	 * NumberProblem constructor - creates a NumberProblem object.
	 */
	public NumberProblem() {
		
	}
	
	/**
	 * Returns the answer to the number problem.
	 * @return the answer
	 */
	public double getAnswer() {
		return answer;
	}

	/**
	 * Returns the String of the equation/problem.
	 * @return the problem
	 */
	public String getProblem() {
		return problem;
	}

	/**
	 * Sets the answer to the number problem.
	 * @param answer the answer to set
	 */
	public void setAnswer(double answer) {
		this.answer = answer;
	}

	/** 
	 * Sets the String of the equation/problem
	 * @param problem the problem to set
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}

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
