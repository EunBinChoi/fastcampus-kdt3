package me.day12.exception.spring.examples.strategy.application;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private String owner;
    private BigDecimal balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(String accountNumber, String owner, BigDecimal balance) {
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


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal depositMoney) {
        balance.add(depositMoney);
    }

    public void withdraw(BigDecimal withdrawMoney) throws InsufficientBalanceException {
        if (balance.compareTo(withdrawMoney) < 0) {
            throw new InsufficientBalanceException();
        }
        balance.subtract(withdrawMoney);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
