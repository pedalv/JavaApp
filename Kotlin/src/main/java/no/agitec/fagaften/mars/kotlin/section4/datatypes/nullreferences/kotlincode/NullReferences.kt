package no.agitec.fagaften.mars.kotlin.section4.datatypes.nullreferences.kotlincode


fun main(args: Array<String>) {

    //val strnull: String = null
    /*
    Error:(6, 27) Kotlin: Null can not be a value of a non-null type String
     */

    val str: String? = null
    //val str4 = str!!.toUpperCase()
    /*
    Exception in thread "main" kotlin.KotlinNullPointerException
	at no.agitec.fagaften.mars.kotlin.section4.datatypes.nullreferences.kotlincode.NullReferencesKt.main(NullReferences.kt:7)
     */
    if(str != null) { //it is not use in kotlin => str?.toUpperCase()
        str.toUpperCase()
    }

    val str4 = str?.toUpperCase() //less verbose in kotlin

    println("What happens when we do this: ${str?.toUpperCase()}")
    //What happens when we do this: null

    if(str == null) {
        null
    } else {
        str.toUpperCase()
    }

    println(" -1- ")
    val str2 = str ?: "This is the default value"
    println(str2) //This is the default value
    println(" -2- ")

    /*
        //JAVA
        if( bankBranch != null ) {
            Address address = bankBranch.getAddress();
            if( address != null ) {
                Country country = address.getCountry();
                if( country != null) {
                    String countryCode = country.getCountryCode();
                }
            }
        }

        //Kotlin
        val countryCode : String? = bankBranch?.address?.country?.countryCode

        val whatever = bankBranch?.address?.country ?: "US"

        if( country == null) {
            whatever = "US"
        } else {
            whatever = country
        }
     */

    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String //cast a Array of Any to String - no no no
    println(str3) //null
    println(" -3- ")

    println(str3?.toUpperCase())
    println(" -4- ") //null
}