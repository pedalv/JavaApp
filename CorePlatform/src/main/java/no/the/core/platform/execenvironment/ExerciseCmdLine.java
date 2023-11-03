package no.the.core.platform.execenvironment;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExerciseCmdLine {

    static void showFileLines(String filename) {
        System.out.println();

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line = null;
            while((line = reader.readLine()) != null)
                System.out.println(line);
        } catch(Exception ex) {
            System.out.println(ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
    }

    static void showUsage() {
        System.out.println();
        System.out.println("Please provide the filename to process on the command line");
    }

}
