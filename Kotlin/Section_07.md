# Section 7: Lambda Expressions, Collections, and Generics

## Lambda Expressions Basics
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

- Lambda Expressions and Collections

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
