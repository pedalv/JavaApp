package no.dfo.com.pluralsight;

import sun.security.x509.X500Name;
//Add '--add-exports java.base/sun.security.x509=ALL-UNNAMED' to module compiler options

public class Legacy {

    public static void main(String... args) throws Exception {
        X500Name name = new X500Name("test.com", "test", "test", "US");
        System.out.println(name);
    }

}
