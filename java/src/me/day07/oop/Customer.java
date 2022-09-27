package me.day07.oop;

import java.util.Objects;

public class Customer {
    /* auto-generated */
    private String ID;
    private String name;
    /* auto-generated */
    private int totalPay;
    public static final String STORE_NAME = "SMARTSTORE";
    private static int total = 0;
    public Customer() {
        this.ID = String.format("%04d", (total+1));
        total++;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return totalPay == customer.totalPay && Objects.equals(ID, customer.ID) && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, totalPay);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", totalPay=" + totalPay +
                '}';
    }
}
