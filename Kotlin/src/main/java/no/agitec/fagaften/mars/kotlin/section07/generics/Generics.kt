package no.agitec.fagaften.mars.kotlin.section07.generics

import java.math.BigDecimal


fun main(args: Array<String>) {

    //val list2: MutableList = mutableListOf("Hello")
    /*
    Kotlin: One type argument expected for interface MutableList<E>
     */

    val list = mutableListOf("Hello")
    list.add("another string")
    printCollectionS(list)
    printCollectionG(list)
    list.printCollection()
    //Hello
    //another string
    println(" --1-- ")



    val bdList = mutableListOf(
            BigDecimal(-33.45),
            BigDecimal(3503.99),
            BigDecimal(0.329))
    printCollectionG(bdList)
    bdList.printCollection()
    //-33.4500000000000028421709430404007434844970703125
    //3503.989999999999781721271574497222900390625
    //0.329000000000000014654943925052066333591938018798828125
    println(" --2-- ")

}

//Extended function
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}

//Top leval function
fun <T> printCollectionG(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

fun printCollectionS(collection: List<String>) {
    for (item in collection) {
        println(item)
    }
}