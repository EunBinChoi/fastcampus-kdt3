package me.day05.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherClassExample1 {
    static final String REGEX = "^[a-zA-Z]*$";
    public static void main(String[] args) {
        // 코딩 테스트 문제 (https://school.programmers.co.kr/learn/courses/30/lessons/17682)

        // 1. 생성하기, 정규식 일치여부 판별하기
        String input = "hello world";
        System.out.println(Pattern.matches(REGEX, input)); // 공백 포함. false

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        System.out.println(matcher.matches()); // 공백 포함. false
        System.out.println();

        // 2. Grouping
        // find() - 패턴이 일치하는 다음 문자열이 존재다면 true 반환
        pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        matcher = pattern.matcher("1D2S#10S*"); // 1D/2S#/10S*
        while (matcher.find()) {
            System.out.println(matcher.group(1) + "/" + matcher.group(2) + "/" + matcher.group(3));
            System.out.println(matcher.start(1) + "/" + matcher.start(2) + "/" + matcher.start(3));
            System.out.println(matcher.end(1) + "/" + matcher.end(2) + "/" + matcher.end(3));
            System.out.println();
        }

        pattern = Pattern.compile("(?<score>[0-9]+)(?<bonus>[SDT])(?<option>[*#]?)");
        matcher = pattern.matcher("1D2S#10S*"); // 1D/2S#/10S*
        while (matcher.find()) {
            System.out.println(matcher.group("score"));
        }
    }
}
