package no.agitec.fagaften.mars.kotlin.section02.test

import java.util.*

class Location(val locationID: Int, val description: String) {
    private val exits: MutableMap<String, Int>

    init {
        this.exits = HashMap()
        this.exits["Q"] = 0
    }

    fun getExits(): Map<String, Int> {
        return HashMap(exits)
    }

    protected fun addExit(direction: String, location: Int) {
        exits[direction] = location
    }
}