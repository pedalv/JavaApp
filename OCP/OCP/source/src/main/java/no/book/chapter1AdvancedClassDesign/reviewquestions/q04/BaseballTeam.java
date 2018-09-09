package no.book.chapter1AdvancedClassDesign.reviewquestions.q04;

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
D
 */
