import java.util.Random;

import javafx.scene.control.Label;

/**
 * Number problem abstract class declares common methods
 * which all NumberProblems must implement. 
 * @author Dylan
 *
 */
public abstract class NumberProblem {
	
	private double answer;
	private String problem;
	private Random numberGenerator;
	
	/**
	 * NumberProblem constructor - creates a NumberProblem object.
	 */
	public NumberProblem() {
		numberGenerator = new Random();
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
	 * Returns the number generator for the problem.
	 * @return the numberGenerator
	 */
	public Random getNumberGenerator() {
		return numberGenerator;
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
	 * Sets the number generator for the problem.
	 * @param numberGenerator the numberGenerator to set
	 */
	public void setNumberGenerator(Random numberGenerator) {
		this.numberGenerator = numberGenerator;
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
