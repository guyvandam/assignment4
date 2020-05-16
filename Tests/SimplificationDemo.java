//public class SimplificationDemo {
//
//    /**
//     * bonus test.
//     *
//     * @param args ignored.
//     * @throws Exception e if given functions are given illegal parameters.
//     */
//    public static void main(String[] args) throws Exception {
//        Expression e = new Plus(new Mult(new Num(2), new Var("x")), new Mult(new Num(4), new Var("x")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Plus(new Var("x"), new Var("x"));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Pow(new Var("x"), new Pow(new Var("y"), new Var("z")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Div(new Pow(new Var("x"), new Num(3)), new Pow(new Var("y"), new Num(3)));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Neg(new Neg(new Num(3)));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Neg(new Num(0));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//        //Plus.
//        e = new Plus(new Neg(new Var("x")), new Neg(new Var("y")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Plus(new Var("x"), new Neg(new Var("y")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Plus(new Neg(new Var("x")), new Var("y"));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//        //Mult.
//        e = new Mult(new Var("x"), new Var("x"));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Mult(new Neg(new Var("x")), new Neg(new Var("y")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Mult(new Neg(new Var("x")), new Var("y"));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Div(new Neg(new Var("x")), new Neg(new Var("y")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Div(new Neg(new Var("x")), new Neg(new Var("y")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//        //Pow.
//        e = new Mult(new Pow(new Var("x"), new Var("z")), new Pow(new Var("x"), new Var("z")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Div(new Pow(new Var("x"), new Var("z")), new Pow(new Var("x"), new Var("z")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Mult(new Pow(new Var("x"), new Var("z")), new Pow(new Var("x"), new Var("z")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//        e = new Mult(new Pow(new Var("x"), new Var("z")), new Pow(new Var("x"), new Var("z")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//        //Sin.
//        e = new Sin(new Num(0));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Sin(new Neg(new Var("x")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Minus(new Pow(new Var("x"), new Num(2)), new Pow(new Var("y"), new Num(2)));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//        //Cos.
//        e = new Cos(new Num(0));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Cos(new Neg(new Var("x")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//        //Log.
//        e = new Log(new Plus(new Var("x"), new Var("y")), new Num(1));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//        e = new Pow(new Var("x"), new Log(new Var("x"), new Var("y")));
//        System.out.println(e.toString());
//        System.out.println(e.simplify().toString());
//
//
//    }
//}