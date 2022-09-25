package me.day05.string;

public class StringEqualsExample {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Hello";

        boolean isEquals1 = s1.equals(s2);
        boolean isEquals2 = s1.equalsIgnoreCase(s2);
        boolean isEquals3 = s1.equalsIgnoreCase(s2);
        // equalsIgnoreCase()의 내부 구현 방법

        System.out.println(isEquals1); // false
        System.out.println(isEquals2); // true
        System.out.println(isEquals3); // true
    }
}
