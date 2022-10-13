package me.smartstore.project.exception;

import me.smartstore.project.util.Message;

public class InputEmptyException extends RuntimeException {

    public InputEmptyException() {
        super(Message.ERR_MSG_INVALID_INPUT_EMPTY);
    }

    public InputEmptyException(String message) {
        super(message);
    }
}
