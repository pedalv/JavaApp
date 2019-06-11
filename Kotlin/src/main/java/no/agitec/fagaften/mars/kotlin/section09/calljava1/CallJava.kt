package no.agitec.fagaften.mars.kotlin.section09.calljava1

import no.agitec.fagaften.mars.kotlin.section09.calljava1.javacode.Car
import kotlin.jvm.javaClass as javaClass1


fun main(args: Array<String>) {

    val car = Car("blue", "Ford", 2015)
    car.color = "green"
    println(car)
    //Car{color='green', model='Ford', year=2015}
    println(" --1-- ")

    //car.color = null
    //Exception in thread "main" java.lang.IllegalArgumentException: Argument for @NotNull parameter 'color' of no/agitec/fagaften/mars/kotlin/section09/calljava/javacode/Car.setColor must not be null
    //	at no.agitec.fagaften.mars.kotlin.section09.calljava.javacode.Car.$$$reportNull$$$0(Car.java)
    //	at no.agitec.fagaften.mars.kotlin.section09.calljava.javacode.Car.setColor(Car.java)
    //	at no.agitec.fagaften.mars.kotlin.section09.calljava.CallJavaKt.main(CallJava.kt:14)
    println(car)
    println(" --2-- ")

    //val java type (nullable type - without annotation) = kotlin type (non-nullable type)
    var model = car.model
    //println(model.javaClass)
    /*
        - It is not equivalent 'String!' in Java
        - Error:(24, 19) Kotlin: Unresolved reference: javaClass
     */
    model = null //default type for java that is not annotated is nullable type
    println(model)
    //null
    println(" --3-- ")


    //val java type (non-nullable type  - without annotation) = kotlin type (non-nullable type)
    var model2: String = car.model
    //println(model2.javaClass) // It is not equivalent in Java
    /*
        - It is not equivalent model2 of type String in Java
        -Error:(38, 20) Kotlin: Unresolved reference: javaClass
     */
    //model2 = null
    /*
    Error:(43, 14) Kotlin: Null can not be a value of a non-null type String
     */
    //println(model2)
    //Ford
    println(" --4-- ")


    //val java type (nullable type not exist in java - with annotation) = kotlin type(nullable type)
    var model3: String? = car.modelA
    //println(model3.javaClass) // It is not equivalent 'String?' in Java
    /*
        - It is not equivalent model2 of type String in Java
        - Error:(54, 20) Kotlin: Unresolved reference: javaClass

     */
    model3 = null
    println(model3)
    //empty
    println(" --5-- ")


    //val java type (NotNulabel) = kotlin type (NotNulabel)
    //var model4: String! = car.modelA2
    /*
        - Error:(61, 23) Error:(66, 23) Kotlin: Unexpected token
        - Error:(66, 27) Kotlin: Type mismatch:
            inferred type is String? but String was expected
     */
    //println(model.javaClass) // It is not equivalent in Java
    //model4 = null
    //println(model4)
    //null
    println(" --6-- ")

    //val java type (Nonnullable) = kotlin type (Nonnullable)
    //var model5: String = car.modelA2
    /*
    Exception in thread "main" java.lang.IllegalStateException: @NotNull method no/agitec/fagaften/mars/kotlin/section09/calljava/javacode/Car.getModelA2 must not return null
	    at no.agitec.fagaften.mars.kotlin.section09.calljava.javacode.Car.$$$reportNull$$$0(Car.java)
	    at no.agitec.fagaften.mars.kotlin.section09.calljava.javacode.Car.getModelA2(Car.java:38)
	    at no.agitec.fagaften.mars.kotlin.section09.calljava.CallJavaKt.main(CallJava.kt:79)
     */

    //val java type = kotlin type
    //val color: Int = car.color
    /*
        - Error:(78, 22) Kotlin: Type mismatch:
            inferred type is String! but Int was expected
     */
}