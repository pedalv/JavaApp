package no.book.AssessmentTest.q06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

final public class Duck {

    final private String name;

    final private List<Duck> ducklings;

    public Duck(String name, List<Duck> ducklings) {
        this.name = name;
        this.ducklings = new ArrayList<Duck>(ducklings);
    }

    public String getName() { return name; }

    public List<Duck> getDucklings() {
        // Problem: Possible do getFavoriteFoods().clear()/replace, remove, or even sort the List.
        // return ducklings;

        // The solution is never to return that List reference to the user.
        return Collections.unmodifiableList(ducklings); // IMPORTANT IMPORTANT IMPORTANT
    }

    public String hasDucklings(Predicate<Duck> p) {
        return p.test(this) ? "Quack Quack": "";
    }

}

/*
Question 6
    A. None, the immutable object pattern is properly implemented.
B. Mark name and ducklings final.
C. Mark the Duck class final.
    D. Have Duck implement the Immutable interface.
    E. Remove the hasDucklings() method since any lambda expressions passed to it could modify the Duck object.
F. Replace the getDucklings() with a method (or methods) that do not give the caller
        direct access to the List<Duck> ducklings.
    G. Change the type of List<Duck> to be List<Object>.

Answer
B, C, F.
A is incorrect, since there are definitely some problems with the immutable objects implementation.
B is correct, because all instance variables should be marked final and private
    for the class to be considered immutable.
C is correct, because it prevents the methods from being overridden.
D is incorrect, since there is no such thing as the Immutable interface defined in the Java API.
E is also incorrect, because any passed lambda expression would have access
    to only the public methods of the class.
F is correct, because the mutable object ducklings should not be exposed directly,
    since this allows the user to modify it.
G is incorrect, because this has nothing to do with immutability.
For more information, see Chapter 2.
 */