package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.anonymousinnerclasses;

public class AnonInnerI {
    /*
    Now we convert this same example to implement an interface instead
        of extending an abstract class:

    The most interesting thing here is how little has changed.
    Lines 2 through 4 declare an interface instead of an abstract class.
    Line 7 is public instead of using default access since interfaces require public methods.
    And that is it.
    The anonymous inner class is the same whether you implement an interface or extend a class!
    Java figures out which one you want automatically.
    But what if we want to implement both an interface and extend a class?
    You can’t with an anonymous inner class, unless the class to extend is java.lang.Object.
    Object is a special class, so it doesn’t count in the rule.
    Remember that an anonymous inner class is just an unnamed local inner class.
    You can write a local inner class and give it a name if you have this problem.
    Then you can extend a class and implement as many interfaces as you like.
    If your code is this complex, a local inner class probably isn’t the most readable option anyway.

    There is one more thing that you can do with anonymous inner classes.
    You can define them right where they are needed, even if that is an argument to another method:
     */
    interface SaleTodayOnly { // Line 2
        int dollarsOff();
    } // Line 4

    public int admission(int basePrice) { // Line 5

        SaleTodayOnly sale = new SaleTodayOnly() { // Line 7
            public int dollarsOff() { return 3; }
        };

        return basePrice - sale.dollarsOff();
    }

}
