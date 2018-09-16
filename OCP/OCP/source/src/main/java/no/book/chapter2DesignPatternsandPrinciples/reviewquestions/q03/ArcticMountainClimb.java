package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q03;

public interface ArcticMountainClimb extends MountainClimb {

    // default need a implementation
    public default int getSpeed() {
        return 0;
    }

}

/*
Which of the following are valid functional interfaces? (Choose all that apply.)

A. Climb
    B. Swim
    C. ArcticMountainClimb
D. MountainClimb
E. None of these are valid functional interfaces.

Answer

 */
