package no.the.core.platform.execenvironment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesFromResource {

    static void storeXML() throws IOException {
        Properties props = new Properties();
        props.setProperty("displayName","Pedro Alves");
        props.setProperty("accountNumber", "123-45-6-789");

        try(OutputStream out = Files.newOutputStream(Paths.get("xyz.xml"))) {
            props.storeToXML(out,"Mycomment");
        }
    }

    static void loadXML() throws IOException {
        //loadFromXML();
        //usingDefaultProperties();
        loadDefaultProperties();
        //LoadStoreFromXMLFiles();
    }

    private static void loadDefaultProperties() throws IOException {
        Properties defaultProps = new Properties();
        /*
        // inputStream is null
        try(InputStream inputStream = PropertiesFromResource.class.getResourceAsStream("MyDefaultValues.xml")) {
                defaultProps.loadFromXML(inputStream);
            }
        */
        /*
        // static not have this
        try(InputStream inputStream = this.getClass().getResourceAsStream("MyDefaultValues.xml")) {
                defaultProps.loadFromXML(inputStream);
            }
        */
        try(InputStream inputStream = Files.newInputStream(Paths.get("MyDefaultValues.xml"))) {
            defaultProps.loadFromXML(inputStream);
        }
        Properties userProps = new Properties(defaultProps);
        loadUserProps(userProps);

        String welcomeMessage = userProps.getProperty("welcomeMessage");
        String farewellMessage = userProps.getProperty("farewellMessage");

        System.out.println(welcomeMessage);
        System.out.println(farewellMessage);

        if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
            userProps.setProperty("welcomeMessage", "Welcome back");
            userProps.setProperty("farewellMessage", "Things will be familiar now");
            userProps.setProperty("isFirstRun", "N");
            saveUserProps(userProps);
        }
    }

    private static void usingDefaultProperties() {
        Properties defaultProps = new Properties();
        defaultProps.setProperty("position","1");
        Properties props = new Properties(defaultProps);
        String nextPos = props.getProperty("position"); //1 default
        int iPos = Integer.parseInt(nextPos);
        props.setProperty("position",Integer.toString(++iPos));
        nextPos = props.getProperty("position"); //2
    }

    private static void LoadStoreFromXMLFiles() throws IOException {
        Properties defaultProps = new Properties();
        Properties userProps = new Properties(defaultProps);
        defaultProps = loadUserProps(userProps);
        defaultProps.setProperty("displayName","Pedro Alves");
        defaultProps.setProperty("accountNumber", "123-45-6-789");

        String welcomeMessage = userProps.getProperty("welcomeMessage");
        String farewellMessage = userProps.getProperty("farewellMessage");

        System.out.println(welcomeMessage);
        System.out.println(farewellMessage);

        if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
            userProps.setProperty("welcomeMessage", "Welcome back");
            userProps.setProperty("farewellMessage", "Things will be familiar now");
            userProps.setProperty("isFirstRun", "N");
            saveUserProps(userProps);
        }

        try(OutputStream out = Files.newOutputStream(Paths.get("MyDefaultValues.xml"))) {
            defaultProps.storeToXML(out,"Mycomment");
        }
    }

    private static void saveUserProps(Properties userProps) throws IOException {
        try(OutputStream outputStream = Files.newOutputStream(Paths.get("userValues.xml"))) {
            userProps.storeToXML(outputStream, null);
        }
    }

    private static Properties loadUserProps(Properties userProps) throws IOException{
        Path userFile = Paths.get("userValues.xml");
        if(Files.exists(userFile)) {
            try(InputStream inputStream = Files.newInputStream(userFile)) {
                userProps.loadFromXML(inputStream);
            }
        }

        return userProps;
    }

    private static void loadFromXML() throws IOException {
        Properties props = new Properties();

        try(InputStream in = Files.newInputStream(Paths.get("xyz.xml"))) {
            props.loadFromXML(in);
        }

        String displayName = props.getProperty("displayName");
        System.out.println("displayName: " +displayName);
    }

    static void loadproperties() throws IOException {

        Properties props = new Properties();

        try(Reader reader = Files.newBufferedReader(Paths.get("myapp.properties"))) {
            props.load(reader);
        }

        String displayName = props.getProperty("displayName");
        System.out.println(displayName);
        String val1 = props.getProperty("val1");
        System.out.println(val1);
        String val2 = props.getProperty("val2");
        System.out.println(val2);
        String val3 = props.getProperty("val3");
        System.out.println(val3);
        String val4 = props.getProperty("val4");
        System.out.println(val4);
        String val5 = props.getProperty("val5");
        System.out.println(val5);
    }

    static void storeProperties() throws IOException {

        Properties props = new Properties();
        props.setProperty("displayName","Pedro Alves");
        props.setProperty("accountNumber", "123-45-6-789");


        try(Writer writer = Files.newBufferedWriter(Paths.get("xyz.properties"))) {
            props.store(writer,"Mycomment");
        }
    }

}
