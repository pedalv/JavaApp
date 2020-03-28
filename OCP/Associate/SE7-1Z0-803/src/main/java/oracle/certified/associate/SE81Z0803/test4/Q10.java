package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q10 {

    //1.
    //A class is uninstantiable if the class is declared abstract
    //2.
    // If a method has been declared as abstract, it cannot provide
    // an implementation i.e. a method body even if empty (and the
    // class containing that method must be declared abstract).
    //3.
    // If a method is not declared abstract, it must provide a method
    // body (the class can be abstract but not necessarily so)
    // 4.
    // If any method in a class is declared abstract, then the whole
    // class must be declared abstract.


}

// legal definition of a class that cannot be instantiated

abstract class Automobile1{
    void honk(){}
}

abstract class Automobile2{
    abstract void honk();
}