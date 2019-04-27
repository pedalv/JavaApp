package no.agitec.fagaften.mars.kotlin.section05.singletons


import java.time.Year

fun main(args: Array<String>) {

    println(CompanyCommunications.getTagLine())
    // Our company rocks!
    println(CompanyCommunications.getCopyrightLine())
    // Copyright © 2019 Our Company. All rights reserved.
}

object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}


