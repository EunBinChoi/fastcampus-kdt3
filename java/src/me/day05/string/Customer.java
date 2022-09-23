package me.day05.string;

import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    private MemberShip membership;
    private static int IDGEN = 0; // id generator

    public Customer(String name, MemberShip membership) {
        this.id = ++Customer.IDGEN;
        this.name = name;
        this.membership = membership;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberShip getMembership() {
        return membership;
    }

    public void setMembership(MemberShip membership) {
        this.membership = membership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && membership == customer.membership;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, membership);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", membership=" + membership +
                '}';
    }
}
