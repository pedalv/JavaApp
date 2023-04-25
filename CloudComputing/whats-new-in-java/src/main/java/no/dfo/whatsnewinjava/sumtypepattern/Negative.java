package no.dfo.whatsnewinjava.sumtypepattern;

//error: class is not allowed to extend sealed class: Expr (as it is not listed in its permits clause)
public record Negative(Expr e) /*implements Expr*/ {
    //@Override
    public int eval() {
        return -e.eval();
    }
}
