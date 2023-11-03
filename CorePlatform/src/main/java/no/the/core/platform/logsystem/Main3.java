package no.the.core.platform.logsystem;

import java.io.IOException;
import java.util.logging.*;

public class Main3 {

    static Logger logger = Logger.getLogger("no.java.core.platform");

    public static void main(String ... args) throws IOException {

        FileHandler h = new FileHandler("%h/myapp_%g.log",1000,4);
        Formatter f = new SimpleFormatter();
        h.setFormatter(f);

        logger.addHandler(h);
        logger.setLevel(Level.INFO);
        logger.log(Level.INFO, "We are Logging!");

    }

}
