package no.book.chapter1AdvancedClassDesign.assegmentTest.q15;

public class VisitPark {

    enum AnimalsInPark { // Line 2
        SQUIRREL, CHIPMUNK, SPARROW;
    }

    public static void main(String[] args) {
        AnimalsInPark[] animals = AnimalsInPark.values(); // Line 6
        System.out.println(animals[1]); // Line 7

        System.out.println(String.format("Result: %s %d",animals[1].name(),animals[1].ordinal()));
    }
}
/*
OUTPUT: CHIPMUNK

What is the result of the following code?
A. CHIPMUNK
B. SQUIRREL
C. The code compiles, but the output is indeterminate.
D. A compiler error occurs on line 2.
E. A compiler error occurs on line 6.
F. A compiler error occurs on line 7.

Answer
A

The code compiles.
An enum may be an inner class.
The values() method returns an array
    with the enum values in the order in which they were declared in the code.
Since Java uses 0-based indexes, the answer is A.
For more information, see Chapter 1.

 */