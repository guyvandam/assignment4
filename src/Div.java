import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Div extends BinaryExpression implements Expression {
    /**
     * constructor method. creates the parent BinaryExpression and inherit from it.
     *
     * @param x an Expression object.
     * @param y an Expression object.
     */
    public Div(Expression x, Expression y) {
        super(x, y);
    }

    public Div(int i, int i1) {
        super(i,i1);
    }

    public Div(int i, String x) {
        super(i,x);
    }

    public Div(String x, String x1) {
        super(x,x1);
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
                super.getY().differentiate(var))), new Pow(super.getY(), new Num(2)));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
            return super.isEqualExpression(simplifiedX, simplifiedY) ? new Num(1)
                    : (super.isNum(simplifiedY, 1) ? simplifiedX : new Div(simplifiedX, simplifiedY));
        }
    }
}
