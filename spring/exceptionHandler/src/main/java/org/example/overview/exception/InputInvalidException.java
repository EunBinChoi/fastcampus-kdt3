package org.example.overview.exception;

public class InputInvalidException extends RuntimeException {
    public InputInvalidException() {
        super();
    }

    public InputInvalidException(String message) {
        super(message);
    }
}
