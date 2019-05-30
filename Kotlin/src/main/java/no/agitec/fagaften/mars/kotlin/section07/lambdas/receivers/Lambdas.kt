package no.agitec.fagaften.mars.kotlin.section07.lambdas.receivers

fun main(args: Array<String>) {

    println(countTo100())
    //1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100
    println("  --1-- ")

    val employees = listOf(Employee("John", "Smith", 2012),
            Employee("Jane", "Wilson", 2015),
            Employee("Mary", "Johnson", 2010),
            Employee("Mike", "Jones", 2002))

    findByLastName(employees, "Wilson")
    findByLastName(employees, "Smithson")
    //Yes, there's an employee with the last name Wilson
    //Nope, there's no employee with the last name Wilson
    //Nope, there's no employee with the last name Smithson
    println("  --2-- ")

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

fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@ {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return@returnBlock
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

fun countTo100() =
        StringBuilder().apply() {
            for (i in 1..99) {
                append(i)
                append(", ")
            }
            append(100)
        }.toString()

fun count2To100() =
        with(StringBuilder()) {
            for (i in 1..99) {
                append(i)
                append(", ")
            }
            append(100)
            toString()
        }


fun count3To100(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}
