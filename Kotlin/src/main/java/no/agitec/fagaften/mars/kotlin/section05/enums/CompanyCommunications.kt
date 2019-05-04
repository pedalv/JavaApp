package no.agitec.fagaften.mars.kotlin.section05.enums

fun main(args: Array<String>) {
    println(Department.ACCOUNTING.getDeptInfo())
    //The Accounting department has 3 employees
}

enum class Department(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 5),
    IT("Information Technology", 10),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 20)
    ;// KOTLIN HAVE SEMI COLUMN FOR ENUMMMMMMMMMMMMMMMMMMMMMMMMMMM

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}

