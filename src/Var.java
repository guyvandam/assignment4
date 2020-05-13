import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Var implements Expression {
    private String var;

    public Var(String x) {
        this.var = x;
    }

    public String getVar() {
        return var;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return assignment.get(this.getVar());
    }

    @Override
    public double evaluate() throws Exception {
        return this.evaluate(new TreeMap<>());
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>() {
            {
                add(getVar());
            }
        };
    }

    @Override
    public String toString() {
        return this.getVar();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var != null && expression != null && var.equals(this.getVar())) {
            return expression;
        }
        return new Var(this.getVar());
    }

    @Override
    public Expression differentiate(String var) {
        return this.getVar().equals(var) ? new Num(1) : new Num(0);
    }

    @Override
    public Expression simplify() {
        return new Var(this.getVar());
    }


}
