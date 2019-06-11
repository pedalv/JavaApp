package no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava;

import no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Challenge;
import no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee;
import no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.KotlinCodeKt;

public class Main {

    public static void main(String[] args) {
        /*
        Exception in thread "main" java.lang.IllegalArgumentException: Parameter specified as non-null is null: method no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault, parameter parm1
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault(KotlinCode.kt)
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault$default(KotlinCode.kt:19)
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault(KotlinCode.kt)
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.Main.main(Main.java:20)
         */


        //1 J
        KotlinCodeKt.sayHelloToJava("Student");
        //1.1 K
       // KotlinStuff.sayHelloToJava("Student");
        //Kotlin says hello to Java and Student
        System.out.println("  --1-- ");

        Employee employee = new Employee("John", "Smith", 2010);
        //2 J
        employee.setStartYear(2009);
        //2 K
        //employee.startYear = 2009;


        //3 J
        Challenge.INSTANCE.doMath(5, 4);
        //3 K
        //Challenge.doMath(5, 4);


        //4 K
        //employee.takesDefault(null);
        /*
        Exception in thread "main" java.lang.IllegalArgumentException: Parameter specified as non-null is null: method no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault, parameter parm1
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault(KotlinCode.kt)
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault$default(KotlinCode.kt:22)
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault(KotlinCode.kt)
	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.Main.main(Main.java:34)
         */

        //4 K
        employee.takesDefault("arg1");
        //arg1 and default
        System.out.println(" --2-- ");

//        KotlinStuff.sayHelloToJava("Student");
//
//        Employee employee = new Employee("John", "Smith", 2010);
//        employee.startYear = 2009;
//
//        Challenge.doMath(5, 4);
//
//        employee.takesDefault("arg1");

//        //1 kotlin kode
//        //KotlinCodeKt.sayHelloToJava("Student");
//        KotlinStuff.sayHelloToJava("Student");
//
//        Employee employee = new Employee("John", "Smith", 2010);
//        //2 kotlin kode
//        //employee.setStartYear(2009);
//        employee.startYear = 2009;
//        //3 kotlin kode
//        Challenge.INSTANCE.doMath(5, 4);
//
//        //4 kotlin kode
//        //employee.takesDefault(null);
//        /*
//        Exception in thread "main" java.lang.IllegalArgumentException: Parameter specified as non-null is null: method no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault, parameter parm1
//	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault(KotlinCode.kt)
//	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault$default(KotlinCode.kt:22)
//	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode.Employee.takesDefault(KotlinCode.kt)
//	        at no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.Main.main(Main.java:34)
//         */
//
//        //4 kotlin kode
//        employee.takesDefault("arg1");


    }
}
