package no.the.core.platform.execenvironment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

    public static void main (String ... args) {

        //showArgsPassed(args);
        //passFilenameViaArgs(args);

        try {
            //PropertiesFromResource.storeProperties();
            //PropertiesFromResource.loadproperties();
            //PropertiesFromResource.storeXML();
            PropertiesFromResource.loadXML();
        } catch (IOException e) {
            System.out.println("Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage());
            e.printStackTrace();
        }

        /*
            https://www.jetbrains.com/help/idea/2016.1/configuring-module-dependencies-and-libraries.html?origin=old_help#add_existing_lib
            https://netbeans.org/kb/74/java/project-setup.html#projects-classpath
         */

        environmentInformation();
    }


    private static void environmentInformation() {

        //System Property
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        String osArchitecture = System.getProperty("os.arch");
        String javaVender = System.getProperty("java.vendor");
        String javaClassPath = System.getProperty("java.class.path");
        //getClassLoader.getURLs()


        //Environment Variables
        Map<String, String> all = System.getenv();
        String compName = System.getenv("COMPUTERNAME");
        String sysRoot = System.getenv("SystemRoot");


    }

    private static void passFilenameViaArgs(String[] args) {
        if(args.length == 0) {
            ExerciseCmdLine.showUsage();
            return;
        }

        String filename = args[0];
        if(!Files.exists(Paths.get(filename))) {
            System.out.println("\n File not found: " + filename);
            return;
        }
        ExerciseCmdLine.showFileLines(filename);
    }

    /*
        cmd: java no.the.core.platform.execenvironment.Main "file 1 cmd.txt" Hello there world

        https://www.jetbrains.com/help/idea/creating-and-editing-run-debug-configurations.html
        http://netbeans.tusharjoshi.com/2009/02/using-command-line-arguments-in.html
    */
    private static void showArgsPassed(String[] args) {
        if(args.length < 1)
        {
            System.out.println("No arguments provided");
        } else {
            for(String word: args)
                System.out.println(word);
        }
    }

}
