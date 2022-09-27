package me.day07.oop;

public class Customers {
    public static final int NUM_CUSTOMER = 10;
    public Customer[] customers = new Customer[NUM_CUSTOMER];

    public Customers() {
        initialize();
    }
    public void initialize() {
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer();
        }
    }
    public void random() {
        for (int i = 0; i < customers.length; i++) {
            int totalPay = (int)(Math.random() * 10000000); // 0 <=    < 10,000,000
            customers[i].setName(Character.toString((char) ((i) % ('z'-'a' + 1) + 'a')));
        }
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    // is it right code?
    public Grade classify(Parameters parameters) {
        // TODO: Write Code for Classifying the Customers with Parameters
        return null;
    }

}
