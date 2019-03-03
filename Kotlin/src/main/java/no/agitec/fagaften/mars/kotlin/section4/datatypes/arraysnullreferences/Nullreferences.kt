package no.agitec.fagaften.mars.kotlin.section4.datatypes.arraysnullreferences

fun main(args: Array<String>) {

    val nullableInts = arrayOfNulls<Int>(5)
    for (i in nullableInts) {
        print(" " + i)
    }
    println(" -1- ")
    //null null null null null
    println(nullableInts[3].toString()) //null
    println(" -2- ")
    nullableInts[3].toString()
    println(nullableInts[3].toString()) //null
    println(" -3- ")
    val emptystr : String = nullableInts[3].toString()
    println(emptystr) //null
    println(" -4- ")

    /*
    Note: verbose is need for check many variables are not null to do some thing as in Java
    if( str1 != null && str2 != null ... && strn != null) {
        //Do some thing
    }
    Note: ?. save operator or ?: Elvis oparator does not help here
     */

}