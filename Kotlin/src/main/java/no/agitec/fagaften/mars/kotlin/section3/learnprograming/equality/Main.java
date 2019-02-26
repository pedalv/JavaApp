package no.agitec.fagaften.mars.kotlin.section3.learnprograming.equality;

public class Main {


    public static void main(String ... args) {
        Employeej employeeOne = new Employeej("Mary", 1);
        Employeej employeeTwo = new Employeej("John", 2);
        Employeej employeeThree = new Employeej("John", 2);

        System.out.println(employeeOne == employeeTwo); //false //REFERENCIAL
        System.out.println(employeeTwo == employeeThree); //false //REFERENCIAL
        System.out.println(employeeOne.equals(employeeTwo)); //false //STRUCTURAL EQUALITY
        System.out.println(employeeTwo.equals(employeeThree)); //true  //STRUCTURAL EQUALITY
    }
}
