import java.util.List;
import java.util.Map;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided in the input TreeMap and returns the result. a double.
     * <p>
     * If the expression contains a variable which is not in the assignment, an nullPointer-exception is thrown.
     * </p>
     *
     * @param assignment a java TreeMap object. contains the values of the variables in the expression.
     * @return a double. the result of the expression after the assignment of all the variables to there values.
     * @throws Exception nullPointerException.
     */
    double evaluate(Map<String, Double> assignment) throws Exception;


    /**
     * calls the evaluate function above with an empty input tree.
     *
     * @return a double. the value of the expression (if possible to calculate).
     * @throws Exception nullPointerException.
     */
    double evaluate() throws Exception;

    /**
     * @return a java-List object. a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * @return a string. a nice string representation of the expression according to the rules in the assignment page.
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable var are replaced with the provided expression.
     * <p>
     * doesn't modify the current expression. if it doesnt find the input var in the expression returns a new expression
     * with the same values of the our expression.
     * </p>
     *
     * @param var        a String. the var we want to replace.
     * @param expression an Expression object. the expression we want instead of the input var.
     * @return an Expression object. the current expression with the input var replaced with the input expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var a string. the variable we want to differentiate relative to.
     * @return an Expression object. as described above.
     */
    Expression differentiate(String var);

    /**
     * Returned a simplified version of the current expression.
     *
     * @return an Expression object. as described above.
     */
    Expression simplify();
}