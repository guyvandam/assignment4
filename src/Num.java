import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class Num implements Expression {
    private double num;

    /**
     * constructor method.
     *
     * @param num a double. the value of the number.
     */
    public Num(double num) {
        this.num = num;
    }

    /**
     * @return a double. the value of the number.
     */
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
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        // returns a nicer string representation where integer don't have a decimal point.
        return this.getNum() == Math.floor(this.getNum()) ? String.valueOf((int) this.getNum())
                : String.valueOf(this.getNum());
//        return String.valueOf(this.getNum());
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
