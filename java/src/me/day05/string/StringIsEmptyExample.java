package me.day05.string;

public class StringIsEmptyExample {
    public static void main(String[] args) {
        // isEmpty: 문자열 길이 확인
        // isBlank: 문자열이 비어있거나 whitespace 문자인지 확인

        String s1 = "";
        String s2 = "\t\n   ";
        System.out.println(s1.isEmpty()); // true
        System.out.println(s2.isEmpty()); // 문자열 길이 0이 아님. false
        System.out.println(s1.isBlank()); // true
        System.out.println(s2.isBlank()); // white space 존재. true
    }
}
