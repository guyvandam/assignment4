/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public abstract class BaseExpression implements Expression {
//    private Expression expression;
//
//    public BaseExpression(Expression expression) {
//        this.expression = expression;
//    }
//
//    public Expression getExpression() {
//        return expression;
//    }

    /**
     * check if the input expression represents the input number.
     * <p>
     * compares the toString of the input expression to the string representation of the input number.
     * aware of the fact the input double can represent an integer. (as seen in the note above the return line).
     * </P>
     *
     * @param e   an Expression object.
     * @param num a double.
     * @return a boolean. true if the input expression represents a number, false otherwise.
     */
    protected boolean isNum(Expression e, double num) {
//        return e.toString().equals(String.valueOf(num));
        return num == Math.floor(num) ? e.toString().equals(String.valueOf((int) num))
                : e.toString().equals(String.valueOf(num));
    }

//    public boolean isEqualBinaryExpression(BinaryExpression e1, BinaryExpression e2) {
//        return e1.toString().equals(e2.toString())
//                || (isEqualExpression(e1.getX(), e2.getX()) && isEqualExpression(e1.getY(), e2.getY()))
//                || (isEqualExpression(e1.getX(), e2.getY()) && isEqualExpression(e1.getY(), e2.getX()));
//        // equal toString OR (x=x and y=y) OR (x=y and y=x)
//
//    }

    /**
     * checks if 2 expressions are equal base on their toString.
     *
     * @param e1 an Expression object.
     * @param e2 an Expression object.
     * @return a boolean. true if the expressions are 'equal'. false otherwise.
     */
    protected boolean isEqualExpression(Expression e1, Expression e2) {
//        try {
//            return e1.evaluate() == e2.evaluate();
//        } catch (Exception exception) {
//            // checks if the 2 lists have the same variables.
//            if (new HashSet<>(e1.getVariables()).equals(new HashSet<>(e2.getVariables()))) {
//                return false;
//            }
//        }
//        if (e1 == null || e2 == null) {
//            return false;
//        }
        return e1 != null && e2 != null && e1.toString().equals(e2.toString()); // the best we can do...
    }

}