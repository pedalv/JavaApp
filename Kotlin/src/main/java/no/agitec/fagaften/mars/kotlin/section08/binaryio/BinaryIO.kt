package no.agitec.fagaften.mars.kotlin.section08.binaryio

import java.io.DataInputStream
import java.io.EOFException
import java.io.File
import java.io.FileInputStream


fun main(args: Array<String>) {

    testfilepath()
    println(" --1-- ")
    testfile()
    println(" --2-- ")

}

private fun testfilepath() {

    val di = DataInputStream(FileInputStream("testfile.bin"))
    var si: String

    try {
        while (true) {
            si = di.readUTF()
            println(si)
        }
    }
    catch (e: EOFException) {

    }

}

private fun testfile() {
    val abstractpathfilename = File(getFilePath() + "/src/main/resources/files/" + "testfile.bin")

    val di = DataInputStream(FileInputStream(abstractpathfilename))
    var si: String

    try {
        while (true) {
            si = di.readUTF()
            println(si)
        }
    }
    catch (e: EOFException) {

    }

}

private fun getFilePath(): String = File("").absolutePath