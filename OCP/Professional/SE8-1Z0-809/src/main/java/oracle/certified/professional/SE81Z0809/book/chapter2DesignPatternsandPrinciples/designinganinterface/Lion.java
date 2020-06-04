package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.designinganinterface;

/*
In this example,
    the interface Run extends Walk and inherits all of the abstract methods of the parent interface.
Notice that modifiers used in the methods isQuadruped(), getMaxSpeed(), and canHuntWhileRunning()
    are different between the class and interface definitions, such as public and abstract.
The compiler automatically adds public to all interface methods and abstract to all non‐static and non‐default
    methods, if the developer does not provide them.
By contrast, the class implementing the interface must provide the proper modifiers.
For example, the code would not compile if getMaxSpeed() was not marked public in the Lion class.
Since the Lion class implements Run, and Run extends Walk, the Lion class must provide
    concrete implementations of all inherited abstract methods.
As shown in this example with getMaxSpeed(), interface method definitions may be duplicated
    in a child interface without issue.

Remember that an interface cannot extend a class,
    nor can a class extend an interface.
For these reasons, none of the following definitions using
    our previous Walk interface and Lion class will compile:

public interface Sleep extends Lion {} // DOES NOT COMPILE
In the first definition above, the interface Sleep cannot extend Lion,
    since Lion is a class.
Likewise, the class Tiger cannot extend the interface Walk.
public class Tiger extends Walk {} // DOES NOT COMPILE
 */
public class Lion implements Run {
    @Override
    public boolean canHuntWhileRunning() {
        return true;
    }

    @Override
    public boolean isQuadruped() {
        return true;
    }

    @Override
    public double getMaxSpeed() {
        return 100;
    }

}
