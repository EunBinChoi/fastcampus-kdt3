package me.day05.string;

public class StringInitExample {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");

        // 주소값 비교
        System.out.println(s1 == s2); // true
        System.out.println(s3 == s4); // false

        // 내용물 비교
        System.out.println(s1.equals(s2)); // true
        System.out.println(s3.equals(s4)); // true
    }
}
