package no.dfo.whatsnewinjava.module.security;

//import javax.xml.bind.DatatypeConverter;
//error: package javax.xml.bind does not exist


/**
 * Solution for Java 9 and 10:
 * javac --add-modules java.xml.bind Main.java
 * java --add-modules java.xml.bind Main
 * or
 * Java --add-modules java.se.ee Main //6 modules
 *
 * -
 *
 * jdeps -jdkinternals .\build\classes\java\main\no\dfo\whatsnewinjava\module\security\MainDatatypeConverter.class
 *
 * Warning: C:\Java\jdk1.8.0_281\jre\lib\ext\bcpkix-jdk15on-1.70.jar is a multi-release jar file.
 * All versioned entries are analyzed. To analyze the entries for a specific
 * version, use a newer version of jdeps (JDK 9 or later) "--multi-release" option.
 * Warning: C:\Java\jdk1.8.0_281\jre\lib\ext\bcprov-jdk15on-1.70.jar is a multi-release jar file.
 * All versioned entries are analyzed. To analyze the entries for a specific
 * version, use a newer version of jdeps (JDK 9 or later) "--multi-release" option.
 *
 * $ jdeps Main.class
 * Main.class -> java.base
 * Main.class -> not found
 *  <unnamed> -> java.lang java.base
 *  <unnamed> -> javax.xml.bind not found
 *
 * -
 *
 * Solution for Java 11+
 * Java 11 package javax.xml.bind does not exist [duplicate]
 * https://stackoverflow.com/questions/52502189/java-11-package-javax-xml-bind-does-not-exist
 *
 * According to the release-notes, Java 11 removed the Java EE modules:
 *
 * java.xml.bind (JAXB) - REMOVED
 * Java 8 - OK
 * Java 9 - DEPRECATED
 * Java 10 - DEPRECATED
 * Java 11 - REMOVED
 *
 * javax.xml.bind.DatatypeConverter;
 * Java 8 - okay
 * Java 9 - doest not exist === using non-default module
 *
 * Solution:
 * javac --add-modules java.xml.bind MainDatatypeConverter.java
 * java --add-modules java.xml.bind MainDatatypeConverter
 * java --add-modules java.se.ee MainDatatypeConverter === import the 6 packages
 * jdeps src/Main.class
 * - unnamed module for java.lang - java.base
 * - unnamed module for javax.xml.bind - not found
 *
 * okay: 2. You use types from non-default Java SE modules
 *
 * List of using non-default module
 * - java.transaction
 * - java.annotations.common
 * - java.xml.bind
 * - java.xml.ws
 * - java.corba
 * - java.activation
 *
 */
public class MainDatatypeConverter {

    public static void main(String... args) {
        //DatatypeConverter.parseBase64Binary("SGVsbG8gd29ybGQh");
        //java 9 and 10:
        //- javac --add-modules java.xml.bind Main.java
        //- java --add-modules java.xml.bind Main
        //java 11+
        //-add tree libraries to pom or gradle file
    }

}
