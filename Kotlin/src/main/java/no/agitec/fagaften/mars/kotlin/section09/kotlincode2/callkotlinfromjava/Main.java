package no.agitec.fagaften.mars.kotlin.section09.kotlincode2.callkotlinfromjava;

import no.agitec.fagaften.mars.kotlin.section09.kotlincode2.Car;
import no.agitec.fagaften.mars.kotlin.section09.kotlincode2.SingletonObj;
import no.agitec.fagaften.mars.kotlin.section09.kotlincode2.StaticCar;

import java.io.IOException;

import static no.agitec.fagaften.mars.kotlin.section09.kotlincode2.StaticCar.print;
import static no.agitec.fagaften.mars.kotlin.section09.kotlincode2.StaticCar.topLevel;

public class Main {

    public static void main(String[] args) {
	    topLevel();
	    //I'm in the Car file!
	    System.out.println(" --1-- ");

	    print("print this Java string");
	    //print this Java string
		System.out.println(" --2-- ");

	    Car car = new Car("blue", "BMW", 2011);
	    System.out.println(car.model);
	    //BMW
	    System.out.println(car.getColor());
	    //blue
		System.out.println(" --3-- ");

	    Car.carComp();
	    //I'm in Car's companion object
	    System.out.println("isAuto = " + Car.constant);
		//isAuto = 25
		System.out.println("isAuto = " + Car.isAuto);
		//isAuto = false
		System.out.println(" --4-- ");

		SingletonObj.INSTANCE.doSomething2();
		//I'm doing something in the singleton object
		//SingletonObj.doSomething2();
		/*
			Error:(38, 29) java: non-static method doSomething2() cannot be referenced from a static context
		 */
		SingletonObj.doSomething();
	    //isAuto = falseI'm doing something in the singleton object
		System.out.println(" --5-- ");

	    //car.printMe(null);
	    /*
	    Exception in thread "main" java.lang.IllegalArgumentException: Parameter specified as non-null is null: method no.agitec.fagaften.mars.kotlin.section09.kotlincode2.Car.printMe, parameter text
			at no.agitec.fagaften.mars.kotlin.section09.kotlincode2.Car.printMe(Car.kt)
			at no.agitec.fagaften.mars.kotlin.section09.kotlincode2.callkotlinfromjava.Main.main(Main.java:48)
	     */
	    System.out.println(" --6-- ");

	    try {
            StaticCar.doIO();
        }
        catch (IOException e) {
	        System.out.println("IOException!");
	        //IOException!
        }
		//StaticCar.doIO2();
	    //Exception in thread "main" java.io.IOException
		//	at no.agitec.fagaften.mars.kotlin.section09.kotlincode2.StaticCar.doIO2(Car.kt:24)
		//	at no.agitec.fagaften.mars.kotlin.section09.kotlincode2.callkotlinfromjava.Main.main(Main.java:63)
		System.out.println(" --7-- ");

        StaticCar.defaultArgs("The Number is: ");
		System.out.println(" --8-- ");
		//StaticCar.defaultArgs2("The Number is: ");
		//Error:(71, 26) java: method defaultArgs2 in class no.agitec.fagaften.mars.kotlin.section09.kotlincode2.StaticCar cannot be applied to given types;
		//  required: java.lang.String,int
		//  found: java.lang.String
		//  reason: actual and formal argument lists differ in length
		System.out.println(" --9-- ");
	}
}
