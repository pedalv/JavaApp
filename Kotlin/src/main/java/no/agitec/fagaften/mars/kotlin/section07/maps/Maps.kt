package no.agitec.fagaften.mars.kotlin.section07.maps


fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(1 to Car("green", "Toyota", 2015),
            2 to Car("red", "Ford", 2016),
            3 to Car("silver", "Honda", 2013))

    println(immutableMap.javaClass)
    println(immutableMap)
    //class java.util.LinkedHashMap
    //{
    // 1=no.agitec.fagaften.mars.kotlin.section07.maps.Car@12843fce,
    // 2=no.agitec.fagaften.mars.kotlin.section07.maps.Car@3dd3bcd,
    // 3=no.agitec.fagaften.mars.kotlin.section07.maps.Car@97e1986
    // }
    println(" --1-- ")

    val mutableMap = hashMapOf<String, Car>("John's car" to Car("red", "Range Rover", 2010),
            "Jane's car" to Car("blue", "Hyundai", 2012))
    println(mutableMap.javaClass)
    println(mutableMap)
    //class java.util.HashMap
    //{
    // John's car=no.agitec.fagaften.mars.kotlin.section07.maps.Car@26f67b76,
    // Jane's car=no.agitec.fagaften.mars.kotlin.section07.maps.Car@153f5a29
    // }
    println(" --2-- ")
    mutableMap.put("Mary's car", Car("red", "Corvette", 1965))

    for ((k, v) in mutableMap) {
        println(k)
        //Mary's car
        //...
        println(v)
        //no.agitec.fagaften.mars.kotlin.section07.maps.Car@7f560810
        //...
    }
    //Mary's car
    //no.agitec.fagaften.mars.kotlin.section07.maps.Car@7f560810
    //John's car
    //no.agitec.fagaften.mars.kotlin.section07.maps.Car@26f67b76
    //Jane's car
    //no.agitec.fagaften.mars.kotlin.section07.maps.Car@153f5a29
    println(" --3-- ")

    val pair = Pair(10, "ten")
    //val firstValue = pair.first
    //val secondValue = pair.second
    val (firstValue, secondValue) = pair
    println(firstValue)
    println(secondValue)
    //10
    //ten
    println(" --4-- ")

    val car = Car("blue", "Corvette", 1959)
    val (color, model, year) = car
    println("color = $color, model = $model, and year = $year")
    //color = blue, model = Corvette, and year = 1959
    println(" --5-- ")
}

class Car(val color: String, val model: String, val year: Int) {

    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year

}



