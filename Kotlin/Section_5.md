# Section 5: OO and Kotlin: Classes, Functions, Inheritace

## Access Modifiers

#### Top-Levels Items
![Access Modifiers](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/toplevels.PNG)

| Java | kotlin |
| ----- | ----- |
| Only class a top level | class, function and properties |
| class name must match with file name and only allow one public class | can have several public class and file name can be different from class name |
| class can not be private | class can be private beacause refere to file |
| - | internal is visible on the same model |
| - | model is a group of files that compile together and is only possible have a model in project |
| classes can not see privete members belong to inner classes | classes can see privete members belong to inner classes |
| private field has get and set | private property(field) has not get and set |

Note:  JVM 
- Private is compile to private package
- Internal is compile to public package

#### Class member level
- public, protected, private
- if a class A is public and has a property B declared intern => it mean the property B is visible in the same model 

'''
public class A {
	internal int b;
}
'''

- if a class A is private and has a property B declared intern => it mean the property B is visible in the same file 

'''
private class A {
	internal int b; 
	//Internal is use for other items/models see the property outside the file. 
	// So it is not make any sence declare property internal when the class is private.
}
'''

- [Class Thread in Java has 8 constuctors](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)
- Classes in kotlin are public and final by default

#### Class
- Code below is very verbose
- Primary constuctor: constructor with one parameters declare outside
- Secondary constructor: all contructores that is not declared outside

'''
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
'''