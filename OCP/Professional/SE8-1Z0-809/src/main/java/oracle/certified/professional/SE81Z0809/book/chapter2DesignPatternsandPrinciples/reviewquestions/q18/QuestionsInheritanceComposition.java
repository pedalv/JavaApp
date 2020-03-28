package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.reviewquestions.q18;

public class QuestionsInheritanceComposition {

    /*
    Which of the following statements about inheritance and object composition are correct?
    (Choose all that apply.)

    A. Inheritance supports access to protected variables.
    B. Object composition tends to promote greater code reuse than inheritance.
        C. Inheritance relies on the has‐a principle.
        D. Object composition supports method overriding at runtime.
    E. Object composition requires a class variable to be declared public or accessible from a
    public method to be used by a class in a different package.
        F. Object composition is always preferred to inheritance.

    ANSWER
    A, B, E.
    A is correct,
        and it is one of the reasons to prefer class inheritance over object composition.
    B is also correct,
        since object composition tends to lead to classes that are easier to reference,
        as they don’t require knowledge of any parent classes.
    C is incorrect,
        as inheritance tends to use the is-a principle,
        whereas object composition relies on the has-a principle.
    D is incorrect,
        as this is a statement about inheritance,
        not object composition.
    E is correct,
        as object composition has no notion of inheritance
        and variables must be exposed publically
        if they are to be used by other classes in different packages.
    F is incorrect, as neither are always the right answer.
    There are situations where inheritance is more appropriate,
        and situations where object composition is more appropriate.


     */
}
