package no.agitec.fagaften.mars.kotlin.section05.`object`.expressions


fun main(args: Array<String>) {

    var thisIsMutable = 45

    /**
     * SomeInterface is not singletons
     */
    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int)  = "This is from mustImplement: ${num * 100}"
    })
    println(thisIsMutable)
    println(" --1-- ")

    /**
     * SomeInterface is not singletons
     */
    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int): String {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            thisIsMutable++
            return "This is from mustImplement: ${num * 100}"
        }
    })
    println(thisIsMutable)
    println(" --1-- ")

}


interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface ${si.mustImplement(22)}")
}
