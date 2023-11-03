package no.agitec.fagaften.mars.kotlin.section05.oochallenge

fun main(args: Array<String>) {

    val bicycle = KotlinBicycle(10, 3, 10)
    bicycle.printDescription()
    // Bike is in gear 10 with a cadence of 10 travelling at a speed of 3.
    println(" --1.1-- ")
    val mountainBike = KotlinMountainBike(20, 10, 10, 30)
    mountainBike.printDescription()
    // Bike is in gear 30 with a cadence of 10 travelling at a speed of 10.
    // The mountain bike has a seat height of 20 inches.
    println(" --1.2-- ")
    val roadBike = KotlinRoadBike(10, 10, 10, 3)
    roadBike.printDescription()
    // Bike is in gear 3 with a cadence of 10 travelling at a speed of 10.
    // The road bike has a tire width of 10 MM.
    println(" --1.3-- ")

    val bicycle2 = KotlinBicycle(10, 3)
    bicycle2.printDescription()
    // Bike is in gear 10 with a cadence of 10 travelling at a speed of 3.
    println(" --2.1-- ")
    val mountainBike2 = KotlinMountainBike(20, 10, 10)
    mountainBike2.printDescription()
    // Bike is in gear 10 with a cadence of 10 travelling at a speed of 10.
    // The mountain bike has a seat height of 20 inches.
    println(" --2.2-- ")
    val roadBike2 = KotlinRoadBike(10, 10, 10)
    roadBike2.printDescription()
    // Bike is in gear 10 with a cadence of 10 travelling at a speed of 10.
    // The road bike has a tire width of 10 MM.
    println(" --2.3-- ")

    val mountainBike3 = KotlinMountainBike("Blue", 10, 10, 10)
    mountainBike3.printDescription()
    // This is the Blue
    // Bike is in gear 20 with a cadence of 10 travelling at a speed of 10.
    // The mountain bike has a seat height of 10 inches.
    println(" --3.1-- ")
    val mountainBike3Unorder = KotlinMountainBike(
            cadence = 10,
            speed = 10,
            color ="Blue",
            gear = 20,
            seatHeight = 10)
    mountainBike3Unorder.printDescription()
    // This is the Blue
    // Bike is in gear 20 with a cadence of 10 travelling at a speed of 10.
    // The mountain bike has a seat height of 10 inches.
    println(" --3.2-- ")

    KotlinMountainBike.availableColors.forEach { println(it) }
    //blue
    //red
    //white
    //black
    //green
    //brown
    println(" --4-- ")
}

open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    fun speedUpShort(increment: Int) = { speed += increment }
    fun speedUpShort2(increment: Int) = run { speed += increment }
    //fun speedUpShort3(increment: Int) = (speed += increment)
    //Error:(41, 42) Kotlin: Assignments are not expressions, and only expressions are allowed in this context

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence " +
                "travelling at a speed of $speed.")
    }

    open fun printDescriptionShort() = println("Bike is in gear $gear with a cadence of $cadence " +
            "travelling at a speed of $speed.")


}

/**
 * ERROR : val mountainBike2 = KotlinMountainBike(20, 10, 10)
 *
 * Kotlin: None of the following functions can be called with the arguments supplied:
public constructor KotlinMountainBike(seatHeight: Int, cadence: Int, speed: Int, gear: Int) defined in no.agitec.fagaften.mars.kotlin.section05.oochallenge.KotlinMountainBike
public constructor KotlinMountainBike(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = ...) defined in no.agitec.fagaften.mars.kotlin.section05.oochallenge.KotlinMountainBike
 */
//class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int):
/**
 * OKAY : val mountainBike2 = KotlinMountainBike(20, 10, 10)
 */
class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10):
        KotlinBicycle(cadence, speed, gear) {


    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 20):
            this(seatHeight, cadence, speed, gear) {
        println("This is the $color")
    }

    // companion object. List<String> called availableColors
    // initialize the list to "blue", "red", "white", "black", "green", and "brown"
    companion object {
        val availableColors = listOf("blue", "red", "white", "black", "green", "brown")
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
    }


}

class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 10):
        KotlinBicycle(cadence, speed, gear) {

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth MM.")
    }

}


