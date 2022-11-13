package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputEmptyException extends RuntimeException {
    public InputEmptyException() {
        super();
    }

    public InputEmptyException(String message) {
        super(message);
    }
}
