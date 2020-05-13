import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plus extends BinaryExpression implements Expression {
    public Plus(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return super.getX().evaluate(assignment) + super.getY().evaluate(assignment);
    }


    @Override
    public double evaluate() throws Exception {
//        return super.getX().evaluate() + super.getY().evaluate();
        return this.evaluate(new TreeMap<>());
    }

//    @Override
//    public double evaluate() throws Exception {
//        try {
//            return super.getX().evaluate() + super.getY().evaluate();
//        } catch (NullPointerException nullPointerException) {
//            throw nullPointerException;
//        }
//    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return "(" + super.getX().toString() + " + " + super.getY().toString() + ")";
    }


//    @Override
//    public Expression assign(String var, Expression expression) {
//        if (var != null && expression != null) {
//            if (var.equals(super.getX().toString())) {
//                return new Plus(expression, super.getY());
//            } else if (var.equals(super.getY().toString())) {
//                return new Plus(super.getX(), expression);
//            }
//        }
//        return this;
//    }

    @Override
    public Expression assign(String var, Expression expression) {
//        return (Plus) super.binaryAssign(var, expression);
        return new Plus(super.getX().assign(var, expression), super.getY().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Plus(super.getX().differentiate(var), super.getY().differentiate(var));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
//            if (super.getX().equals(new Num(0))) {
//                return super.getX();
//            } else if (super.getY().equals(new Num(0))) {
//                return super.getY();
//            }
//            return new Plus(super.getX(), super.getY());
            return simplifiedX.equals(new Num(0)) ? simplifiedY :
                    (simplifiedY.equals(new Num(0)) ? simplifiedX : new Plus(simplifiedX, simplifiedY));
        }

    }
}