package no.agitec.fagaften.mars.kotlin.section05.singletons

import java.time.Year

fun main(args: Array<String>) {

    println(CompanyCommunications.getTagLine())
    // Our company rocks!
    println(CompanyCommunications.getCopyrightLine())
    // Copyright © 2019 Our Company. All rights reserved.
}

object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."

    //println(SomeClass.accessPrivateVar())
    // Kotlin: Expecting member declaration

    val someClass1 = SomeClass.justAssign("this is the string as is")
    val someClass2 = SomeClass.upperOrLowerCase("this isn't the string as is", false)
    //println(someClass1.someString)
    // Kotlin: Expecting member declaration
    //println(someClass2.someString)
    // Kotlin: Expecting member declaration

}

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