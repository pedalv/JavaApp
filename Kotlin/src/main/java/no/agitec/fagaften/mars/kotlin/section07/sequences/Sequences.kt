package no.agitec.fagaften.mars.kotlin.section07.sequences


fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(
            1 to Car("green", "Toyota", 2015),
            2 to Car("red", "Ford", 2016),
            3 to Car("silver", "Honda", 2013),
            17 to Car("red", "BMW", 2015),
            8 to Car("green", "Ford", 2010))
    //[red, green]
    println(  immutableMap
            .filter { it.value.model == "Ford"}
            .map { it.value.color })
    println(" --0-- ")

    println(  immutableMap.asSequence()
                    .filter { it.value.model == "Ford"}
                    .map { it.value.color })
    //kotlin.sequences.TransformingSequence@4f933fd1
    println(" --1-- ")

    println(  immutableMap.asSequence()
            .filter { it.value.model == "Ford"}
            .map { it.value.color }
            .toList())
    //[red, green]
    println(" --2-- ")

    listOf("Mary", "Jane", "Joe")
            .asSequence()
            .filter { println("filtering $it"); it[0] == 'J'}
            .toList()
            //mapping Jane      //filtering JANE

            .map { println("mapping $it"); it.toUpperCase() }
            //.toList()
            //mapping Jane  //filtering JANE

            //.find { it.endsWith('E') }
            //filtering Mary
            //filtering Jane     //mapping Jane
    println(" --3-- ")

    listOf("Jane", "Mary", "Joe")
            .asSequence()
            .map { println("mapping $it"); it.toUpperCase() }
            //.toList()
            // mapping Mary
            // mapping Jane
            // mapping Joe

            .filter { println("filtering $it"); it[0] == 'J'}
            //.toList()
            //mapping Jane  //filtering JANE
            //mapping Mary  //filtering MARY
            //mapping Joe   //filtering JOE

            .find { it.endsWith('E') }
            //mapping Jane     //filtering JANE
    println(" --4-- ")
}

data class Car(val color: String, val model: String, val year: Int) {

}