package me.day16.logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class LoggingExample3 {

    private static Logger logger = Logger.getLogger(LoggingExample3.class.getName());

    public static void main(String[] args) {
        // remove default log handler
        logger.setUseParentHandlers(false);

        // add new log handler
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new MyLogFormatter());
        logger.addHandler(handler);

        // logging
        logger.warning("Warning logging");
        logger.info("Info logging");
    }

    public static class MyLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date(record.getMillis());

            StringBuffer sb = new StringBuffer(1000);
            sb.append(dateFormat.format(date));
            sb.append(" [");
            sb.append(record.getLevel());
            sb.append("] ");
            sb.append(record.getMessage());
            sb.append("\n");
            return sb.toString();
        }
    }
}