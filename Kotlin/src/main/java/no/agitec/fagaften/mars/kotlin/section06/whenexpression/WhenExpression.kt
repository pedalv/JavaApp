package no.agitec.fagaften.mars.kotlin.section06.whenexpression

import java.math.BigDecimal

enum class Season {
    SPRING, SUMMER, FALL, WINTER
}

fun main(args: Array<String>) {

    var num = 100

    val timeOfYear = Season.SPRING
    val str = when (timeOfYear) {
        Season.SPRING -> {

            num += 5
            "Flowers are blooming"

        }
        Season.SUMMER -> "It's hot!"
        Season.FALL -> "It's getting cooler"
        Season.WINTER -> {
            num = 22 - 55
            "I need a coat"
        }
    }
    println(str)
    //Flowers are blooming
    println(" --1-- ")

    //Error:(34, 20) Kotlin: 'when' expression must be exhaustive, add necessary 'WINTER' branch or 'else' branch instead
    /*
    val strError = when (timeOfYear) {
        Season.SPRING -> "Flowers are blooming"
        Season.SUMMER -> "It's hot!"
        Season.FALL -> "It's getting cooler"
        //Season.WINTER -> "I need a coat"
    }
    println(strError)
    //Flowers are blooming
    */
    println(" --1.1-SHOW ERROR EXAMPLE- ")

    //IT IS VERY VERBOSE IN KOTLIN SO USE WHEN (2)
    val num2 = -50
    if (num < num2) {
        println("num is less than num2")
    }
    else if (num > num2) {
        println("num is greater than num2")
    }
    else {
        println("num = num2")
    }
    //num is greater than num2
    println(" --2-- ")

    //(2) IS BEST SOLUTION FOR KOTLIN BECAUSE IS LESS VERBOSE
    when {
        num < num2 -> println("num is less than num2")
        num > num2 -> println("num is greater than num2")
        else -> println("num = num2")
    }
    //num is greater than num2
    println(" --3-- ")

    val obj: Any = "I'm a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

    //IT IS VERBOSE FOR KOTLIN SO USE WHEN FOR REDUCE VERBOSE - SE BELOW SOLUTION (1)
    val something: Any = obj2
    if (something is String) {
        println(something.toUpperCase())
    }
    else if (something is BigDecimal) {
        println(something.remainder(BigDecimal(10.5)))
    }
    else if (something is Int) {
        println("${something - 22}")
    }
    //4.199999999999999289457264239899814128875732421875
    println(" --6-- ")

    //(1) SOLUTION LESS VERBOSE
    val z = when (something) {
        is String -> {
            println(something.toUpperCase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            2
        }
        is Int -> {
            println("${something - 22}")
            3
        }
        else -> {
            println("I have no idea what type this is")
            -1
        }
    }
    //4.199999999999999289457264239899814128875732421875
    //2
    println(z)
    println(" --7-- ")

    //Error:(116, 18) Kotlin: 'when' expression must be exhaustive, add necessary 'else' branch
    /*
    val zError = when (something) {
        is String -> {
            println(something.toUpperCase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            2
        }
        is Int -> {
            println("${something - 22}")
            3
        }
    }
    */
    println(" --8-SHOW ERROR EXAMPLE- ")

}