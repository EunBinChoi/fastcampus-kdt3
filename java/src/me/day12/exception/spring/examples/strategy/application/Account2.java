package me.day12.exception.spring.examples.strategy.application;

import java.math.BigDecimal;

public class Account2 {
    private String accountNumber;
    private String owner;
    private BigDecimal balance;

    public Account2(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account2(String accountNumber, String owner, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal depositMoney) {
        balance.add(depositMoney);
        return balance;
    }

    public int withdraw(BigDecimal withdrawMoney) {
        if (balance.compareTo(withdrawMoney) < 0) {
            return -1;
        }
        balance.subtract(withdrawMoney);
        return 1;
    }

    @Override
    public String toString() {
        return "Account2{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
