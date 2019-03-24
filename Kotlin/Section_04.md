# Section 4: Data Types and Null Reference Handling
- Everthing is a class 
- => So primitives as in Java do not exist
- => boolean , byte , char , short , int , long , float and double. 
- There is no lower case in Kotlin
- => so data types is represent by wrapper classes. 
- => In the java.lang package java provides a separate class for each of the primitive data types namely 
- => Boolean, Byte, Character, Short, Integer, Long, Float, and Double.

![Primitive Data Types](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/primitive-data-types.PNG)

Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section04/datatypes)

| Java | kotlin |
| ----- | ----- |
| int myInt = 10 | val myInt = 10 |
| Long myLong = myInt | var myLong = myInt.toLong() |
|  |  |
| byte myByte = 111 | val myByte: Byte = 111 |
| short myShort = myByte | var myShort: Short = myByte.toShort() |
|  |  |
| double myDouble = 65.984 | var myDouble = 65.984 => It is as Java |
|  |  |
| float myFloat = 838.8492f | val myFloat = 838.8492f |
| double myDouble = myFloat | val myDouble = myFloat.toDouble() |
|  |  |
| char myChar = 65 | val myCharInt = 65 (myCharInt.toChar()) |
|  |  |
|  | val anything: Any |
|  |  |
| void myMethod() {} | fun myMethod() {} (It return a singleton Unit instance) |
|  |  |
|  | fun fail(message: String): Nothing { throw IllegalArgumentException(message) } |

## Any

Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section04/datatypes/nullreferences) og [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section04/datatypes/primitive/DataTypes.kt)

```
public open class Any public constructor() {
    public open operator fun equals(other: kotlin.Any?): kotlin.Boolean { /* compiled code */ }

    public open fun hashCode(): kotlin.Int { /* compiled code */ }

    public open fun toString(): kotlin.String { /* compiled code */ }
}

fun myMethod() {}
```

## Nothing

Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section04/datatypes/primitive/DataTypes.kt)

Use for a method return a infinit loop for exemple

```
public final class Nothing private constructor() {
}


fun fail(message: String) : Nothing { throw IllegalArgumentException(message)
}

fun infinitLoop() :  Nothing { for (;;) }
```

## Arrays

Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section04/datatypes/arrays/DataTypes.kt) og [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section04/datatypes/arraysnullreferences/Nullreferences.kt)

```
val names = arrayOf("John", "Jane", "Jill", "Joe")

val longs1 = arrayOf(1L, 2L, 3L)
val longs2 = arrayOf<Long>(1, 2, 3, 4)
val longs3 = arrayOf(1, 2, 3, 4)
println(longs1 is Array<Long>) //true
println(longs2 is Array<Long>) //true
println(longs3 is Array<Int>) //true
println(longs1[2]) //3

val evenNumbers = Array(16) { i -> i * 2 }
for (number in evenNumbers) {
	print(" " + number)
}
//0  2  4  6  8  10  12  14  16  18  20  22  24  26  28  30

val lotsOfNumbers = Array(100000) { i -> i + 1 }

val allZeroes = Array(100) { 0 } // i -> 0

var someArray: Array<Int>
someArray = arrayOf(1, 2, 3, 4)
for (number in someArray) {
	print(" " + number)
}
// 1 2 3 4

someArray = Array(6) { i -> (i + 1) * 10 }
for (number in someArray) {
	print(" " + number)
}
//10 20 30 40 50 60

val mixedArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
for (element in mixedArray) {
	print(" " + element)
}
//hello 22 10.5 a
println(mixedArray is Array<Any>) //true

val myIntArray = intArrayOf(3, 9, 434, 2, 33)
DummyClass().printNumbers(myIntArray)
//3 9 434 2 33

var someOtherArray = IntArray(5)
for (number in someOtherArray) {
	print(" " + number)
}
//0 0 0 0 0

DummyClass().printNumbers(evenNumbers.toIntArray()) //Array<Int> to Int
//0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30

val convertedIntArray = myIntArray.toTypedArray() //Int to Array<Int>
DummyClass().printNumbers(convertedIntArray.toIntArray())
//3 9 434 2 33
```

## Null Refrences

Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section04/datatypes/nullreferences)

```
val str: String? = "This is not null"
```

| Java | kotlin |
| ----- | ----- |
| if(str != null) { str.toUpperCase() } | str?.toUpperCase() |
| if ( str != null ) { printText(str) } | str?.let { printText(it) } |

?. - Save operator as == (equal)

```
val str : String? = null
val anotherStr = "This isn't nullable"
println(str == anotherStr) //false
```


Java: 

```
if( bankBranch != null ) {
	Address address = bankBranch.getAddress();
	if( address != null ) {
		Country country = address.getCountry();
		if( country != null) {
			String countryCode = country.getCountryCode();
		}
	}
} 
```

Kotlin:	

```
val countryCode : String? = bankBranch?.address?.country?.countryCode |
val whatever = bankBranch?.address?.country ?: "US"
```

?: - Elvis operator


Kotlin:	

```
val str5: String? = "This isn't null"
val str51 = str5!!.toUpperCase() // !! : val will not be null for sure
if( str5 == null) {
	throw Exception()
} else {
	str5.toUpperCase()
}
```

!! - assertion 
!! - val will not be null for sure

```
val str1 : String? = null 		//Line 1
val str2  = str1!!				//Line 2
val str3 = str2.toUpperCase()	//Line 3
/*
Exception in thread "main" kotlin.KotlinNullPointerException
at
no.agitec.fagaften.mars.kotlin.section4.datatypes.nullreferences.kotlincode.NullReferencesKt.main(NullReferences.kt:2)

EXCEPTION IS IN LINE 2 (NOT IN LINE 3)
 */

```

Note: 
- verbose is need for check many variables are not null to do some thing as in Java.
- ?. Save operator 
- or ?: Elvis oparator does not help here 

```    
if( str1 != null && str2 != null ... && strn != null) {
	//Do some thing
}
```    

##






























