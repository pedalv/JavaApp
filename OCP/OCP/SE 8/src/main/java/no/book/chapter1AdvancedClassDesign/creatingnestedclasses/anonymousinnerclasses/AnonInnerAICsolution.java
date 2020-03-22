package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.anonymousinnerclasses;


/*
But what if we want to implement both an interface and extend a class?
You can write a local inner class and give it a name if you have this problem.
Then you can extend a class and implement as many interfaces as you like.
If your code is this complex, a local inner class probably isn’t the most readable option anyway.

There is one more thing that you can do with anonymous inner classes.
You can define them right where they are needed, even if that is an argument to another method:
 */
public class AnonInnerAICsolution {

    interface SaleTodayOnly {
        int dollarsOff();
    }

    /*
    Lines 6 through 8 are the anonymous inner class.
    We don’t even store it in a local variable.
    Instead, we pass it directly to the method that needs it.
    Reading this style of code does take some getting used to.
    But it is a concise way to create a class that you will use only once.
    Before you get too attached to anonymous inner classes, know that you’ll see a shorter
        way of coding them in Chapter 4, “Functional Programming.”
     */
    public int pay() { // Line 5
        return admission(
                5,
                new SaleTodayOnly() { // Line 6
                    public int dollarsOff() { return 3; } // Line 7
                }
               ); // Line 8
    } // Line 9

    public int admission(int basePrice, SaleTodayOnly sale) {
        return basePrice - sale.dollarsOff();
    }

}
