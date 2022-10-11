package me.smartstore.project.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    public static Scanner scanner;

    public Menu() {
    }

    public static int dispMainMenu() throws InputMismatchException {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Classification Parameter");
        System.out.println(" 2. Customer Data");
        System.out.println(" 3. Summary");
        System.out.println(" 4. Quit");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        return scanner.nextInt();
    }

    static {
        scanner = new Scanner(System.in);
    }
}
