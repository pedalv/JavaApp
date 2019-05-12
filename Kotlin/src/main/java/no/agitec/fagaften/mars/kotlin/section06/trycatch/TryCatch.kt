package no.agitec.fagaften.mars.kotlin.section06.trycatch


fun main(args: Array<String>) {

    println(getNumber2("22"))
    //22
    println(" --1.1-- ")

    println(getNumber2("22.5"))
    //0
    println(" --1.2-- ")

    println(getNumber3("22"))
    //I'm in the finally block
    //22
    println(" --2.1-- ")

    println(getNumber3("22.5"))
    //I'm in the finally block
    //0
    println(" --2.2-- ")

    println(getNumber4FinallyNotReturn("22.5"))
    //I'm in the finally block and ignore return type DUDE
    //0
    println(" --2.3-- ")

    println(getNumber5Exception("22.5"))
    //I'm in the finally block
    //Exception in thread "main" java.lang.NumberFormatException: For input string: "22.5"
    //	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    //	at java.base/java.lang.Integer.parseInt(Integer.java:652)
    //	at java.base/java.lang.Integer.parseInt(Integer.java:770)
    //	at no.agitec.fagaften.mars.kotlin.section06.trycatch.TryCatchKt.getNumber5Exception(TryCatch.kt:117)
    //	at no.agitec.fagaften.mars.kotlin.section06.trycatch.TryCatchKt.main(TryCatch.kt:29)
    println(" --2.4-SHOW EXCEPTION 1- ")

    println("?  Allowed return null")
    println("?: Elvis operator assign a default value when value is null")
    println("!  Programmer has 100% sure that value is never..never null")
    println(getNumber("22.5") ?: "I can't print the result")
    //?  Allowed return null
    //?: Elvis operator assign a default value when value is null
    //!  Programmer has 100% sure that value is never..never null
    //I'm in the finally block
    //I can't print the result
    println(" --3-- ")

    //println(getNumber("22.5") ?: throw java.lang.IllegalArgumentException("The value is not a INT"))
    //I'm in the finally block
    //Exception in thread "main" java.lang.IllegalArgumentException: The value is not a INT
    //	at no.agitec.fagaften.mars.kotlin.section06.trycatch.TryCatchKt.main(TryCatch.kt:47)
    println(" --3.1-SHOW EXCEPTION 2 - WITH DESCRIPTION OF THE PROBLEM WROTE BY THE PROGRAMMER on MAIN METHOD- ")

    notImplementedYet("string")
    //Exception in thread "main" java.lang.IllegalArgumentException: Implement me!
    //	at no.agitec.fagaften.mars.kotlin.section06.trycatch.TryCatchKt.notImplementedYet(TryCatch.kt:64)
    //	at no.agitec.fagaften.mars.kotlin.section06.trycatch.TryCatchKt.main(TryCatch.kt:56)
    println(" --4-EXCEPTION- ")
}

fun notImplementedYet(something: String): Nothing {
    throw IllegalArgumentException("Implement me!")
}

fun getNumber(str: String): Int? {
    return try {
            Integer.parseInt(str)
        }
        catch(e: NumberFormatException) {
            null
        }
        finally {
            println("I'm in the finally block")
        }
}


fun getNumber2(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
    catch(e: NumberFormatException) {
        0
    }
}

fun getNumber3(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
    catch(e: NumberFormatException) {
        0
    }
    finally {
        println("I'm in the finally block")
    }
}


fun getNumber4FinallyNotReturn(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
    catch(e: NumberFormatException) {
        0
    }
    finally {
        println("I'm in the finally block and ignore return type DUDE")
        10
    }
}

fun getNumber5Exception(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
//    catch(e: NumberFormatException) {
//        0
//    }
    finally {
        println("I'm in the finally block")
    }
}