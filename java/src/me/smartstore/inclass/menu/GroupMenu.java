package me.smartstore.inclass.menu;

public class GroupMenu extends Menu {
    private static GroupMenu groupMenu;
    private String[] menus
            = { "Set Parameter", "View Parameter", "Update Parameter",  "Back"};

    /* method reflect */
    private String[] methods = { "setParam", "viewParam", "updateParam" };

    private GroupMenu() {}

    public static GroupMenu getInstance() {
        if (groupMenu == null) {
            groupMenu = new GroupMenu();
        }
        return groupMenu;
    }

    public void setParam() {
        System.out.println("setParam");
    }
    public void viewParam() {
        System.out.println("viewParam");
    }
    public void updateParam() {
        System.out.println("updateParam");
    }

    @Override
    public void manage() {
        setInstance(groupMenu);
        setMethods(methods);
        super.manage();
    }

    @Override
    public int dispMenu() {
        setMenus(menus);
        return super.dispMenu();
    }
}
