package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.singletonpatterns.applyinglazyinstantiationtosingletons;

/*
Another technique is to delay creation of the singleton until the first time the
getInstance() method is called:
 */
public class ApplyingLazyInstantiationtoSingletons {

}

/*
The VisitorTicketTracker, like our singleton classes,
    declares only private constructors,
    creates a singleton instance,
    and returns the singleton with a getInstance() method.

The VisitorTicketTracker class, though, does not create the singleton object
    when the class is loaded but rather the first time it is requested by a client.
Creating a reusable object the first time it is requested is a software design pattern known as
    lazy instantiation.
It used often in conjunction with the singleton pattern.
Lazy instantiation reduces memory usage and improves performance when an application starts up.
 */
class VisitorTicketTracker {

    private static VisitorTicketTracker instance;

    private VisitorTicketTracker() {
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
    public static synchronized VisitorTicketTracker getInstance() {
        if(instance == null) {
            instance = new VisitorTicketTracker(); // THREAD-SAFE! WITH synchronized
        }
        return instance;
    }

    // Data access methods

}


/*

In fact, without lazy instantiation, most operating systems and applications that you run
    would take significantly longer to load and consume a great deal more memory,
    perhaps more memory than is even available on your computer.

The downside of lazy instantiation is
    that users may see a noticeable delay the first time a particular type of resource is needed.

For example, you may have seen lazy instantiation in applications that you use to
    write software and not even noticed it.

One such freely available software development tool, Eclipse, often demonstrates a slight delay
    the first time you open a Java file in an editor window after starting the program.
This delay disappears, though, when you open additional Java files.
This is an example of lazy instantiation, since Eclipse is only loading
    the libraries to parse and present Java files the first time a Java file is open.
 */

/*
Singletons in Server Environments
For the purposes of the exam, singletons are always unique.
When you get to writing applications that run across multiple computers,
    the static singleton solution starts to require special consideration,
    as each computer would have its own JVM.
In those situations, you might still use the singleton pattern,
    although it might be implemented with
    ENUM
    a database
    or queue server rather than as a static object.
 */
