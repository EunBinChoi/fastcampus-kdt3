package me.smartstore.inclass;

import me.smartstore.inclass.customers.Customer;
import me.smartstore.inclass.customers.Customers;
import me.smartstore.inclass.groups.Group;
import me.smartstore.inclass.groups.GroupType;
import me.smartstore.inclass.groups.Groups;
import me.smartstore.inclass.groups.Parameter;
import me.smartstore.inclass.menu.CustomerMenu;
import me.smartstore.inclass.menu.GroupMenu;
import me.smartstore.inclass.menu.Menu;
import me.smartstore.inclass.menu.SummaryMenu;
import me.smartstore.inclass.util.ErrorMessage;

import java.lang.reflect.InvocationTargetException;

public class SmartStoreApplication  {

    private static SmartStoreApplication smartStoreApp;

    /* customers object */
    private Customers allCustomers = Customers.getInstance();

    /* groups object */
    private Groups allGroups = Groups.getInstance();

    /* menu object */
    private Menu menu = Menu.getInstance();

    /* menu object */
    private GroupMenu groupMenu = GroupMenu.getInstance();
    private CustomerMenu customerMenu = CustomerMenu.getInstance();
    private SummaryMenu summaryMenu = SummaryMenu.getInstance();

    /* method reflect */
    private Class[] classes = { GroupMenu.class, CustomerMenu.class, SummaryMenu.class };
    private Object[] instances = { groupMenu, customerMenu, summaryMenu };
    private String[] methods = { "manage", "manage", "manage" };


    private SmartStoreApplication() {
    }

    public static SmartStoreApplication getInstance() {
        if (smartStoreApp == null) {
            smartStoreApp = new SmartStoreApplication();
        }
        return smartStoreApp;
    }

    public void details() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println("===========================================\n");
    }


    public SmartStoreApplication test() {
        allGroups.add(new Group(GroupType.GENERAL, new Parameter(10, 100000)));
        allGroups.add(new Group(GroupType.VIP, new Parameter(20, 200000)));
        allGroups.add(new Group(GroupType.VVIP, new Parameter(30, 300000)));

        for (int i = 0; i < 20; ++i) {
            allCustomers.add(new Customer("" + (char) (97 + i), (char) (97 + i) + "12345", i * 10, i * 100000));
        }
        return this;
    }

    /*
     * this is method for running application.
     * */
    public void run() {

        details();
        while (true) {
            int choice = menu.dispMenu();
            if (!(choice >= 1 && choice <= methods.length + 1)) { // + 1은 break 포함
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
            if (choice == methods.length + 1) {
                break; // back
            }

            try {
                int i = choice - 1;
                classes[i].getMethod(methods[i]).invoke(instances[i]);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
