package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.reviewquestions.q19;

public class SingletonPattern {

    /*
    Which three scenarios would best benefit from using a singleton pattern?
    (Choose all three.)

        A. Create read‐only objects that are thread‐safe.
    B. Manage a reusable cache of objects.
        C. Ensure that all objects are lazily instantiated.
    D. Manage write access to a log file.
    E. Provide central access to application configuration data.
        F. Allow multiple instances of a static object to be managed in memory.

    ANSWER
    B, D, E.
    A is incorrect,
        as that is a property of the immutable object pattern.
    B is correct,
        as caching data is one of the most common uses of the singleton pattern.
    While the singleton pattern may use lazy instantiation,
        it is not used to ensure that objects are lazily instantiated,
        so C is incorrect. D is correct, as we only want one class writing to a log file at once.
    E is also correct,
        as managing application-wide configuration data
        is another very common use of the singleton pattern.
    F is incorrect,
        as we only want one instance of a static object created when using the singleton pattern.

     */
}
