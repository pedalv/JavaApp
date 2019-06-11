@file:JvmName("StaticCar")

package no.agitec.fagaften.mars.kotlin.section09.kotlincode2

import java.io.IOException

fun topLevel() = println("I'm in the Car file!")

fun main(args: Array<String>) {
    //print()
    Car.carComp()
}

@JvmOverloads fun defaultArgs(str: String, num: Int = 25) {

}

fun defaultArgs2(str: String, num: Int = 25) {

}

@Throws(IOException::class)
fun doIO() {
    throw IOException()
}

fun doIO2() {
    throw IOException()
}

object SingletonObj {
    @JvmStatic fun doSomething() = println("I'm doing something in the singleton object")
    fun doSomething2() = println("I'm doing something in the singleton object")
}


class Car(val color: String, @JvmField val model: String, val year: Int) {

//    var color: String = color
//        private set(value) {
//            field = "always green"
//        }

    companion object {
        const val constant = 25
        @JvmField val isAuto = false
        @JvmStatic fun carComp() = println("I'm in Car's companion object")
    }

    fun printMe(text: String) {
        println("I don't expect a null value: $text")
    }




}

fun String.print() {
    println(this)
}