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
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section07/maps)

```
val immutableMap = mapOf<Int, Car>(
		1 to Car("green", "Toyota", 2015),
		2 to Car("red", "Ford", 2016),
		3 to Car("silver", "Honda", 2013))

println(immutableMap.javaClass) //class java.util.LinkedHashMap


val immutableMap2 = mutableMapOf<String, Car>(
		"John's car" to Car("red", "Range Rover", 2010),
		"Jane's car" to Car("blue", "Hyundai", 2012))
println(immutableMap2.javaClass) //class java.util.LinkedHashMap

val mutableMap = hashMapOf<String, Car>(
		"John's car" to Car("red", "Range Rover", 2010),
		"Jane's car" to Car("blue", "Hyundai", 2012))
println(mutableMap.javaClass) //class java.util.HashMap
println(mutableMap)
//{
// John's car=no.agitec.fagaften.mars.kotlin.section07.maps.Car@7f560810,
// Jane's car=no.agitec.fagaften.mars.kotlin.section07.maps.Car@69d9c55
// }
mutableMap.put("Mary's car", Car("red", "Corvette", 1965))

for ((k, v) in mutableMap) {
	println(k)
	//Mary's car
	//...
	println(v)
	//no.agitec.fagaften.mars.kotlin.section07.maps.Car@7f560810
	//...
}
```

- Destructuring declaration
```
val pair = Pair(10, "ten")
- Two Declarations
//val firstValue = pair.first
//val secondValue = pair.second
- Destructuring declaration
    val (firstValue, secondValue) = pair
println(firstValue) // 10
println(secondValue) // ten
```

```
val car = Car("blue", "Corvette", 1959)
val (color, model, year) = car
//color = blue, model = Corvette, and year = 1959
println("color = $color, model = $model, and year = $year")
}

class Car(val color: String, val model: String, val year: Int) {

    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}
//variables must be public
```

## Sets

```
val setInts = setOf(10, 15, 19, 5, 3, -22) //immutable
println(setInts.plus(20)) //[10, 15, 19, 5, 3, -22, 20]
println(setInts.plus(10)) //[10, 15, 19, 5, 3, -22]
println(setInts.minus(19)) //[10, 15, 5, 3, -22]
println(setInts.minus(100)) //[10, 15, 19, 5, 3, -22]
println(setInts.average()) //5.0
println(setInts.drop(3)) //[5, 3, -22] // drop the 3 first elements from the set

val mutableInts = mutableSetOf(1, 2, 3, 4, 5)
mutableInts.plus(10)
println(mutableInts) //[1, 2, 3, 4, 5]
}
```

## Collections Functions

```
val setInts = setOf(10, 15, 19, 5, 3, -22) //immutable
println(setInts.filter { it % 2 != 0 }) //odds: [15, 19, 5, 3]

val ints = arrayOf(1, 2, 3, 4, 5)
val add10List = ints.map { it + 10 } // map function
println(add10List.javaClass) // class java.util.ArrayList
println(add10List) //[11, 12, 13, 14, 15]
```

```
val mutableMap = mutableMapOf<Int, Car>(
	1 to Car("green", "Toyota", 2015),
	2 to Car("red", "Ford", 2016),
	3 to Car("silver", "Honda", 2013))

mutableMap.filter { it.value.color == "silver"}
println("The filters map is $mutableMap") //do nothing
//The filters map is {
// 1=Car(color=green, model=Toyota, year=2015),
// 2=Car(color=red, model=Ford, year=2016),
// 3=Car(color=silver, model=Honda, year=2013)
// }
```

