public abstract class BaseExpression implements Expression {
    public boolean isNum(double num) {
        double result;
        try {
            result = this.evaluate();
        } catch (Exception e) {
            return false;
        }
        return result == num;
    }
}
