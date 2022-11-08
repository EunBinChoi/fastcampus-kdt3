package org.example.overview.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogExample {
    private Logger logger = LogManager.getLogger(LogExample.class);

    public void printLog() {
        logger.debug("DEBUG LOG");
        logger.info ("INFO LOG");
        logger.warn ("WARN LOG");
        logger.error("ERROR LOG");
    }
}
