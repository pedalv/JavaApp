package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns;

/*
We can also instantiate a singleton in two other ways.
The following example creates a singleton using a static initialization block when the class is loaded.
For simplicity, we skip defining the data methods on these classes and
    present only the creation and instance retrieval logic:


Both the StaffRegister class and our previous HayStorage class instantiate the singleton
    at the time the class is loaded.
Unlike the HayStorage class, though, the StaffRegister class instantiates the singleton
    as part of a static initialization block.

Conceptually, these two implementations are equivalent, since both create the singleton when the class is loaded,
    although the static initialization block allows additional steps
    to be taken to set up the singleton after it has been created.
It also allows us to handle cases in which the StaffRegister constructor throws an exception.
Since the singleton is created when the class is loaded, we are able to mark the reference final,
    which guarantees only one instance will be created within our application.
 */
public class StaffRegister {

    private static final StaffRegister instance;
    static {
        instance = new StaffRegister();
        // Perform additional steps
    }

    private StaffRegister() {
    }

    public static StaffRegister getInstance() {
        return instance;
    }

    // Data access methods

}
