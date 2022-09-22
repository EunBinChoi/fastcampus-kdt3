package me.day05.regex;

import java.util.regex.Pattern;

public class PatternClassExample {
    public static void main(String[] args) {
        String strRegEx1 = "qwerty@gmail.com";
        String emailRegEx = "^\\w+@\\w+\\.\\w+(\\.\\w+)?$";
        System.out.println("Pattern.matches(emailRegEx, strRegEx1) = " + Pattern.matches(emailRegEx, strRegEx1));

        strRegEx1 = "qweqw@naver.co.kr";
        System.out.println("Pattern.matches(emailRegEx, strRegEx1) = " + Pattern.matches(emailRegEx, strRegEx1));

        strRegEx1 = "qwe@naver.";
        System.out.println("Pattern.matches(emailRegEx, strRegEx1) = " + Pattern.matches(emailRegEx, strRegEx1));
        System.out.println();

        String strRegEx2 = "010-1234-5678";
        String phoneRegEx = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
        System.out.println("Pattern.matches(phoneRegEx, strRegEx2) = " + Pattern.matches(phoneRegEx, strRegEx2));

        strRegEx2 = "02-000-0000";
        System.out.println("Pattern.matches(phoneRegEx, strRegEx2) = " + Pattern.matches(phoneRegEx, strRegEx2));

        strRegEx2 = "010-00000-0000";
        System.out.println("Pattern.matches(phoneRegEx, strRegEx2) = " + Pattern.matches(phoneRegEx, strRegEx2));
    }
}
