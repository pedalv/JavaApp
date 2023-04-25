package no.dfo.whatsnewinjava.sumtype;

public sealed interface Expr  {

    int eval();
}

record Constant(int value) implements Expr {

    @Override
    public int eval() {
        return value;
    }
}


record Add(Expr lval, Expr rval) implements Expr {

    @Override
    public int eval() {
        return lval.eval() + rval().eval();
    }
}

record Mul(Expr lval, Expr rval) implements Expr {

    @Override
    public int eval() {
        return lval.eval() * rval().eval();
    }
}

//class is allowed to extend sealed class: Expr (as it is listed in its permits clause)
record Negate2(Expr e) implements Expr {
    @Override
    public int eval() {
        return -e.eval();
    }
}