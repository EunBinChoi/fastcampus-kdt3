package me.day16.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample2 {
    private static Logger logger = Logger.getLogger(LoggingExample2.class.getName());
    public static void main(String[] args) {
        // 특정 Level 이상의 로그들만 출력하도록 설정
        logger.setLevel(Level.WARNING);

        // level 인자 없이 로그 출력
        // warning(), info() 등의 메소드를 이용하여 로그 출력
        logger.warning("Warning Logging"); // 출력됨
        logger.info("Info Logging"); // 출력 되지 않음
        logger.severe("Severe Logging"); // 출력됨
    }
}
