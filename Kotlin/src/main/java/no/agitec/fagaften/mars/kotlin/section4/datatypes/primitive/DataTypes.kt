package no.agitec.fagaften.mars.kotlin.section4.datatypes.primitive

import no.agitec.fagaften.mars.kotlin.section3.learnprograming.stringtemplate.Employeek
import no.agitec.fagaften.mars.kotlin.section4.javacode.DummyClass

/**
 * The myMethod() function in the above code doesn't accept any argument.
 * Also, the function doesn't return any value (return type is Unit).
 */
fun myMethod() {}

/**
 * The type of the throw expression is the special type Nothing.
 */
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}


fun main(args: Array<String>) {

    val myInt = 10
    println("This is a Int: ${myInt is Int}")
    var myLong = 22L
    var myLongWay : Long = 22 // It is not kotlin because it is very verbose

    /*
    int myInt = 10;
    Long myLong = myInt
     */

    myLong = myInt.toLong()

    val myByte: Byte = 111
    var myShort: Short
    myShort = myByte.toShort()

    val anotherInt = 5

    var myDouble = 65.984
    println(myDouble is Double)

    val myFloat = 838.8492f
    println("This is a float: ${myFloat is Float}")

    myDouble = myFloat.toDouble()

    /*
    char myChar = 65;
     */

    val char = 'b'
    val myCharInt = 65
    println(myCharInt.toChar())

    val myBoolean = true

    val vacationTime = false
    val onVacation = DummyClass().isVacationTime(vacationTime)
    println(onVacation)

    val anything: Any

    val anyNothing : Nothing


    //Elvis expression ?:
    val employee = Employeek("Agitec AS", 21)
    val s1 = employee.name ?: throw IllegalArgumentException("Name required")

    val person = Person("Agitec As" as Nothing)
    /*
    Exception in thread "main" java.lang.ClassCastException:
    class java.lang.String cannot be cast to class java.lang.Void
    (java.lang.String and java.lang.Void are in module java.base of loader 'bootstrap')
	at no.agitec.fagaften.mars.kotlin.section4.datatypes.primitive.DataTypesKt.main(DataTypes.kt:71)
     */

    val s2 = person.name ?: throw IllegalArgumentException("Name required")

}

data class Person(val  name : Nothing) {}