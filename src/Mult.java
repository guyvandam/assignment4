import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Mult extends BinaryExpression implements Expression {
    /**
     * constructor method. creates the parent BinaryExpression and inherit from it.
     *
     * @param x an Expression object.
     * @param y an Expression object.
     */
    public Mult(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return super.getX().evaluate(assignment) * super.getY().evaluate(assignment);
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
        return "(" + super.getX().toString() + " * " + super.getY().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Mult(super.getX().assign(var, expression), super.getY().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Plus(new Mult(super.getX().differentiate(var), super.getY()),
                new Mult(super.getX(), super.getY().differentiate(var)));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
//            return simplifiedX.toString().equals("1.0") ? simplifiedY :
//                    (simplifiedY.toString().equals("1.0") ? simplifiedX :
//                            :new Mult(simplifiedX, simplifiedY)));
            return super.isNum(simplifiedX, 1) ? simplifiedY
                    : (super.isNum(simplifiedY, 1) ? simplifiedX
                    : (super.isNum(simplifiedX, 0) || isNum(simplifiedY, 0) ? new Num(0)
                    : (super.isEqualExpression(simplifiedX, simplifiedY) ? new Pow(simplifiedX, new Num(2)).simplify()
                    : new Mult(simplifiedX, simplifiedY))));
        }
    }

}
