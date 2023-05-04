package no.dfo.whatsnewinjava.module.security;

import javax.security.auth.x500.X500Principal;
import sun.security.x509.X500Name;
//error: package sun.security.x509 is not visible
//package sun.security.x509 is declared in module java.base, which does not export it to the unnamed module
//--add-exports=java.base/sun.security.x509=ALL-UNNAMED --add-exports=java.base/sun.security.pkcs=ALL-UNNAMED --add-exports=java.base/sun.security.util=ALL-UNNAMED
//Module: 'CloudComputing.whats-new-in-java.main'	--add-exports java.base/sun.security.x509=ALL-UNNAMED



import java.io.IOException;

/**
 * old
 * - javax.security.cert.Certificate
 * - javax.security.cert.X509Certificate
 * new
 * - java.security.cert.Certificate
 * - java.security.cert.X509Certificate
 *
 * Migrating a Classpath-based Application
 * javac -cp $CLASSPATH ...
 * java -cp $CLASSPATH ..
 * Unless ...
 * 1. You use JDK types that have been encapsulated
 * 2. You use types from non-default Java modules
 *
 * Modules == Encapsulated
 * "unnamed" module
 * java.base module
 *
 * $ /java1.8/bin/javac Main.java
 *   Main.java:1: warning: X500Name is internal proprietary API and may be
 *   removed in a future release
 *   import sun.security.x509.X500Name;
 *
 * $ /java9/bin/java Main
 *
 * -
 *
 * $ /java9/bin/javac Main.java
 * Main.java:1: error: package sun.security.x509 is not visible
 * import sun.security.x509.X500Name
 * (package sun.security.x509 is declared in module java.base, which
 *  does not export it to the unnamed module)
 * 1 error
 *
 * -
 * $ /java1.8/bin/javac Main.java
 * $ /java9/bin/java --illegal-access=deny Main
 * Exception in thread "main" java.lang.IllegalAccessError: class Main (in
 * unnamed module @0x7b3300e5) cannot access class
 * sun.security.x509.X500Name (in module java.base) because module
 * java.base does not export sun.security.x509 to unnamed module
 * @0x7b3300e5
 *
 *
 * Exception in thread "main" java.lang.IllegalAccessError: class no.dfo.whatsnewinjava.module.langandlib.MainSecurity
 * (in unnamed module @0x5a07e868) cannot access class sun.security.x509.X500Name
 * (in module java.base) because module java.base does not export sun.security.x509 to unnamed module @0x5a07e868
 * 	at no.dfo.whatsnewinjava.module.langandlib.MainSecurity.main(MainSecurity.java:38)
 *
 * -
 *
 * java --illegal-access=permit Main
 * javac --add-exports java.base/sun.security.x509=ALL-UNNAMED Main.java
 * java --add-exports java.base/sun.security.x509=ALL-UNNAMED Main
 *
 * -
 *
 * jdeps -jdkinternals Main.class
 *  jdeps -jdkinternals .\build\classes\java\main\no\dfo\whatsnewinjava\module\security\MainX500Name.class
 *
 * Warning: C:\Java\jdk1.8.0_281\jre\lib\ext\bcpkix-jdk15on-1.70.jar is a multi-release jar file.
 * All versioned entries are analyzed. To analyze the entries for a specific
 * version, use a newer version of jdeps (JDK 9 or later) "--multi-release" option.
 * Warning: C:\Java\jdk1.8.0_281\jre\lib\ext\bcprov-jdk15on-1.70.jar is a multi-release jar file.
 * All versioned entries are analyzed. To analyze the entries for a specific
 * version, use a newer version of jdeps (JDK 9 or later) "--multi-release" option.
 * MainSecurity.class -> C:\Java\jdk1.8.0_281\jre\lib\rt.jar
 *    no.dfo.whatsnewinjava.module.langandlib.MainSecurity (MainSecurity.class)
 *       -> sun.security.x509.X500Name                         JDK internal API (rt.jar)
 *
 * Warning: JDK internal APIs are unsupported and private to JDK implementation that are
 * subject to be removed or changed incompatibly and could break your application.
 * Please modify your code to eliminate dependency on any JDK internal APIs.
 * For the most recent update on JDK internal API replacements, please check:
 * https://wiki.openjdk.java.net/display/JDK8/Java+Dependency+Analysis+Tool
 *
 * JDK Internal API                         Suggested Replacement
 * ----------------                         ---------------------
 * sun.security.x509.X500Name               Use javax.security.auth.x500.X500Principal @since 1.4
 *
 * -
 *
 * https://intellij-support.jetbrains.com/hc/en-us/community/posts/5153987456018-Java-17-cannot-access-class-sun-security-pkcs-PKCS7
 *
 * JEP 396: Strongly Encapsulate JDK Internals by Default
 * https://openjdk.org/jeps/396
 *
 *
 * sun.security.x509.X500Name - Private - you should not use - is not export
 * Java 8 - okay
 * Java 9 - doest not exist
 * Javac src/Main.java
 * java -cp src Main === IllegalAccessError
 * jdeps -jdkinternals src/Main.class
 * sun.security.x509.X500Name => javax.security.auth.x500.X500Principal === using non-default module
 *
 * Solution:
 * javac --add-exports java.base/sun.security.x509=ALL-UNNAMED Main.java
 * javac --add-exports java.base/sun.security.x509=ALL-UNNAMED Main
 *
 * okay: 1. You use JDK types that have been encapsulated
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
public class MainX500Name {

    public static void main(String... args) throws IOException {
        X500Name name = new X500Name("CN=user");
        System.out.println(name);

        sun.security.x509.X500Name name2 = new sun.security.x509.X500Name("test.com","test", "test","US");
        System.out.println(name2);

        //javac -d out MainX500Name.java - error med Java 9+
        //javac -add-exports java.base/sun.security.x509=ALL-UNNAMED -d out MainX500Name.java - okay with WARN but nonono
        //java -cp out MainX500Name - okay
        //java --illegal-access=deny -cp MainX500Name - error
        //java -add-exports java.base/sun.security.x509=ALL-UNNAMED --illegal-access=deny -cp MainX500Name - Okay
        //but solutin is use jdeps
        //jdeps -jdkinternals out/.../MainX500Name.class

    }

}
