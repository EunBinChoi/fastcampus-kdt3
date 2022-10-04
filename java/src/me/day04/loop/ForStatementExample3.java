package me.day04.loop;

import java.util.Scanner;

public class ForStatementExample3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUM = 5;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < NUM; i++) {
            int n = sc.nextInt();
            if (n < minValue) {
                minValue = n;
            }
            if (n > maxValue) {
                maxValue = n;
            }
        }
        System.out.println("최솟값 = " + minValue);
        System.out.println("최댓값 = " + maxValue);

        sc.close();
    }
}