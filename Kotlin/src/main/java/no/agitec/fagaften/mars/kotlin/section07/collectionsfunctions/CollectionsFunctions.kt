package no.agitec.fagaften.mars.kotlin.section07.collectionsfunctions


fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(
            1 to Car("green", "Toyota", 2015),
            2 to Car("red", "Ford", 2016),
            3 to Car("silver", "Honda", 2013),
            17 to Car("red", "BMW", 2015),
            8 to Car("green", "Ford", 2010))

    println(immutableMap.filter { it.value.year == 2016 })
    //{2=Car(color=red, model=Ford, year=2016)}
    println(immutableMap.toSortedMap()) //Sorted by key
    //{
    // 1=Car(color=green, model=Toyota, year=2015),
    // 2=Car(color=red, model=Ford, year=2016),
    // 3=Car(color=silver, model=Honda, year=2013),
    // 8=Car(color=green, model=Ford, year=2010),
    // 17=Car(color=red, model=BMW, year=2015)
    // }
    println(" --1-- ")

    println(immutableMap.all { it.value.year > 2014 }) //false
    println(immutableMap.any { it.value.year > 2014 }) //true
    println(immutableMap.count { it.value.year > 2014 }) //3
    println(" --2-- ")
    val cars = immutableMap.values
    println(cars.find { it.year > 2014 })
    //Car(color=green, model=Toyota, year=2015)
    println(cars.groupBy { it.color })
    //{
    // green=[
    // Car(color=green, model=Toyota, year=2015),
    // Car(color=green, model=Ford, year=2010)
    // ],
    // red=[
    // Car(color=red, model=Ford, year=2016),
    // Car(color=red, model=BMW, year=2015)
    // ],
    // silver=[Car(color=silver, model=Honda, year=2013)
    // ]
    // }
    println(cars.sortedBy { it.year })
    //[
    // Car(color=green, model=Ford, year=2010),
    // Car(color=silver, model=Honda, year=2013),
    // Car(color=green, model=Toyota, year=2015),
    // Car(color=red, model=BMW, year=2015),
    // Car(color=red, model=Ford, year=2016)
    // ]
    println(" --3-- ")

    println(immutableMap.filter { it.value.model == "Ford"}
            .map { it.value.color })
    //[red, green]
    println(immutableMap.map { it.value.year })
    //[2015, 2016, 2013, 2015, 2010]
    println(" --4-- ")


    println(immutableMap.filter { it.value.year == 2016 })
    //{2=Car(color=red, model=Ford, year=2016)}
    println(" --5-- ")

    val mutableMap = mutableMapOf<Int, Car>(
            1 to Car("green", "Toyota", 2015),
            2 to Car("red", "Ford", 2016),
            3 to Car("silver", "Honda", 2013))

    mutableMap.filter { it.value.color == "silver"}
    println("The filters map is $mutableMap") //do nothing
    //The filters map is {
    // 1=Car(color=green, model=Toyota, year=2015),
    // 2=Car(color=red, model=Ford, year=2016),
    // 3=Car(color=silver, model=Honda, year=2013)
    // }
    println(" --6-- ")





    val setInts = setOf(10, 15, 19, 5, 3, -22) //immutable
    println(setInts.filter { it % 2 != 0 }) //odds
    //[15, 19, 5, 3]
    println(" --7-- ")

    val ints = arrayOf(1, 2, 3, 4, 5)
    val add10List2: MutableList<Int> = mutableListOf()
    for (i in ints) {
        add10List2.add(i + 10)
    }
    println(add10List2)
    //[11, 12, 13, 14, 15]
    println(" --8-- ")

    val add10List = ints.map { it + 10 } // map function
    println(add10List.javaClass) // class java.util.ArrayList
    println(add10List) //[11, 12, 13, 14, 15]
    println(" --9-- ")
}

data class Car(val color: String, val model: String, val year: Int) {

}