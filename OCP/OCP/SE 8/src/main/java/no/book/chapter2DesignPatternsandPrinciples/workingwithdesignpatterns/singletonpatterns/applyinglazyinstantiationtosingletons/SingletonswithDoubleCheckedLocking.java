package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.singletonpatterns.applyinglazyinstantiationtosingletons;

/*
The synchronized implementation of getInstance(), while correctly preventing multiple
    singleton objects from being created, has the problem that every single call to this
    method will require synchronization.
In practice, this can be costly and can impact performance.
Synchronization is only needed the first time that the object is created.

The solution is to use double‐checked locking, a design pattern in which we first test if
    synchronization is needed before actually acquiring any locks.
The following is an example rewrite of this method using double‐checked locking:

 */
public class SingletonswithDoubleCheckedLocking {

}


class VisitorTicketTracker1 {

    //private static VisitorTicketTracker1 instance;
    private static volatile VisitorTicketTracker1 instance;
    /*
    As you may have noticed, we added the volatile modifier to our singleton object.
    This keyword prevents a subtle case where the compiler tries to optimize the code such that
        that the object is accessed before it is finished being constructed.
    For the exam, you are not required to know how volatile works or about any compiler optimizations.

    volatile modifier
        will tell the JVM to be cautious of the threads which runs concurrently.
    Essentially, volatile is used to indicate that a variable's value will be modified by different threads.
    Declaring a volatile Java variable means:
        • The value of this variable will never be cached thread-locally:
        all reads and writes will go straight to "main memory"
        • Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself.

    We say "acts as though" in the second point, because to the programmer at least
        (and probably in most JVM implementations) there is no actual lock object involved.

    -----

    The volatile modifier tells
        the compiler that the variable modified by volatile can be changed unexpectedly by other parts of your program.
    One of these situations involves multithreaded programs.
    In a multithreaded program, sometimes, two or more threads share the same instance variable.
    For efficiency considerations, each thread can keep its own, private copy of such a shared variable.
    The real (or master) copy of the variable is updated at various times,
        such as when a synchronized method is entered.
    While this approach works fine, it may be inefficient at times.
    In some cases, all that really matters is that the master copy of a variable always reflects its current state.
    To ensure this, simply specify the variable as volatile, which tells the compiler
        that it must always use the master copy of a volatile variable
        (or, at least, always keep any private copies up to date with the master copy, and vice versa).
    Also, accesses to the master variable must be executed in the precise order
        in which they are executed on any private copy.
     */

    private VisitorTicketTracker1() {
    }

    /*
    Creating Unique Singletons
    To truly implement the singleton pattern, we must ensure that only one instance of the singleton is ever created.
    Marking the constructor private is a good first step as it prevents the singleton from being created by other classes,
        but we also need to ensure that the object is only created once within the singleton class itself.
    We guaranteed this in the HayStorage and StaffRegister classes by using the final modifier on the static reference.
    Unfortunately, because we used lazy instantiation in the VisitorTicketTracker class,
        the compiler won’t let us assign the final modifier to the static reference.
    The implementation of VisitorTicketTracker, as shown, is not considered thread‐safe in that two threads
        could call getInstance() at the same time, resulting in two objects being created.
    After both threads finish executing, only one object will be set and used by other threads going forward,
        but the object that the two initial threads received may not be the same.

    Thread safety is the property of an object that guarantees safe execution by multiple threads at the same time.
    We present a simple solution that is compatible with lazy instantiation using the synchronized modifier.
    The getInstance() method is now synchronized, which means only one thread will be allowed in the method at a time,
        ensuring that only one object is created.
     */
    /*
    public static synchronized VisitorTicketTracker1 getInstance() {
        if(instance == null) {
            instance = new VisitorTicketTracker1(); // THREAD-SAFE! WITH synchronized
        }
        return instance;
    }
    */

    /*
    This solution is better than our previous version, as it performs the synchronization
        step only when the singleton does not exist. If our singleton is accessed thousands of
        times over many hours or days, this means that only the fi rst few calls would require
        synchronization, and the rest would not.
     */
    public static VisitorTicketTracker1 getInstance() {
        if(instance == null) {
            synchronized(VisitorTicketTracker1.class) {
                if(instance == null) {
                    instance = new VisitorTicketTracker1();
                }
            }
        }
        return instance;
    }
    /*
    As you may have noticed, we added the volatile modifier to our singleton object. This
keyword prevents a subtle case where the compiler tries to optimize the code such that
that the object is accessed before it is finished being constructed. For the exam, you are
not required to know how volatile works or about any compiler optimizations.
     */




    // Data access methods

}
