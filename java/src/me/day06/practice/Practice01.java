package me.day06.practice;

import java.util.Map;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int STUDENTS = 10;
        int[] scores = new int[STUDENTS];

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("[%d] 학생 성적 입력 = ", i + 1);
            scores[i] = scanner.nextInt();
        }

        System.out.println("max = " + max(scores));
        System.out.println("min = " + min(scores));
        System.out.println("average = " + average(scores));
        System.out.println("derivation = " + derivation(scores));
        System.out.println("standard = " + standard(scores));
    }
    public static int max(int[] scores) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }
    public static int min(int[] scores) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }
    public static double average(int[] scores) {
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (double)sum / scores.length;
    }
    public static double derivation(int[] scores) {
        double avg = average(scores);
        double dev = 0.0;

        for (int i = 0; i < scores.length; i++) {
            dev += Math.pow((scores[i]-avg), 2);
        }
        dev /= scores.length;
        return dev;
    }
    public static double standard(int[] scores) {
        return Math.sqrt(derivation(scores));
    }
}
