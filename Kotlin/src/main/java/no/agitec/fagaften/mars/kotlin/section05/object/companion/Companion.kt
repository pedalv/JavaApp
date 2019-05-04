package academy.learnprogramming.inheritance

import no.agitec.fagaften.mars.kotlin.section05.`object`.companion.SomeClassKotlinFix
import no.agitec.fagaften.mars.kotlin.section05.`object`.companion.javacode.SomeOtherClass


fun main(args: Array<String>) {

    println(SomeClassKotlinFix.accessPrivateVar())
    //I'm accessing privateVar: 6
    //kotlin.Unit
    println(" --0-- ")

    println(SomeClassJavaToKotlin.accessPrivateVar())
    //I'm accessing privateVar: 6
    //kotlin.Unit
    println(" --1.1-- ")

    println(SomeClassJavaToKotlin.accessPrivateVarKotlin())
    //I'm accessing privateVar: 6
    println(" --1.1.2-- ")

    println(SomeClassSample.accessPrivateVar())
    //I'm accessing privateVar: 6
    println(" --1.2-- ")

    val someClass1 = SomeClassSample.justAssign("this is the string as is")
    val someClass2 = SomeClassSample.upperOrLowerCase("this isn't the string as is", false)
    println(someClass1.someString)
    //this is the string as is
    println(" --2-- ")
    println(someClass2.someString)
    //THIS ISN'T THE STRING AS IS
    println(" --3-- ")
}

object OutSideCompanionClass {

    /*
    It is not possible access privateVar outside the class.
    - In Java will be need implement get and set
    - In Kotlin we do not have get and set because variable is private
    - For create same behaviour as in  in Kotlin it is need change class to object to have only one instance
    - Class => public final
    - Object => public static final
     */
    //println(SomeClassJavaToKotlin.accessPrivateVarKotlin())
    // Kotlin: Expecting member declaration
    // Object SomeClassJavaToKotlin { ... }
    // TODO : From main method it WORKS - SHOW example 1.1 and 1.1.1

    //println(SomeClassKotlin.accessPrivateVar())
    // Kotlin: Unresolved reference: accessPrivateVar
    // Class SomeClassKotlin { ... }

    //SE solution in CompanionSample46.kt
}

object SomeClassJavaToKotlin {

    private val privateVar = 6

    @JvmStatic
    fun main(args: Array<String>) {
        SomeOtherClass().someOtherMethod()
    }

    fun accessPrivateVar() {
        println("I'm accessing privateVar: $privateVar")
    }

    fun accessPrivateVarKotlin() = println("I'm accessing privateVar: $privateVar")
}

class SomeClassKotlin {

    private val privateVar = 6

    fun main(args: Array<String>) = SomeOtherClass().someOtherMethod()

    fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")
}

object SomeClassKotlinObject {

    private val privateVar = 6

    fun main(args: Array<String>) = SomeOtherClass().someOtherMethod()

    fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")
}


class SomeClassSample private constructor(val someString: String) {
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        fun justAssign(str: String) = SomeClassSample(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClassSample {
            if (lowerCase) {
                return SomeClassSample(str.toLowerCase())
            }
            else {
                return SomeClassSample(str.toUpperCase())
            }
        }
    }
}


