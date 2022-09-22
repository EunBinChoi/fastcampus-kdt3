package me.day05.string;

public class StringContainsExample {
    public static void main(String[] args) {
        String str = "hello";

        boolean isContains1 = str.contains("ell");
        boolean isContains2 = str.contains("llo");
        boolean isContains3 = str.contains("lle");
        boolean isContains4 = str.contains("H");

        System.out.println(isContains1); // true
        System.out.println(isContains2); // true
        System.out.println(isContains3); // false
        System.out.println(isContains4); // false (case sensitive)

    }
}
