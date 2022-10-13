package me.smartstore.project.customers;

import me.smartstore.project.groups.Group;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String serialNO;
    private String name;
    private String userID;
    private int spentTime;
    private int totalPay;
    private Group group;
    private static int AUTO_GENERATOR = 0;

    public Customer() {
        ++AUTO_GENERATOR;
        this.serialNO = String.format("%04d", AUTO_GENERATOR);
    }

    public Customer(String name, String userID, int spentTime, int totalPay) {
        ++AUTO_GENERATOR;
        this.serialNO = String.format("%04d", AUTO_GENERATOR);
        this.name = name;
        this.userID = userID;
        this.spentTime = spentTime;
        this.totalPay = totalPay;
    }

    public String getSerialNO() {
        return this.serialNO;
    }

    private void setSerialNO(String serialNO) {
        this.serialNO = serialNO;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getSpentTime() {
        return this.spentTime;
    }

    public void setSpentTime(int spentTime) {
        this.spentTime = spentTime;
    }

    public int getTotalPay() {
        return this.totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Customer customer = (Customer)o;
            return this.spentTime == customer.spentTime && this.totalPay == customer.totalPay && Objects.equals(this.serialNO, customer.serialNO) && Objects.equals(this.name, customer.name) && Objects.equals(this.userID, customer.userID) && Objects.equals(this.group, customer.group);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.serialNO, this.name, this.userID, this.spentTime, this.totalPay, this.group);
    }

    public String toString() {
        return "Customer{serialNO='" + this.serialNO + "', name='" + this.name + "', userID='" + this.userID + "', spentTime=" + this.spentTime + ", totalPay=" + this.totalPay + "}";
    }

    public int compareTo(Customer o) {
        if (this.name.compareTo(o.name) < 0) return -1;
        else if (this.name.compareTo(o.name) == 0) return this.userID.compareTo(o.userID);
        else return 1;

    }
}
