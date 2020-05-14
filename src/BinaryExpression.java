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
    public BinaryExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return an Expression object.
     */
    public Expression getX() {
        return x;
    }

    /**
     * @return an Expression object.
     */
    public Expression getY() {
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
