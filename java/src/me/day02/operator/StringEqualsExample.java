package me.day02.operator;

public class StringEqualsExample {
    public static void main(String[] args) {
        String s1 = "hello"; // s 변수에는 주소값 들어가 있음
        String s2 = "hello"; // s 변수에는 주소값 들어가 있음
        String s3 = "hello"; // "hello"을 저장할 수 있는 공간 새롭게 할당

        boolean isEquals1 = (s1 == s2); // 주소값의 비교
        boolean isEquals2 = (s1 == s3); // 주소값의 비교
        boolean isEquals3 = s1.equals(s2); // 문자열의 내용물 비교
        boolean isEquals4 = s1.equals(s3); // 문자열의 내용물 비교
    }
}