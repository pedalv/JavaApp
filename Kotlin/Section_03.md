# Section 3: Basic Differences Between Kotlin and Java

## Compile a Kotlin application
- The Kotlin compiler (kotlinc) takes files with the .kt extendion as input and generates bytecode as .class files.
- At this point, the .class files are equivalent to Java .class files, and the JVM can run them.
- However, when running Kotlin applications, you need the KOTLIN RUNTIME LIBRARY, in addition to JRE.
So, the Kotlin compiler compiles .kt into -class files, which contain bytecode.
- The .class files can be on the JVM, exactly like class files generated from Java code.
- When distributing a Kotlin application, you have to distribute the Kotlin runtime library and the JRE for application run.

![Default Imports](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/java-kotlin-compile.png)

- [Does the Kotlin compiler compile java files?](https://stackoverflow.com/questions/49602284/does-the-kotlin-compiler-compile-java-files)

Scala and Kotlin do not get compiled to Java, that would, in that case, need three phases of compilation to be able to run the program, 
first - compile to Java, 
second - compile to bytecode, 
third - JIT compile to machine code.


## [The Kotlin Standard LIBRARY](https://kotlinlang.org/api/latest/jvm/stdlib/index.html)

The Kotlin Standard Library provides living essentials for everyday work with Kotlin. These include:

- Higher-order functions implementing idiomatic patterns (let, apply, use, synchronized, etc).
- Extension functions providing querying operations for collections (eager) and sequences (lazy).
- Various utilities for working with strings and char sequences.
- Extensions for JDK classes making it convenient to work with files, IO, and threading.

Packages
- [Package kotlin](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/index.html) : Core functions and types, available on all supported platforms. 
- [Package kotlin.annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/index.html) : Library support for the Kotlin annotation facility. | 
- [Package kotlin.collections](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html) : Collection types, such as [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html#kotlin.collections.Iterable), [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html#kotlin.collections.Collection), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html#kotlin.collections.List), [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html#kotlin.collections.Set), [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html#kotlin.collections.Map) and related top-level and extension functions.
- [Package kotlin.comparisons](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.comparisons/index.html) : Helper functions for creating Comparator instances.
- [Package kotlin.concurrent](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/index.html) : Utility functions for concurrent programming.
- ...
- [Package kotlin.io](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/index.html) : IO API for working with files and streams.
- [Package kotlin.js](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.js/index.html) : Functions and other APIs specific to the JavaScript platform.

![Default Imports](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/defaultimports.PNG)

- [Kotlin](https://kotlinlang.org/)
- [Kotlin 1.3 Released](https://kotlinlang.org/docs/reference/whatsnew13.html)
- [Introducing Kotlin support in Spring Framework 5.0](https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0)

## Declaration

| Kotlin | description | automatic generate |
| -------| ------- |
| val | The variable is immutable as final in Java, can be assigned only one time | get |
| var | The variable can be assigned more than one time, keep same reference | only get |

```
val number: Int
val number = 1
val number: Int = 1 (It is not normal in Kotlin)
val number: Short = 1 (It is OKAY)

var number: Int
```

- class

Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/declarations/Declaration.kt)

```
class Employee(var name: String, val id : Int) { ... }

val employee15 = Employee("Agitec AS", 21)
employee15.name = "Agitec"
employee15 = Employee("Bjørn", 1) (It is not OKAY because employee15 is final)
```

## Type Aliases
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/declarations/alias/Declaration.kt)

- Use for [generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html) types
- @kotlin.SinceKotlin public typealias StringBuilder = java.lang.StringBuilder

## Kotlin String class
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/declarations/Declaration.kt)

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
Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/equality)

| Java | Kotlin |
| ----- | ----- |
| == | === referencial 	//REFERENCIAL |
| equals | == or equals 	//STRUCTURAL EQUALITY |

## Bit operator and casting
Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/bitoperatorcasting)

| Java | Kotlin |
| ----- | ----- |
| Employeej newEmployee = (Employeej) employeeOne; | val newEmployee = employeeOne as Employee |

Java: |, &, ^ 		<=>		Kotlin: or, and, xor

## String template
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/stringtemplate/Declaration.kt)

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
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/rowstrings/Declaration.kt)


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

## @JvmStatic annotation
kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section03/learnprograming/helloworld)

- @JvmStatic annotation can also be applied on 
1. a property of an object or 
2. a companion object making its getter and setter methods be static members in that object or the class containing the companion object.
2.1 [Companion object in Kotlin](https://medium.com/@agrawalsuneet/companion-object-in-kotlin-5251e03d6423)
2.2 [Calling Kotlin from Java](https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#static-methods)

```
@Target([AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER]) annotation class JvmStatic
```

- Specifies that an additional static method needs to be generated from this element if it's a function. 
- If this element is a property, additional static getter/setter methods should be generated.

#### Static Methods
- [Why and when to use @JvmStatic with companion objects?](https://stackoverflow.com/questions/48780003/why-and-when-to-use-jvmstatic-with-companion-objects)
- As mentioned above, Kotlin represents package-level functions as static methods. 
- Kotlin can also generate static methods for functions defined in named objects or companion objects if you annotate those functions as @JvmStatic. 
- If you use this annotation, the compiler will generate both a static method in the enclosing class of the object and an instance method in the object itself. 

For example:

```
class C {
    companion object {
        @JvmStatic fun foo() {}
        fun bar() {}
    }
}
```

Now, foo() is static in Java, while bar() is not:

```
C.foo(); // works fine
C.bar(); // error: not a static method
C.Companion.foo(); // instance method remains
C.Companion.bar(); // the only way it works
```

Same for named objects:

```
object Obj {
    @JvmStatic fun foo() {}
    fun bar() {}
}
```

In Java:

```
Obj.foo(); // works fine
Obj.bar(); // error
Obj.INSTANCE.bar(); // works, a call through the singleton instance
Obj.INSTANCE.foo(); // works too
```

##### Exercise
1. Declare two immutable String variables called hello1 and hello2. Assign "Hello" to both variables.

```
    val hello1 = "Hello"
    val hello2 = "Hello"
```

2. Using one line of code, test whether hello1 and hello2 are referentially equal and print the result

```
    println("hello1 is referentially equal to hello2: ${hello1 === hello2}")
```

3. Using one line of code, test whether hello1 and hello2 are structurally equal and print the result.

```
    println("hello2 is structurally equal to hello2: ${hello1 == hello2}")
```

4. Declare a mutable variable of type Int and assign it the value 2988.

```
    var num = 2988
```

5. Declare an immutable variable of type Any and assign to it the string "The Any type is the root of the Kotlin class hierarchy". Then, using a smart cast, print out the uppercased string.

```
    val text: Any = "The Any type is the root of the Kotlin class hierarchy"
    if (text is String) {
        println(text.toUpperCase())
    }
```

6. Using one line of code, print out the following. Make sure your code is nicely indented:

```
    //    1
    //   11
    //  111
    // 1111
	
    println("""   1
             |  11
             | 111
             |1111""".trimMargin())
```
