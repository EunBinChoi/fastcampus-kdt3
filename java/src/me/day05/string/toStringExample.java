package me.day05.string;

public class toStringExample {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Sally", MemberShip.NORMAL);
        Customer customer2 = new Customer("John", MemberShip.VIP);
        System.out.println(customer1);
        System.out.println(customer2);
    }
}