```
val immutableMap = mapOf<Int, Car>(
	1 to Car("green", "Toyota", 2015),
	2 to Car("red", "Ford", 2016),
	3 to Car("silver", "Honda", 2013),
	17 to Car("red", "BMW", 2015),
	8 to Car("green", "Ford", 2010))

println(immutableMap.filter { it.value.year == 2016 }) //{2=Car(color=red, model=Ford, year=2016)}
println(immutableMap.toSortedMap()) //Sorted by key
//{
// 1=Car(color=green, model=Toyota, year=2015),
// 2=Car(color=red, model=Ford, year=2016),
// 3=Car(color=silver, model=Honda, year=2013),
// 8=Car(color=green, model=Ford, year=2010),
// 17=Car(color=red, model=BMW, year=2015)
// }

println(immutableMap.all { it.value.year > 2014 }) //false
println(immutableMap.any { it.value.year > 2014 }) //true
println(immutableMap.count { it.value.year > 2014 }) //3

val cars = immutableMap.values
println(cars.find { it.year > 2014 }) //Car(color=green, model=Toyota, year=2015)
println(cars.groupBy { it.color })
//{
// green=[
// Car(color=green, model=Toyota, year=2015),
// Car(color=green, model=Ford, year=2010)
// ],
// red=[
// Car(color=red, model=Ford, year=2016),
// Car(color=red, model=BMW, year=2015)
// ],
// silver=[Car(color=silver, model=Honda, year=2013)
// ]
// }
println(cars.sortedBy { it.year })
//[
// Car(color=green, model=Ford, year=2010),
// Car(color=silver, model=Honda, year=2013),
// Car(color=green, model=Toyota, year=2015),
// Car(color=red, model=BMW, year=2015),
// Car(color=red, model=Ford, year=2016)
// ]

println(immutableMap.filter { it.value.model == "Ford"}.map { it.value.color }) //[red, green]
println(immutableMap.map { it.value.year }) //[2015, 2016, 2013, 2015, 2010]
```

## Sequences

- Sequences is like Streams in Java
- Filter return a collections of objects
- When you do not know how big is the collections will return is a good pattern use sequences

```
val immutableMap = mapOf<Int, Car>(
	1 to Car("green", "Toyota", 2015),
	2 to Car("red", "Ford", 2016),
	3 to Car("silver", "Honda", 2013),
	17 to Car("red", "BMW", 2015),
	8 to Car("green", "Ford", 2010))
//[red, green]
println(  immutableMap
	.filter { it.value.model == "Ford"}
	.map { it.value.color })

println(  immutableMap
	.asSequence()
	.filter { it.value.model == "Ford"}
	.map { it.value.color })
//kotlin.sequences.TransformingSequence@4f933fd1


println(  immutableMap.asSequence()
	.filter { it.value.model == "Ford"}
	.map { it.value.color }
	.toList())
//[red, green]
```

- Streams was introduced in Java 8, however Android do not support Java 8 yet
- Kotlin introduced Sequences and as result of it, kotlin is very used in Android (, server side, database, ...)
- asSequences is only use for large collections
-- Intermedia sequence return other sequence
-- Terminal operation not return a sequence
- filter -> map -> terminate => order matter if it is not a sequence

## Generics

```
fun main(args: Array<String>) {

    //val list2: MutableList = mutableListOf("Hello")
    /*
    Kotlin: One type argument expected for interface MutableList<E>
     */

    val list = mutableListOf("Hello")
    list.add("another string")
    printCollectionS(list)
    printCollectionG(list)
    list.printCollection()
    //Hello
    //another string
   
    val bdList = mutableListOf(
            BigDecimal(-33.45),
            BigDecimal(3503.99),
            BigDecimal(0.329))
    printCollectionG(bdList)
    bdList.printCollection()
    //-33.4500000000000028421709430404007434844970703125
    //3503.989999999999781721271574497222900390625
    //0.329000000000000014654943925052066333591938018798828125
}
```

```
//Extended function
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}

//Top leval function
fun <T> printCollectionG(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

fun printCollectionS(collection: List<String>) {
    for (item in collection) {
        println(item)
    }
}
```

## Generics: Functions and Erasure


 
 






















