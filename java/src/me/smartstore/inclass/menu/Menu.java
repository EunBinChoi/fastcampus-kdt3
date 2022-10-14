package me.smartstore.inclass.menu;

import me.smartstore.inclass.exception.InputRangeException;
import me.smartstore.inclass.util.ErrorMessage;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    private static Menu menu;

    private String[] menus = { "Parameter", "Customer Data", "Classification Summary",  "Quit" };

    /* method reflect */
    private Menu instance = menu;
    private String[] methods = { "", "", "" };
    protected Menu() {}

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menu) {
        Menu.menu = menu;
    }

    public void setInstance(Menu instance) {
        this.instance = instance;
    }

    public String[] getMethods() {
        return methods;
    }

    public void setMethods(String[] methods) {
        this.methods = methods;
    }

    public String[] getMenus() {
        return menus;
    }

    public void setMenus(String[] menus) {
        this.menus = menus;
    }

    public void manage() {
        while (true) {
            int choice = dispMenu();
            if (!(choice >= 1 && choice <= methods.length + 1)) { // + 1은 break 포함
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
            if (choice == methods.length + 1) {
                break; // back
            }

            try {
                int i = choice - 1;
                this.getClass().getMethod(methods[i]).invoke(instance);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public int dispMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                for (int i = 0; i < menus.length; i++) {
                    System.out.printf("  %d. %s\n", i + 1, menus[i]);
                }
                System.out.println("==============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(scanner.next());
                if (choice >= 1 && choice <= menus.length) {
                    return choice;
                }
                throw new InputRangeException();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }
}
