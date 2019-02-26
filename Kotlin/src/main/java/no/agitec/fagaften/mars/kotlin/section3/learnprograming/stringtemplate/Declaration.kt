package no.agitec.fagaften.mars.kotlin.section3.learnprograming.stringtemplate

fun main(args: Array<String>)  {

    val employee1 = Employeek("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    println(employee1) //Employeek(name='Lynn Smith', id=500)

    val change = 4.22
    println("Your change is $") //Your change is $
    println("Your change is $change") //Your change is 4.22
    println("Your change is $$change") //Your change is $4.22
    println("Your change is \$change") //Your change is $change

    val numerator = 10.99
    val denominator = 20.00
    println("The value of $numerator divided by $denominator is ${numerator/denominator}")
    //The value of 10.99 divided by 20.0 is 0.5495

    println("The employee's id is ${employee1.id}") //The employee's id is 500
}

class Employeek(var name: String, val id : Int) {

    override fun toString(): String {
        return "Employeek(name='$name', id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employeek

        if (name != other.name) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }
}
