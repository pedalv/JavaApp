package no.agitec.fagaften.mars.kotlin.section05.interfaces

//
interface MyInterface {

    val number: Int
    val number2: Int
        get() = number * 100

    fun myFunction(str: String): String

}

interface MySubInterface: MyInterface {

    fun mySubFunction(num: Int): String

}

//
open class Something : MySubInterface {

    override val number: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun myFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mySubFunction(num: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

//
open class Something2 : MyInterface {

    override fun myFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val number: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}

//
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





