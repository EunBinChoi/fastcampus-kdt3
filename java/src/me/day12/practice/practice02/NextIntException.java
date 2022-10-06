package me.day12.practice.practice02;

import java.util.Scanner;

public class NextIntException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">> input number : ");
        int number = scanner.nextInt();
        System.out.println("number = " + number);

        scanner.close();
    }
}
