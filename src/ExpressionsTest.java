import java.util.TreeMap;

/**
 * @author Guy Vandam 325133148 <guyvandam@gmail.com>
 * @version 1.0
 * @since 2020-05-14.
 */
public class ExpressionsTest {
    /**
     * main method. demenstrate the what we did in the assignment.
     * <p>
     * create the (2x) + (sin(4y)) + (e^x) expression and prints it.
     * assigns values to the different variables and prints the value of the expression.
     * differentiate it according to the 'x' variable and prints the result. prints the value of the differentiated
     * expression according to the same values as in the previous step.
     * prints the simplified differentiated expression.
     * </p>
     *
     * @param args a String array. the input from the command line. doesn't have a use in this method.
     */
    public static void main(String[] args) {
        Expression e = new Plus(new Mult(new Num(2), new Var("x")), new Plus(new Sin(new Mult(new Num(4),
                new Var("y"))), new Pow(new Var("e"), new Var("x"))));

        // prints the expression:
        System.out.println(e.toString());

        TreeMap<String, Double> assignment = new TreeMap<>();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);

        try {
            // prints the value of the expression with the values seen above:
            System.out.println(e.evaluate(assignment));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        // differentiate the expression
        Expression de = e.differentiate("x");

        // print the differentiated expression:
        System.out.println(de.toString());

        try {
            // print the value of the differentiated expression with the values seen above:
            System.out.println(de.evaluate(assignment));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        // prints the simplified differentiated expression:
        System.out.println(de.simplify());

    }
}
