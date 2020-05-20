import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression x;
    private Expression y;

    /**
     * constructor function.
     *
     * @param x an Expression object.
     * @param y an Expression object.
     */
    protected BinaryExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    protected BinaryExpression(double x, double y) {
        this.x = new Num(x);
        this.y = new Num(y);
    }

    protected BinaryExpression(double x, String y) {
        this.x = new Num(x);
        this.y = new Var(y);
    }

    protected BinaryExpression(String x, double y) {
        this.x = new Var(x);
        this.y = new Num(y);
    }

    protected BinaryExpression(String x, String y) {
        this.x = new Var(x);
        this.y = new Var(y);
    }

    /**
     * @return an Expression object.
     */
    protected Expression getX() {
        return x;
    }

    /**
     * @return an Expression object.
     */
    protected Expression getY() {
        return y;
    }

    @Override
    public List<String> getVariables() {
        List<String> temp = this.getX().getVariables();
        temp.addAll(this.getY().getVariables());
        temp = new ArrayList<>(new HashSet<>(temp)); // removes the duplicates.
        return temp;
    }

}
