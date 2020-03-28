package oracle.certified.professional.SE81Z0809.book.AssessmentTest.q08;

public class Wolf extends Canine {
}

/*
What statements are true about the following code? (Choose all that apply.)

A. Wolf has-a name.
B. Wolf has-a Tail.
    C. Wolf is-a Tail.
D. Wolf is-a Animal.
    E. Canine is-a Wolf.
    F. Animal has-a Tail.


Answer
A
B
D

A is correct because name is public and therefore inherited by the Wolf class.
B is correct because Wolf is-a Canine and Canine has-a Tail; therefore, since tail is public, it
    is inherited and Wolf has-a Tail.
C is incorrect, because Wolf is not inherited from Tail.
D is correct, because Wolf is-a Canine and Canine is-a Animal; therefore, Wolf is-a Animal.
E is incorrect, because the relationship is reversed.
F is incorrect, since Animal does not have a Tail attribute.
For more information, see Chapter 2.
 */
