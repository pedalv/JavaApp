package no.agitec.fagaften.mars.kotlin.section07.lambdas.withreceivers

fun main(args: Array<String>) {

    val employees = listOf(Employee("John", "Smith", 2012),
            Employee("Jane", "Wilson", 2015),
            Employee("Mary", "Johnson", 2010),
            Employee("Mike", "Jones", 2002))

    findByLastName(employees, "Wilson")
    //Yes, there's an employee with the last name Wilson
    //Nope, there's no employee with the last name Wilson
    println("  --1-- ")
    findByLastName1(employees, "Wilson")
    findByLastName2(employees, "Wilson")
    //Yes, there's an employee with the last name Wilson
    println("  --2-- ")
    findByLastName(employees, "Smithson")
    //Nope, there's no employee with the last name Smithson
    println("  --3-- ")
    findByLastName1(employees, "Smithson")
    findByLastName2(employees, "Smithson")
    //Nope, there's no employee with the last name Smithson
    println("  --4-- ")
    //Nope, there's no employee with the last name Smithson

    "Some String".apply somestring@ {
        "Another String".apply {
            println(toLowerCase())
            println(this@somestring.toUpperCase())
        }
    }
    //another string
    //SOME STRING
    println("  --3-- ")


}

// No local return : return from lambda and function at same time
fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@ {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return@returnBlock
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

// Local return : Return from lambda or function
fun findByLastName2(employees: List<Employee>, lastName: String) {
    employees.forEach {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

fun findByLastName1(employees: List<Employee>, lastName: String) {
    for(employee in employees) {
        if (employee.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}



data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}
