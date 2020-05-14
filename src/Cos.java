import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cos extends UnaryExpression implements Expression {
    public Cos(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.cos(super.getExpression().evaluate(assignment));
    }

    @Override
    public double evaluate() throws Exception {
//        return Math.cos(super.getExpression().evaluate(new ));
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
