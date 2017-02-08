/**
 * Factory used to create NumberProblem objects.
 * @author Dylan
 *
 */
public class NumberProblemFactory implements FactoryInterface {

	/**
	 * Returns a new NumberProblem from the specified type.
	 * @param type the type of NumberProblem to create.
	 * @return a new NumberProblem object.
	 */
	public NumberProblem createNumberProblem(String type) {
		if (type.equalsIgnoreCase("addition")) {
			return new AdditionNumberProblem();
		}
		if (type.equalsIgnoreCase("division")) {
			return new DivisionNumberProblem();
		}
		if (type.equalsIgnoreCase("multiplication")) {
			return new MultiplicationNumberProblem();
		}
		if (type.equalsIgnoreCase("subtraction")) {
			return new SubtractionNumberProblem();
		}
		else {
			return null;
		}
	}

}
