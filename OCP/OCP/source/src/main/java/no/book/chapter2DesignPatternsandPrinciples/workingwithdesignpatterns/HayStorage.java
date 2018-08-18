package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns;

/*
We present a simple implementation of our HayManager class as a singleton and discuss
its various properties:
 */
public class HayStorage {

    private int quantity = 0;
    private HayStorage() {}
    /*
    Finally, all constructors in a singleton class are marked private,
    which ensures that no other class is capable of instantiating another version of the class.
    By marking the constructors private, we have implicitly marked the class final.
    Recall that every class requires at least one constructor, with the default no‐argument constructor
        being added if none are provided.
    Furthermore, the first line of any constructor is a call to a parent constructor with the super() command.
        If all of the constructors are declared private in the singleton class,
        then it is impossible to create a subclass with a valid constructor;
        therefore, the singleton class is effectively final.
    */
    private static final HayStorage instance = new HayStorage();
    /*
    As shown in the preceding code, singletons in Java are created as private static variables within the class,
    often with the name instance.
    */
    public static HayStorage getInstance() {
        return instance;
    }
    /*
    They are accessed via a single public static method, often named getInstance(),
    which returns the reference to the singleton object.
     */
    public synchronized void addHay(int amount) {
        quantity += amount;
    }
    public synchronized boolean removeHay (int amount) {
        if(quantity < amount) return false;
        quantity -= amount;
        return true;
    }
    public synchronized int getHayQuantity() {
        return quantity;
    }
    /*
    You might have noticed that we added the modifier synchronized to
    addHay() , removeHay() , and getHayQuantity().
    They prevent two processes from running the same method at the exact same time.
     */

}
