package no.agitec.fagaften.mars.kotlin.section08.iokotlin

import java.io.File

fun main(/*args: Array<String>*/ vararg args: String) {
    var reader = File("testfile.txt").reader()
    var fileText = reader.readText()
    println(fileText)
    reader.close()
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    //
    println(" --1-- ")

    reader = File("testfile.txt").reader()
    var lines = reader.readLines()
    lines.forEach{ println(it) }
    reader.close()
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    println(" --2-- ")

    fileText = File("testfile.txt").reader().use { it.readText() }
    println(fileText)
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    //
    println(" --3.1-- ")

    lines = File("testfile.txt").reader().use { it.readLines() }
    lines.forEach{ println(it) }
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    println(" --3.2-- ")

    lines = File("testfile.txt").bufferedReader().use { it.readLines() }
    lines.forEach{ println(it) }
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    println(" --3.3-- ")

    fileText = File("testfile.txt").readText()
    println(fileText)
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    //
    println(" --3.4-- ")

    File("testfile.txt").reader().forEachLine { println(it) }
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    println(" --4.1-- ")

    File("testfile.txt").reader().useLines { it.forEach {  println(it) } }
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    println(" --4.2-- ")

    File(getFilePath() + "/src/main/resources/files/" + "testfile.txt").reader().forEachLine { println(it) }
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
    println(" --5-- ")

    //kotlin: File("testfile.txt").reader()
    //<=>
    //java: new InputStreamReader(new FileInputStreamReader(new File("testfile.txt")), "UTF-8")
}


private fun getFilePath(): String = File("").absolutePath