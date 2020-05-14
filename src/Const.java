import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Const implements Expression {
    private Var var;
    private double value;

    public Const(Var var, double value) {
        this.var = var;
        this.value = value;
    }

    public Var getVar() {
        return var;
    }

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
        return this.getVar().getVariables();
    }

    @Override
    public String toString() {
        return "e";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Const(this.getVar(), this.getValue());
    }

    @Override
    public Expression differentiate(String var) {
        return new Num(0);
    }

    @Override
    public Expression simplify() {
        return new Const(this.getVar(),this.getValue());
    }
}
