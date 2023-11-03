package no.the.core.platform.logsystem;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main
{

    //C:\Users\niamh\AppData\Local\Temp
    static Logger  logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String ... args) {

        logger.setLevel(Level.INFO);
        logger.log(Level.SEVERE, "Uh Oh !!");
        logger.log(Level.INFO, "Just so you know");
        logger.log(Level.FINE, "Hey developer dude");
        logger.log(Level.FINEST, "You are special"); //ignore
        logger.log(Level.INFO, "My firts log message"); //ignore
        logger.log(Level.INFO, "Another message"); //ignore
        logger.log(Level.INFO, "{0} is my favorite", "Java");
        logger.log(Level.INFO, "{0} is {1} days from {2}", new Object[]{"Wed", 2, "Fri"});


    }

}
