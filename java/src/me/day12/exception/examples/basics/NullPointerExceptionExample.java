package me.day12.exception.examples.basics;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally block");
        }
        System.out.println("main method exit...");
    }
}
