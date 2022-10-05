package me.day12.exception.examples.basics;

public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        String string1 = "100";
        String string2 = "10o";
        try {
            int intValue1 = Integer.parseInt(string1);
            int intValue2 = Integer.parseInt(string2);
            System.out.println("intValue1 = " + intValue1);
            System.out.println("intValue2 = " + intValue2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("main exit ...");
    }
}
