package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.anonymousinnerclasses;

public class AnonInnerIs {

    interface SaleTodayOnly extends Pedro { // Line 2
        int dollarsOff();
    } // Line 4

    public String admission(int basePrice) { // Line 5

        SaleTodayOnly sale = new SaleTodayOnly() {

            @Override
            public String workForAchieveOCP() {
                return "Work for OCP";
            }

            @Override
            public int dollarsOff() { return 3; } // Line 7
        };

        return sale.workForAchieveOCP() + " with admission: " + (basePrice - sale.dollarsOff());
    }

}
