package no.agitec.fagaften.mars.kotlin.section03.learnprograming.helloworld.declarations.alias

import no.agitec.fagaften.mars.kotlin.section03.learnprograming.helloworld.declarations.Employee

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>)  {

    var employees: EmployeeSet

    employees = setOf(Employee("Lynn Jones", 500), Employee("Jane Smith", 400))

    println(employees.size) //
    println(" -1- ")

    employees = employees.plusElement(Employee("Mike Watson", 150))
    println(employees.size) // 3
    println(" -2.1- ")
    employees = employees.plus(Employee("Mike Watson", 150))
    println(employees.count()) // 4
    println(" -2.2- ")


    println("$employees.size")
    println(" -3- ")
    //[no.agitec.fagaften.mars.kotlin.section3.learnprograming.helloworld.declarations.Employee@3c09711b, no.agitec.fagaften.mars.kotlin.section3.learnprograming.helloworld.declarations.Employee@5cc7c2a6].size
    println("${employees.size}") //2
    println(" -4- ")

    val name = employees . iterator ().next().name;
    println(name) //Lynn Jones
    println(" -5- ")
    println("$name") //Lynn Jones
    println(" -6- ")

    employees.forEach { e -> println(e.name) }
    //Lynn Jones
    //Jane Smith
    println(" -7- ")

}
