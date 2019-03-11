# Section 5: OO and Kotlin: Classes, Functions, Inheritace

## Access Modifiers

#### Top-Levels Items
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
fun labelMultiply(operand1: Int, operand2: Int,
                  label: String = "The answer is:") =
        "$label ${operand1 * operand2}"

fun main(args: Array<String>) = 
	println(labelMultiply(operand1 = 3, operand2 = 4))
	//The answer is: 12

-

//name arguments
fun labelMultiplyLong2(operand1: Int, operand2: Int, label: String) =
        "$label ${operand1 * operand2}"
		
fun main(args: Array<String>) {
    println(labelMultiply(label = "Here's the result:", operand2 = 3, operand1 = 4))
	//Here's the result: 12
}
```


#### varargs
- varargs parameter_name : type (Ony one vararg per method)

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
