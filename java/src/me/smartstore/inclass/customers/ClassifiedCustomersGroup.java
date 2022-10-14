package me.smartstore.inclass.customers;

public class ClassifiedCustomersGroup {
    protected ClassifiedCustomers[] classifiedCustomers;
    private static ClassifiedCustomersGroup classifiedCustomersGroup;

    private ClassifiedCustomersGroup() {}

    public static ClassifiedCustomersGroup getInstance() {
        if (classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }
}
