package me.day12.exception.spring.examples.restore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RestoreExceptionExample {
    public static void main(String[] args) {

        final int MAX_RETRY = 10;
        try {
            int intValue = input(MAX_RETRY);
            System.out.println("Finally We Get Integer Number = " + intValue);
        } catch (Exception e) {
            System.out.println("Finally We Can't Get Integer Number ... ");
        }

    }
    public static int input(int maxRetry) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int tries = maxRetry;
        int intValue;
        while (tries > 0) {
            try {
                System.out.print("Input Integer Number: ");
                intValue = scanner.nextInt();
                return intValue;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Input Type Error ... ");
                System.out.printf("[%d] Please Retry to Input Integer Number ... \n\n", maxRetry - tries + 1);
            }
            tries--;
        }
        scanner.close();
        throw new Exception();
    }
}
