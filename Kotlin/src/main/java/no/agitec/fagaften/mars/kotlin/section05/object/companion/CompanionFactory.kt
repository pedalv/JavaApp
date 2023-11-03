package no.agitec.fagaften.mars.kotlin.section05.`object`.companion

fun main(args: Array<String>) {

    println(SomeClass.accessPrivateVar())
    // I'm accessing privateVar: 6
    println(" --1-- ")

    println(SomeClass.Companion.accessPrivateVar())
    // I'm accessing privateVar: 6
    println(" --2-- ")

    val someClass1 = SomeClass.justAssign("this is the string as is")
    val someClass2 = SomeClass.upperOrLowerCase("this isn't the string as is", false)
    println(someClass1.someString)
    // this is the string as is
    println(" --3-- ")

    println(someClass2.someString)
    // THIS ISN'T THE STRING AS IS
    println(" --4-- ")


    val someClass3 = SomeClass2.justAssign("this is the string as is")
    val someClass4 = SomeClass2.upperOrLowerCase("this isn't the string as is", false)
    println(someClass3.someString)
    // this is the string as is
    println(" --5-- ")
    println(someClass4.someString)
    // this is the string as is
    println(" --6-- ")

    //val someClass5 = SomeClass()
    // Error:(33, 22) Kotlin: Cannot access '<init>': it is private in 'SomeClass'
    // Error:(33, 32) Kotlin: No value passed for parameter 'someString'

}

object TheFactoryPattern {

}

/**
 * Implement factory pattern, https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */
class SomeClass private constructor(val someString: String) {


    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        fun justAssign(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClass {
            if (lowerCase) {
                return SomeClass(str.toLowerCase())
            }
            else {
                return SomeClass(str.toUpperCase())
            }
        }
    }
}

/**
 * Implement factory pattern, https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */
class SomeClass2 private constructor(val someString: String)  {

    /*
    val someString: String

    constructor(str: String) {
        someString = str
    }

    constructor(str : String, lowerCase: Boolean) {

        if(lowerCase) {
            someString = str.toLowerCase()
        } else {
            someString = str.toUpperCase()
        }

    }
    */

    companion object {

        // This functions do the same thing as the constructor so them can be removed
        fun justAssign(str: String) = SomeClass2(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClass2 {
            if (lowerCase) {
                return SomeClass2(str.toLowerCase())
            }
            else {
                return SomeClass2(str.toUpperCase())
            }
        }
    }
}

