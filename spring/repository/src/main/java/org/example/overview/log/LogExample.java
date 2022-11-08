package org.example.overview.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogExample {
    private Logger logger = LogManager.getLogger(LogExample.class);

    public void printLog() {
        logger.debug(String.format("[%5s] LOG", "DEBUG"));
        logger.info (String.format("[%5s] LOG", "INFO"));
        logger.warn (String.format("[%5s] LOG", "WARN"));
        logger.error(String.format("[%5s] LOG", "ERROR"));
    }
}
