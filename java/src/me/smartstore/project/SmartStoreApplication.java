package me.smartstore.project;

import me.smartstore.project.customers.Customer;
import me.smartstore.project.customers.Customers;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;
import me.smartstore.project.groups.Groups;
import me.smartstore.project.groups.Parameter;
import me.smartstore.project.menu.SummarizedMenu;
import me.smartstore.project.menu.CusMenu;
import me.smartstore.project.menu.GroupMenu;
import me.smartstore.project.menu.Menu;
import me.smartstore.project.util.Message;

import java.util.InputMismatchException;

public class SmartStoreApplication {
    private static SmartStoreApplication smartStoreApp;

    private final Groups allGroups = Groups.getInstance();
    private final Customers allCustomers = Customers.getInstance();

    private final Menu menu = Menu.getInstance();
    private final CusMenu customerMenu = CusMenu.getInstance();
    private final GroupMenu groupMenu = GroupMenu.getInstance();
    private final SummarizedMenu classifiedMenu = SummarizedMenu.getInstance();


    public static SmartStoreApplication getInstance() {
        if (smartStoreApp == null) {
            smartStoreApp = new SmartStoreApplication();
        }
        return smartStoreApp;
    }

    public SmartStoreApplication test() {
        allGroups.add(new Group(GroupType.GENERAL, new Parameter(10, 100000)));
        allGroups.add(new Group(GroupType.VIP, new Parameter(20, 200000)));
        allGroups.add(new Group(GroupType.VVIP, new Parameter(30, 300000)));

        for (int i = 0; i < 20; ++i) {
            allCustomers.add(new Customer("" + (char) (97 + i), (char) (97 + i) + "12345", i * 10, i * 100000));
        }

        allCustomers.refresh(allGroups);
        return this;
    }

    public void run() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Segmentation");
        System.out.println(" Release Date : 22.10.13");
        System.out.println(" Copyright 2022 Eunbin All rights reserved.");
        System.out.println("===========================================");
        System.out.println();

        while (true) {
            try {
                int choice = menu.dispMainMenu();
                if (choice == 1) {
                    groupMenu.manageParameter();
                } else if (choice == 2) {
                    customerMenu.manageCustomerData();
                } else if (choice == 3) {
                    classifiedMenu.manageSummaryMenu();
                } else if (choice == 4) {
                    System.out.println("\nProgram Finished.");
                    break;
                } else {
                    System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
                }
            } catch (InputMismatchException var2) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_TYPE);
                Menu.scanner.next();
            }
        }

        Menu.scanner.close();
    }
}
