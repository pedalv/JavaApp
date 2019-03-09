package no.agitec.fagaften.mars.kotlin.section5.functions

fun upperFirstAndLast(str: String): String {
    val upperFirst = str.substring(0, 1).toUpperCase() + str.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

class Utils {

    fun upperFirstAndLast(str: String): String {
        val upperFirst = str.substring(0, 1).toUpperCase() + str.substring(1)
        return upperFirst.substring(0, upperFirst.length - 1) +
                upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
    }

}