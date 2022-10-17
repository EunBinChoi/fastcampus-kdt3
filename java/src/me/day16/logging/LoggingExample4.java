package me.day16.logging;

import java.util.Date;
import java.util.logging.*;

public class LoggingExample4 {

    private static Logger logger = Logger.getLogger(LoggingExample4.class.getName());

    public static void main(String[] args) {
        // remove default log handler
        logger.setUseParentHandlers(false);

        // add new log handler
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });
        logger.addHandler(handler);

        // logging
        logger.warning("Warning logging");
        logger.info("Info logging");
    }
}
