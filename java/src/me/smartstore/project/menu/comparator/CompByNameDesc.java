package me.smartstore.project.menu.comparator;

import me.smartstore.project.customers.Customer;

import java.util.Comparator;

public class CompByNameDesc implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.compareTo(o2) * -1;
    }
}
