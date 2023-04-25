package no.dfo.whatsnewinjava.sumtypepattern;

import jakarta.el.ExpressionFactory;

public class MainSealedExp {

    public static void main(String... args) {
        Expr e = new Add(
                new Constant(1),
                new Mul(new Constant(7), new Constant(2) )
        );

        System.out.println(e + " = " + e.eval());
    }

}


/*
//class is not allowed to extend sealed class: Expr (as it is not listed in its permits clause)
record Negate(Expr e) implements Expr {
    @Override
    public int eval() {
        return -e.eval();
    }
}
 */