package me.day05.string;

public class StringLengthExample {
    public static void main(String[] args) {
        String s1 = "            ";
        String s2 = "hello        ";
        System.out.println(s1.length()); // whitespace도 계산
        System.out.println(s2.length()); // whitespace도 계산
        System.out.println(s2.strip().length()); // whitespace 제거하고 계산
        // method1().method2().. 이어서 작성가능 (function chaining)
    }
}
