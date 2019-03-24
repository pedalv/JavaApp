package no.agitec.fagaften.mars.kotlin.section02.convert.textadventuregamekotlin.exercise.kotlinbyhand

/**
 No class declaration, file has format kt
*/

/**
 * Kotlin has null point exception also
 * However it is possible prevent it
 * Use
 * ?! - when a variable is null return a default value
 * or
 * !! - when a block or a line wont be null
 */

/**
 * TODO: Try to fix exception below when you run the main method
 *
 * Exception in thread "main" java.io.FileNotFoundException: locations_big.txt (Systemet finner ikke angitt fil)
 *   at java.base/java.io.FileInputStream.open0(Native Method)
 *   at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
 *   at no.agitec.fagaften.mars.kotlin.section2.convert.textadventuregamekotlin.exercise.kotlinbyhand.LocationsKt.readLocationInfo(Locations.kt:28)
 *   at no.agitec.fagaften.mars.kotlin.section2.convert.textadventuregamekotlin.exercise.kotlinbyhand.MainKt.main(Main.kt:7)
 */
fun main(args: Array<String>) {

    val locations = readLocationInfo()
    var loc = 64

    while (true) {

        val location = locations[loc] ?: Location(0,
                "Sorry, something went wrong, so the game will terminate")

        println(location.description)

        if (location.locationID == 0) {
            break
        }

        print("Available exits are: ")
        location.exits.keys.forEach {
            print("$it, ")
        }

        val direction = readLine()?.toUpperCase() ?: "Z"
        if (location.exits.containsKey(direction)) {
            loc = location.exits[direction]!!
        }
        else {
            println("You can't go in that direction")
        }

    }

}