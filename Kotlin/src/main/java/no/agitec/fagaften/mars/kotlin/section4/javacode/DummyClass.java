package no.agitec.fagaften.mars.kotlin.section4.javacode;

public class DummyClass {

    public String isVacationTime(Boolean onVacation) {
        return onVacation ? "I'm on vacation!" : "I'm working";
    }

    public void printNumbers(int[] numbers) {
        for (int number: numbers) {
            System.out.println(number);
        }
    }

}
