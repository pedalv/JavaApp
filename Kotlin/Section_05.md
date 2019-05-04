# Section 5: OO and Kotlin: Classes, Functions, Inheritace

## Access Modifiers

#### Top-Levels Items
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/accessmodifiers/AccessModifiers.kt)

![Access Modifiers](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/toplevels.PNG)

| Java | kotlin |
| ----- | ----- |
| Only class a top level | class, function and properties |
| class name must match with file name and only allow one public class | can have several public class and file name can be different from class name |
| class can not be private | class can be private because refere to file |
| - | internal is visible on the same model. The model: is a group of files that compile together and is only possible have a model in project |
| classes can not see private members belong to inner classes | classes can see private members belong to inner classes |
| private field has get and set | private property(field) has not get and set |

Note:  JVM 
- Private is compile to private package
- Internal is compile to public package

#### Class member level
- public, protected, private
- if a class A is public and has a field b declared intern => it mean the field B is visible in the same model 

```
public class A {
	internal int b;
}
```

- if a class A is private and has a field b declared intern => it mean the field B is visible in the same file 

```
private class A {
	internal int b; 
	//Internal is use for other items/models see the property outside the file. 
	// So it is not make any sence declare property internal when the class is private.
}
```

- [Class Thread in Java has 8 constuctors however in kotlin can has only one](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)
- Classes in kotlin are public and final by default

#### Class
Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/classesconstructor)

- Code below is very verbose
- Primary constuctor: constructor with one parameters declare outside
- Secondary constructor: all contructores that is not declared outside

```
class EmployeeVerbose constructor(firstName: String) {

    //Long way
    val firstName: String

    //It is not a constructor
    //It is the body for the primary constructor
    //It is possible to have many inits blocks
    init {
        this.firstName = firstName
    }

    //Short way
    //val firstName: String = firstName

}
```

#### data class A 
- data class has default implementstions of toString, equals, hasCode, copy methods
- parameters must have val or var 
- data class can be abstract, seal or inner classes

#### Functions
Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/functions)

- functions with {...}: block body

```
fun labelMultiplyLong(operand1: Int, operand2: Int, label: String) : String {
    return ("$label ${operand1 * operand2}")
}

fun main(args: Array<String>) : Unit = 
	println(labelMultiply(label = "Here's the result:", operand2 = 3, operand1 = 4))
	//Here's the result: 12
}
```

- function without {...}: expression body
- parameters must have type annotation always 

```
fun labelMultiply(operand1: Int, operand2: Int, label: String = "The answer is:") =
        "$label ${operand1 * operand2}"

fun main(args: Array<String>) = 
	println( labelMultiply(operand1 = 3, operand2 = 4) )
	//The answer is: 12
```

```
// name arguments
fun labelMultiplyLong2(operand1: Int, operand2: Int, label: String) =
        "$label ${operand1 * operand2}"
		
fun main(args: Array<String>) {
    println( labelMultiply(label = "Here's the result:", operand2 = 3, operand1 = 4) )
	//Here's the result: 12
}
```

- Extended functions

```
=> Kotlin with Extended functions

fun String.upperFirstAndLast2(): String {
    val upperFirst = substring(0, 1).toUpperCase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

val s = "this is all in lowercase"
println(s.upperFirstAndLast2()) //This is all in lowercasE
```

```
=> Java does not have Extended functions

val s = "this is all in lowercase"
println(Utils().upperFirstAndLast(s)) //This is all in lowercasE
println(upperFirstAndLast(s)) //This is all in lowercasE

fun upperFirstAndLast(str: String): String {
    val upperFirst = str.substring(0, 1).toUpperCase() + str.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

class Utils {

    fun upperFirstAndLast(str: String): String {
        val upperFirst = str.substring(0, 1).toUpperCase() + str.substring(1)
        return upperFirst.substring(0, upperFirst.length - 1) +
                upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
    }

}
```


#### vararg
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/functions/Functions.kt)

- vararg parameter_name : type (Ony one vararg per method)

```
data class Car(val color: String, val model: String, val year: Int) {

}
	
fun printColors(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}

fun main(args: Array<String>) {
	val car1 = Car("blue", "Toyota", 2015)
    val car2 = Car("red", "Ford", 2016)
    val car3 = Car("grey", "Ford", 2017)

	printColors(car1, car2, car3)
	//blue
    //red
    //grey
	
	var numbers = arrayOf(1, 2, 3)
	//public inline fun <reified @kotlin.internal.PureReifiable T> arrayOf(vararg elements: T): kotlin.Array<T> { /* compiled code */ }

	val manyCars = arrayOf(car1, car2, car3)
    printColors(*manyCars)
    //blue
    //red
    //grey
	
	val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()
    
	val lotsOfCars = arrayOf(*manyCars, *moreCars, car4)
	for (c in lotsOfCars) {
        println(c)
    }
    //Car(color=blue, model=Toyota, year=2015)
    //Car(color=red, model=Ford, year=2016)
    //Car(color=grey, model=Ford, year=2017)
    //Car(color=red, model=Ford, year=2016)
    //Car(color=grey, model=Ford, year=2017)
    //Car(color=red, model=Ford, year=2016)
	
	val lotsOfCars2 = arrayOf(manyCars, moreCars, car4)
    for (c in lotsOfCars2) {
        println(c)
    }
    //[Lno.agitec.fagaften.mars.kotlin.section5.functions.Car;@35fb3008
    //[Lno.agitec.fagaften.mars.kotlin.section5.functions.Car;@7225790e
    //Car(color=red, model=Ford, year=2016)   
}
```

