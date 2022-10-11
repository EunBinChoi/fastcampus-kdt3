package me.smartstore.project.menu;

import java.util.InputMismatchException;
import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;
import me.smartstore.project.groups.Groups;
import me.smartstore.project.groups.Parameter;

public class GroupMenu extends Menu {
    public static Groups allGroups = new Groups();

    public GroupMenu() {
    }

    public static String chooseGroup() {
        while(true) {
            try {
                System.out.println();
                System.out.println("** Press 'end', if you want to exit! **");
                System.out.print("Which group (GENERAL, VIP, VVIP)? ");
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

                for(int i = 0; i < GroupType.values().length; ++i) {
                    if (choice != null && choice.equals(GroupType.values()[i].toString())) {
                        return choice;
                    }
                }

                throw new InputRangeException();
            } catch (NullPointerException var2) {
                System.out.println("Null Input. Please input something.");
            } catch (InputEmptyException var3) {
                System.out.println("Empty Input. Please input something.");
            } catch (InputRangeException var4) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public static int dispManageParameterMenu() {
        while(true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Set Parameter");
                System.out.println(" 2. View Parameter");
                System.out.println(" 3. Update Parameter");
                System.out.println(" 4. Back");
                System.out.println("==============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(Menu.scanner.next());
                if (choice >= 1 && choice <= 4) {
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

    public static void manageParameter() {
        while(true) {
            int choice = dispManageParameterMenu();
            if (choice == 1) {
                setParameter();
            } else if (choice == 2) {
                viewParameter();
            } else if (choice == 3) {
                updateParameter();
            } else {
                if (choice == 4) {
                    return;
                }

                System.out.println("\nInvalid Input. Please try again.");
            }
        }
    }

    public static void setParameter() {
        while(true) {
            String strGroup = chooseGroup().toUpperCase();
            if (strGroup.equals("END")) {
                return;
            }

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup);
            } catch (IllegalArgumentException var5) {
                System.out.println("\nInvalid Input. Please try again.");
                continue;
            }

            Group grp = allGroups.find(groupType);
            if (grp != null && grp.getParam() != null) {
                System.out.println("\n" + strGroup + " group already exists.");
                System.out.println("\n" + grp);
            } else {
                Parameter param = new Parameter();

                while(true) {
                    try {
                        int pchoice = setParameterMenu();
                        if (pchoice == 1) {
                            setParameterMinimumSpentTime(param);
                        } else if (pchoice == 2) {
                            setParameterMinimumTotalPay(param);
                        } else {
                            if (pchoice == 3) {
                                break;
                            }

                            System.out.println("\nInvalid Input. Please try again.");
                        }
                    } catch (InputMismatchException var6) {
                        System.out.println("\nInvalid Type for Input. Please try again.");
                        Menu.scanner.next();
                    }
                }

                allGroups.add(new Group(groupType, param));
                CustomerMenu.allCustomers.refresh(allGroups);
            }
        }
    }

    public static void viewParameter() {
        while(true) {
            String strGroup = chooseGroup().toUpperCase();
            if (strGroup.equals("END")) {
                return;
            }

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup);
            } catch (IllegalArgumentException var3) {
                System.out.println("\nInvalid Type for Input. Please try again.");
                continue;
            }

            Group grp = allGroups.find(groupType);
            System.out.println();
            System.out.println(grp);
        }
    }

    public static void updateParameter() {
        while(true) {
            String strGroup = chooseGroup().toUpperCase();
            if (strGroup.equals("END")) {
                return;
            }

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup);
            } catch (IllegalArgumentException var6) {
                System.out.println("\nInvalid Input. Please try again.");
                System.out.println(var6);
                return;
            }

            Group grp = allGroups.find(groupType);
            if (grp.getParam() == null) {
                System.out.println("\nNo parameter. Set the parameter first.");
            } else {
                System.out.println("\n" + grp.toString());
                Parameter param = grp.getParam();

                label41:
                while(true) {
                    while(true) {
                        try {
                            int pchoice = setParameterMenu();
                            if (pchoice == 1) {
                                setParameterMinimumSpentTime(param);
                            } else if (pchoice != 2) {
                                if (pchoice == 3) {
                                    break label41;
                                }

                                System.out.println("\nInvalid Input. Please try again.");
                            } else {
                                setParameterMinimumTotalPay(param);
                            }
                        } catch (InputMismatchException var5) {
                            System.out.println("\nInvalid Type for Input. Please try again.");
                            Menu.scanner.next();
                        }
                    }
                }

                CustomerMenu.allCustomers.refresh(allGroups);
                System.out.println("\n" + grp.toString());
            }
        }
    }

    public static int setParameterMenu() {
        while(true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Minimum Spent Time");
                System.out.println(" 2. Minimum Total Pay");
                System.out.println(" 3. Back");
                System.out.println("==============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(Menu.scanner.next());
                if (choice >= 1 && choice <= 3) {
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

    public static void setParameterMinimumSpentTime(Parameter param) {
        while(true) {
            try {
                System.out.println();
                System.out.print("Input Minimum Spent Time: ");
                int minimumSpentTime = Integer.parseInt(Menu.scanner.next());
                if (minimumSpentTime < 0) {
                    throw new InputRangeException();
                }

                param.setMinimumSpentTime(minimumSpentTime);
                return;
            } catch (NumberFormatException var2) {
                System.out.println("Invalid Type for Input. Please try again.");
            } catch (InputRangeException var3) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public static void setParameterMinimumTotalPay(Parameter param) {
        while(true) {
            try {
                System.out.println();
                System.out.print("Input Minimum Total Pay: ");
                int minimumTotalPay = Integer.parseInt(Menu.scanner.next());
                if (minimumTotalPay < 0) {
                    throw new InputRangeException();
                }

                param.setMinimumTotalPay(minimumTotalPay);
                return;
            } catch (NumberFormatException var2) {
                System.out.println("Invalid Type for Input. Please try again.");
            } catch (InputRangeException var3) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }
}
