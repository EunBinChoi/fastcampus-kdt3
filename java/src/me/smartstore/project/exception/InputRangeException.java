package me.smartstore.project.exception;

public class InputRangeException extends RuntimeException {
    public InputRangeException() {
        super("Invalid Input. Please try again.");
    }

    public InputRangeException(String message) {
        super(message);
    }
}
