package me.smartstore.project.menu;

import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.util.Message;

import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);

    private static Menu menu;

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public int dispMainMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Parameter");
                System.out.println(" 2. Customer Data");
                System.out.println(" 3. Classification Summary");
                System.out.println(" 4. Quit");
                System.out.println("==============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(scanner.next());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }

                throw new InputRangeException();
            } catch (NumberFormatException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_FORMAT);
            } catch (InputRangeException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            }

        }
    }
}
