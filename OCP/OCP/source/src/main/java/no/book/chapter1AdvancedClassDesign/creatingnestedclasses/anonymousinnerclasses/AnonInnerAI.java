package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.anonymousinnerclasses;

public class AnonInnerAI {

    abstract class SaleTodayOnly implements Pedro { // Line 2
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