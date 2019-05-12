package no.agitec.fagaften.mars.kotlin.section06.whenexpression.java;

public class SwitchExample {

    public static void main(String[] args) {

        int num = 200;

        switch(num) {
            case 100:
                System.out.println("100");
                break;
            case 200:
                System.out.println("200");
                break;
            case 300:
                System.out.println("300");
                break;
            default:
                System.out.println("Didn't match anything");
        }
        //200
        System.out.println(" --1-- ");

        switch(num) {
            case 100:
                System.out.println("100");
                break;
            case 200:
                System.out.println("200");
                //break;
            case 300:
                System.out.println("300");
                break;
            default:
                System.out.println("Didn't match anything");
        }
        //200
        //300
        System.out.println(" --2-- ");
    }
}
