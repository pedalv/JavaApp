package no.agitec.fagaften.mars.kotlin.section09.kotlincode1.callkotlinfromjava;

import no.agitec.fagaften.mars.kotlin.section09.kotlincode1.Car;
import no.agitec.fagaften.mars.kotlin.section09.kotlincode1.StaticCar;

import static no.agitec.fagaften.mars.kotlin.section09.kotlincode1.StaticCar.topLevel;


public class Main {

    public static void main(String[] args) {
	    topLevel();
		//I'm in the Car file!
		StaticCar.topLevel();
	    //I'm in the Car file!
	    System.out.println(" --1-- ");

	    StaticCar.print("print this Java string");
	    //print this Java string
		System.out.println(" --2-- ");

	    Car car = new Car("blue", "BMW", 2011);
	    System.out.println(car.model);
		//BMW
	    System.out.println(car.getColor());
		//blue
	    System.out.println(" --3-- ");

    }
}
