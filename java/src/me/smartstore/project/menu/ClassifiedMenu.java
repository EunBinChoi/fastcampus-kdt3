package me.smartstore.project.menu;

import me.smartstore.project.customers.ClassifiedCustomersGroup;
import me.smartstore.project.customers.Customer;
import me.smartstore.project.customers.Customers;
import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;
import me.smartstore.project.groups.Groups;
import me.smartstore.project.util.Message;

import java.io.PrintStream;

public class ClassifiedMenu extends Menu {
    private static ClassifiedMenu classifiedMenu;

    private final Groups allGroups = Groups.getInstance();
    private final Customers allCustomers = Customers.getInstance();

    private ClassifiedCustomersGroup classifiedCustomersGroup = ClassifiedCustomersGroup.getInstance();

    public static ClassifiedMenu getInstance() {
        if (classifiedMenu == null) {
            classifiedMenu = new ClassifiedMenu();
        }
        return classifiedMenu;
    }

    public int dispSummaryMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Summary");
                System.out.println(" 2. Summary (Sorted By Name)");
                System.out.println(" 3. Summary (Sorted By Spent Time)");
                System.out.println(" 4. Summary (Sorted By Total Payment)");
                System.out.println(" 5. Back");
                System.out.println("==============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(Menu.scanner.next());
                if (choice >= 1 && choice <= 5) {
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

    public void manageSummaryMenu() {
        classifiedCustomersGroup = allCustomers.classify();
        System.out.println("classifiedCustomersGroup = " + classifiedCustomersGroup);

        while (true) {
            int choice = dispSummaryMenu();
            if (choice == 1) {
                dispSummary();
            } else if (choice == 2) {
                manageSortedByName();
            } else if (choice == 3) {
                manageSortedBySpentTime();
            } else if (choice == 4) {
                manageSortedByTotalPay();
            } else if (choice == 5) {
                return;
            } else {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }


    public void dispSummary() {
        System.out.println();

        for (int i = 0; i < allGroups.length(); ++i) {
            Group grp = allGroups.get(i);
            int custCount = 0;
            if (!classifiedCustomersGroup.get(i).isNull() && !classifiedCustomersGroup.get(i).isEmpty()) {
                custCount = classifiedCustomersGroup.get(i).getCount();
            }

            System.out.println();
            System.out.println("==============================");
            if (grp.getType().equals(GroupType.NONE)) {
                System.out.println("Others : " + custCount + " customer(s)");
            } else {
                System.out.println(grp.getType() + " Group : " + custCount + " customer(s)");
                if (grp.getParam() == null) {
                    System.out.println("[Parameter] null");
                } else {
                    System.out.println("[Parameter] " + grp.getParam().toString());
                }
            }

            System.out.println("------------------------------");
            if (!classifiedCustomersGroup.get(i).isNull() && !classifiedCustomersGroup.get(i).isEmpty()) {
                for (int j = 0; j < custCount; ++j) {
                    Customer cust = classifiedCustomersGroup.get(i).get(j);
                    if (cust != null) {
                        System.out.println("No. " + (j + 1) + " => " + cust);
                    }
                }
            } else {
                System.out.println("No customer.");
            }
        }

    }


    public void manageSortedByName() {
        while (true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals(Message.END_MSG)) {
                return;
            }

            try {
                OrderType orderType = OrderType.valueOf(strOrder);
                if (orderType == OrderType.ASCENDING) {
                    classifiedCustomersGroup.sortByName(OrderType.ASCENDING);
                } else {
                    classifiedCustomersGroup.sortByName(OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_TYPE);
            }

            dispSummary();
        }
    }

    public void manageSortedBySpentTime() {
        while (true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals(Message.END_MSG)) {
                return;
            }

            try {
                OrderType orderType = OrderType.valueOf(strOrder);
                if (orderType == OrderType.ASCENDING) {
                    classifiedCustomersGroup.sortedBySpentTime(OrderType.ASCENDING);
                } else {
                    classifiedCustomersGroup.sortedBySpentTime(OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_TYPE);
            }

            dispSummary();
        }
    }

    public void manageSortedByTotalPay() {
        while (true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals(Message.END_MSG)) {
                return;
            }

            try {
                OrderType orderType = OrderType.valueOf(strOrder);
                if (orderType == OrderType.ASCENDING) {
                    classifiedCustomersGroup.sortedByTotalPay(OrderType.ASCENDING);
                } else {
                    classifiedCustomersGroup.sortedByTotalPay(OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_TYPE);
            }
            dispSummary();
        }

    }

    public String chooseSortOrder() {
        while (true) {
            try {
                System.out.println();
                System.out.println("** Press 'end', if you want to exit! **");
                System.out.print("Which order (ASCENDING, DESCENDING)? ");
                String choice = Menu.scanner.next().toUpperCase();
                if (choice == null) {
                    throw new NullPointerException();
                }

                if (choice.equals("")) {
                    throw new InputEmptyException();
                }

                if (choice.equals(Message.END_MSG)) {
                    return choice;
                }

                try {
                    OrderType orderType = OrderType.valueOf(choice);

                    for (int i = 0; i < OrderType.values().length; ++i) {
                        if (orderType == OrderType.values()[i]) {
                            return choice;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(Message.ERR_MSG_INVALID_INPUT_TYPE);
                }
            } catch (NullPointerException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_NULL);
            } catch (InputEmptyException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_EMPTY);
            } catch (InputRangeException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }
}
