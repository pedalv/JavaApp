package no.agitec.fagaften.mars.kotlin.section04.datatypes.nullreferences.javacode;

public class NullReferences {

    public static void main(String[] args) {
        String str = null;
        str.toUpperCase();
        /*
        Exception in thread "main" java.lang.NullPointerException
	    at
	    no.agitec.fagaften.mars.kotlin.section4.datatypes.nullreferences.javacode.NullReferences.main(NullReferences.java:7)
         */
    }


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
     */





}
