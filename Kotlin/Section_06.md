# Section 6: Loops, and the if, When, and Try/Catch Expressions

## Loops in Kotlin
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section06/forloop/Loops.kt)

| loop | Java vs kotlin |
| ----- | ----- |
| for | different |
| when | same |

- this form of 'for( int i = 0; i < 10; i++) {...}' does not exist in Kotlin
- for loops in Kotling use a [ranges](https://kotlinlang.org/docs/reference/ranges.html#ranges)
- A Range is interval that has a start and a end
- You can use a range in a for loop and assign them to variables
- A range is inclusive and comparable [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html), charRange, stringRange, osv
- [Package kotlin.ranges](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/index.html)
- [until](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/until.html)

```
val range = 1..5 // 1 2 3 4 5 
val charRange = 'a'..'z' 
val stringRange = 'ABC'..'XYZ'

println(3 in range) //true
println('c' in charRange) //true
println("CCC" in stringRange) //true
println("CCCCCC" in stringRange) //true
println("ZZZZZZ" in stringRange) //false

val backWardRange = 5.downTo(1)
println(5 in backWardRange) //true
val backWard_Range = 5..1 // 
println(5 in backWard_Range) //false : 5 is in start -> true && 5 is in end -> true && 5 is not bigger than last element -> false

val stepRange = 3..15
val stepThree = stepRange.step(3) 

val reversedRange = range.reversed() 
``` 
- 'range.reversed()' works for intRange or charRange. 
   Other type of objects need implement comparable, because the compile can not know or figure out what the program want.
- [Using ranges](https://kotlinlang.org/docs/reference/basic-syntax.html#using-ranges)

#### for loop

| loop | Java | kotlin |
| ----- | ----- |----- |
| for | for(int i = 1; i < 6; i++) { System.out.println(i);} | for(i in 1..5) { println(i) } |

```
val stringRange = "ABD".."XYZ"
//Error:(58, 15) Kotlin: For-loop range must have an 'iterator()' method
for (s in stringRange) {
	println(s)
}
```

- for loop : it is for intRange and charRange, for stringRange (closedRange) there are less options 
- [intRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html) => has many options
- [charRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-char-range/index.html) => has many options
- [stringRange -closed-range](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/index.html) => has less options
- [Loops on ranges](https://kotlinlang.org/docs/reference/coding-conventions.html#loops-on-ranges)

###### for loop with ranges

```
for (i in 1..20 step 4) {
	println(i)
}
//1
//5
//9
//13
//17

for (i in 20 downTo 5) {
	println(i)
}
//20
//19
//18
//17
//16
//15
//14
//13
//12
//11
//10
//9
//8
//7
//6
//5

for (i in 20 downTo 10 step 5) {
	println(i)
}
//20
//15
//10

for (i in 1 until 4) {
 println (i) 
}
//1
//2
//3

val s = "goodbye"
val sRange = 0..s.length
println(s) //goodbye
println(sRange) //0..7
println(sRange.first) //0
println(sRange.last) //7
```

###### for loop with arrays

```
val seasons = arrayOf("spring", "summer", "winter", "fall")
for (index in seasons.indices) {
	println("${seasons[index]} is season number $index")
}
//spring is season number 0
//summer is season number 1
//winter is season number 2
//fall is season number 3

seasons.forEach { 
	println(it) 
}
//spring
//summer
//winter
//fall

seasons.forEachIndexed { index, value -> println("$value is season number $index")}
//spring is season number 0
//summer is season number 1
//winter is season number 2
//fall is season number 3
```

#### if expression
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section06/ifexpression/IfExpression.kt)

| Java | kotlin |
| ----- |----- |
| int num = someCondition ? 50 : 592; | val num = if(someCondition) 50 else 592 |

```
val someCondition = 20 < 22
num = if(someCondition) 50 else 592
```

```
println("The result of the if expression issssss ${if (someCondition) {
	println(" --0.1.1-- ")
	println("somethinggggg")
	50
	println(" --0.1.2-- ")
}
else {
	println(" --0.2.1-- ")
	println("something else")
	592
	println(" --0.2.2-- ")
}}")
// --0.1.1--
//somethinggggg
// --0.1.2--
//The result of the if expression issssss kotlin.Unit
```

```
val x = if (someCondition) {
	println("something")
}
else {
	println("something else")
}
println(x) //kotlin.Unit
println(x.javaClass) //class kotlin.Unit

val num2 = if (someCondition) {
	println("something")
	50
}
else {
	println("something else")
	100
}
println(num2) //50
```

```    
Error: Kotlin: 'if' must have both main and 'else' branches if used as an expression
    
val numError = if (someCondition) {
	println("something")
	50
}

//okay
if (someCondition) {
	println("something")
}
```

```
val x = if (someCondition) {
	println("something")
}
else {
	println("something else")
}
println(" --2-- ")

println(x) //kotlin.Unit
println(x.javaClass) //class kotlin.Unit
println(" --3-- ")

val num2 = if (someCondition) {
	println("something")
	50
}
else {
	println("something else")
	100
}
println(num2) //50
println(num2.javaClass) //int
```

#### when loop
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section06/whenexpression/WhenExpression.kt)



## try/catch expressions
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section06/)
