package no.agitec.fagaften.mars.kotlin.section3.learnprograming.bitoperatorcasting

import no.agitec.fagaften.mars.kotlin.section3.learnprograming.equality.Employee

fun main(args: Array<String>)  {

    //bit operator
    val x = 0x00101101
    val y = 0x11011011
    val a = x or y
    val b = x and y
    val c = x xor y


    //Casting
    val employeeOne = Employee("Mary", 1)
    val employeeFour = Employee("John", 2)

    var something: Any = employeeFour
    if (something is Employee) { //instanceof
        //val newEmployee = something as Employee
        something = employeeFour //Only Employee
        println(something.name) //John

        something = "notEmployee" //Kotlin know it is a error here. Only allow Employee
        //println(something.name) //Error:(26, 27) Kotlin: Unresolved reference: name

        something = employeeOne
        println(something.name) //Mary
    }




}
