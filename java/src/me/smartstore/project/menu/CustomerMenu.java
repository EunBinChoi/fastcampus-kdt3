package me.smartstore.project.menu;

import java.util.regex.Pattern;
import me.smartstore.project.customers.Customer;
import me.smartstore.project.customers.Customers;
import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputFormatException;
import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.groups.Group;

public class CustomerMenu extends Menu {
    public static Customers allCustomers = new Customers();

    public static void manageCustomerData() {
        while(true) {
            int choice = dispManageCustomerMenu();
            if (choice == 1) {
                int size = getSizeOfCustomersToInput();
                setCustomerData(size);
            } else if (choice == 2) {
                viewCustomerData();
            } else if (choice == 3) {
                editCustomerData();
            } else if (choice == 4) {
                deleteCustomerData();
            } else {
                if (choice == 5) {
                    return;
                }

                System.out.println("\nInvalid Input. Please try again.");
            }
        }
    }

    public static void setCustomerData(int size) {
        label46:
        for(int i = 0; i < size; ++i) {
            Customer customer = new Customer();
            System.out.println("\n====== Customer " + (i + 1) + " Info. ======");

            while(true) {
                while(true) {
                    int choice = dispSetCustomerMenu();
                    if (choice == 1) {
                        setCustomerName(customer);
                        break;
                    }

                    if (choice == 2) {
                        setCustomerUserID(customer);
                        break;
                    }

                    if (choice == 3) {
                        setCustomerSpentTime(customer);
                        break;
                    }

                    if (choice == 4) {
                        setCustomerTotalPay(customer);
                        break;
                    }

                    if (choice == 5) {
                        customer.setGroup(GroupMenu.allGroups.findGroupFor(customer));
                        allCustomers.add(customer);
                        System.out.println();
                        continue label46;
                    }

                    System.out.println("\nInvalid Input. Please try again.");
                }

                Group grp = GroupMenu.allGroups.findGroupFor(customer);
                if (grp == null) {
                    customer.setGroup((Group)null);
                } else if (!grp.equals(customer.getGroup())) {
                    customer.setGroup(grp);
                }
            }
        }

    }

    public static void viewCustomerData() {
        System.out.println("\n======= Customer Info. =======");

        for(int i = 0; i < allCustomers.getCount(); ++i) {
            Customer cust = allCustomers.get(i);
            if (cust != null) {
                System.out.println("No. " + (i + 1) + " => " + cust);
            } else {
                System.out.println("null");
            }
        }

    }

    public static void editCustomerData() {
        int allCustCount = allCustomers.getCount();
        viewCustomerData();
        int custNo = findCustomer(allCustCount);
        if (custNo >= 1 && custNo <= allCustCount) {
            Customer cust = allCustomers.get(custNo - 1);
            if (cust != null) {
                while(true) {
                    while(true) {
                        int choice = dispSetCustomerMenu();
                        if (choice == 1) {
                            setCustomerName(cust);
                            break;
                        }

                        if (choice == 2) {
                            setCustomerUserID(cust);
                            break;
                        }

                        if (choice == 3) {
                            setCustomerSpentTime(cust);
                            break;
                        }

                        if (choice == 4) {
                            setCustomerTotalPay(cust);
                            break;
                        }

                        if (choice == 5) {
                            return;
                        }

                        System.out.println("\nInvalid Input. Please try again.");
                    }

                    Group grp = GroupMenu.allGroups.findGroupFor(cust);
                    if (grp == null) {
                        cust.setGroup((Group)null);
                    } else if (!grp.equals(cust.getGroup())) {
                        cust.setGroup(grp);
                    }
                }
            }
        }

    }

    public static void deleteCustomerData() {
        int allCustCount = allCustomers.getCount();
        viewCustomerData();
        int custNo = findCustomer(allCustCount);
        if (custNo >= 1 && custNo <= allCustCount) {
            Customer cust = allCustomers.get(custNo - 1);
            int ret = allCustomers.pop(custNo - 1);
            if (ret == -1) {
                System.out.println("\nCustomer Data Can't Be Deleted ...");
            } else {
                System.out.println("\nCustomer Data Deleted Successfully !");
            }

            viewCustomerData();
        } else {
            System.out.printf("\nSelected Customer Number Incorrect ! ( Range: %d ~ %d )\n", 1, allCustCount);
        }

    }

