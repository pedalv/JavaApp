package no.agitec.fagaften.mars.kotlin.section07.sets


fun main(args: Array<String>) {

    val setInts = setOf(10, 15, 19, 5, 3, -22) //immutable
    println(setInts.plus(20)) //[10, 15, 19, 5, 3, -22, 20]
    println(setInts.plus(10)) //[10, 15, 19, 5, 3, -22]
    println(setInts.minus(19)) //[10, 15, 5, 3, -22]
    println(setInts.minus(100)) //[10, 15, 19, 5, 3, -22]
    println(setInts.average()) //5.0
    println(setInts.drop(3)) //[5, 3, -22] // drop the 3 first elements from the set
    println(" --1-- ")

    val mutableInts = mutableSetOf(1, 2, 3, 4, 5)
    mutableInts.plus(10)
    println(mutableInts)
    //[1, 2, 3, 4, 5]
    println(" --2-- ")
}

data class Car(val color: String, val model: String, val year: Int) {

}



