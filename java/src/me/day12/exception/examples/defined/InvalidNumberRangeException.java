package me.day12.exception.examples.defined;

public class InvalidNumberRangeException extends RuntimeException {
    public InvalidNumberRangeException() {
    }

    public InvalidNumberRangeException(String message) {
        super(message);
    }
}
