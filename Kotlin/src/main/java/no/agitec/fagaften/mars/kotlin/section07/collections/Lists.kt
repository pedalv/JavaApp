package no.agitec.fagaften.mars.kotlin.section07.collections


fun main(args: Array<String>) {

    val strings = listOf("spring", "summer", "fall", "summer", "winter")
    val colorList = listOf("black", "white", "red", "black", "red")

    val mutableSeasons = strings.toMutableList()
    mutableSeasons.add("some other season")
    println(mutableSeasons)
    //[spring, summer, fall, summer, winter, some other season]
    println(" --1-- ")

    println(strings.last())
    //winter
    println(" --2-- ")

    println(strings.asReversed())
    //[winter, summer, fall, summer, spring]
    println(" --3-- ")

    println(strings.getOrNull(5))
    //null
    //if (strings.size > 5) {
        //println(strings[5])
        /*
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
        at java.base/java.util.Arrays$ArrayList.get(Arrays.java:4351)
        at no.agitec.fagaften.mars.kotlin.section07.collections.ListsKt.main(Lists.kt:57)
         */
    //}
    println(" --4-- ")

    val ints = listOf(1, 2, 3, 4, 5)
    println(ints.max())
    //5
    println(" --5-- ")

    println(colorList.zip(strings))
    //[(black, spring), (white, summer), (red, fall), (black, summer), (red, winter)]
    //val strings = listOf("spring", "summer", "fall", "summer", "winter")
    //val colorList = listOf("black", "white", "red", "black", "red")
   /*
    public data class Pair<out A, out B>(
        public val first: A,
        public val second: B
    )
    */
    println(" --6-- ")

    val mergedLists = listOf(colorList, strings)
    println(mergedLists)
    //[[black, white, red, black, red], [spring, summer, fall, summer, winter]]
    println(" --7-- ")

    val combinedList = colorList + strings
    println(combinedList)
    //[black, white, red, black, red, spring, summer, fall, summer, winter]
    println(" --8-- ")

    val noDupsList = colorList.union(strings)
    println(noDupsList)
    //[black, white, red, spring, summer, fall, winter]
    println(" --9-- ")

    val noDupColors = colorList.distinct()
    println(noDupColors)
    //[black, white, red]
    println(" --10-- ")


}