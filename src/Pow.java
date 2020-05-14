import java.util.List;
import java.util.Map;

/**
 * added this comment to test the github desktop.
 */
public class Pow extends BinaryExpression implements Expression {
    public Pow(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.pow(super.getX().evaluate(assignment), super.getY().evaluate(assignment));
    }


    @Override
    public double evaluate() throws Exception {
        return Math.pow(super.getX().evaluate(), super.getY().evaluate());
    }


    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return "(" + super.getX().toString() + "^" + super.getY().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
//        return (Pow) super.binaryAssign(var, expression);
        return new Pow(super.getX().assign(var, expression), super.getY().assign(var, expression));

    }

    @Override
    public Expression differentiate(String var) {
        // uses the generalized power rule, seen in the wikipedia page the assignment page referred to.
        return new Mult(new Pow(this.getX(), this.getY()), new Plus(new Mult(super.getX().differentiate(var),
                new Div(super.getY(), super.getX())), new Mult(super.getY().differentiate(var),
                new Log(new Const(new Var("e"), 2.71828), super.getX()))));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
//            return simplifiedX.toString().equals("1.0") || simplifiedX.equals(new Num(1)) ? simplifiedX :
//                    (simplifiedY.equals(new Num(0)) ? new Num(0) :
//                            (simplifiedY.equals(new Num(1)) ? simplifiedX : new Pow(simplifiedX, simplifiedY)));
            return super.isNum(simplifiedX, 1) || super.isNum(simplifiedX, 0) ? simplifiedX :
                    (super.isNum(simplifiedY, 0) ? new Num(1) :
                            (super.isNum(simplifiedY, 1) ? simplifiedX : new Pow(simplifiedX, simplifiedY)));
        }

    }

}
