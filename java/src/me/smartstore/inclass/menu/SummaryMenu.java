package me.smartstore.inclass.menu;

public class SummaryMenu extends Menu {
    private static SummaryMenu summaryMenu;

    private String[] menus
            = { "Summary",
            "Summary (Sorted By Name)",
            "Summary (Sorted By Spent Time)",
            "Summary (Sorted By Total Payment)",
            "Back"};

    /* method reflect */
    private String[] methods = { "summary", "sortedByName", "sortedBySpentTime", "sortedByTotalPayment" };

    private SummaryMenu() {}

    public static SummaryMenu getInstance() {
        if (summaryMenu == null) {
            summaryMenu = new SummaryMenu();
        }
        return summaryMenu;
    }

    public void summary() {
        System.out.println("summary");
    }

    public void sortedByName() {
        System.out.println("sortedByName");
    }

    public void sortedBySpentTime() {
        System.out.println("sortedBySpentTime");
    }

    public void sortedByTotalPayment() {
        System.out.println("sortedByTotalPayment");
    }

    @Override
    public void manage() {
        setInstance(summaryMenu);
        setMethods(methods);
        super.manage();
    }

    @Override
    public int dispMenu() {
        setMenus(menus);
        return super.dispMenu();
    }

}
