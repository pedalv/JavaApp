package util.com.pluralsight.util;

import java.util.logging.Logger;

public class LoggingUtil {
  private static Logger logger = Logger.getLogger("util");

  public static void log(String logMsg) {
    logger.info(">> " + logMsg);
  }
}
