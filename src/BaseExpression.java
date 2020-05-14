/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public abstract class BaseExpression implements Expression {

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
    public boolean isNum(Expression e, double num) {
//        return e.toString().equals(String.valueOf(num));
        return num == Math.floor(num) ? e.toString().equals(String.valueOf((int) num))
                : e.toString().equals(String.valueOf(num));
    }
    public boolean isEqualExpression(Expression e1, Expression e2) {
//        return null == e1 || e2 == null || !e1.toString().equals(e2.toString());
        return e1.toString().equals(e2.toString());
    }

}