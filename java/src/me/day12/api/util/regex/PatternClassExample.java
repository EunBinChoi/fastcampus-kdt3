package me.day12.api.util.regex;

import java.util.regex.Pattern;

public class PatternClassExample {
    static final String EMAIL_REGEX = "^\\w+@\\w+\\.\\w+(\\.\\w+)?$";
    static final String PHONE_REGEX = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
    public static void main(String[] args) {
        String email = "qwerty@gmail.com";
        System.out.println("Pattern.matches(EMAIL_REGEX, email) = " + Pattern.matches(EMAIL_REGEX, email));

        email = "qweqw@naver.co.kr";
        System.out.println("Pattern.matches(EMAIL_REGEX, email) = " + Pattern.matches(EMAIL_REGEX, email));

        email = "qwe@naver.";
        System.out.println("Pattern.matches(EMAIL_REGEX, email) = " + Pattern.matches(EMAIL_REGEX, email));
        System.out.println();


        String phone = "010-1234-5678";
        System.out.println("Pattern.matches(PHONE_REGEX, phone) = " + Pattern.matches(PHONE_REGEX, phone));

        phone = "02-000-0000";
        System.out.println("Pattern.matches(PHONE_REGEX, phone) = " + Pattern.matches(PHONE_REGEX, phone));

        phone = "010-00000-0000";
        System.out.println("Pattern.matches(PHONE_REGEX, phone) = " + Pattern.matches(PHONE_REGEX, phone));
    }
}
