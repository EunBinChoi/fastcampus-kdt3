package me.day12.exception.examples.defined;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDefinedExceptionExample {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int money;

        while (true) {
            try {
                System.out.print("input money: ");
                money = scanner.nextInt();
                isValidMoneyValue(money);
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // flush buffer in scanner
                e.printStackTrace();
            } catch (InvalidNumberRangeException e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally block");
            }
            Thread.sleep(1000); // sleep 1 sec for printing stack trace
        }
        System.out.print("you can go kimbab paradise ");
        System.out.println("with your money = " + money + " won");
        System.out.println("main exit ...");
        scanner.close();
    }
    public static boolean isValidMoneyValue(int money) throws InvalidNumberRangeException {
        if (money < 0) {
            throw new InvalidNumberRangeException();
        }
        return true;
    }
}
