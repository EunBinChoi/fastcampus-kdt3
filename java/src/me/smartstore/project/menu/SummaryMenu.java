package me.smartstore.project.menu;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import me.smartstore.project.customers.Customer;
import me.smartstore.project.customers.Customers;
import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;

public class SummaryMenu extends Menu {
    public SummaryMenu() {
    }

    public static int dispSummaryMenu() {
        while(true) {
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
            } catch (NumberFormatException var1) {
                System.out.println("Invalid Type for Input. Please try again.");
            } catch (InputRangeException var2) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public static void manageSummaryMenu() {
        while(true) {
            int choice = dispSummaryMenu();
            if (choice == 1) {
                dispSummary(classify());
            } else if (choice == 2) {
                manageSortedByName();
            } else if (choice == 3) {
                manageSortedBySpentTime();
            } else if (choice == 4) {
                manageSortedByTotalPay();
            } else {
                if (choice == 5) {
                    return;
                }

                System.out.println("\nInvalid Input. Please try again.");
            }
        }
    }

    public static void manageSortedByName() {
        while(true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals("END")) {
                return;
            }

            try {
                OrderType orderType = OrderType.valueOf(strOrder);
                if (orderType == OrderType.ASCENDING) {
                    System.out.println("ASCENDING");
                    sortByName(OrderType.ASCENDING);
                } else {
                    System.out.println("DESCENDING");
                    sortByName(OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException var3) {
                System.out.println("\nInvalid Type for Input. Please try again.");
            }
        }
    }

    public static void manageSortedBySpentTime() {
        while(true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals("END")) {
                return;
            }

            try {
                OrderType orderType = OrderType.valueOf(strOrder);
                if (orderType == OrderType.ASCENDING) {
                    System.out.println("ASCENDING");
                    sortedBySpentTime(OrderType.ASCENDING);
                } else {
                    System.out.println("DESCENDING");
                    sortedBySpentTime(OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException var3) {
                System.out.println("\nInvalid Type for Input. Please try again.");
            }
        }
    }

    public static void manageSortedByTotalPay() {
        while(true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals("END")) {
                return;
            }

            try {
                OrderType orderType = OrderType.valueOf(strOrder);
                if (orderType == OrderType.ASCENDING) {
                    System.out.println("ASCENDING");
                    sortedByTotalPay(OrderType.ASCENDING);
                } else {
                    System.out.println("DESCENDING");
                    sortedByTotalPay(OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException var3) {
                System.out.println("\nInvalid Type for Input. Please try again.");
            }
        }
    }

    public static String chooseSortOrder() {
        while(true) {
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

                if (choice.equals("END")) {
                    return choice;
                }

                try {
                    OrderType orderType = OrderType.valueOf(choice);

                    for(int i = 0; i < OrderType.values().length; ++i) {
                        if (orderType == OrderType.values()[i]) {
                            return choice;
                        }
                    }
                } catch (IllegalArgumentException var3) {
                    System.out.println("Invalid Type for Input. Please try again.");
                }
            } catch (NullPointerException var4) {
                System.out.println("Null Input. Please input something.");
            } catch (InputEmptyException var5) {
                System.out.println("Empty Input. Please input something.");
            } catch (InputRangeException var6) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public static Customers[] classify() {
        Customers[] groupByCustomers = new Customers[GroupType.values().length];

        for(int i = 0; i < GroupMenu.allGroups.length(); ++i) {
            Group grp = GroupMenu.allGroups.get(i);
            groupByCustomers[i] = grp.getCustomers(CustomerMenu.allCustomers);
        }

        return groupByCustomers;
    }

    public static void dispSummary(Customers[] groupByCustomers) {
        System.out.println();

        for(int i = 0; i < GroupMenu.allGroups.length(); ++i) {
            Group grp = GroupMenu.allGroups.get(i);
            int custCount = 0;
            if (!groupByCustomers[i].isNull() && !groupByCustomers[i].isEmpty()) {
                custCount = groupByCustomers[i].getCount();
            }

            System.out.println();
            System.out.println("==============================");
            if (grp.getType().equals(GroupType.NONE)) {
                System.out.println("Others : " + custCount + " customer(s)");
            } else {
                PrintStream var10000 = System.out;
                String var10001 = grp.getType().toString();
                var10000.println(var10001 + " Group : " + custCount + " customer(s)");
                if (grp.getParam() == null) {
                    System.out.println("[Parameter] null");
                } else {
                    System.out.println("[Parameter] " + grp.getParam().toString());
                }
            }

            System.out.println("------------------------------");
            if (!groupByCustomers[i].isNull() && !groupByCustomers[i].isEmpty()) {
                for(int j = 0; j < custCount; ++j) {
                    Customer cust = groupByCustomers[i].get(j);
                    if (cust != null) {
                        System.out.println("No. " + (j + 1) + " => " + cust);
                    }
                }
            } else {
                System.out.println("No customer.");
            }
        }

    }

    public static void sortByName(OrderType orderType) {
        Customers[] groupByCustomers = classify();
        if (orderType != null && !orderType.equals("")) {
            for(int i = 0; i < groupByCustomers.length; ++i) {
                Customer[] customers = groupByCustomers[i].getCustomers();
                if (orderType == OrderType.ASCENDING) {
                    Arrays.sort(customers);
                } else {
                    Arrays.sort(customers, new Comparator<Customer>() {
                        public int compare(Customer o1, Customer o2) {
                            return o1.compareTo(o2) * -1;
                        }
                    });
                }

                groupByCustomers[i].setCustomers(customers);
            }

            dispSummary(groupByCustomers);
        }
    }

    public static void sortedBySpentTime(OrderType orderType) {
        Customers[] groupByCustomers = classify();
        if (orderType != null && !orderType.equals("")) {
            for(int i = 0; i < groupByCustomers.length; ++i) {
                Customer[] customers = groupByCustomers[i].getCustomers();
                if (orderType == OrderType.ASCENDING) {
                    Arrays.sort(customers, new Comparator<Customer>() {
                        public int compare(Customer o1, Customer o2) {
                            if (o1.getSpentTime() < o2.getSpentTime()) {
                                return -1;
                            } else if (o1.getSpentTime() == o2.getSpentTime()) {
                                return o1.getName() != null && o2.getName() != null ? o1.getName().compareTo(o2.getName()) : 0;
                            } else {
                                return 1;
                            }
                        }
                    });
                } else {
                    Arrays.sort(customers, new Comparator<Customer>() {
                        public int compare(Customer o1, Customer o2) {
                            if (o1.getSpentTime() < o2.getSpentTime()) {
                                return 1;
                            } else if (o1.getSpentTime() == o2.getSpentTime()) {
                                return o1.getName() != null && o2.getName() != null ? o1.getName().compareTo(o2.getName()) : 0;
                            } else {
                                return -1;
                            }
                        }
                    });
                }

                groupByCustomers[i].setCustomers(customers);
            }

            dispSummary(groupByCustomers);
        }
    }

    public static void sortedByTotalPay(OrderType orderType) {
        Customers[] groupByCustomers = classify();
        if (orderType != null && !orderType.equals("")) {
            for(int i = 0; i < groupByCustomers.length; ++i) {
                Customer[] customers = groupByCustomers[i].getCustomers();
                if (orderType == OrderType.ASCENDING) {
                    Arrays.sort(customers, new Comparator<Customer>() {
                        public int compare(Customer o1, Customer o2) {
                            if (o1.getTotalPay() < o2.getTotalPay()) {
                                return -1;
                            } else if (o1.getTotalPay() == o2.getTotalPay()) {
                                return o1.getName() != null && o2.getName() != null ? o1.getName().compareTo(o2.getName()) : 0;
                            } else {
                                return 1;
                            }
                        }
                    });
                } else {
                    Arrays.sort(customers, new Comparator<Customer>() {
                        public int compare(Customer o1, Customer o2) {
                            if (o1.getTotalPay() < o2.getTotalPay()) {
                                return 1;
                            } else if (o1.getTotalPay() == o2.getTotalPay()) {
                                return o1.getName() != null && o2.getName() != null ? o1.getName().compareTo(o2.getName()) : 0;
                            } else {
                                return -1;
                            }
                        }
                    });
                }

                groupByCustomers[i].setCustomers(customers);
            }

            dispSummary(groupByCustomers);
        }
    }
}
