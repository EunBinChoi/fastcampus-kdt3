package org.example.overview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DatabaseDuplicateException extends RuntimeException {

    public DatabaseDuplicateException() {
    }

    public DatabaseDuplicateException(String message) {
        super(message);
    }
}
