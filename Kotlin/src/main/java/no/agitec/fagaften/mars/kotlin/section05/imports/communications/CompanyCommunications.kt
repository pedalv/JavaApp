package no.agitec.fagaften.mars.kotlin.section05.imports.communications

import java.time.Year

fun main(args: Array<String>) {
    println(" --1-- ")
    println(Department.ACCOUNTING.getDeptInfo())
    println(" --2-- ")
    println(CompanyCommunications.getTagline())
    println(" --3-- ")
    println(CompanyCommunications.getCopyrightLine())
    println(" --4-- ")

    println("___The access level visible in the same file___")
    println(CompanyCommunications.getCopyrightLineInternal())
    println(" --5-- ")
    topLevelPrivate("I'm private!")
    println(" --6-- ")
    println(PrivateClass.nonono())
    println(" --7-- ")
}

//1
fun topLevel(str: String) = println("Top level function: $str")
private fun topLevelPrivate(str: String) = println("Top level function: $str")

//2
object CompanyCommunications {

    val currentYear = Year.now().value;

    fun getTagline() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
    internal fun getCopyrightLineInternal() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}

/**
 * internal is not need because the class in only visibel in the same file
 */
private object PrivateClass {
    internal fun nonono() : Unit = println("Remove internal keyword because nonono method is only visible in this file")
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
