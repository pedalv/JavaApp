package no.dfo.whatsnewinjava.finalization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.Cleaner;

/**
 * Finalization: clean up external resources of object holds
 *     @Override
 *     protected void finalize() {
 *         // Clean up here
 *     }
 *
 * JEP 421: Deprecate Finalization for Removal
 * https://openjdk.org/jeps/421
 *
 * Try-with-resources tutorial
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
 *
 * JavaDoc of Cleaner
 * https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/ref/Cleaner.html
 */
public class MainFinalization {

    public static void main(String... args) {


        //alternative 1: try-with-resources
        try(FileInputStream s = new FileInputStream("HELP.md")) {
            // Use S
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //alternative 2: Cleaner API - java.lang.ref.Cleaner
        Cleaner cleaner = Cleaner.create();
        cleaner.register(new byte[0], () -> {});


    }




}
