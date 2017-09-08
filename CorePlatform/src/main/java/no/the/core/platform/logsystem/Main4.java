package no.the.core.platform.logsystem;

import java.io.IOException;
import java.util.logging.*;

/*
/c/Workspace/JavaApp/CorePlatform/src/main/java/no/the/core/platform/logsystem
javac Main4.java
java Main4

/c/Workspace/JavaApp/CorePlatform
javac src/main/java/no/the/core/platform/logsystem/Main4.java

java -cp src/main/java no/the/core/platform/logsystem/Main4
sep 08, 2017 2:48:09 PM no.the.core.platform.logsystem.Main4 main
INFO: We are Logging!

java -Djava.util.logging.config.file=log.properties -cp src/main/java no/the/core/platform/logsystem/Main4
We are Logging!,no.the.core.platform.logsystem.Main4 main,INFO
 */
public class Main4 {

    static Logger logger = Logger.getLogger("no.javacoreplatform");

    public static void main(String ... args) throws IOException {

        logger.log(Level.INFO, "We are Logging!");

    }

}
