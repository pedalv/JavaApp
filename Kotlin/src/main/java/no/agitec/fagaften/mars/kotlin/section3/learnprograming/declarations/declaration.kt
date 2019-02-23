package no.agitec.fagaften.mars.kotlin.section3.learnprograming.helloworld.declarations

fun main(args: Array<String>)  {

    var number: Int
    number = 10;
    number = 20

    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1]) //Jane

    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"
    employee1.name.length

    val employee2: Employee
    val number2 = 100

    if (number < number2) {
        employee2 = Employee("Jane Smith", 400)
    }
    else {
        employee2 = Employee("Mike Watson", 150)
    }
}

class Employee(var name: String, val id : Int) {

}
