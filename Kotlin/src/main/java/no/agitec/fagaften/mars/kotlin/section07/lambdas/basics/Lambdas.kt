package no.agitec.fagaften.mars.kotlin.section07.lambdas.basics

import no.agitec.fagaften.mars.kotlin.section07.lambdas.receivers.Employee

fun main(args: Array<String>) {
    run { println("I'm in a lambda!") }
    println(" --1-- ")

    val employees = listOf(
            Employee("John", "Smith", 2012),
            Employee("Jane", "Wilson", 2015),
            Employee("Mary", "Johnson", 2010),
            Employee("Mike", "Jones", 2002))

    println(employees.minBy { e -> e.startYear} )
    println(employees.minBy { e: Employee -> e.startYear} )
    println(employees.minBy { it.startYear} )
    println(employees.minBy ({ e -> e.startYear}) )
    println(employees.minBy(Employee::startYear)) //member reference
    //Employee(firstName=Mike, lastName=Jones, startYear=2002)
    println(" --2-- ")

    var num = 10
    run {
        num += 15
        println(num)
    }
    println(" --3-- ")

    run(::topLevel)
    println(" --4-- ")

}

fun topLevel() = println("I'm in a function!")

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num) //member reference can only be read
        // num++ :  Kotlin: Val cannot be reassigned
    }
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}