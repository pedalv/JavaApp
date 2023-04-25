package no.dfo.whatsnewinjava.sumtype.beforesealclass;

//Before Sealed Classes
public abstract class Option<T> {

    private Option() {}

    public final class Some<T> extends Option<T> { }

    public final class Empty extends Option<Void> {  }
}
