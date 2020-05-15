import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Log extends BinaryExpression implements Expression {
    /**
     * constructor method. creates the parent BinaryExpression and inherit from it.
     *
     * @param x an Expression object. the base of the log.
     * @param y an Expression object.
     */
    public Log(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double valueOfX = super.getX().evaluate(assignment), valueOfY = super.getY().evaluate(assignment);
        if (valueOfX == 1) {
            return valueOfY;
        }
        if (valueOfX == valueOfY) {
            return 1;
        }
        if (valueOfY == 1) {
            return 0;
        }
        // uses the identity: log(a,b) = log(e,b)/log(e,a)
        // uses the identity: log(x,y) = log(e,y)/log(e,x)
        return Math.log(valueOfY) / Math.log(valueOfX);

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
        return "log(" + super.getX().toString() + ", " + super.getY().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Log(super.getX().assign(var, expression), super.getY().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Div(super.getY().differentiate(var), new Mult(super.getY(), new Log(new Const(
                new Var("e"), 2.71828), super.getX())));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
//            return simplifiedX.toString().equals(simplifiedY.toString()) ? new Num(1) :
//                    (simplifiedX.toString().equals("1.0") ? simplifiedY :
//                            simplifiedY.toString().equals("1.0") ? new Num(0) : new Log(simplifiedX, simplifiedY));
            return super.isEqualExpression(simplifiedX, simplifiedY) ? new Num(1)
                    : (super.isNum(simplifiedX, 1) ? simplifiedY
                    : super.isNum(simplifiedY, 1) ? new Num(0) : new Log(simplifiedX, simplifiedY));
        }
    }
}
