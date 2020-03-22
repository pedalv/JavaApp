package no.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples;

/*
Encapsulation is so prevalent in Java that there is a standard for creating classes that store data, called JavaBeans.
A JavaBean is a design principle for encapsulating data in an object in Java.



 */
public class CreatingJavaBeans {

    private boolean playing;
    private Boolean dancing;

    public boolean isPlaying() { return playing; } // Line 1
    // The first line is correct because it defines a proper getter for a boolean variable.
    public boolean getPlaying() { return playing; } // Line 2
    // The second example is also correct, since boolean may use is or get.
    public Boolean isDancing() { return dancing; } // Line 3
    //The third line is incorrect, because a Boolean wrapper should start with get, since it is an object.
    public Boolean getDancing() { return dancing; } // Line 3 - correct

    // None of these lines follow correct JavaBean practices!
    public String name; // Line 1
    // The first line makes name public, whereas it should be private.
    public String name() { return name; } // Line 2
    // The second line does not define a proper getter and should be getName().

    // The last two lines are both incorrect setters,
    public void updateName(String n) { name = n; } // Line 3
    // since the first does not start with set
    public void setname(String n) { name = n; } // Line 4
    // and the second does not have the first letter of the attribute name in uppercase.




}
