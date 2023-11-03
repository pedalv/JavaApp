package no.agitec.fagaften.mars.kotlin.section07.functionsanderasure


fun main(args: Array<String>) {

    val ints = listOf(1, 2, 3, 4, 5) //non nullable
    val shorts: List<Short?> = listOf(10, 20, 30, 40) //nullable
    val floats: List<Float?> = listOf(100.3f, -459.43f) //nullable
    val strings = listOf("1", "2", "3") //non nullable

    if (strings is List<String>) {
        println("This list contains strings")
    }
    //This list contains strings
    println(" --1-- ")

    var listAny: Any = listOf("str1", "str2")
    //if (listAny is List<String>) { }
    /*
    Kotlin: Cannot check for instance of erased type: List<String>
    */
    //if (listAny is List) { }
    /*
     Kotlin: One type argument expected. Use 'List<*>' if you don't want to pass type arguments
    */
    if (listAny is List<*>) {
        println("Yes, this is a list. Thank you star projection!")
    }
    //Yes, this is a list. Thank you star projection!
    if (listAny is List<*>) {
        println("This list contains strings")
        //This list contains strings
        val strList = listAny as List<String>
        println(strList[1].replace("str", "string"))
        //string2
    }
    println(" --2-- ")

    listAny = listOf(1, 2, 3)
    if (listAny is List<*>) {
        println("This list contains strings")
        //This list contains strings
        val strList = listAny as List<String>
        //Warning:(43, 31) Kotlin: Unchecked cast: Any to List<String>
        println(strList[1].replace("str", "string"))
        /*
        Exception in thread "main" java.lang.ClassCastException:
            class java.lang.Integer cannot be cast to class java.lang.String
            (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
	            at no.agitec.fagaften.mars.kotlin.section07.upperbound.UpperBoundKt.main(UpperBound.kt:45)
         */
    }
    println(" --3-- ")

    convertToInt(floats)
    //100
    //-459
    println(" --4-- ")

    convertToInt(shorts)
    //10
    //20
    //30
    //40
    println(" --5-- ")

    //convertToInt(strings)
    /*
    Kotlin: Type parameter bound for T in fun <T : Number?> convertToInt(collection: List<T>): Unit
        is not satisfied: inferred type String is not a subtype of Number?
     */
    println(" --6-- ")

    append(StringBuilder("String 1"), StringBuilder("String 2"))

    //printCollection(shorts)
    /*
    Kotlin: Type parameter bound for T in fun <T : Any> printCollection(collection: List<T>): Unit
        is not satisfied: inferred type Short? is not a subtype of Any

    NB: short is type nullable => val shorts: List<Short?> = listOf(10, 20, 30, 40) //nullable
    and we only accept no nullable type
     */
    //
    println(" --7-- ")
    //Result is 'String 1String 2'
    printCollection(strings)
    //1
    //2
    //3
    println(" --8-- ")
}

//WE JUST WANT non nullable types
fun <T: Any> printCollection(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

fun <T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable {
    println("Result is '${item1.append(item2)}'")
}

//COULD BE nullable
fun <T: Number?> convertToInt(collection: List<T>) {
    for (num in collection) {
        println("${num?.toInt()}")
    }
}

//non nullable
fun <T: Number> convertToInt2(collection: List<T>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
}

//non nullable
fun <T> convertToInt1(collection: List<T>) {
    for (num in collection) {
        //println("${num.toInt()}")
        /*
        Kotlin: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type T
         */
    }
}