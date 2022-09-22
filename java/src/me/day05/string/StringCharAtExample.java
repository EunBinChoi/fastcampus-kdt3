package me.day05.string;

public class StringCharAtExample {
    public static void main(String[] args) {
        String s = "hello";
        // 문자열에는 인덱스라는 개념 존재
        // 문자열도 문자들의 열거. 즉 배열이기 때문에 문자열 내에 순서가 존재함
        // 인덱스 - 원소 순서대로 번호를 매겨 원소를 접근할 수 있도록 하는 숫자 (0 <=  < 문자열 길이)
        // 인덱싱 - 인덱스를 통해 원소 접근 방법

        // h e l l o
        // 0 1 2 3 4

        char c = s.charAt(0);
        System.out.println(c);

        c = s.charAt(s.length()-1);
        System.out.println(c);
    }
}
