import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Var implements Expression {
    private String variable;

    /**
     * constructor method.
     *
     * @param x a String.
     */
    public Var(String x) {
        this.variable = x;
    }

    /**
     * @return a String. the string representing the variable.
     */
    public String getVariable() {
        return variable;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return assignment.get(this.getVariable());
    }

    @Override
    public double evaluate() throws Exception {
        return this.evaluate(new TreeMap<>());
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>() {
            {
                add(getVariable());
            }
        };
    }

    @Override
    public String toString() {
        return this.getVariable();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var != null && expression != null && var.equals(this.getVariable())) {
            return expression;
        }
        return new Var(this.getVariable());
    }

    @Override
    public Expression differentiate(String var) {
        return this.getVariable().equals(var) ? new Num(1) : new Num(0);
    }

    @Override
    public Expression simplify() {
        return new Var(this.getVariable());
    }


}
