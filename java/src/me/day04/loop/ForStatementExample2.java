package me.day04.loop;

import java.util.Scanner;

public class ForStatementExample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUM = 5;
        double sum = 0;
        double avg = 0;

        for(int i = 0; i < NUM; i++) {
            sum += sc.nextDouble();
        }
        avg = sum / NUM;
        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);

        sc.close();
    }
}
