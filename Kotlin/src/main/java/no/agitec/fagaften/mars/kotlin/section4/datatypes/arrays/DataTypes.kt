package no.agitec.fagaften.mars.kotlin.section4.datatypes.arrays

import no.agitec.fagaften.mars.kotlin.section4.javacode.DummyClass
import java.math.BigDecimal

fun main(args: Array<String>) {

    val names = arrayOf("John", "Jane", "Jill", "Joe")

    val longs1 = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(1, 2, 3, 4)

    val longs3 = arrayOf(1, 2, 3, 4)

    println(longs1 is Array<Long>) //true
    println(longs2 is Array<Long>) //true
    println(longs3 is Array<Int>) //true
    println(" -1- ")
    println(longs1[2]) //3
    println(" -2- ")
    val evenNumbers = Array(16) { i -> i * 2 }

    for (number in evenNumbers) {
        print(" " + number)
    }
    //0  2  4  6  8  10  12  14  16  18  20  22  24  26  28  30
    println(" -3- ")

    val lotsOfNumbers = Array(100000) { i -> i + 1 }

    val allZeroes = Array(100) { 0 } // i -> 0

    var someArray: Array<Int>
    someArray = arrayOf(1, 2, 3, 4)
    for (number in someArray) {
        print(" " + number)
    }
    // 1 2 3 4
    println(" -4- ")

    someArray = Array(6) { i -> (i + 1) * 10 }
    for (number in someArray) {
        print(" " + number)
    }
    //10 20 30 40 50 60
    println(" -5- ")

    val mixedArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
    for (element in mixedArray) {
        print(" " + element)
    }
    //hello 22 10.5 a
    println(" -6- ")
    println(mixedArray is Array<Any>) //true

    val myIntArray = intArrayOf(3, 9, 434, 2, 33)
    DummyClass().printNumbers(myIntArray)
    //3 9 434 2 33
    println(" -7- ")

    //var someOtherArrayFeil = Array<Int>(5) //Error:(61, 42) Kotlin: No value passed for parameter 'init'
    var array1: Array<Int>
    var someOtherArray = IntArray(5)
    for (number in someOtherArray) {
        print(" " + number)
    }
    //0 0 0 0 0
    println(" -8- ")

    DummyClass().printNumbers(evenNumbers.toIntArray()) //Array<Int> to Int
    //0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30
    println(" -9- ")
    val convertedIntArray = myIntArray.toTypedArray() //Int to Array<Int>
    DummyClass().printNumbers(convertedIntArray.toIntArray())
    //3 9 434 2 33
    println(" -10- ")

}