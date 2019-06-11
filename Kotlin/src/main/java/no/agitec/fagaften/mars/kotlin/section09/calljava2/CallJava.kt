package no.agitec.fagaften.mars.kotlin.section09.calljava2

import no.agitec.fagaften.mars.kotlin.section09.calljava2.javacode.Car


fun main(args: Array<String>) {

    val car = Car("blue", "Ford", 2015)
    car.color = "green"
    println(car)
    println(" --1-- ")

    car.variableMethod(5, "hello", "goodbye")
    val strings = arrayOf("hello", "goodbye")
    car.variableMethod(10, *strings) // Important
    println(" --2-- ")

    car.wantsIntArray(arrayOf(1, 2, 3).toIntArray())
    car.wantsIntArray(intArrayOf(1, 2, 3))
    println(" --3-- ")

    println("x = ${Car.x}")
    println(Car.xString())
    println(" --4-- ")

    car.demoMethod( { println("I'm in a thread!") })
    println(" --5-- ")

    (car.anObject as java.lang.Object).notify()
    //car.anObject.javaClass

}