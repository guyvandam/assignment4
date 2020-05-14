import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Cos extends UnaryExpression implements Expression {
    /**
     * constructor function.
     *
     * @param expression an Expression object.
     */
    public Cos(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.cos(super.getExpression().evaluate(assignment));
    }

    @Override
    public double evaluate() throws Exception {
        return this.evaluate(new TreeMap<>());
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return "cos(" + super.getExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Cos(super.getExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Mult(super.getExpression().differentiate(var), new Neg(new Sin(super.getExpression())));
    }

    @Override
    public Expression simplify() {
        return new Cos(super.getExpression().simplify());
    }
}
