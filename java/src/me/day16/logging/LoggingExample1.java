package me.day16.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample1 {
    private static Logger logger = Logger.getLogger(LoggingExample1.class.getName());
    public static void main(String[] args) {
        // Logger#log(level, message)
        logger.log(Level.WARNING, "Warning Logging");
        logger.log(Level.INFO, "Info Logging");
        logger.log(Level.SEVERE, "Severe Logging");

        // level 인자 없이 로그 출력
        // warning(), info() 등의 메소드를 이용하여 로그 출력
        logger.warning("Warning Logging");
        logger.info("Info Logging");
        logger.severe("Severe Logging");
    }
}
