package me.smartstore.project.menu;

import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.util.ErrorMessage;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;
import me.smartstore.project.groups.Parameter;

import java.util.InputMismatchException;

import static me.smartstore.project.SmartStoreApplication.smartStoreApp;


public class GroupMenu extends Menu {

    public String chooseGroup() {
        while (true) {
            try {
                System.out.println();
                System.out.println("** Press 'end', if you want to exit! **");
                System.out.print("Which group (GENERAL, VIP, VVIP)? ");

                String choice = smartStoreApp.scanner.next().toUpperCase();

                if (choice == null) throw new NullPointerException();
                if (choice.equals("")) throw new InputEmptyException();

                if (choice.equals(ErrorMessage.END_MSG)) return choice;

                for (int i = 0; i < GroupType.values().length; i++) {
                    if (choice != null) {
                        if (choice.equals(GroupType.values()[i].toString())) {
                            return choice;
                        }
                    }
                }
                throw new InputRangeException();
            } catch (NullPointerException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_NULL);
            } catch (InputEmptyException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_EMPTY);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }

    // Parameter
    public int dispManageParameterMenu() {

        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Set Parameter");
                System.out.println(" 2. View Parameter");
                System.out.println(" 3. Update Parameter");
                System.out.println(" 4. Back");
                System.out.println("==============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(smartStoreApp.scanner.next());
                if (choice < 1 || choice > 4) throw new InputRangeException();

                return choice;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }

    public void manageParameter() {

        while (true) {

            int choice = dispManageParameterMenu();

            if (choice == 1) { // 1. Set Parameter
                setParameter();
            } else if (choice == 2) { // 2. View Parameter
                viewParameter();
            } else if (choice == 3) { // 3. Update Parameter
                updateParameter();
            } else if (choice == 4) { // 4. Break
                break;
            } else {
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }

    /*
     * Manage Parameter
     *
     */

    // Parameter
    public void setParameter() {
        while (true) {
            String strGroup = chooseGroup().toUpperCase();

            if (strGroup.equals(ErrorMessage.END_MSG)) {
                break;
            } else {
                GroupType groupType;

                try {
                    groupType = GroupType.valueOf(strGroup);
                } catch (IllegalArgumentException e) {
                    System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
                    continue;
                }

                Group grp = smartStoreApp.allGroups.find(groupType);

                if (grp != null && grp.getParam() != null) {
                    System.out.println("\n" + strGroup + " group already exists.");
                    System.out.println("\n" + grp);
                    continue;
                }

                Parameter param = new Parameter();

                while (true) {
                    try {
                        int choice = setParameterMenu();

                        if (choice == 1) {
                            setParameterMinimumSpentTime(param);
                        } else if (choice == 2) {
                            setParameterMinimumTotalPay(param);
                        } else if (choice == 3) {
                            break;
                        } else {
                            System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
                        smartStoreApp.scanner.next();
                    }
                }


                smartStoreApp.allGroups.add(new Group(groupType, param));
                smartStoreApp.allCustomers.refresh(smartStoreApp.allGroups);
            }
        }
    }

    // Parameter
    public void viewParameter() {
        while (true) {
            if (!(smartStoreApp.allGroups.isNull() || smartStoreApp.allGroups.isEmpty())) {
                if (smartStoreApp.allGroups.isNullAllParams()) {
                    System.out.println("No group's parameter set. Please set any group's parameter first.");
                    break;
                }
            }

            String strGroup = chooseGroup().toUpperCase();

            if (strGroup.equals(ErrorMessage.END_MSG)) {
                break;
            } else {
                GroupType groupType;

                try {
                    groupType = GroupType.valueOf(strGroup);
                } catch (IllegalArgumentException e) {
                    System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
                    continue;
                }

                Group grp = smartStoreApp.allGroups.find(groupType);

                if (grp.getParam() == null) {
                    System.out.println("\nNo parameter. Set the parameter first.");
                    continue;
                }

                System.out.println();
                System.out.println(grp);
            }
        }
    }

    // Parameter
    public void updateParameter() {
        while (true) {
            if (!(smartStoreApp.allGroups.isNull() || smartStoreApp.allGroups.isEmpty())) {
                if (smartStoreApp.allGroups.isNullAllParams()) {
                    System.out.println("No group's parameter set. Please set any group's parameter first.");
                    break;
                }
            }

            String strGroup = chooseGroup().toUpperCase();

            if (strGroup.equals(ErrorMessage.END_MSG)) break;

            else {
                GroupType groupType;

                try {
                    groupType = GroupType.valueOf(strGroup);
                } catch (IllegalArgumentException e) {
                    System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
                    System.out.println(e);
                    break;
                }

                Group grp = smartStoreApp.allGroups.find(groupType);

                if (grp.getParam() == null) {
                    System.out.println("\nNo parameter. Set the parameter first.");
                    continue;
                }

                System.out.println("\n" + grp.toString());

                Parameter param = grp.getParam();

                while (true) {
                    try {
                        int pchoice = setParameterMenu();

                        if (pchoice == 1) {
                            setParameterMinimumSpentTime(param);
                        } else if (pchoice == 2) {
                            setParameterMinimumTotalPay(param);
                        } else if (pchoice == 3) {
                            break;
                        } else {
                            System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
                        smartStoreApp.scanner.next();
                    }
                }

                smartStoreApp.allCustomers.refresh(smartStoreApp.allGroups);

                System.out.println("\n" + grp.toString());
            }
        }
    }

//    public static void deleteParameter() {
//        while (true) {
//            String strGroup = chooseGroup().toUpperCase();
//
//            if (strGroup.equals(Message.END_MSG)) break;
//
//            else {
//                GroupType groupType;
//
//                try {
//                    groupType = GroupType.valueOf(strGroup);
//                } catch (IllegalArgumentException e) {
//                    System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
//                    System.out.println(e);
//                    break;
//                }
//
//                Group grp = allGroups.find(groupType);
//
//                if (grp.getParam() == null) {
//                    System.out.println("\nNo parameter. Set the parameter first.");
//                    continue;
//                }
//
//                System.out.println("\n" + grp.toString());
//
//                Parameter param = grp.getParam();
//
//                while (true) {
//                    try {
//                        int pchoice = setParameterMenu();
//
//                        if (pchoice == 1) {
//                            deleteParameterMinimumSpentTime(param);
//                        } else if (pchoice == 2) {
//                            deleteParameterMinimumTotalPay(param);
//                        } else if (pchoice == 3) {
//                            break;
//                        } else {
//                            System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
//                            continue;
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_TYPE);
//                        Menu.scanner.next();
//                    }
//                }
//
//                CustomerMenu.allCustomers.refresh(allGroups);
//
//                System.out.println("\n" + grp.toString());
//            }
//        }
//    }

    // Parameter
    public static int setParameterMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Minimum Spent Time");
                System.out.println(" 2. Minimum Total Pay");
                System.out.println(" 3. Back");
                System.out.println("==============================");
                System.out.print("Choose One: ");

                int choice = Integer.parseInt(smartStoreApp.scanner.next());
                if (choice < 1 || choice > 3) throw new InputRangeException();
                return choice;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }

    public static void setParameterMinimumSpentTime(Parameter param) {
        while (true) {
            try {
                System.out.println();
                System.out.print("Input Minimum Spent Time: ");

                int minimumSpentTime = Integer.parseInt(smartStoreApp.scanner.next());
                if (minimumSpentTime < 0) throw new InputRangeException();
                param.setMinimumSpentTime(minimumSpentTime);
                return;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }

    public static void setParameterMinimumTotalPay(Parameter param) {
        while (true) {
            try {
                System.out.println();
                System.out.print("Input Minimum Total Pay: ");

                int minimumTotalPay = Integer.parseInt(smartStoreApp.scanner.next());
                if (minimumTotalPay < 0) throw new InputRangeException();
                param.setMinimumTotalPay(minimumTotalPay);
                return;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }

    }

//    public static void deleteParameterMinimumSpentTime(Parameter param) {
//        param.setMinimumSpentTime(0);
//        System.out.println("Delete Finished. " + param);
//    }
//
//    public static void deleteParameterMinimumTotalPay(Parameter param) {
//        param.setMinimumTotalPay(0);
//        System.out.println("Delete Finished. " + param);
//    }

}
