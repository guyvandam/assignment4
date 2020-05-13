import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Log extends BinaryExpression implements Expression {
    public Log(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
//            return Math.log(super.getY().evaluate(assignment)) / Math.log(super.getX().evaluate(assignment));
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
        return new Div(super.getY().differentiate(var), new Mult(super.getY(), new Log(new Const(new Var("e"), 2.71828), super.getX())));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
            return simplifiedX.equals(simplifiedY) ? new Num(1) :
                    (simplifiedX.equals(new Num(1)) ? simplifiedY :
                            simplifiedY.equals(new Num(1)) ? new Num(0) : new Log(simplifiedX, simplifiedY));
        }
    }
}
