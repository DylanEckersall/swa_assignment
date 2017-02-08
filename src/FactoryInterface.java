/**
 * The interface which factories must implement to create
 * new NumberProblem objects.
 * @author Dylan
 *
 */
public interface FactoryInterface {
	/**
	 * Returns a new NumberProblem from the specified type.
	 * @param type the type of NumberProblem to create.
	 * @return a new NumberProblem object.
	 */
	NumberProblem createNumberProblem(String type);
}
