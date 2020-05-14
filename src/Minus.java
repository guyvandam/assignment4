import org.w3c.dom.css.CSSUnknownRule;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Minus extends BinaryExpression implements Expression {
    public Minus(Expression x, Expression y) {
        super(x, y);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return super.getX().evaluate(assignment) - super.getY().evaluate(assignment);
    }

    @Override
    public double evaluate() throws Exception {
//        return super.getX().evaluate() - super.getY().evaluate();
        return this.evaluate(new TreeMap<>());
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return "(" + super.getX().toString() + " - " + super.getY().toString() + ")";
    }


    @Override
    public Expression assign(String var, Expression expression) {
        return new Minus(super.getX().assign(var, expression), super.getY().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Minus(super.getX().differentiate(var), super.getY().differentiate(var));
    }

    @Override
    public Expression simplify() {
        Expression simplifiedX = super.getX().simplify(), simplifiedY = super.getY().simplify();
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
//            return simplifiedX.equals(new Num(0)) ? new Neg(simplifiedY) :
//                    (simplifiedY.equals(new Num(0)) ? simplifiedX : new Minus(simplifiedX, simplifiedY));
            return super.isNum(simplifiedX, 0) ? new Neg(simplifiedY) :
                    (super.isNum(simplifiedY, 0) ? simplifiedX : new Minus(simplifiedX, simplifiedY));
        }
    }
}
