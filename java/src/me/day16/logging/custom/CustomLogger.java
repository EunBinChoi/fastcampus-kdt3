package me.day16.logging.custom;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomLogger {
    private Logger logger = Logger.getLogger("customLogger");
    private static CustomLogger customLogger;
    private FileHandler infoFileHandler;
    private FileHandler warnFileHandler;
    private FileHandler severeFileHandler;

    private static final String path = CustomLogger.class.getResource("").getPath();
    private static final String infoFileName = path + "info.log";
    private static final String warnFileName = path + "warn.log";
    private static final String severeFileName = path + "severe.log";



    public static CustomLogger getInstance() {
        if (customLogger == null) {
            customLogger = new CustomLogger();
        }
        return customLogger;
    }

    public CustomLogger() {
        try {
            infoFileHandler = new FileHandler(infoFileName, true); // append mode: true
            warnFileHandler = new FileHandler(warnFileName, true); // append mode: true
            severeFileHandler = new FileHandler(severeFileName, true); // append mode: true

            infoFileHandler.setFormatter(new SimpleFormatter());
            warnFileHandler.setFormatter(new SimpleFormatter());
            severeFileHandler.setFormatter(new SimpleFormatter());

            logger.setLevel(Level.INFO); // root logger

            infoFileHandler.setLevel(Level.INFO);
            warnFileHandler.setLevel(Level.WARNING);
            severeFileHandler.setLevel(Level.SEVERE);

            logger.addHandler(infoFileHandler);
            logger.addHandler(warnFileHandler);
            logger.addHandler(severeFileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void log(String msg) {
        logger.finest(msg);
        logger.finer(msg);
        logger.fine(msg);
        logger.config(msg);
        logger.info(msg);
        logger.warning(msg);
        logger.severe(msg);
    }
}
