package me.day05.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherClassExample2 {
    static final String REGEX = "a*b";
    public static void main(String[] args) {
        String input = "aabzzzaabxxxxabyyyy";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            System.out.println("sb = " + sb);
            System.out.println("matcher.group().toUpperCase() = " + matcher.group().toUpperCase());
            matcher.appendReplacement(sb, matcher.group().toUpperCase());
            System.out.println();
        }
        matcher.appendTail(sb);
        System.out.println("sb = " + sb);
    }
}
