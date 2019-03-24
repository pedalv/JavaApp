# Section 3: Basic Differences Between Kotlin and Java

## Compile a Kotlin application
- The Kotlin compiler (kotlinc) takes files with the .kt extendion as input and generates bytecode as .class files.
- At this point, the .class files are equivalent to Java .class files, and the JVM can run them.
- However, when running Kotlin applications, you need the KOTLIN RUNTIME LIBRARY, in addition to JRE.
So, the Kotlin compiler compiles .kt into -class files, which contain bytecode.
- The .class files can be on the JVM, exactly like class files generated from Java code.
- When distributing a Kotlin application, you have to distribute the Kotlin runtime library and the JRE for application run.

![Default Imports](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/java-kotlin-compile.png)


## [The Kotlin Standard LIBRARY](https://kotlinlang.org/api/latest/jvm/stdlib/index.html)

The Kotlin Standard Library provides living essentials for everyday work with Kotlin. These include:

- Higher-order functions implementing idiomatic patterns (let, apply, use, synchronized, etc).
- Extension functions providing querying operations for collections (eager) and sequences (lazy).
- Various utilities for working with strings and char sequences.
- Extensions for JDK classes making it convenient to work with files, IO, and threading.

Packages

| Name | Description |
| [Package kotlin](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/index.html) | Core functions and types, available on all supported platforms. |
| [Package kotlin.annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/index.html) | Library support for the Kotlin annotation facility. | 
| [Package kotlin.collections](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html) | Collection types, such as Iterable, Collection, List, Set, Map and related top-level and extension functions.
 |
| [Package kotlin.comparisons](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.comparisons/index.html) | Helper functions for creating Comparator instances. |
| [Package kotlin.concurrent](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/index.html) | Utility functions for concurrent programming. |
| ... | ... |
| [Package kotlin.io](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/index.html) | IO API for working with files and streams. |
| [Package kotlin.js](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.js/index.html) | Functions and other APIs specific to the JavaScript platform. |

![Default Imports](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/defaultimports.PNG)

- [Kotlin](https://kotlinlang.org/)
- [Kotlin 1.3 Released](https://kotlinlang.org/docs/reference/whatsnew13.html)
- [Introducing Kotlin support in Spring Framework 5.0](https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0)

## Declaration
- val: The variable is immutable as final in Java, can be assigned only one time
```
val number: Int
val number = 1
val number: Int = 1 (It is not normal in Kotlin)
val number: Short = 1 (It is OKAY)
```

- var: The variable can be assigned more than one time, keep same reference

```
var number: Int
```

- class

```
class Employee(var name: String, val id : Int) { ... }

val employee15 = Employee("Agitec AS", 21)
employee15.name = "Agitec"
employee15 = Employee("Bjørn", 1) (It is not OKAY because employee15 is final)
```

## Type Aliases
- Use for [generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html) types
- @kotlin.SinceKotlin public typealias StringBuilder = java.lang.StringBuilder

## Kotlin String class
- [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/)
- lenght is a property 

```
employee15.name.length
```

## Exception
- All Exceptions are uncheck

## Not exist
- Ternary operation (val q = x ? true : false) 	-> use if else as in Java
- for (int i = 0; i < 20, i++) {...}			-> many forms to loop  

```
employees.forEach { e -> println(e.name) }

File(getFilePath() + "locations_big.txt").reader().forEachLine {
	val tokens = it.split("`")

	val location = Location(tokens[0].toInt(), tokens[1])
	locations[location.locationID] = location
}
...
```

- static is not need 							-> fun main(args: Array<String>)  { ... }
- new key word (new Employee("PA", 15)) 		->  Employee("PA", 15)

## Equality

| Java | Kotlin |
| ----- | ----- |
| == | === referencial 	//REFERENCIAL |
| equals | == or equals 	//STRUCTURAL EQUALITY |

## Bit operator and casting

| Java | Kotlin |
| ----- | ----- |
| Employeej newEmployee = (Employeej) employeeOne; | val newEmployee = employeeOne as Employee |

Java: |, &, ^ 		<=>		Kotlin: or, and, xor

## String template

```
val employee1 = Employeek("Lynn Jones", 500)
employee1.name = "Lynn Smith"

println(employee1) //Employeek(name='Lynn Smith', id=500)

class Employeek(var name: String, val id : Int) {

    override fun toString(): String {
        return "Employeek(name='$name', id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employeek

        if (name != other.name) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }
}
```

```
val change = 4.22
println("Your change is $") //Your change is $
println("Your change is $change") //Your change is 4.22
println("Your change is $$change") //Your change is $4.22
println("Your change is \$change") //Your change is $change

val numerator = 10.99
val denominator = 20.00
println("The value of $numerator divided by $denominator is ${numerator/denominator}")
//The value of 10.99 divided by 20.0 is 0.5495

println("The employee's id is ${employee1.id}") //The employee's id is 500
```

## Raw Strings 
trimMargin()

```
val nurseryRhyme2 = """$eggName Dumpty sat on the wall
                        *$eggName Dumpty had a great fall
                        *All the king's horses and all the king's men
                        *Couldn't put $eggName together again.""".trimMargin("*")
    println(nurseryRhyme2)
OUTPUT:
Humpty Dumpty sat on the wall
Humpty Dumpty had a great fall
All the king's horses and all the king's men
Couldn't put Humpty together again.
```