    public static int dispManageCustomerMenu() {
        while(true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Set Customer Data");
                System.out.println(" 2. View Customer Data");
                System.out.println(" 3. Update Customer Data");
                System.out.println(" 4. Delete Customer Data");
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

    public static int getSizeOfCustomersToInput() {
        while(true) {
            try {
                System.out.println();
                System.out.println("** Press -1, if you want to exit! **");
                System.out.print("How many customers to input? ");
                int size = Integer.parseInt(Menu.scanner.next());
                if (size < 0) {
                    throw new InputRangeException();
                }

                return size;
            } catch (NumberFormatException var1) {
                System.out.println("\nInvalid Type for Input. Please try again.");
            } catch (InputRangeException var2) {
                System.out.println("\nInvalid Input. Please try again.");
            }
        }
    }

    public static int dispSetCustomerMenu() {
        while(true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Customer Name");
                System.out.println(" 2. Customer ID");
                System.out.println(" 3. Customer Spent Time");
                System.out.println(" 4. Customer Total Pay");
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

    public static void setCustomerName(Customer customer) {
        while(true) {
            try {
                System.out.println();
                System.out.print("Input Customer's Name: ");
                String REGEX = "^[a-zA-Z]{3,}$";
                String name = Menu.scanner.next();
                if (name != null && !name.equals("")) {
                    if (Pattern.matches(REGEX, name)) {
                        customer.setName(name);
                        return;
                    }

                    throw new InputFormatException();
                }

                throw new InputEmptyException();
            } catch (InputEmptyException var3) {
                System.out.println("Empty Input. Please input something.");
            } catch (InputFormatException var4) {
                System.out.println("Invalid Format for Input. Please try again.");
            }
        }
    }

    public static void setCustomerUserID(Customer customer) {
        while(true) {
            try {
                System.out.println();
                System.out.print("Input Customer's UserID: ");
                String REGEX = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
                String userID = Menu.scanner.next();
                if (userID != null && !userID.equals("")) {
                    if (Pattern.matches(REGEX, userID)) {
                        customer.setUserID(userID);
                        return;
                    }

                    throw new InputFormatException();
                }

                throw new InputEmptyException();
            } catch (InputEmptyException var3) {
                System.out.println("Empty Input. Please input something.");
            } catch (InputFormatException var4) {
                System.out.println("Invalid Format for Input. Please try again.");
            }
        }
    }

    public static void setCustomerSpentTime(Customer customer) {
        while(true) {
            try {
                System.out.println();
                System.out.print("Input Customer's Spent Time at Your Store: ");
                int spentTime = Integer.parseInt(Menu.scanner.next());
                if (spentTime < 0) {
                    throw new InputRangeException();
                }

                customer.setSpentTime(spentTime);
                return;
            } catch (NumberFormatException var2) {
                System.out.println("Invalid Type for Input. Please try again.");
            } catch (InputRangeException var3) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public static void setCustomerTotalPay(Customer customer) {
        while(true) {
            try {
                System.out.println();
                System.out.print("Input Customer's Total Payment at Your Store: ");
                int totalPay = Integer.parseInt(Menu.scanner.next());
                if (totalPay < 0) {
                    new InputRangeException();
                }

                customer.setTotalPay(totalPay);
                return;
            } catch (NumberFormatException var2) {
                System.out.println("Invalid Type for Input. Please try again.");
            } catch (InputRangeException var3) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public static int findCustomer(int allCustCount) {
        while(true) {
            try {
                System.out.println();
                System.out.print("Which customer ( 1 ~ " + allCustCount + " )? ");
                int custNo = Integer.parseInt(Menu.scanner.next());
                return custNo;
            } catch (NumberFormatException var2) {
                System.out.println("\nInvalid Type for Input. Please try again.");
            }
        }
    }
}
