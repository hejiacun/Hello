package Utils.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogUtils.class);
    
    public static void info(String s, Object... objects) {
        LOGGER.info(s, objects);
    }

    public static void warn(String s, Object... objects) {
        LOGGER.warn(s, objects);
    }

    public static void error(String s, Object... objects) {
        LOGGER.error(s, objects);
    }
    
    public static void info(String s) {
        LOGGER.info(s);
    }

    public static void warn(String s) {
        LOGGER.warn(s);
    }

    public static void error(String s) {
        LOGGER.error(s);
    }
}
