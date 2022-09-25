package me.day05.string;

public class StringToUpperLowerCaseExample {
    public static void main(String[] args) {
        String s1 = "HeLLo";
        String s2 = "hello";
        String s3 = "1231123!";
        System.out.println(s1.toLowerCase());
        System.out.println(s2.toUpperCase());
        System.out.println(s3.toLowerCase()); // 영문자가 아닌 경우에는 그대로

        // 대소문자 구분 없이 문자열 동등비교
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.equalsIgnoreCase(s2)); // 위 코드와 동일

    }
}
