package me.day12.exception.examples.inheritance;

public class ExceptionA extends Exception {
    public ExceptionA() {
    }

    public ExceptionA(String message) {
        super(message);
    }
}
