public class Test {
    public static void main(String[] args) {
//        Expression e = new Plus(new Var("y"), new Num(4));
//        Expression e = new Pow(new Mult(new Plus(new Mult(new Num(2), new Var("x")), new Var("y")), new Num(4)), new Var("x"));
//        Expression e2 = new Pow(new Plus(new Var("x"), new Var("y")), new Num(2));
//
//        String s = e2.toString();
//        System.out.println(s);
//
//        Expression e3 = e2.assign("y", e2);
//        System.out.println(e3);

//        e3 = e3.assign("x", new Num(1));
//        System.out.println(e3);

//        List<String> vars = e3.getVariables();
//        for (String v : vars) {
//            System.out.println(v);
//        }
//
//        Expression e = new Pow(new Var("x"), new Num(4));
//        Expression de = e.differentiate("x");
//        System.out.println(de);
//
//        e = new Pow(new Var("e"), new Var("x"));
//        System.out.println(e.differentiate("x"));
//        System.out.println(e.differentiate("x").simplify());


//        Expression e = new Neg(new Neg(new Plus(new Var("x"), new Num(4))));
//        System.out.println(e.simplify());
//        e = new Neg(new Plus(new Neg(new Var("x")), new Num(4)));
//        System.out.println(e.simplify());

        Expression e = new Div(new Num(1),new Var("x"));
        System.out.println(e.toString());
        e = e.differentiate("x").simplify();
        System.out.println(e.toString());

//
//        System.out.println(e.toString());
//        Map<String, Double> assignment = new TreeMap<String, Double>();
//        assignment.put("y", 2.0);
//
//        System.out.println(e.evaluate(assignment));
//        System.out.println(e.getVariables());

    }
}
