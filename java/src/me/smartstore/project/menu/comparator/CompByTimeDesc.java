package me.smartstore.project.menu.comparator;

import me.smartstore.project.customers.Customer;

import java.util.Comparator;

public class CompByTimeDesc implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getSpentTime() < o2.getSpentTime()) {
            return 1;
        } else if (o1.getSpentTime() == o2.getSpentTime()) {
            return o1.getName() != null && o2.getName() != null ? o1.getName().compareTo(o2.getName()) : 0;
        } else {
            return -1;
        }
    }
}
