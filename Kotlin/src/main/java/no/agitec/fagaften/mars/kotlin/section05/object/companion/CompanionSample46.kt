package no.agitec.fagaften.mars.kotlin.section05.`object`.companion

/*
 SOLUTION DO NOT WORK AS SAMPLE 46 in 3:45
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

 IT WORKS FROM MAIN METHOD ONLY
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */

fun main(args: Array<String>) {

    //println(SomeClassKotlinFix.Companion.accessPrivateVar())
    //I'm accessing privateVar: 6
    //kotlin.Unit
    println(" --0-- ")

    println(SomeClassKotlinFix.SomeCompanion.accessPrivateVar())
    //I'm accessing privateVar: 6
    //kotlin.Unit
    println(" --1-- ")

    //Kotlin now that it is call from a companion
    println(SomeClassKotlinFix.accessPrivateVar())
    //I'm accessing privateVar: 6
    //kotlin.Unit
    println(" --2-- ")
}

object OutSideCompanionClassFix {

    /*
    It is possible now access privateVar outside the object,
    because we can call your method without a instance of your class
    - Object => public static final
     */
    //println(SomeClassKotlinFix.Companion.accessPrivateVar())
    //or
    //println(SomeClassKotlinFix.SomeCompanion.accessPrivateVar())
    //or
    //println(SomeClassKotlinFix.accessPrivateVar()) //Kotlin now that it is call from a companion
    //println(SomeClassKotlinFix)
    //Kotlin: Expecting member declaration
}

//object // Error:(36, 5) Kotlin: Modifier 'companion' is not applicable inside 'object'
class //OKAY
SomeClassKotlinFix {

    /*
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")
    }
   */
    companion object SomeCompanion {
        private var privateVar = 6

        fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")
    }
}
