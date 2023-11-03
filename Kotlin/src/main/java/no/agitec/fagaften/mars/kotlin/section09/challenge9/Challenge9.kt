package no.agitec.fagaften.mars.kotlin.section09.challenge9

import no.agitec.fagaften.mars.kotlin.section09.challenge9.javacode.Employee

fun main(args: Array<String>) {

    val employee = Employee("Jane", "Smith", 2000)

    // Make this code compile
    //1. add set and get
    employee.lastName = "Jones"
    //2. use one of solution below to fix this error:
    //employee.salaryLast3Years = arrayOf(50000.25f, 54000.60f, 56800.42f)
    /*
        Error:(13, 33) Kotlin: Type inference failed. Expected type mismatch: inferred type is Array<Float> but FloatArray! was expected
     */
    employee.salaryLast3Years = floatArrayOf(50000.25f, 54000.60f, 56800.42f)
    employee.salaryLast3Years = arrayOf(50000.25f, 54000.60f, 56800.42f).toFloatArray()

}