import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Div extends BinaryExpression implements Expression {
    public Div(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return super.getX().evaluate(assignment) / super.getY().evaluate(assignment);
    }


    @Override
    public double evaluate() throws Exception {
//        return super.getX().evaluate() / super.getY().evaluate();
        return this.evaluate(new TreeMap<>());
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return "(" + super.getX().toString() + " / " + super.getY().toString() + ")";
    }


    @Override
    public Expression assign(String var, Expression expression) {
        return new Div(super.getX().assign(var, expression), super.getY().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Div(new Minus(new Mult(super.getX().differentiate(var), super.getY()), new Mult(super.getX(),
                super.getY().differentiate(var))), new Pow(super.getX(), new Num(2)));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
            return simplifiedX.equals(simplifiedY) ? new Num(1) :
                    (simplifiedY.equals(new Num(1)) ? simplifiedX : new Div(simplifiedX, simplifiedY));
        }
    }
}
