import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Neg extends UnaryExpression implements Expression {
    public Neg(Expression expression) {
        super(expression);
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
        return null;
    }
}
