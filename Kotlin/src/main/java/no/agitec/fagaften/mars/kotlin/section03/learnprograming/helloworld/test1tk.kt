package no.agitec.fagaften.mars.kotlin.section03.learnprograming.helloworld

object Test1tk {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello World from class") // Hello World from class
    }
}

//TODO
// https://stackoverflow.com/questions/48780003/why-and-when-to-use-jvmstatic-with-companion-objects
//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html

fun main(args: Array<String>) {
    println("Hello World from method") // Hello World from method
}