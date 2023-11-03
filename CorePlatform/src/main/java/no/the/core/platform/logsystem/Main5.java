package no.the.core.platform.logsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
/c/Workspace/JavaApp/CorePlatform
javac src/main/java/no/the/core/platform/logsystem/Main5.java

java -Djava.util.logging.config.file=log.properties -cp src/main/java no/the/core/platform/logsystem/Main5
We are Logging!,no.the.core.platform.logsystem.Main5 main,INFO



 */
public class Main5 {

    static Logger pkglogger = Logger.getLogger("no.the.core.platform.logsystem");
    static Logger logger = Logger.getLogger("no.the.core.platform.logsystem.Main5");

    public static void main(String ... args) {

        logger.entering("no.the.core.platform.logsystem","Main5");
        logger.log(Level.INFO, "We are Logging!");
        logger.exiting("no.the.core.platform.logsystem","Main5");



    }
}
