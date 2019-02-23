package no.agitec.fagaften.mars.kotlin.section3.learnprograming.helloworld.declarations.alias

import no.agitec.fagaften.mars.kotlin.section3.learnprograming.helloworld.declarations.Employee

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>)  {

    val employees: EmployeeSet

    employees = setOf(Employee("Lynn Jones", 500), Employee("Jane Smith", 400))

    println(employees.size) //2

    employees.plusElement(Employee("Mike Watson", 150))

    println(employees.size) //2 //???? 3 Check later

    println("$employees.size")
    //[no.agitec.fagaften.mars.kotlin.section3.learnprograming.helloworld.declarations.Employee@3c09711b, no.agitec.fagaften.mars.kotlin.section3.learnprograming.helloworld.declarations.Employee@5cc7c2a6].size

    val name = employees . iterator ().next().name;
    println(name) //Lynn Jones
    println("$name") //Lynn Jones

    employees.forEach { e -> println(e.name) }
    //Lynn Jones
    //Jane Smith

}
