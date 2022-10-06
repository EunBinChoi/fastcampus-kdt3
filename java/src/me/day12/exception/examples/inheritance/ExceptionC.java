package me.day12.exception.examples.inheritance;

public class ExceptionC extends ExceptionB {
    private final static String MESSAGE = "ExceptionC";

    public ExceptionC() {
        super(MESSAGE);
    }

    public ExceptionC(String message) {
        super(message);
    }

    public ExceptionC(String message, Throwable cause) {
        super(message, cause);
    }
}
