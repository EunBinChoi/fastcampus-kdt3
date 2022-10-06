package me.day12.api.lang.system;

import java.util.Properties;

public class SystemPropertyExample {
    public static void main(String[] args) {
        // 시스템 프로퍼티 읽기
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println();

        // 시스템 프로퍼티 모두 읽기
        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);
        System.out.println();

        // 환경변수 읽기
        System.out.println(System.getenv());
    }
}
