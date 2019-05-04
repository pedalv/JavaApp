package no.agitec.fagaften.mai.kotlin.section05.imports.othermodule

import no.agitec.fagaften.mars.kotlin.section05.imports.communications.topLevel
import no.agitec.fagaften.mars.kotlin.section05.imports.communications.topLevel as tp

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
}