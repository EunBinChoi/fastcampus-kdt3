package me.smartstore.inclass.menu;

public class CustomerMenu extends Menu {
    private static CustomerMenu customerMenu;
    private String[] menus
            = { "Set Customer Data", "View Customer Data", "Update Customer Data",  "Delete Customer Data", "Back"};

    /* method reflect */
    private String[] methods = { "setCusData", "viewCusData", "updateCusData", "deleteCusData" };

    private CustomerMenu() {}

    public static CustomerMenu getInstance() {
        if (customerMenu == null) {
            customerMenu = new CustomerMenu();
        }
        return customerMenu;
    }
    public void setCusData() {
        System.out.println("setCusData");
    }
    public void viewCusData() {
        System.out.println("viewCusData");
    }
    public void updateCusData() {
        System.out.println("updateCusData");
    }
    public void deleteCusData() {
        System.out.println("deleteCusData");
    }

    @Override
    public void manage() {
        setInstance(customerMenu);
        setMethods(methods);
        super.manage();
    }

    @Override
    public int dispMenu() {
        setMenus(menus);
        return super.dispMenu();
    }
}
