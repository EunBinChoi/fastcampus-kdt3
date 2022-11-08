package org.example.overview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InputEmptyException extends RuntimeException {
    public InputEmptyException() {
        super();
    }

    public InputEmptyException(String message) {
        super(message);
    }
}
