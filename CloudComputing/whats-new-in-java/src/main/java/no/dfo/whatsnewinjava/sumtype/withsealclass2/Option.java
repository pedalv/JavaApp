package no.dfo.whatsnewinjava.sumtype.withsealclass2;

//In the same source file, permits is optional
public sealed class Option<T> {

    public final class Empty extends Option<Void> { }

    public final class Some<T> extends Option<T> { }
}
