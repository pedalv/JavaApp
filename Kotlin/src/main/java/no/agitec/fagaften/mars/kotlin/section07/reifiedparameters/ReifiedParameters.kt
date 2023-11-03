package no.agitec.fagaften.mars.kotlin.section07.reifiedparameters

import java.math.BigDecimal

fun main(args: Array<String>) {

    val mixedList: List<Any> = listOf(
            "string",
            1,
            BigDecimal(22.5),
            "fall",
            BigDecimal(-5938.393849))
    //val bigDecimalsOnly = getElementsOfType<String>(mixedList)
    //string
    //fall
    val bigDecimalsOnly = getElementsOfType<BigDecimal>(mixedList)
    //22.5
    //-5938.393849000000045634806156158447265625
    for (item in bigDecimalsOnly) {
        println(item)
    }
}

/**/inline fun </**/reified T> getElementsOfType(list: List<Any>): List<T> {

    var newList: MutableList<T> = mutableListOf()
    for (element in list) {
        if (element is T) {
            newList.add(element)
        }
    }

    //val c = T()
    /*
    Error: Kotlin: Type parameter T cannot be called as function
     */

    return newList
}
/*
Error: Kotlin: Cannot check for instance of erased type: T

Solution:
1. inline
2. reified
 */

/*
Note:
- reified is only use to verifiy a type of T in a function and it is only works for inline functions
- class samethings<reified T>, ERROR: Kotlin: Only type parameters of inline functions can be reified
- val c = T(), ERROR: Kotlin: Type parameter T cannot be called as function
 */

//class samethings<reified T>
/*
Error: Kotlin: Only type parameters of inline functions can be reified
 */





