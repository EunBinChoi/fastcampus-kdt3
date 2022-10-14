package me.smartstore.inclass.exception;

import me.smartstore.inclass.util.ErrorMessage;

public class InputFormatException extends Exception {
    public InputFormatException() {
        super(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
    }

    public InputFormatException(String message) {
        super(message);
    }
}
