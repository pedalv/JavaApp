package academy.learnprogramming.covariance


fun main(vararg args: String) {
//fun main(args: Array<String>) {

    //public class Short private constructor() : Number(), Comparable<Short> { ... }
    //public interface List<out E> : Collection<E> { ... }
    //public fun <T> listOf(vararg elements: T) = ...
    val shortList: List<Short> = listOf(1, 2, 3, 4, 5)
    convertToInt(shortList)


    //public class Short private constructor() : Number(), Comparable<Short> { ... }
    //public interface MutableList<E> : List<E>, MutableCollection<E> { ... }
    //public fun <T> mutableListOf(vararg elements: T): MutableList<T> = ...
    val shortListM: MutableList<Short> = mutableListOf(1, 2, 3, 4, 5)
    //convertToIntM(shortListM)
    /*
    Error:Kotlin: Type mismatch: inferred type is MutableList<Short> but MutableList<Number> was expected
     */
}


/**
 * Works with immutable list - is not need 'out' in parameter for mutable collections
 *
 * Type and subtype and supertype = class and subclass and superclass
 *
 * Covariance : list of short as a list of number like subtype
 *              can only be used as return type <=> out
 *
 * public class Short private constructor() : Number(), Comparable<Short> { ... }
 * public interface List<out E> : Collection<E> { ... }
 * public fun <T> listOf(vararg elements: T) = ...
 */
fun convertToInt(collection: List<Number>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
    //1
    //2
    //3
    //4
    //5

    /*
        This is the reason covariante can only be use a return type.

        convertToInt(shortList)
        if you add 25 to a shortList could be a problem  - collection.add(25)
        if you add25.3 to a shortList is a problem - collection.add(25.3)
     */
}

/**
 * Not works with mutable list - is need 'out' in parameter for immutable collections works
 *
 * Type and subtype and supertype != class and subclass and superclass
 *
 * Invariante <=> not Covariance : list of short is not a list of number.
 *                  subtype is not preserve
 *
 *
 * public class Short private constructor() : Number(), Comparable<Short> { ... }
 * public interface MutableList<E> : List<E>, MutableCollection<E> { ... }
 * //public fun <T> mutableListOf(vararg elements: T): MutableList<T> = ...
 */
fun convertToIntM(collection: MutableList<Number>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
    //1
    //2
    //3
    //4
    //5

}



fun tendGarden(roseGarden: Garden<Rose>) {
    //waterGarden(roseGarden)
    /*
    Kotlin: Type mismatch: inferred type is Garden<Rose> but Garden<Flower> was expected
     */
}

fun waterGarden(garden: Garden<Flower>) {

}



fun tendGardenC(roseGarden: GardenC<Rose>) {
    waterGardenC(roseGarden)
    /*
    Kotlin: Type mismatch: inferred type is Garden<Rose> but Garden<Flower> was expected
     */
}


fun waterGardenC(garden: GardenC<Flower>) {

}

open class Flower

class Rose: Flower()

/**
 * T is invariant
 */
class Garden<T: Flower>

/**
 * T is covariante now with 'out'
 */
class GardenC<out T: Flower> {

    val flowers: List<T> = listOf()

    fun pickFlower(i: Int): T = flowers[i]
}


/**
 * Error:Kotlin: Type parameter T is declared as 'out' but occurs in 'invariant' position in type T
 * val : set is not generate and it is not possible pass rose, or other type flowers
 */
//class Garden3<out T: Flower>(var something: T)

/**
 * No body outside the class can change something property
 *
 */
class Garden2<out T: Flower>(private var something: T) {

    val flowers: List<T> = listOf()

    /**
     * T is used as return type <=> out
     */
    fun pickFlower(i: Int): T = flowers[i]

    /**
     * In position : it is used as parameters
     * Out position: it is used as return type
     *
     * if we have a garden of roses we can not allowed other sub types of flowers as parameters
      */
   //fun plantFlower(flower: T) { }
    /*
     Kotlin: Type parameter T is declared as 'out' but occurs in 'in' position in type T
     */

}