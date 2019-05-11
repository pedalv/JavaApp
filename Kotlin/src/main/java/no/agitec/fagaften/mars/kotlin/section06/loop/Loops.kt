package no.agitec.fagaften.mars.kotlin.section06.loop

fun main(args: Array<String>) {

    val range = 1..5
    for (i in 1..5) {
        println(i)
    }
    //1
    //2
    //3
    //4
    //5
    println(" --01.1-- ")
    for (i in range) {
        println(i)
    }
    //1
    //2
    //3
    //4
    //5
    println(" --01.2-- ")
    for (num in 1..20 step 4) {
        println(num)
    }
    //1
    //5
    //9
    //13
    //17
    println(" --02-- ")
    for (i in 1 until 10) {
        println(i)
    }
    //1
    //2
    //3
    //4
    //5
    //6
    //7
    //8
    //9
    println(" --03-- ")
    val s = "goodbye"
    val sRange = 0..s.length
    println(s)
    //goodbye
    println(sRange) //0..7
    println(sRange.first) //0
    println(sRange.last) //7
    println(" --04-- ")
    for (i in 20 downTo 10 step 5) {
        println(i)
    }
    //20
    //15
    //10
    println(" --05-- ")
    val charRange = 'a'..'z'
    println(charRange) // a..z
    val stringRange = "ABD".."XYZ"
    println(stringRange) // ABD..XYZ
    println(" --06-- ")
    val str = "Hello"
    for (c in str) {
        println(c)
    }
    //H
    //e
    //l
    //l
    //o
    println(" --07-- ")
    println(3 in range) // true
    println('q' in charRange) // true
    println("CCC" in stringRange) // true
    println("CCCCCC" in stringRange) // true
    println("ZZZZZZ" in stringRange) // false
    println(" --08-- ")
    val backwardRange = 5.downTo(1)
    println(backwardRange)// 5 downTo 1 step 1
    val stepRange = 3..15
    println(stepRange) // 3..15
    println(" --09-- ")
    val stepThree = stepRange.step(3)
    for (n in stepThree) {
        println(n)
    }
    //3
    //6
    //9
    //12
    //15
    println(" --10-- ")
    val reversedRange = range.reversed()
    for (i in reversedRange) {
        println(i)
    }
    //5
    //4
    //3
    //2
    //1
    println(" --11-- ")

    val seasons = arrayOf("spring", "summer", "winter", "fall")
    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }
    //spring is season number 0
    //summer is season number 1
    //winter is season number 2
    //fall is season number 3
    println(" --12-- ")
    seasons.forEach { println(it) }
    //spring
    //summer
    //winter
    //fall
    seasons.forEachIndexed { index, value -> println("$value is season number $index")}
    //spring is season number 0
    //summer is season number 1
    //winter is season number 2
    //fall is season number 3
    println(" --13-- ")
    val notASeason = "whatever" !in seasons
    println(notASeason)
    // true
    println(" --14-- ")
    val notInRange = 32 !in 1..10
    println(notInRange)
    //true
    println(" --15-- ")
    val str2 = "Hello"
    println('e' in str2) //true
    println('e' !in str2) //false
    println(" --16-- ")
    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for (k in 5..10) {
                println("k = $k")
                if (k == 7) {
                    continue@jloop
                }
            }
        }
    }
    //i = 1
    //j = 1
    //k = 5
    //k = 6
    //k = 7
    //j = 2
    //k = 5
    //k = 6
    //k = 7
    //j = 3
    //k = 5
    //k = 6
    //k = 7
    //j = 4
    //k = 5
    //k = 6
    //k = 7
    //i = 2
    //j = 1
    //k = 5
    //k = 6
    //k = 7
    //j = 2
    //k = 5
    //k = 6
    //k = 7
    //j = 3
    //k = 5
    //k = 6
    //k = 7
    //j = 4
    //k = 5
    //k = 6
    //k = 7
    //i = 3
    //j = 1
    //k = 5
    //k = 6
    //k = 7
    //j = 2
    //k = 5
    //k = 6
    //k = 7
    //j = 3
    //k = 5
    //k = 6
    //k = 7
    //j = 4
    //k = 5
    //k = 6
    //k = 7
    println(" --17-- ")

}