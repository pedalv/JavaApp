package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q09;

public class CheetahManager {

    public static CheetahManager cheetahManager;

    private CheetahManager() {}

    public static CheetahManager getCheetahManager() {
        if(cheetahManager == null) {
            cheetahManager = new CheetahManager();
        }
        return cheetahManager;
    }

}

/*
What changes need to be made to make the following singleton pattern correct?
(Choose all that apply.)

    A. None; the singleton pattern is properly implemented.
    B. Rename cheetahManager to instance.
    C. Rename getCheetahManager() to getInstance().
    D. Change the access modifier of cheetahManager from public to private.
E. Mark cheetahManager final.
F. Add synchronized to getCheetahManager().

ANSWER


 */