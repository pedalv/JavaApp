package no.agitec.fagaften.mars.kotlin.section07.contravariance


fun main(vararg args: String) {

    /**
     * Singleton reference
     * Anonymous object
     */
    val flowerTender = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a ${flower.name}!")
    }

    /**
     * Singleton reference
     * Anonymous object
     *
     * We do not need after fix with 'in'
     */
    val roseTender = object: FlowerCare<Rose> {
        override fun prune(flower: Rose) = println("I'm pruning a rose!")
    }
    //class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) { ... }
    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), roseTender)
    roseGarden.tendFlower(0)

    val roseGardenFlower = Garden<Rose>(listOf(Rose(), Rose()), flowerTender)
    /*
    in will fix: Error:(25, 65) Kotlin: Type mismatch: inferred type is <no name provided> but FlowerCare<Rose> was expected
     */
    roseGardenFlower.tendFlower(0)

    /**
     * Singleton reference
     * Anonymous object
     *
     * We do not need after fix with 'in'
     */
    val daffodilTender = object: FlowerCare<Daffodil> {
        override fun prune(flower: Daffodil) = println("I'm pruning a daffodil!")
    }
    //class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) { ... }
    //class Daffodil: Flower("Daffodil")
    //val daffodilGardenRose = Garden<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), roseTender)
    /*
    Error: Kotlin: Type mismatch: inferred type is <no name provided> but FlowerCare<Daffodil> was expected

    Covariante (down in heritance): we preserve subtyping.
                                    Start at superclass and we want accept instance of that class or any of sub classes
    Contravariance (up in heritance) : It is opposite of covariante.
                     we go in opposite direction.
                     Start at subclass and we want accept instance of that class or any of super classes
     */
    /**/val daffodilGarden = Garden<Daffodil>(
            listOf(Daffodil(), Daffodil(), Daffodil()),
            flowerTender)
    /*
    in will fix: Error:(51, 13) Kotlin: Type mismatch: inferred type is <no name provided> but FlowerCare<Daffodil> was expected
     */
    daffodilGarden.tendFlower(2)

    /**
     * Singleton reference
     * Anonymous object
     */
    val flowerTender2 = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a flower")
        /*override*/ fun pick(): Flower = Flower("some random flower") //(1)
    }
    //class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) { ... }
    val roseGarden2 = Garden<Rose>(listOf(Rose()), flowerTender2)
    /*
    in will fix: Error:(66, 52) Kotlin: Type mismatch: inferred type is <no name provided> but FlowerCare<Rose> was expected
     */
    val rose: Rose = roseGarden2.pickFlower(0) //(1)
}

class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]

    //fun pickFlower(i: Int) = flowerCare.pick(i) //(1)
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class Flower(val name: String)

class Rose: Flower("Rose")

class Daffodil: Flower("Daffodil")

/**
 * in is the solution for be contravariance
 */
interface FlowerCare</**/in T> {
    fun prune(flower: T)

    /**
     * in is used as parameter in a function - contravariance
     * out is used as return type in a function - covariante
     *
     * if it was allowed we could return any type of flower - Se (1)
     */
    //fun pick(): T //(1)
    /*
    Error:(99, 17) Kotlin: Type parameter T is declared as 'in' but occurs in 'out' position in type T

    Error:(10, 24) Kotlin: Object is not abstract and does not implement abstract member public abstract fun pick(): Flower defined in no.agitec.fagaften.mars.kotlin.section07.contravariance.FlowerCare
    Error:(20, 22) Kotlin: Object is not abstract and does not implement abstract member public abstract fun pick(): Rose defined in no.agitec.fagaften.mars.kotlin.section07.contravariance.FlowerCare
    Error:(39, 26) Kotlin: Object is not abstract and does not implement abstract member public abstract fun pick(): Daffodil defined in no.agitec.fagaften.mars.kotlin.section07.contravariance.FlowerCare
    Error:(68, 13) Kotlin: 'pick' hides member of supertype 'FlowerCare' and needs 'override' modifier

     */
}
