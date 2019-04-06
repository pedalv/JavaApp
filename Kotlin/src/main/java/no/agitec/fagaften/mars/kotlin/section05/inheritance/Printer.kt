package no.agitec.fagaften.mars.kotlin.section05.inheritance

fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("Brother 1234")
    laserPrinter.printModel()
    // The model name of this 'laser printer' is Brother 1234

    //Step 6:
    val laserPrinter6 = LaserPrinter6("Brother 1234")
    laserPrinter6.printModel()
    //The model name of this 'printer' is Brother 1234
}

// Step 1: Errors
/*
Kotlin: This type is final, so it cannot be inherited from
Kotlin: This type has a constructor, and thus must be initialized here
 */
/*
class Printer1 {

}

class LaserPrinter1 : Printer1 {

}
*/

// Step 2: Solution 1 -  Not work
/*
Kotlin: This type has a constructor, and thus must be initialized here
*/
/*
open class Printer1 {

}
class LaserPrinter1 : Printer1 {
}
*/

// Step 3: Solution 2.1 - Works
//open class for inheritance
open class Printer321 {

}
class LaserPrinter321() : Printer321() {
}

// Solution 2.2: Works
open class Printer322 {

}
class LaserPrinter322 : Printer322 {

    constructor() : super()
}

//Step 4: open abstract class, it is redundant => abstract class
abstract class Printer4() {

}
class LaserPrinter4 : Printer4() {

}

//Step 5: ERROR - VAL in LaserPrinter
abstract class Printer5(val modelName: String) {

}
// Kotlin: 'modelName' hides member of supertype 'Printer5' and needs 'override' modifier
class LaserPrinter5(/*val*/ modelName: String) : Printer5(modelName) {

}


//Step 6:
abstract class Printer6(val modelName: String) {
    fun printModel() = println("The model name of this 'printer' is $modelName")
}
// Kotlin: 'modelName' hides member of supertype 'Printer5' and needs 'override' modifier
class LaserPrinter6(modelName: String) : Printer6(modelName) {

}

//step 7
abstract class Printer7(val modelName: String) {

    //2. Kotlin: 'printModel' in 'Printer7' is final and cannot be overridden
    /**/ open fun printModel() = println("The model name of this printer is $modelName")

}

open class LaserPrinter7(modelName: String): Printer7(modelName) {

    //key word overrid is mandatory here
    //1. Kotlin: 'printModel' hides member of supertype 'Printer7' and needs 'override' modifier
    final /**/ override fun printModel() = println("The model name of this laser printer is $modelName")

}

// Step final:
abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this 'printer' is $modelName")
    abstract fun bestSellingPrice(): Double

}

open class LaserPrinter(modelName: String): Printer(modelName) {

    final override fun printModel() = println("The model name of this 'laser printer' is $modelName")
    override fun bestSellingPrice(): Double = 129.99

}
