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

    when {
        num < num2 -> println("num is less than num2")
        num > num2 -> println("num is greater than num2")
        else -> println("num = num2")
    }
    //num is greater than num2
    println(" --3-- ")

    when(num) {
        in 100..199 -> println("in range 100..199")
        200 -> println("200")
        300 -> println("300")
        else -> println("Doesn't match anything")
    }
    //in range 100..199
    println(" --4-- ")

    val y = 10
    when(num) {
        y + 80 -> println("90")
        y + 90 -> println("100")
        300 -> println("300")
        else -> println("Doesn't match anything")
    }
    //Doesn't match anything
    println(" --5-- ")

    val obj: Any = "I'm a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

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
}