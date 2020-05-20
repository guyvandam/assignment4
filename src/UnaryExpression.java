import java.util.List;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression expression;

    /**
     * constructor method.
     *
     * @param expression an Expression object.
     */
    protected UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * @return an Expression object.
     */
    protected Expression getExpression() {
        return expression;
    }

    /**
     * @return a java-List object. the variables of the inner expression.
     */
    public List<String> getVariables() {
        return this.getExpression().getVariables();
    }


}
