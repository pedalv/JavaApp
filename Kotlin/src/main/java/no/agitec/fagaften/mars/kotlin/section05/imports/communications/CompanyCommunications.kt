package no.agitec.fagaften.mars.kotlin.section05.imports.communications

import java.time.Year

fun main(args: Array<String>) {
    topLevel("I'm private!")
    println(Department.ACCOUNTING.getDeptInfo())

    println(CompanyCommunications.getTagline())
    println(CompanyCommunications.getCopyrightLine())
}

//1
fun topLevel(str: String) = println("Top level function: $str")

//2
object CompanyCommunications {

    val currentYear = Year.now().value;

    fun getTagline() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."

}

//3
enum class Department(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 5), IT("Information Technology", 10),
    ACCOUNTING("Accounting", 3), SALES("Sales", 20);

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}

//4
fun String.upperFirstAndLast() : String {
    val upperFirst = substring(0, 1).toUpperCase() + substring(1);
    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}
