package no.agitec.fagaften.mars.kotlin.section5.constantsdataclass

val MY_CONSTANT = 100

fun main(args: Array<String>) {

    println(MY_CONSTANT) //100


    val car = Car("blue", "Toyota", 2015)
    println(car) //Car(color=blue, model=Toyota, year=2015)
    val car2 = Car("blue", "Toyota", 2015)
    println(car == car2) //true
    val car3 = car.copy()
    println(car3) //Car(color=blue, model=Toyota, year=2015)
    val car4 = car.copy(year = 2016, color = "green")
    println(car4) //Car(color=green, model=Toyota, year=2016)

    val emp = Employee("John")
    println(emp) //no.agitec.fagaften.mars.kotlin.section5.constantsdataclass.Employee@34b7bfc0
    val emp2 = Employee("John")
    println(emp == emp2) //false

}

data class Car(val color: String, val model: String, val year: Int) {

}

class Employee(val firstName: String, fullTime: Boolean = true){

    var fullTime = fullTime
        get() {
            println("Running the custom get")
            return field
        }
        set(value) {
            println("Running the custom set")
            field = value
        }

}



