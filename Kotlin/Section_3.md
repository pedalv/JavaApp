# Section 3: Basic Differences Between Kotlin and Java

## Compile a Kotlin application
- The Kotlin compiler (kotlinc) takes files with the .kt extendion as input and generates bytecode as .class files.
- At this point, the .class files are quivalent to Java .class files, and the JVM can run them.
- However, when running Kotlin applications, you need the KOTLIN RUNTIME LIBRARY, in addition to JRE.
So, the Kotlin compiler compiles .kt into -class files, which contain nytecode.
- The .class files can be on the JVM, exactly like class files generated from Java code.
- When distributing a Kotlin application, you have to distribute the Kotlin runtime library and the JRE for application run.

## The Kotlin Standard LIBRARY
- [Kotlin](https://kotlinlang.org/)
- [Kotlin 1.3 Released](https://kotlinlang.org/docs/reference/whatsnew13.html)
- [Kotlin Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/index.html)
![Default Imports](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/defaultimports.PNG)
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
class Employee(var name: String, val id : Int) {

}

val employee15 = Employee("Pedro Alves", 15)
employee15.name = "PA"
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