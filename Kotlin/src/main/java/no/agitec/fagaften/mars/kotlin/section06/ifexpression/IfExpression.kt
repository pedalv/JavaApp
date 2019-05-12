package no.agitec.fagaften.mars.kotlin.section06.ifexpression

fun main(args: Array<String>) {

    var num: Int

    var someCondition = false

    //java
    if (someCondition) {
        num = 50
    }
    else {
        num = 592
    }
    //java
    //num = someCondition ? 50 : 592 //det finnes ikke ternary expression i Kotlin

    //kotlin
    num = if(someCondition) 50 else 592

    someCondition = 20 < 22
    println(" --1.1-- ")

    println(if (someCondition) {
        println("somethinggggg")
        50
    }
    else {
        println("something else")
        592
    })
    //somethinggggg
    //50
    println(" --1.2-- ")

    println("The result of the if expression issssss ${if (someCondition) {
        println(" --1.2.1.1-- ")
        println("somethinggggg")
        50
        println(" --1.2.1.2-- ")
    }
    else {
        println(" --1.2.2.1-- ")
        println("something else")
        592
        println(" --1.2.2.2-- ")
    }}")
    // --1.2.1.1--
    //somethinggggg
    // --1.2.1.2--
    //The result of the if expression issssss kotlin.Unit
    println(" --1.3-- ")

    val x = if (someCondition) {
        println("something")
    }
    else {
        println("something else")
    }
    println(" --2-- ")

    println(x) //kotlin.Unit
    println(x.javaClass) //class kotlin.Unit
    println(" --3-- ")

    val num2 = if (someCondition) {
        println("something")
        50
    }
    else {
        println("something else")
        100
    }
    println(num2) //50
    println(num2.javaClass) //int
    println(" --4-- ")

    //Error:(67, 20) Kotlin: 'if' must have both main and 'else' branches if used as an expression
    /*
    val numError = if (someCondition) {
        println("something")
        50
    }
    */

    if (someCondition) {
        println("something")
    }
    println(" --5-- ")
}