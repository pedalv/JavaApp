# Section 8: File I/O

## Reading text files
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section06/iokotlin/FileReading.kt)

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
