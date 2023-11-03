package no.agitec.fagaften.mars.kotlin.section02.convert.textadventuregamekotlin.exercise.kotlinbyhand

/**
 *  With class declaration, file has not format kt
 */
data class Location(val locationID: Int, val description: String) {

    /*
    @kotlin.SinceKotlin @kotlin.internal.InlineOnly public inline fun <K, V> mutableMapOf()
        : kotlin.collections.MutableMap<K, V> { /* compiled code */ }
     */
    val exits = mutableMapOf<String, Int>()

    init {
        exits["Q"] = 0
    }

    fun addExit(direction: String, destinationID: Int) {
        exits[direction] = destinationID
    }

}