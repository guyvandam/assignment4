import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Const implements Expression {
    private Var name;
    private double value;

    /**
     * constructor function.
     *
     * @param var   a Var Object.
     * @param value a double.
     */
    public Const(Var var, double value) {
        this.name = var;
        this.value = value;
    }

    /**
     * @return a Var Object.
     */
    public Var getName() {
        return name;
    }

    /**
     * @return a double.
     */
    public double getValue() {
        return value;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.getValue();
    }

    @Override
    public double evaluate() throws Exception {
        return this.evaluate(new TreeMap<>());
    }

    @Override
    public List<String> getVariables() {
        return this.getName().getVariables();
    }

    @Override
    public String toString() {
        return "e";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Const(this.getName(), this.getValue());
    }

    @Override
    public Expression differentiate(String var) {
        return new Num(0);
    }

    @Override
    public Expression simplify() {
        return new Const(this.getName(), this.getValue());
    }
}
