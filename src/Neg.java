import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Neg extends UnaryExpression implements Expression {
    /**
     * constructor method. create the parent UnaryExpression an inherit from it.
     *
     * @param expression an Expression object.
     */
    public Neg(Expression expression) {
        super(expression);
    }

    @Override
    public Expression getExpression() {
        return super.getExpression();
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return -super.getExpression().evaluate(assignment);
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
        return "(-" + super.getExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Neg(super.getExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Neg(super.getExpression().differentiate(var));
    }

    @Override
    public Expression simplify() {
//        System.out.println(super.getExpression().toString());
//        if (super.getExpression().toString().charAt(1) == '-') {
        Expression simplifiedExpression = super.getExpression().simplify();
        try {
            Neg expression = (Neg) simplifiedExpression;
            return expression.getExpression();
        } catch (Exception e) {
            return this;

        }
//        }
    }
}
