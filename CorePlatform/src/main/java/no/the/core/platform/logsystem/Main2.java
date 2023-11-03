package no.the.core.platform.logsystem;

import java.util.logging.*;

public class Main2 {

    //C:\Users\niamh\AppData\Local\Temp
    static Logger logger = Logger.getLogger("no.java.core.platform");

    public static void main(String ... args) {

        Handler h = new ConsoleHandler();
        Formatter f = new SimpleFormatter();
        h.setFormatter(f);
        logger.addHandler(h);
        logger.setLevel(Level.INFO);
        logger.log(Level.INFO, "We are Logging!");
    }

}
