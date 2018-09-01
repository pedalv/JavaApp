package no.book.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Directories {
    public static Path getResourcePath(Class<?> resourceClass, String resourceName) throws URISyntaxException {
        URL url = resourceClass.getResource(resourceName);
        return Paths.get(url.toURI());
    }

    public static URL getURLFile(String name) {
        InputStream inputStream =  ClassLoader.getSystemResourceAsStream(name);
        System.out.println(inputStream);
        URL url = ClassLoader.getSystemResource("no/book/AssessmentTest/q03/birds.dat");
        System.out.println(url);

        return url;
    }

    public static String getAbsolutePathFile(String pathname) {
        // C:\Space2\JavaApp\OCP\OCP\source

        File openFile = new File(pathname);
        System.out.println(openFile.getAbsolutePath());
        // C:\Space2\JavaApp\OCP\OCP\source\src\main\resources\no\book\AssessmentTest\q03\birds.dat
        try {
            System.out.println(openFile.getCanonicalPath());
            // C:\Space2\JavaApp\OCP\OCP\source\src\main\resources\no\book\AssessmentTest\q03\birds.dat
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(openFile.getName()); // birds.dat
        System.out.println(openFile.length()); // 28

        return openFile.getAbsolutePath();
    }

    public static String GettingCurrentWorkingDirectory() {
        String current = null;
        try {
            current = new File( "." ).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Current dir:"+current);
        String currentDir = System.getProperty("user.dir");
        // C:\Space2\JavaApp\OCP\OCP\source
        System.out.println("Current dir using System:" +currentDir);
        // C:\Space2\JavaApp\OCP\OCP\source

        return current;
    }
}
