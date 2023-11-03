package no.agitec.fagaften.mars.kotlin.section02.convert.textadventuregamekotlin.kotlin

import java.io.File


fun readLocationInfo() : Map<Int, Location> {

    val locations = mutableMapOf<Int, Location>()

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
    var path = "$filePath\\src\\main\\java\\no\\agitec\\fagaften\\mars\\kotlin\\section2\\convert\\textadventuregamekotlin\\files-kotlin\\"
    //System.out.println("** " + path + " **");
    return path
}