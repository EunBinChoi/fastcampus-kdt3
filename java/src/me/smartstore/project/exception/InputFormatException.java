package me.smartstore.project.exception;

public class InputFormatException extends RuntimeException {
    public InputFormatException() {
        super("Invalid Format for Input. Please try again.");
    }

    public InputFormatException(String message) {
        super(message);
    }
}
