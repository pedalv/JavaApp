//1 k
//@file:JvmName("KotlinStuff")

package no.agitec.fagaften.mars.kotlin.section09.callkotlinfromjava.kotlincode

fun sayHelloToJava(name: String) {
    println("Kotlin says hello to Java and $name")
}

//3
object Challenge {
    fun doMath(x: Int, y: Int) = (x + y) * (x - y)
    //k //@JvmStatic fun doMath(x: Int, y: Int) = (x + y) * (x - y)
}

//2
//k //class Employee(val firstName: String, val lastName: String, @JvmField var startYear: Int) {
//J
class Employee(val firstName: String, val lastName: String, var startYear: Int) {



    //k
    @JvmOverloads fun takesDefault(parm1: String, parm2: String = "default") {
    //only i kotlin file //fun takesDefault(parm1: String, parm2: String = "default") {
        println("$parm1 and $parm2")
    }

}