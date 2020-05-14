import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class BinaryExpression extends BaseExpression {
    private Expression x;
    private Expression y;

    public BinaryExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    public Expression getX() {
        return x;
    }

    public Expression getY() {
        return y;
    }

    public List<String> getVariables() {
//        return new ArrayList<String>() {
//            {
//                add(x.toString());
//                add(y.toString());
//            }
//        };
        List<String> temp = this.getX().getVariables();
        temp.addAll(this.getY().getVariables());
        temp = new ArrayList<>(new HashSet<>(temp)); // removes the duplicates.
        return temp;
    }

//    public boolean isNumX(double num) {
//        return super.isNum(this.getX(), num);
//    }
//
//    public boolean isNumY(double num) {
//        return super.isNum(this.getY(), num);
//    }

//    public BinaryExpression binaryAssign(String var, Expression expression) {
////        if (var != null && expression != null) {
////            System.out.println(var);
////            System.out.println(this.getY().toString());
////            if (var.equals(this.getX().toString())) {
////                System.out.println("in");
////                return new BinaryExpression(expression, this.getY());
////            } else if (var.equals(this.getY().toString())) {
////                return new BinaryExpression(this.getX(), expression);
////            }
////        }
////        return this;
//
//        return new BinaryExpression(this.getX().assign(var,expression),this.getY().assign(var,expression));
//    }
}
