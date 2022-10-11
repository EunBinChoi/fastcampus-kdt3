package me.day12.exception.examples.basics;

public class ArrayIndexOutOfBoundExceptionExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            for (int i = 0; i <= arr.length; i++) {
                System.out.println(arr[i]); // i == arr.length
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("main exit ...");
    }
}
