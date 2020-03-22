package no.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples.isapoordesign;

/*
As a developer, you might also design a class Tiger,
 and since tigers also have an age and a name,
 you might be inclined to reuse the parent Pet class
 for the purposes of saving time and lines of code.

 Poor design—A Tiger is‐a Pet, because Tiger extends Pet.

Unfortunately, Pet also has a cuddle() method, with the result being that you are
    encouraging people to cuddle tigers!
By reusing the parent Pet class, you are conceptually stating that a Tiger is‐a Pet,
    even though a Tiger is not a Pet.
Although this example is functionally correct and does save time and lines of code,
    the result of failing to apply the is‐a relationship is that you have created
    a relationship that violates the data model.
Let’s try to fix the problem by placing Pet and Tiger underneath a Feline parent


 */
public class Tiger extends Pet {
}
