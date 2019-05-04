package no.agitec.fagaften.mars.kotlin.section05.imports.anotherpackage

import no.agitec.fagaften.mars.kotlin.section05.imports.communications.Department.IT
import no.agitec.fagaften.mars.kotlin.section05.imports.communications.Department.SALES
import no.agitec.fagaften.mars.kotlin.section05.imports.communications.topLevel
import no.agitec.fagaften.mars.kotlin.section05.imports.communications.CompanyCommunications as Comm
import no.agitec.fagaften.mars.kotlin.section05.imports.communications.topLevel as tp
import no.agitec.fagaften.mars.kotlin.section05.imports.communications.upperFirstAndLast as ufal


fun main(args: Array<String>) {
    topLevel("Hello from AnotherFile")
    println(" --1.1-- ")
    tp("Hello from AnotherFile")
    println(" --1.2-- ")
    println(Comm.getCopyrightLine())
    println(" --2-- ")
    println(IT.getDeptInfo())
    println(" --3-- ")
    println(SALES.getDeptInfo())
    println(" --4-- ")
    println("some string".ufal())
    println(" --5-- ")
}