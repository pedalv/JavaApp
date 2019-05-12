package academy.learnprogramming.section6challenge


fun main(args: Array<String>) {

    // 5, 10, 15, 20, 25... 5000
    for (i in 5..5000 step 5) {
        println(i)
    }
    println(" --1-- ")
    for (i in -500..0) {
        println(i)
    }
    println(" --2-- ")
    // 0, 1, 1, 2, 3, 5, 8...
    // print the first 15 numbers in the Fibonacci sequence

    var total: Int
    var secondToLast = 0
    var last = 1

    println(secondToLast)
    println(last)
    for (i in 1..13) {
        total = secondToLast + last
        println(total)
        secondToLast = last
        last = total
    }
    println(" --3-- ")

    iloop@ for (i in 1..5) {
        println(i)
        if (i == 2) {
            break
        }
        for (j in 11..20) {
            println(j)
            for (k in 100 downTo 90) {
                println(k)
                if (k == 98) {
                    continue@iloop
                }
            }
        }
    }

    // 1, 11, 100, 99, 98, 2
    println(" --4-- ")

    // Declare a variable called num (int) and assign it whatever you want

    // Declare a variable called dnum (double) and assign it as follows:
    // if num > 100, assign dnum -234.567
    // if num < 100, assign dnum 4444.555
    // if num == 100, assign dnum 0.0
    // do all of the above in one statement/expression

    // Then print the value of dnum - separate statement

    val num = 101
    println(" --5.1-- ")
    println(if (num < 100) {
                        -234.567
                    }
                    else if (num > 100) {
                        4444.555
                    }
                    else {
                        0.0
                    })
    println(" --5.2-- ")
    val dnum = when {
        num < 100 -> -234.567
        num > 100 -> 4444.555
        else -> 0.0
    }
    println(" --5.2.1-- ")
    println(dnum)
    println(" --5.3-- ")

}