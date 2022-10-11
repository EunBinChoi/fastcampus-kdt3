package me.smartstore.project;

import java.util.InputMismatchException;
import me.smartstore.project.customers.Customer;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;
import me.smartstore.project.groups.Parameter;
import me.smartstore.project.menu.CustomerMenu;
import me.smartstore.project.menu.Menu;
import me.smartstore.project.menu.GroupMenu;
import me.smartstore.project.menu.SummaryMenu;

public class Main {
    public static void test() {
        GroupMenu.allGroups.add(new Group(GroupType.GENERAL, new Parameter(10, 100000)));
        GroupMenu.allGroups.add(new Group(GroupType.VIP, new Parameter(20, 200000)));
        GroupMenu.allGroups.add(new Group(GroupType.VVIP, new Parameter(30, 300000)));

        for(int i = 0; i < 20; ++i) {
            CustomerMenu.allCustomers.add(new Customer("" + (char)(97 + i), (char)(97 + i) + "12345", i * 10, i * 100000));
        }

        CustomerMenu.allCustomers.refresh(GroupMenu.allGroups);
    }

    public static void main(String[] args) {
        GroupMenu.allGroups.initialize();
        test();
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Segmentation");
        System.out.println(" Release Date : 22.10.07");
        System.out.println(" Copyright 2022 Eunbin All rights reserved.");
        System.out.println("===========================================");
        System.out.println("");

        while(true) {
            try {
                int choice = Menu.dispMainMenu();
                if (choice == 1) {
                    GroupMenu.manageParameter();
                } else if (choice == 2) {
                    CustomerMenu.manageCustomerData();
                } else if (choice == 3) {
                    SummaryMenu.manageSummaryMenu();
                } else {
                    if (choice == 4) {
                        System.out.println("\nProgram Finished.");
                        break;
                    }

                    System.out.println("\nInvalid Input. Please try again.");
                }
            } catch (InputMismatchException var2) {
                System.out.println("\nInvalid Type for Input. Please try again.");
                Menu.scanner.next();
            }
        }

        Menu.scanner.close();
    }
}
