package me.day12.exception.examples.defined;

public class InvalidNumberRangeException extends Exception {
    private final static String MESSAGE = "InvalidNumberRangeException";
    public InvalidNumberRangeException() {
        super(MESSAGE);
    }

    public InvalidNumberRangeException(String message) {
        super(message);
    }

    public InvalidNumberRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
