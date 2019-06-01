package no.agitec.fagaften.mars.kotlin.section07.maps


fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(
            1 to Car("green", "Toyota", 2015),
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

    val mutableMap2 = mutableMapOf<Int, Car>(
            1 to Car("green", "Toyota", 2015),
            2 to Car("red", "Ford", 2016),
            3 to Car("silver", "Honda", 2013))
    mutableMap2[4] = Car("blue","Opel", 1996)
    println(mutableMap2.javaClass)
    println(mutableMap2)
    //class java.util.LinkedHashMap
    //{
    // 1=no.agitec.fagaften.mars.kotlin.section07.maps.Car@26f67b76,
    // 2=no.agitec.fagaften.mars.kotlin.section07.maps.Car@153f5a29,
    // 3=no.agitec.fagaften.mars.kotlin.section07.maps.Car@7f560810,
    // 4=no.agitec.fagaften.mars.kotlin.section07.maps.Car@69d9c55
    // }
    println(" --2-- ")

    val mutableMap = hashMapOf<String, Car>(
            "John's car" to Car("red", "Range Rover", 2010),
            "Jane's car" to Car("blue", "Hyundai", 2012))
    println(mutableMap.javaClass)
    println(mutableMap)
    //class java.util.HashMap
    //{
    // John's car=no.agitec.fagaften.mars.kotlin.section07.maps.Car@26f67b76,
    // Jane's car=no.agitec.fagaften.mars.kotlin.section07.maps.Car@153f5a29
    // }
    println(" --3-- ")
    mutableMap.put("Mary's car", Car("red", "Corvette", 1965))

    //for (entry in mutableMap) {
    for ((k, v) in mutableMap) {
        //println(entry.key)
        println(k)
        //Mary's car
        //...
        //println(entry.v)
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
    println(" --4-- ")

    val pair = Pair(10, "ten")
    //val firstValue = pair.first
    //val secondValue = pair.second
    val (firstValue, secondValue) = pair
    println(firstValue)
    println(secondValue)
    //10
    //ten
    println(" --5-- ")

    val car = Car("blue", "Corvette", 1959)
    val (color, model, year) = car
    /*
    Kotlin: Destructuring declaration initializer of type Car must have a 'component1()' function
    Kotlin: Destructuring declaration initializer of type Car must have a 'component2()' function
    Kotlin: Destructuring declaration initializer of type Car must have a 'component3()' function
     */
    println("color = $color, model = $model, and year = $year")
    //color = blue, model = Corvette, and year = 1959
    println(" --6-- ")

    val car2 = Car2("blue", "Corvette", 1959)
    val (color2, model2, year2) = car2
    println("color = $color2, model = $model2, and year = $year2")
    //color = blue, model = Corvette, and year = 1959
    println(" --7-- ")
}

class Car(val color: String, val model: String, val year: Int) {

    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year

}


data class Car2(val color: String, val model: String, val year: Int) {

}


