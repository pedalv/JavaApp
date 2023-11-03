package no.agitec.fagaften.mars.kotlin.section02.convert.textadventuregamekotlin.exercise.kotlinbyhand

import java.io.File

/**
 * No class declaration, file has format kt
 */


fun readLocationInfo() : Map<Int, Location> {

    /*
    @kotlin.SinceKotlin @kotlin.internal.InlineOnly public inline fun <K, V> mutableMapOf()
        : kotlin.collections.MutableMap<K, V> { /* compiled code */ }
     */
    val locations = mutableMapOf<Int, Location>()

    /*
    public File(String pathname) { ... }

    @kotlin.internal.InlineOnly public inline fun java.io.File.reader(
        charset: java.nio.charset.Charset /* = compiled code */)
            : java.io.InputStreamReader { /* compiled code */ }

    public fun java.io.Reader.forEachLine(
        action: (kotlin.String) -> kotlin.Unit)
            : kotlin.Unit { /* compiled code */ }

    data class Location(val locationID: Int, val description: String) { ... }
     */
    File(getFilePath() + "locations_big.txt").reader().forEachLine {
        val tokens = it.split("`")

        val location = Location(tokens[0].toInt(), tokens[1])
        locations[location.locationID] = location
    }

    File(getFilePath() + "directions_big.txt").reader().forEachLine {
        val tokens = it.split(",")

        locations[tokens[0].toInt()]?.addExit(tokens[1], tokens[2].toInt())
    }

    return locations

}

private fun getFilePath(): String {
    val filePath = File("").absolutePath
    var path = "" // TODO : Solution inside Locations.kt
    return path
}