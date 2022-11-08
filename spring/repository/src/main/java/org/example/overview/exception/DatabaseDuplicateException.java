package org.example.overview.exception;

public class DatabaseDuplicateException extends RuntimeException {

    public DatabaseDuplicateException() {
    }

    public DatabaseDuplicateException(String message) {
        super(message);
    }
}
