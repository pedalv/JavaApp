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