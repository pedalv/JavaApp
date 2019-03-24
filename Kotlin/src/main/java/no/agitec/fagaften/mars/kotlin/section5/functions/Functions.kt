package no.agitec.fagaften.mars.kotlin.section5.functions

fun main(args: Array<String>) {
    println(labelMultiply(3, 4, "Here's the result:"))
    //Here's the result: 12
    println(" -1- ")
    //name arguments
    println(labelMultiply(label = "Here's the result:", operand2 = 3, operand1 = 4))
    //Here's the result: 12
    println(" -1- ")
    //name arguments
    println(labelMultiply(operand1 = 3, operand2 = 4))
    //The answer is: 12
    println(" -1- ")

    val emp = Employee("Jane")
    println(emp.upperCaseFirstName())
    //JANE
    println(" -2- ")

    val car1 = Car("blue", "Toyota", 2015)
    val car2 = Car("red", "Ford", 2016)
    val car3 = Car("grey", "Ford", 2017)

    printColors(car1, car2, car3)
    //blue
    //red
    //grey
    println(" -3- ")
    printColors2(car1, car2, car3, str = "Agitec")
    println(" -3- ")
    printColors3("Agitec", car1, car2, car3)
    println(" -3- ")

    val numbers = arrayOf(1, 2, 3)
    //public inline fun <reified @kotlin.internal.PureReifiable T> arrayOf(vararg elements: T): kotlin.Array<T> { /* compiled code */ }
    val manyCars = arrayOf(car1, car2, car3)
    printColors(*manyCars)
    //blue
    //red
    //grey
    println(" -4- ")

    val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()
    val lotsOfCars = arrayOf(*manyCars, *moreCars, car4)
    for (c in lotsOfCars) {
        println(c)
    }
    //Car(color=blue, model=Toyota, year=2015)
    //Car(color=red, model=Ford, year=2016)
    //Car(color=grey, model=Ford, year=2017)
    //Car(color=red, model=Ford, year=2016)
    //Car(color=grey, model=Ford, year=2017)
    //Car(color=red, model=Ford, year=2016)
    println(" -5.1- ")
    for (c in lotsOfCars) {
        println(c.model)
    }
    println(" -5.2- ")
    //Toyota
    //Ford
    //Ford
    //Ford
    //Ford
    //Ford

    val lotsOfCars2 = arrayOf(manyCars, moreCars, car4)
    for (c in lotsOfCars2) {
        println(c)
    }
    //[Lno.agitec.fagaften.mars.kotlin.section5.functions.Car;@35fb3008
    //[Lno.agitec.fagaften.mars.kotlin.section5.functions.Car;@7225790e
    //Car(color=red, model=Ford, year=2016)
    println(" -6- ")

    val s = "this is all in lowercase"
    println(Utils().upperFirstAndLast(s))
    println(upperFirstAndLast(s))
    //extended functions
    println(s.upperFirstAndLast1())
    println(s.upperFirstAndLast2())
    //This is all in lowercasE
    println(" -7- ")

}

//extended functions
fun String.upperFirstAndLast1(): String {
    val upperFirst = this.substring(0, 1).toUpperCase() + this.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

//extended functions
fun String.upperFirstAndLast2(): String {
    val upperFirst = substring(0, 1).toUpperCase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}


var numbers = arrayOf(1, 2, 3)
//public inline fun <reified @kotlin.internal.PureReifiable T> arrayOf(vararg elements: T): kotlin.Array<T> { /* compiled code */ }

/**
 * Ony one vararg
 */
fun printColors(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}

fun printColors2(vararg cars: Car, str : String) {
    for (car in cars) {
        println(car.color)
    }
}

fun printColors3(str : String, vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}
fun whatever() = 3 * 4

fun labelMultiplyLong(operand1: Int, operand2: Int, label: String) : String {
    return ("$label ${operand1 * operand2}")
}

fun labelMultiplyLong2(operand1: Int, operand2: Int, label: String) =
        "$label ${operand1 * operand2}"

fun labelMultiply(operand1: Int, operand2: Int,
                  label: String = "The answer is:") =
        "$label ${operand1 * operand2}"

class Employee(val firstName: String) {

    fun upperCaseFirstName() = firstName.toUpperCase()

}

data class Car(val color: String, val model: String, val year: Int) {

}