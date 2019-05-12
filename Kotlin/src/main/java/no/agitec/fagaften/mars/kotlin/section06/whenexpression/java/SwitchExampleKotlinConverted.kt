package no.agitec.fagaften.mars.kotlin.section06.whenexpression.java

object SwitchExampleBla {

    @JvmStatic
    fun main(args: Array<String>) {

        val num = 200

        when (num) {
            100 -> println("100")
            200 -> println("200")
            300 -> println("300")
            else -> println("Didn't match anything")
        }
        //200
        println(" --1-- ")


        when (num) {
            100 -> println("100")
            200 -> {
                println("200")
                println("300")
            }
            //break;
            300 -> println("300")
            else -> println("Didn't match anything")
        }
        //200
        //300
        println(" --2-- ")

        val num2 = 600

        when (num2) {
            100, 600 -> println("100 and 600 dude")
            200 -> {
                println("200")
                println("300")
            }
            //break;
            300 -> println("300")
            else -> println("Didn't match anything")
        }
        //100 and 600 dude
        println(" --3-- ")


        val num3 = 101

        when (num3) {
            in 100..102 -> println("in 100..102")
            200 -> {
                println("200")
                println("300")
            }
            //break;
            300 -> println("300")
            else -> println("Didn't match anything")
        }
        //in 100..102
        println(" --4-- ")

        when(num) {
            in 100..199 -> println("in range 100..199")
            200 -> println("200")
            300 -> println("300")
            else -> println("Doesn't match anything")
        }
        //200
        println(" --4.1-- ")

        val y = 10
        val num4 = 101

        when (num4) {
            91 - y -> println("in 100..102")
            91 + y -> println("101")
            300 + y -> println("300")
            else -> println("Didn't match anything")
        }
        //101
        println(" --5-- ")

        when(num) {
            y + 80 -> println("90")
            y + 90 -> println("100")
            300 -> println("300")
            else -> println("Doesn't match anything")
        }
        //Doesn't match anything
        println(" --5.1-- ")

    }
}
