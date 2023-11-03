package no.agitec.fagaften.mars.kotlin.section07.collections


fun main(args: Array<String>) {

    val strings = listOf("spring", "summer", "fall", "winter")
    println(strings.javaClass)
    println(strings.asReversed())
    println(strings)
    //class java.util.Arrays$ArrayList
    //[winter, fall, summer, spring]
    //[spring, summer, fall, winter]
    println(" --1-- ")

    val emptyList = emptyList<String>()
    println(emptyList.javaClass)

    if (!emptyList.isEmpty()) {
        println(emptyList[0])
        /*
        class kotlin.collections.EmptyList
Exception in thread "main" java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 0.
	at kotlin.collections.EmptyList.get(Collections.kt:34)
	at kotlin.collections.EmptyList.get(Collections.kt:22)
	at no.agitec.fagaften.mars.kotlin.section07.collections.CollectionsKt.main(Collections.kt:18)

         */
    }
    //class kotlin.collections.EmptyList
    println(" --2-- ")

    val notNullList = listOfNotNull("hello", null, "goodbye")
    println(notNullList)
    //[hello, goodbye]
    println(" --3-- ")

    val arraylist = arrayListOf(1, 2, 4)
    println(arraylist.javaClass)
    //class java.util.ArrayList
    println(" --4-- ")

    val mutableList = mutableListOf<Int>(1, 2, 3)
    println(mutableList.javaClass)
    //class java.util.ArrayList
    println(" --5-- ")

    println(mutableList[2]) //3
    mutableList[1] = 20
    println(mutableList) //[1, 20, 3]


    val array = arrayOf("black", "white", "green")
    println(listOf(array))
    //[[Ljava.lang.String;@29ee9faa]
    println(listOf(*array))
    //[black, white, green]

    val colorList = array.toList()
    println(colorList)
    //[black, white, green]
    println(" --6-- ")

    val ints = intArrayOf(1, 2, 3)
    println(ints.toList())
    //[1, 2, 3]
    println(" --7-- ")

}