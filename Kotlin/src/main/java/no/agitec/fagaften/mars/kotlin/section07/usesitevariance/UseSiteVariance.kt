package no.agitec.fagaften.mars.kotlin.section07.usesitevariance


fun main(vararg args: String) {

    val cars1 = mutableListOf(Car(), Car())
    val cars2: MutableList<Car> = mutableListOf()
    copyCars1(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
    //copyCars1(fords1, fords2)
    /*
     - Generics are compiled time feature
     - Generics are invariant <=> Not Covariance
     - Error: Kotlin: Type mismatch: inferred type is MutableList<Ford> but MutableList<Car> was expected
    Error:(12, 15) Kotlin: Type mismatch: inferred type is MutableList<Ford> but MutableList<Car> was expected
    Error:(12, 23) Kotlin: Type mismatch: inferred type is MutableList<Ford> but MutableList<Car> was expected
    Solution: Use T
     */
    copyCars2(fords2, fords2)



    //copyCars2(fords2, cars2)
    /*
    Error:(24, 5) Kotlin: Type inference failed:
        Cannot infer type parameter T in fun <T : Car> copyCars2(source: MutableList<T>, destination: MutableList<T>): Unit
    None of the following substitutions
        (MutableList<Ford>,MutableList<Ford>)
        (MutableList<Car>,MutableList<Car>)
            can be applied to
                (MutableList<Ford>,MutableList<Car>)

        Solution:
        - Use 'out' for return type
        Covariante
        - Down in heritance
        - Preserve subtyping
        - Start at superclass and we want accept instance of that class or any of subclasses
        - T match T and all subclasses
        - use 'out' position
       - return types
     */
    copyCars3(fords2, cars2)

    val cars3 = mutableListOf(Ford(), Ford())


}

//                      read <=> Covariance : ouy, write <=> Contravariance : in
fun <T: Car> copyCars3(source: MutableList<out T>, destination: MutableList</*in*/  T>) {
    for (car in source) {
        destination.add(car)
    }
}


fun <T: Car> copyCars2(source: MutableList< T>, destination: MutableList<T>) {
    for (car in source) {
        destination.add(car)
    }
}

fun copyCars1(source: MutableList<Car>, destination: MutableList<Car>) {
    for (car in source) {
        destination.add(car)
    }
}

open class Car {

}

class Toyota: Car() {

}

class Ford: Car() {

}

// List<? extends Car> <=> Covariance

// List<? super Car> <=> contravariance