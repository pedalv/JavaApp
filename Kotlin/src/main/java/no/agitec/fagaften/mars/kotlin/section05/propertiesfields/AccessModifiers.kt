package no.agitec.fagaften.mars.kotlin.section05.propertiesfields

fun main(args: Array<String>) {

    var emp4 = Employee2("name", false)
    println(emp4.firstName) //Jane
    println(emp4.fullTime) //false // Error:(31, 18) Kotlin: Cannot access 'fullTime': it is private in 'Employee2'
    println(" -0- ")

    val emp = Employee("John")
    println(emp.firstName)
    //John
    emp.fullTime = false
    //Running the custom set
    println(emp.fullTime)
    //Running the custom get
    //false
    println(" -1- ")

    val emp2 = Employee("Joe")
    println(emp2.firstName) //Joe
    println(emp2.fullTime)
    //Running the custom get
    //true
    println(" -2- ")

    val emp3 = Employee("Jane", false)
    println(emp3.firstName) //Jane
    println(emp3.fullTime)
    //Running the custom get
    //false
    println(" -3- ")


}

class Employee(val firstName: String, fullTime: Boolean = true){

    var fullTime = fullTime //get and set methods for free //custom get and set must be on next lines
        get() {
            println("Running the custom get")
            return field
        }
        set(value) {
            println("Running the custom set")
            field = value
        }

}


class Employee2(val firstName: String, /*private*/ var fullTime: Boolean = true){


}
