# Section 8: File I/O

## Reading text files
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section08/iokotlin/FileReading.kt)

- [Package kotlin.io](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/)

| Java | Kotlin |
| ----- | ----- |
| new InputStreamReader(new FileInputStreamReader(new File("testfile.txt")), "UTF-8") | File("testfile.txt").reader().forEachLine { println(it) } |

```
import java.io.File

fun main(args: Array<String>) {
    File(getFilePath() + "/src/main/resources/files/" + "testfile.txt").reader().forEachLine { println(it) }
    //This is line 1
    //Hello from line 2
    //line 3
    //I'm line 4
    //here's line 5
 }

private fun getFilePath(): String = File("").absolutePath
``` 

| Java | Kotlin |
| ----- | ----- |
| try with resources | it does not exits in kotlin <=> use* function |

``` 
/**
 * Calls the [block] callback giving it a sequence of all the lines in this file and closes the reader once
 * the processing is complete.
 * @return the value returned by [block].
 */
@RequireKotlin("1.2", versionKind = RequireKotlinVersionKind.COMPILER_VERSION, message = "Requires newer compiler version to be inlined correctly.")
public inline fun <T> Reader.useLines(block: (Sequence<String>) -> T): T =
    buffered().use { block(it.lineSequence()) }
``` 

	
## Walking the File Tree
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section08/binaryio/BinaryIO.kt)


``` 
fun main(args: Array<String>) {

    testfilepath()

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
``` 

##
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section08/walkfiletree/WalkFileTree.kt)


- [FileTreeWalk](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/-file-tree-walk/index.html)
- [Kotlin – Iterate through all files in a directory – Examples](https://www.tutorialkart.com/pdf/kotlin/iterate-through-all-files-in-a-directory-using-kotlin-example.pdf)

``` 
package no.agitec.fagaften.mars.kotlin.section08.walkfiletree

import java.io.File

fun main(/*args: Array<String>*/ vararg args: String) {

    File(".").walkTopDown()
            .filter { it.name.endsWith(".kt") }
            .forEach { println(it) }
    //.\OtherModule\src\no\agitec\fagaften\mai\kotlin\section05\imports\othermodule\AnotheModuleFile.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\exercise\kotlinbyhand\Location.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\exercise\kotlinbyhand\Locations.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\exercise\kotlinbyhand\Main.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\exercise\kotlinbyintellij\KotlinLocation.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\exercise\kotlinbyintellij\KotlinLocations.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\exercise\kotlinbyintellij\KotlinMain.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\kotlin\Location.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\kotlin\Locations.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\kotlin\Main.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\convert\textadventuregamekotlin\test\afgitec.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section02\test\locationkt.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\bitoperatorcasting\Declaration.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\declarations\alias\Declaration.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\declarations\Declaration.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\equality\Declarations.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\Exercise2.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\Exercise2Solution.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\helloworld\HelloWorld.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\helloworld\test1tk.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\repl\Declaration.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\rowstrings\Declaration.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section03\learnprograming\stringtemplate\Declaration.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section04\datatypes\arrays\DataTypes.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section04\datatypes\arraysnullreferences\Nullreferences.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section04\datatypes\Exercise3.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section04\datatypes\Exercise3Solution.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section04\datatypes\nullreferences\kotlincode\NullReferences.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section04\datatypes\primitive\DataTypes.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\accessmodifiers\AccessModifiers.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\classesconstructor\AccessModifiers.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\constantsdataclass\AccessModifiers.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\enums\CompanyCommunications.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\functions\Functions.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\functions\Utils.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\imports\anotherpackage\AnotherFile.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\imports\communications\CompanyCommunications.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\imports\communications\Imports.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\inheritance\Printer.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\interfaces\PrinterInterfaces.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\object\companion\Companion.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\object\companion\CompanionFactory.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\object\companion\CompanionSample46.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\object\expressions\AnonymousObjects.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\object\singletons\CompanyCommunications.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\oochallenge\OOChallenge.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section05\propertiesfields\AccessModifiers.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section06\forloop\Loops.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section06\ifexpression\IfExpression.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section06\ifexpression\IfExpressionKotlinConverted.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section06\section6challenge\Section6Challenge.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section06\trycatch\TryCatch.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section06\whenexpression\java\SwitchExampleKotlinConverted.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section06\whenexpression\WhenExpression.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\challenge7\Section7Challenge.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\collections\Collections.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\collectionsfunctions\CollectionsFunctions.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\contravariance\Contravariance.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\covariance\Covariance.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\functionsanderasure\UpperBound.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\generics\Generics.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\lambdas\basics\Lambdas.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\lambdas\withreceivers\Lambdas1.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\lambdas\withreceivers\Lambdas2.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\lists\Lists.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\maps\Maps.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\reifiedparameters\ReifiedParameters.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\sequences\Sequences.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\sets\Sets.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section07\usesitevariance\UseSiteVariance.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section08\binaryio\BinaryIO.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section08\iokotlin\FileReading.kt
    //.\src\main\java\no\agitec\fagaften\mars\kotlin\section08\walkfiletree\WalkFileTree.kt
    //.\src\test\java\no\agitec\fagaften\mars\kotlin\section05\functions\UtilsKtTest.kt
}