import java.util.List;

public abstract class UnaryExpression extends BaseExpression {
    private Expression expression;

    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }


    public Expression getExpression() {
        return expression;
    }

    public List<String> getVariables() {
        return this.getExpression().getVariables();
    }
}
