public abstract class BaseExpression implements Expression {


    public boolean isNum(Expression e, double num) {
//        return e.toString().equals(String.valueOf(num));
        return num == Math.floor(num) ? e.toString().equals(String.valueOf((int) num)) : e.toString().equals(String.valueOf(num));
    }

    public boolean isEqualExpression(Expression e1, Expression e2) {
//        return null == e1 || e2 == null || !e1.toString().equals(e2.toString());
        return e1.toString().equals(e2.toString());
    }

}