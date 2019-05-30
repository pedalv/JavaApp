# Section 7: Lambda Expressions, Collections, and Generics

## Lambda Expressions Basics
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section07/lambdas)

-(Standard.kt)[https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/src/kotlin/util/Standard.kt]
- The brand function

```
/**
 * Calls the specified function [block] and returns its result.
 */
@kotlin.internal.InlineOnly
public inline fun <R> run(block: () -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}
```

- The function

```
fun topLevel() = println("I'm in a function!")
```

- [Member references and reflection](https://kotlinlang.org/docs/tutorials/kotlin-for-py/member-references-and-reflection.html)
- Call The brand function  'run { lambda }' and function 'run( not lambda)'

```
run { println("I'm in a lambda!") }
//I'm in a lambda!

run(::topLevel)
//I'm in a function!
```

- member referances

```
var num = 10
run {
	num += 15
	println(num) // 25
}

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num) //member reference can only be read
        // num++ :  Kotlin: Val cannot be reassigned
    }
}
```

## Lambda Expressions and Collections

```
val employees = listOf(
	Employee("John", "Smith", 2012),
	Employee("Jane", "Wilson", 2015),
	Employee("Mary", "Johnson", 2010),
	Employee("Mike", "Jones", 2002))

println(employees.minBy { e -> e.startYear} )
println(employees.minBy { e: Employee -> e.startYear} )
println(employees.minBy { it.startYear} )
println(employees.minBy ({ e -> e.startYear}) )
println(employees.minBy(Employee::startYear)) //member reference
//Employee(firstName=Mike, lastName=Jones, startYear=2002)
```

## Lambda Expressions with Receivers

```
- Block Body

fun countTo100(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}
```


- With

```
/**
 * Calls the specified function [block] with the given [receiver] as its receiver and returns its result.
 */
@kotlin.internal.InlineOnly
public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return receiver.block()
}
```

```
- Expression body: when the function return only a value

fun countTo100() =
	with(StringBuilder()) {
		for (i in 1..99) {
			append(i)
			append(", ")
		}
		append(100)
		toString()
	}
```

```
- Apply

fun countTo100() =
    StringBuilder().apply() {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
    }.toString()
```	

```	
"Some String".apply somestring@ {
	"Another String".apply {
		println(toLowerCase())
		println(this@somestring.toUpperCase())
	}
}
//another string
//SOME STRING
```	

```	
- No local return : return from lambda and function at same time
fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@ {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return@returnBlock
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

findByLastName(employees, "Wilson")
//Yes, there's an employee with the last name Wilson
//Nope, there's no employee with the last name Wilson
```	

```	
- Local return : Return from lambda or function
fun findByLastName2(employees: List<Employee>, lastName: String) {
    employees.forEach {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

findByLastName2(employees, "Wilson")
//Yes, there's an employee with the last name Wilson
```	

```	
fun findByLastName1(employees: List<Employee>, lastName: String) {
    for(employee in employees) {
        if (employee.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

findByLastName1(employees, "Wilson")
//Yes, there's an employee with the last name Wilson
```	

## Collections
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section07/collections)

- [Kotlin Collections Overview](https://kotlinlang.org/docs/reference/collections-overview.html)

- Collection: Read - Allows to sequentially access the elements, ie, an immutable object (unchangeable object) is an object whose state cannot be modified after it is created.

```	
public interface Collection<out E> : Iterable<E> { ... }
```	

- MutableCollection: Read/Write - Provides the ability to add, modify and remove elements while iterating (mutable).

```	
public interface MutableCollection<E> : Collection<E>, MutableIterable<E> { ... }
```	

## LIST is immutable in Kotlin (class java.util.Arrays$ArrayList), ie, an immutable object (unchangeable object) is an object whose state cannot be modified after it is created.
    
```
val emptyList = emptyList<String>()
println(emptyList.javaClass) //class kotlin.collections.EmptyList

val notNullList = listOfNotNull("hello", null, "goodbye")
println(notNullList) //[hello, goodbye]

val arraylist = arrayListOf(1, 2, 4)
println(arraylist.javaClass) //class java.util.ArrayList

val mutableList = mutableListOf<Int>(1, 2, 3)
println(mutableList.javaClass) //class java.util.ArrayList

println(mutableList[2]) //3
mutableList[1] = 20
println(mutableList) //[1, 20, 3]

val array = arrayOf("black", "white", "green")
println(array.toList()) //[black, white, green]
println(listOf(array)) //[[Ljava.lang.String;@29ee9faa]
println(listOf(*array)) //[black, white, green]

val ints = intArrayOf(1, 2, 3)
println(ints.toList()) //[1, 2, 3]
```

## Kotlin Collections Functions

```
val strings = listOf("spring", "summer", "fall", "summer", "winter")
val colorList = listOf("black", "white", "red", "black", "red")

println(strings.last()) //winter
println(strings.asReversed()) //[winter, summer, fall, summer, spring]

val ints = listOf(1, 2, 3, 4, 5)
println(ints.max())//5
println(colorList.zip(strings)) //[(black, spring), (white, summer), (red, fall), (black, summer), (red, winter)]

val mergedLists = listOf(colorList, strings)
println(mergedLists) //[[black, white, red, black, red], [spring, summer, fall, summer, winter]]

val combinedList = colorList + strings
println(combinedList) //[black, white, red, black, red, spring, summer, fall, summer, winter]

val noDupsList = colorList.union(strings)
println(noDupsList) //[black, white, red, spring, summer, fall, winter]

val noDupColors = colorList.distinct()
println(noDupColors) //[black, white, red]
```

## Maps and Destructuring Declarations

```

```

























