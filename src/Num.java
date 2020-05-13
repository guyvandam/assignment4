import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Num implements Expression {
    private double num;

    public Num(double num) {
        this.num = num;
    }

    public double getNum() {
        return num;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.evaluate();
    }

    @Override
    public double evaluate() throws Exception {
        return this.getNum();
    }


    @Override
    public List<String> getVariables() {
//        return new ArrayList<String>() {
//            {
//                add(this.toString());
//            }
//        };
        return new ArrayList<>();
    }

    @Override
    public String toString() {
//        return this.getNum() == Math.floor(this.getNum()) ? String.valueOf((int) this.getNum()) : String.valueOf(this.getNum());
        return String.valueOf(this.getNum());
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Num(this.getNum());
    }

    @Override
    public Expression differentiate(String var) {
        return new Num(0);
    }

    @Override
    public Expression simplify() {
        return new Num(this.getNum());
    }
}
