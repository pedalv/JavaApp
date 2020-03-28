package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.designinganinterface;

public interface Run extends Walk {
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}
