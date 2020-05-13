import java.util.List;
import java.util.Map;

public class Sin extends UnaryExpression implements Expression {

    public Sin(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.sin(super.getExpression().evaluate(assignment));
    }

    @Override
    public double evaluate() throws Exception {
        return Math.sin(super.getExpression().evaluate());
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return "sin(" + super.getExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Sin(this.getExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Mult(super.getExpression().differentiate(var), new Cos(super.getExpression()));
    }

    @Override
    public Expression simplify() {
        return null;
    }
}
