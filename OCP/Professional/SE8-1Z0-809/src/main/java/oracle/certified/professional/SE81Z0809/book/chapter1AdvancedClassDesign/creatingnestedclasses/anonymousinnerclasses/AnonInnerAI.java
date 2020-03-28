package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.anonymousinnerclasses;

/*
But what if we want to implement both an interface and extend a class?
You can’t with an anonymous inner class, unless the class to extend is java.lang.Object.
Object is a special class, so it doesn’t count in the rule.

Remember that an anonymous inner class is just an unnamed local inner class.

You can write a local inner class and give it a name if you have this problem.
Then you can extend a class and implement as many interfaces as you like.
 */
public class AnonInnerAI {

    abstract class SaleTodayOnly implements Pedro  { // Line 2
        abstract int dollarsOff();
    } // Line 4

    public String admission(int basePrice) { // Line 5

        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            public String workForAchieveOCP() {
                return "Work for OCP";
            }

            @Override
            int dollarsOff() { return 3; } // Line 7
        }; // Line 8

        return sale.workForAchieveOCP() + " with admission: " + (basePrice - sale.dollarsOff());
    }

}