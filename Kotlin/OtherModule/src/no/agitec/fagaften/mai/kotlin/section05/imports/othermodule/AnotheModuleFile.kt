package no.agitec.fagaften.mai.kotlin.section05.imports.othermodule

import no.agitec.fagaften.mars.kotlin.section05.imports.communications.topLevel
//import no.agitec.fagaften.mars.kotlin.section05.imports.communications.topLevelPrivate
// Error:(4, 72) Kotlin: Cannot access 'topLevelPrivate': it is private in file
import no.agitec.fagaften.mars.kotlin.section05.singletons.CompanyCommunications
import no.agitec.fagaften.mars.kotlin.section05.imports.communications.topLevel as tp //top level function

/**
 * TODO:
 * Need add module (kotlin) for recognize topLevel
 *
 * We have two modules now
 * 1. Kotlin module - no.agitec.fagaften.mars.kotlin.*.*
 * 2. OtherModule - no.agitec.fagaften.mai.kotlin.section05.imports.othermodule.*.*
 */
fun main(args: Array<String>) {
    topLevel("Hello from AnotherFile")
    println(" --1.1-- ")
    tp("Hello from AnotherFile")
    println(" --1.2-- ")
    println(CompanyCommunications.getCopyrightLine())
    println(" --2.1-- ")

    println("___The access level does not visible in other module___")
    //topLevelPrivate("I'm private!")
    // Error:(22, 5) Kotlin: Cannot access 'topLevelPrivate': it is private in file
    println(" --3-- ")
    //println(no.agitec.fagaften.mars.kotlin.section05.imports.communications.CompanyCommunications.getCopyrightLineInternal())
    //Error:(27, 99) Kotlin: Cannot access 'getCopyrightLineInternal': it is internal in 'CompanyCommunications'
    println(" --4-- ")

}