#### Inline functions
Inlining works better for functions with parameters of functional types as lambda expression, or refined parameters with generics.

Inlining for regulat functions has not impact in performances.

function body will be directed generated into the byte code rader the function is call.

```
inline fun labelMultiply2Inline(operand1: Int, 
				operand2: Int,
				label: String = "The answer is:") =
				"$label ${operand1 * operand2}"
```

| keyword | description |
| -------| ------- |
| inline | Expected performance impact of inlining 'inline fun labelMultiply2Inline(operand1: Int, operand2: Int, label: String = "The answer is"): String defined in  no.agitec.fagaften.mars.kotlin.section05.functions' can be insignificant. Inlining works best for functions with lambda parameters.  |


#### Inheritance
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/inheritance/Printer.kt)

| Java | Kotlin |
| -------| ------- |
| public (by default) | public final (by default for classes, top level functions, member functions and properties)  |


- open
- abstract
- override

```
fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("Brother 1234")
    laserPrinter.printModel()
    // The model name of this 'laser printer' is Brother 1234

    //Step 6:
    val laserPrinter6 = LaserPrinter6("Brother 1234")
    laserPrinter6.printModel()
    //The model name of this 'printer' is Brother 1234
}

//Step 6:
/*open*/ abstract class Printer6(val modelName: String) {
    fun printModel() = println("The model name of this 'printer' is $modelName")
}
// Kotlin: 'modelName' hides member of supertype 'Printer5' and needs 'override' modifier
class LaserPrinter6(modelName: String) : Printer6(modelName) {

}

// Step final:
/*open*/ abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this 'printer' is $modelName")
    abstract fun bestSellingPrice(): Double

}

open class LaserPrinter(modelName: String): Printer(modelName) {

    final override fun printModel() = println("The model name of this 'laser printer' is $modelName")
    override fun bestSellingPrice(): Double = 129.99

}
```

| keyword | description |
| -------| ------- |
| open | for inheritance |
| open abstract | Modifier 'open' is redundant because 'abstract' is present |
| override | 'printModel()' hides member of supertype 'Printer' and needs 'overide' modifier |
| open data | modifier 'open/data' is incompatible with 'data/open' |

#### Interfaces
Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/interfaces/PrinterInterfaces.kt)

| case | description |
| -------| ------- |
| val number2 : Int = 50 | Property initializers are not allowed in interfaces |
| val number2 : Int  get() = 50 | WORKS |
| val number2 : Int  get() = field * 100 | Property in an interface cannot have a backing field |

```
interface MyInterface {

    val number: Int
    val number2: Int
        get() = number * 100

    fun myFunction(str: String): String

}

interface MySubInterface: MyInterface {

    fun mySubFunction(num: Int): String

}

open class Printer {

}

class LaserPrinter : Printer, MyInterface {

    constructor() : super()

    override val number: Int = 25
    override val number2: Int = 25

    override fun myFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
```

#### Object keyword
For define a class and a final instance at the same time 

| Kotlin | description |
| -------| ------- |
| class | public final |
| object | public static final |

The three user cases for Object keyword are:
1. Singletons

Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/object/singletons/CompanyCommunications.kt)

- A single instance of the class exists and we get that instance using getInstance static method. 

```
object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}
```

2. Companion object

Kode: [here](https://github.com/pedalv/JavaApp/tree/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/object/companion)

- The same class in the Kotlin, the private static instance and the managerInstance property, will be moved to companion object.

- It is not possible access privateVar outside the class.
| Kotlin | Java |
| -------| ------- |
| get and set is not available | implements get and set |
|

NB:
- for have the same behaviour as in Kotlin like in JAVA it is need change CLASS to OBJECT to have only one instance

| Kotlin | description |
| -------| ------- |
| class | public final |
| object | public static final |
| companion object | public static final |


```
object SomeClassKotlinFix2 {
    /*
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")
    }
   */
    companion object SomeCompanion { // Modifier 'companion' is not applicable inside 'object'
        private var privateVar = 6

        fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")
    }
}
```

3. Object expressions (Anonyimous objects)

Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/object/expressions/AnonymousObjects.kt)

```

fun main(args: Array<String>) {

    var thisIsMutable = 45

    /**
     * SomeInterface is not singletons
     */
    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int)  = "This is from mustImplement: ${num * 100}"
    })
    println(thisIsMutable)
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface ${si.mustImplement(22)}")
}
```

#### Enum

Kode: [here](https://github.com/pedalv/JavaApp/blob/master/Kotlin/src/main/java/no/agitec/fagaften/mars/kotlin/section05/enums/CompanyCommunications.kt)

```
fun main(args: Array<String>) {
    println(Department.ACCOUNTING.getDeptInfo())
}

enum class Department(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 5),
    IT("Information Technology", 10),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 20)
	;// KOTLIN HAVE SEMI COLUMN FOR ENUMMMMMMMMMMMMMMMMMMMMMMMMMMM

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}
```

#### Imports

Kode: [here]()

- Since the file name does not match the class file name so we do not need follow the directory structure.
- It means that the package is not need for prevent the same file name is located on same location/directory.
 














