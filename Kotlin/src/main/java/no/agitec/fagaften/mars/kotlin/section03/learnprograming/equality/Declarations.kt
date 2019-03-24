package no.agitec.fagaften.mars.kotlin.section03.learnprograming.equality

fun main(args: Array<String>)  {

    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)
    println(employeeOne == employeeTwo) //false //STRUCTURAL EQUALITY
    println(employeeTwo == employeeThree) //true //STRUCTURAL EQUALITY
    println(employeeOne.equals(employeeTwo) ) //false //STRUCTURAL EQUALITY
    println(employeeTwo.equals(employeeThree)) //true //STRUCTURAL EQUALITY


    //STRUCTURAL EQUALITY
    println(employeeOne === employeeTwo) //false //REFERENCIAL
    println(employeeTwo === employeeThree) //false //REFERENCIAL
    println(employeeOne == employeeTwo) //false //STRUCTURAL EQUALITY
    println(employeeTwo == employeeThree) //true //STRUCTURAL EQUALITY

    val employeeFour = employeeTwo
    println(employeeFour === employeeTwo) //true

    println(employeeFour != employeeTwo) //false //STRUCTURAL EQUALITY
    println(employeeFour !== employeeTwo) //false //REFERENCIAL
    println(employeeTwo != employeeThree) //false //STRUCTURAL EQUALITY
    println(employeeTwo !== employeeThree) //true //REFERENCIAL

}

class Employee(var name: String, val id : Int) {

    override fun equals(obj: Any?): Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }

        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }


}


