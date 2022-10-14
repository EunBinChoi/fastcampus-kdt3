package me.smartstore.inclass.exception;

import me.smartstore.inclass.util.ErrorMessage;

public class InputEmptyException extends Exception {

    public InputEmptyException() {
        super(ErrorMessage.ERR_MSG_INVALID_INPUT_EMPTY);
    }

    public InputEmptyException(String message) {
        super(message);
    }
}
