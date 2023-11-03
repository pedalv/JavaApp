package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.reviewquestions.q09;

public class CheetahManager {

    // TODO: D. Change the access modifier of cheetahManager from public to private.
    /*public (NO NO NO)*/ private static CheetahManager cheetahManager;

    private CheetahManager() {}

    // TODO: F. Add synchronized to getCheetahManager().
    public static synchronized CheetahManager getCheetahManager() {
        if(cheetahManager == null) {
            cheetahManager = new CheetahManager();
        }
        return cheetahManager;
    }

    // TODO: F. (BEST) Add synchronized step only when the singleton does not exist inside getCheetahManager().
    /*
    This solution is better than our previous version, as it performs the synchronization
        step only when the singleton does not exist. If our singleton is accessed thousands of
        times over many hours or days, this means that only the first few calls would require
        synchronization, and the rest would not.
     */
    public static CheetahManager getCheetahManagerBEST() {
        if(cheetahManager == null) {
            synchronized(CheetahManager.class) {
                if(cheetahManager == null) {
                    cheetahManager = new CheetahManager();
                }
            }
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
D, F.
A is incorrect, as there are definitely some problems with the singleton implementation.
B and C are incorrect, as naming of the instance variable and access method are not
    required as part of the pattern.
The public modifier on the cheetahManager instance means that any class can access
    or even replace the instance, which breaks the singleton pattern;
hence D is required to fix the implementation.
E is incorrect,
    as marking the instance final would prevent lazy instantiation
    and as the code would not compile.
F is also required,
    since without this step
    two threads could create two distinct instances
    of the singleton at the same time,
    which would violate the singleton pattern.

 */