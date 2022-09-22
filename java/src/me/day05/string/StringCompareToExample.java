package me.day05.string;

public class StringCompareToExample {
    public static void main(String[] args) {
        // 문자열 사전식 비교
        // s1이 s2보다 앞에 있으면 음수, 같으면 0, 뒤에 있으면 양수 반환

        System.out.println("a".compareTo("aa")); // -1 (길이가 더 긴 게 뒤에 존재. 아스키코드 뺄셈으로 표현할 수 없음)
        System.out.println("c".compareTo("ca")); // -1 (길이가 더 긴 게 뒤에 존재. 아스키코드 뺄셈으로 표현할 수 없음)
        System.out.println("c".compareTo("a"));  // 'c' - 'a' == 2
        System.out.println("a".compareTo("A"));  // 'a' - 'A' == 32
        System.out.println("a".compareToIgnoreCase("A")); // 0
    }
}
