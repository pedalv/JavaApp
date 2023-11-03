package no.agitec.fagaften.mars.kotlin.section05.classesconstructor

fun main(args: Array<String>) {

    val empVerbose31 = EmployeeKotlin3("Agitec AS")
    println(empVerbose31) // EmployeeKotlin3(firstName=Agitec AS)
    println(empVerbose31.firstName) // Agitec AS
    println(empVerbose31.lastName) // default-name
    println(empVerbose31.fulltime) // true
    println(" -0.1- ")
    val empVerbose32 = EmployeeKotlin3(fulltime = false)
    println(empVerbose32) // EmployeeKotlin3(firstName=Agitec AS)
    println(empVerbose32.firstName) // Agitec AS
    println(empVerbose32.lastName) // default-name
    println(empVerbose32.fulltime) // false
    println(" -0.2- ")
    val empVerbose33 = EmployeeKotlin3("first-name", fulltime = false)
    println(empVerbose33) // EmployeeKotlin3(firstName=first-name)
    println(empVerbose33.firstName) // first-name
    println(empVerbose33.lastName) // default-name
    println(empVerbose33.fulltime) // false
    println(" -0.3- ")
    val empVerbose34 = EmployeeKotlin3(firstName = "first-name",lastName = "last-name", fulltime = false)
    println(empVerbose34) // EmployeeKotlin3(firstName=first-name)
    println(empVerbose34.firstName) // first-name
    println(empVerbose34.lastName) // last-name
    println(empVerbose34.fulltime) // false
    println(" -0.4- ")

    val empVerbose = EmployeeLong("Long way to create 'primary' constructor. There are secundaries constructors :-).")
    println(empVerbose.firstName) //Long way to create 'primary' constructor. There are secundaries constructors :-).
    println(" -1- ")

    val empNotVerbose = EmployeeShort("Short way to create 'primary' constructor. There are secundaries constructors :-).")
    println(empNotVerbose.firstName) //Short way to create 'primary' constructor. There are secundaries constructors :-).
    println(" -2- ")
    val empkotlin = EmployeeKotlin("The good way in Kotlin to create 'primary' constructor.")
    println(empkotlin.firstName) //The good way in Kotlin to create 'primary' constructor.
    println(" -3- ")

    val empkotlin3 = EmployeeKotlin3("kotlin3")
    println(empkotlin3.firstName) // kotlin3 //Only first name is available if it is not declared (empkotlin3.fulltime)
    println(" -4- ")

    val empkotlin31 = EmployeeKotlin3("kotlin31", false)
    println(empkotlin31.firstName) // kotlin31
    println(empkotlin31.fulltime) // false
    println(" -5- ")

    val emp = Employee("John")
    println(emp.firstName) //John
    println(" -6- ")

    val emp2 = Employee("Joe")
    println(emp2.firstName) //Joe
    println(emp2.fullTime) //true
    println(" -7- ")

    val emp3 = Employee("Jane", false)
    println(emp3.firstName) //Jane
    println(emp3.fullTime) //false
    println(" -8- ")

    println(Demo().dummy) //Hello
    println(" -9- ")
}

/**
 * Code below is very verbose
 * Primary constuctor: constructor with one parameters declare outside
 * Secondary constructor: all contructores that is not declared outside
 *
 */
class EmployeeLong constructor(firstName: String) {

    //Long way
    val firstName: String

    //It is not a constructor
    //It is the body for the primary constructor
    //It is possible to have many inits blocks
    init {
        this.firstName = firstName
    }

}

class EmployeeShort constructor(firstName: String) {

    val firstName: String = firstName
}

class EmployeeKotlin(val firstName: String) {

}

class EmployeeKotlin2 protected constructor(firstName: String) {

    val firstName: String = firstName
}

data class EmployeeKotlin3(var firstName: String) {
    //Declaration must be on the first line
    //val fulltime: Boolean? = true // it will be always true
    var fulltime: Boolean = true
    var lastName : String = "default-name"


    /*
    Kotlin: Primary constructor call expected
    Kotlin: 'val' on secondary constructor parameter is not allowed
    Kotlin: 'val' on secondary constructor parameter is not allowed
     */
    //constructor(val firstName: String, val fulltime: Boolean) { }

    constructor(firstName: String = "Agitec AS", fulltime: Boolean) : this(firstName) {
        this.fulltime = fulltime // need assign to change the value
    }

    constructor(firstName: String, fulltime: Boolean, lastName: String) : this(firstName) {
        this.lastName = lastName // need assign to change the value
        this.fulltime = fulltime // need assign to change the value
    }

}


class Employee(val firstName: String, var fullTime: Boolean = true) {

}


class Demo {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}


