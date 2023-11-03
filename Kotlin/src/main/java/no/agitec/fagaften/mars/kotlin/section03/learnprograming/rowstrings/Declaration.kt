package no.agitec.fagaften.mars.kotlin.section03.learnprograming.rowstrings

import no.agitec.fagaften.mars.kotlin.section03.learnprograming.helloworld.declarations.Employee
import no.agitec.fagaften.mars.kotlin.section03.learnprograming.stringtemplate.Employeek

fun main(args: Array<String>) {
    val filePath = "c:\\dir1\\dir2"
    println(filePath)
    println("---")
    val filePath2 = """c:\dir1\dir2"""
    println(filePath2)
    println("---")
    val filePath3 = "c:/dir1/dir2"
    println(filePath3)
    println("---")
    val eggName = "Humpty"
    val nurseryRhyme = """$eggName Dumpty sat on the wall
                        |$eggName Dumpty had a great fall
                        |All the king's horses and all the king's men
                        |Couldn't put $eggName together again.""".trimMargin()
    println(nurseryRhyme)
    println("---")
    val nurseryRhyme2 = """$eggName Dumpty sat on the wall
                        *$eggName Dumpty had a great fall
                        *All the king's horses and all the king's men
                        *Couldn't put $eggName together again.""".trimMargin("*")
    println(nurseryRhyme2)
    println("---")
    val nurseryRhyme3 = """$eggName Dumpty sat on the wall
                        *$eggName Dumpty had a great fall
                        *All the king's horses and all the king's men
                        *Couldn't put $eggName together again."""
    println(nurseryRhyme3)
    println("---")

    val employee1 = Employeek("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    println(employee1)
    println(employee1.toString())
    println("The employee's id is ${employee1.id}")

    val employee2 = Employee("Lynn Jones", 500)
    println(employee1)

}