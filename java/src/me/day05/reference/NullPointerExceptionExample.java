package me.day05.reference;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length()); // NullPointerException 발생
    }
}
