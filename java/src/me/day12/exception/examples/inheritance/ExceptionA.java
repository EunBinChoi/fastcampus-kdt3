package me.day12.exception.examples.inheritance;

public class ExceptionA extends Exception {
    private final static String MESSAGE = "ExceptionA";
    public ExceptionA() {
        super(MESSAGE);
    }

    public ExceptionA(String message) {
        super(message);
    }

    public ExceptionA(String message, Throwable cause) {
        super(message, cause);
    }
}
