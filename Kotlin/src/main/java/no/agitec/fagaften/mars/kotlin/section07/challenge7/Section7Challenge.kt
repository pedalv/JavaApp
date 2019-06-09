package academy.learnprogramming.challenge7

import java.awt.print.Paper

fun main(/*args: Array<String>*/ vararg args: String) {

    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 66)

    //task 1
    val people = mapOf(
            "Jones" to joe,
            "Smith" to jane,
            "Wilson" to mary,
            "Adams" to john,
            "Smithson" to jean)

    //task 2
    println(people.filter {
        it.value.lastName.startsWith('S') }
            .count())
    //2
    println("  --1-- ")

    //task 3.1
    val namePairs = people.map {
        Pair(it.value.firstName, it.value.lastName)
    }
    println(namePairs)
    //[(Joe, Jones), (Jane, Smith), (Mary, Wilson), (John, Adams), (Jean, Smithson)]
    println("  --2-- ")

    //task 3.2
    val firstNames = people.map { it.value.firstName }
    val lastNames = people.map { it.value.lastName }
    val namePairs2 = firstNames.zip(lastNames)
    println(namePairs2)
    //[(Joe, Jones), (Jane, Smith), (Mary, Wilson), (John, Adams), (Jean, Smithson)]
    println("  --3-- ")

    //task 4 - lambda expression
    // also() use it to refer to receiver object
    // apply() use this to refer to receiver object
    // Joe is 45 years old
    // Jane is 12 years old
    // etc.
    people.also {
        it.map {
            println("${it.value.firstName} is ${it.value.age} years old")
        }
    }
    //Joe is 45 years old
    //Jane is 12 years old
    //Mary is 70 years old
    //John is 32 years old
    //Jean is 66 years old
    println("  --4-- ")


    //task 5
    val (fName, lName, age) = joe
    println("fName = $fName, lName = $lName, age = $age")
    //fName = Joe, lName = Jones, age = 45
    println("  --5-- ")

    //task 6
    val list1 = listOf(1, 4, 9, 15, 33)
    val list2 = listOf(4, 55, -83, 15, 22, 101)

    val list31 = list1.filter { it in list2 }
    println("list3 = $list31")
    val list32 = list1.filter { list2.contains(it) }
    println("list3 = $list32")
    //list3 = [4, 15]
    println("  --6-- ")

    //task 7
    var regularPaper = Box<Regular>()
   /*val*/ var paper = Box<Paper>()
    paper = regularPaper //1: comment
    /*
    Error:(83, 5) Kotlin: Val cannot be reassigned
    Solution:
    change val to var

    Error:(83, 13) Kotlin: Type mismatch: inferred type is Box<Regular> but Box<Paper> was expected
    Solution:
    covariance: add out keyword => It is not possible write
     */

    // bad!
    //paper.addPaper(Premium())

    regularPaper = paper //1: commented
    /*
        Error:(97, 20) Kotlin: Type mismatch:
            inferred type is Box<Paper> but Box<Regular> was expected
        Solution:
            - Do not comment //1
            - or change to in position, class Box<in T> { ... }
            => It is not possible read bacause we do not know the type as show below
     */

    // bad!
    //val sheet: Regular = regularPaper.takePaper()

}


/*data*/ class Person(val firstName: String, val lastName: String, val age: Int) {

    //5: add data class or create component
    /**/
    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age

}


// Task 7
class Box</*in*/ /**/out T> {

    //out position
    fun takePaper(): List<Paper> {
        return listOf<Regular>(Regular())
    }

    //in position
// nonono bad!
//    fun addPaper(paper: T) {
//
//    }

}

open class Paper

class Regular: Paper()

class Premium: Paper()