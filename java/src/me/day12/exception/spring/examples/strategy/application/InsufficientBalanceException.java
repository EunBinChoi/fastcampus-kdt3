package me.day12.exception.spring.examples.strategy.application;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
