import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mult extends BinaryExpression implements Expression {
    public Mult(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return super.getX().evaluate(assignment) * super.getY().evaluate(assignment);
    }


    @Override
    public double evaluate() throws Exception {
//        return super.getX().evaluate() * super.getY().evaluate();
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
//                            (simplifiedX.toString().equals("0.0") || simplifiedY.toString().equals("0.0") ? new Num(0) :
//                                    new Mult(simplifiedX, simplifiedY)));
            return super.isNum(simplifiedX, 1) ? simplifiedY :
                    (super.isNum(simplifiedY, 1) ? simplifiedX :
                            (super.isNum(simplifiedX, 0) || isNum(simplifiedY, 0) ? new Num(0) :
                                    new Mult(simplifiedX, simplifiedY)));
        }
    }

}
