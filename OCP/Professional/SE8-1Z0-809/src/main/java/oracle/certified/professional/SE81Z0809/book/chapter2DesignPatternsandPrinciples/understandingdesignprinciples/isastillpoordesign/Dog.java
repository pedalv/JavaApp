package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples.isastillpoordesign;

/*
Our class structure now works and is consistent, but if we add a child Dog to Pet,
    we encounter a problem with the is‐a test.
A Dog is‐a Pet, and a Pet is‐a Feline, but the model implies that a Dog is‐a Feline,
    which obviously is not true.

As you saw in this example, the is‐a relationship test helps us avoid creating object
    models that contain contradictions.
One solution in this example is to not combine Tiger and Pet in the same model,
    preferring to write duplicate code rather than create inconsistent data.
 */
public class Dog extends Pet {
}
