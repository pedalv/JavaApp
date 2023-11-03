package no.agitec.fagaften.mars.kotlin.section05.inheritance

fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("Brother 1234")
    laserPrinter.printModel()
    // The model name of this 'laser printer' is Brother 1234
    println("-- 1 --")
    //Step 6:
    val laserPrinter6 = LaserPrinter6("Brother 1234")
    laserPrinter6.printModel()
    //The model name of this 'printer' is Brother 1234
    println("-- 2 --")
    //Part 2
    val laserPrinter2 = LaserPrinter2("Brother 1234", 15)
    laserPrinter2.printModel()
    // The model name of this 'laser printer 2' is Brother 1234
    println("-- 3 --")
    SomethingElse("whatever")
    // I'm in the parent's constructor
    // I'm in the child's constructor
    println("-- 4 --")
    var specialLaserPrinter = SpecialLaserPrinter("Brother 1234",20)
    specialLaserPrinter.printSpecialParameters()
    // modelName: Brother 1234, ppm:$'ppm', ppm2:20,ppm3:30,ppm4:40
    println("-- 5.1 --")
    specialLaserPrinter = SpecialLaserPrinter("Brother 1234",20, 911)
    specialLaserPrinter.printSpecialParameters()
    // modelName: Brother 1234, ppm:$'ppm', ppm2:100,ppm3:30,ppm4:40
    println("-- 5.2 --")

}

// Step 1: Errors
/*
Kotlin: This type is final, so it cannot be inherited from => Solution: Added open keyword
Kotlin: This type has a constructor, and thus must be initialized here => ... : Printer1() {...}
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
open class Printer2 {

}
class LaserPrinter2 : Printer2 {
}
*/

// Step 3: Solution 2.1 - Works
//open class for inheritance
open class Printer321() {

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
abstract class Printer4 {

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

// Part 2
open class LaserPrinter2(modelName: String, ppm: Int): Printer(modelName) {

    final/*(1)*/ override fun printModel() = println("The model name of this 'laser printer 2' is $modelName")
    override fun bestSellingPrice(): Double = 129.99

}

class SpecialLaserPrinter(modelName: String, ppm: Int): LaserPrinter2(modelName, ppm) {

    var ppm2: Int = 20
    val ppm3: Int = 30
    val ppm4: Int = 40

    constructor(modelName : String, ppm: Int, ppm2 : Int) : this(modelName, ppm) {
        this.ppm2 = ppm2
    }

    fun printSpecialParameters() = println("modelName: $modelName, ppm:$'ppm', ppm2:$ppm2,ppm3:$ppm3,ppm4:$ppm4")

    //(1): 'printModel' in 'LaserPrinter2' is final and cannot be overridden
    //override fun printModel() = println("The model name of this 'laser printer 2' is $modelName")
}

//
open class Something {

    val someProperty: String

    constructor(someParameter: String) {
        someProperty = someParameter
        println("I'm in the parent's constructor")
    }
}

class SomethingElse: Something {

    constructor(someOtherParameter: String): super(someOtherParameter) {
        println("I'm in the child's constructor")
    }

}


//

open class Something2(val x : Int) {

    var someProperty: String = ""

    // Error:(185, 5) Kotlin: Primary constructor call expected
    constructor(someParameter: String, y : Int) : this(y) {
        this.someProperty = someParameter
        println("I'm in the parent's constructor")
    }
}

class SomethingElse2: Something2 {

    // Error:(194, 52) Kotlin: Type mismatch: inferred type is String but Int was expected
    constructor(someOtherParameter: String, z : Int): super(z) {
        println("I'm in the child's constructor")
    }

}

/*
Error:(154, 1) Kotlin: Modifier 'open' is incompatible with 'data'
Error:(154, 6) Kotlin: Modifier 'data' is incompatible with 'open'
 */
/*
open data class DataClass(val number: Int) {

}
 */