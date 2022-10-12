package me.day04.practice;

public class Practice04 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = i + 1; j <= 5; j++) {
                System.out.printf("(%d, %d)\n", i, j);
                count++;
            }
        }
        System.out.println("combination count = " + count);
    }
}
