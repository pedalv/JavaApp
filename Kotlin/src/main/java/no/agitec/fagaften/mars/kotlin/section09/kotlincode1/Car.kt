@file:JvmName("StaticCar")

package no.agitec.fagaften.mars.kotlin.section09.kotlincode1

fun topLevel() = println("I'm in the Car file!")

fun main(args: Array<String>) {
    "Print this".print()
    //Print this
}

class Car(val color: String, @JvmField val model: String, val year: Int) {

//    var color: String = color
//        private set(value) {
//            field = "always green"
//        }

}

fun String.print() {
    println(this)
}