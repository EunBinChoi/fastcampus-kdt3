package me.day12.exception.spring.examples.strategy.application;

import java.math.BigDecimal;

public class ApplicationExceptionExample {
    public static void main(String[] args) {
        System.out.println("1. 첫번째 전략 - 애플리케이션 예외 만들기");
        Account account = new Account("1234-5678", "sally", new BigDecimal(1000000));
        try {
            account.withdraw(new BigDecimal(2000000));
            System.out.println("정상적으로 출금되었습니다.");
        } catch (InsufficientBalanceException e) {
            System.out.println("잔고 금액이 부족합니다.");
            BigDecimal availableBalance = account.getBalance();
            System.out.println(account + "의 현재 사용 가능한 금액은 " + availableBalance + " 입니다.");
        }
        System.out.println();

        System.out.println("2. 두번째 전략 - 반환값을 통해 예외 확인");
        Account2 account2 = new Account2("2345-6789", "sally2", new BigDecimal(1000000));
        int ret = account2.withdraw(new BigDecimal(2000000));
        if (ret == 1) {
            System.out.println("정상적으로 출금되었습니다.");
        } else {
            System.out.println("잔고 금액이 부족합니다.");
            BigDecimal availableBalance = account.getBalance();
            System.out.println(account2 + "의 현재 사용 가능한 금액은 " + availableBalance + " 입니다.");
        }
    }
}
