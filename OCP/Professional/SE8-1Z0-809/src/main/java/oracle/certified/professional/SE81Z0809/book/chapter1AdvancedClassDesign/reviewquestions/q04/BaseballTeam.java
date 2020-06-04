package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.reviewquestions.q04;

public class BaseballTeam {

    private String city, mascot;
    private int numberOfPlayers;

    public boolean equals(Object obj) {
        if ( !(obj instanceof BaseballTeam))
            return false;
        BaseballTeam other = (BaseballTeam) obj;
        return (city.equals(other.city) && mascot.equals(other.mascot));
    }

    public int hashCode() {
        return numberOfPlayers;
    }

    // imagine getters and setters are here
}

/*
What is true about the following code? You may assume city and mascot are never null.

    A. The class does not compile.
    B. The class compiles but has an improper equals() method.
C. The class compiles but has an improper hashCode() method.
        D. The class compiles and has proper equals() and hashCode() methods.

ANSWER
C.
The equals() method is correct.
You are allowed to use any business logic that you want in determining equality.

The hashCode() method is not correct.
It violates the rule that two objects that return true for equals() must return the same hashCode().
It is also a bad idea for the hash code to contain values that could change.
 */
