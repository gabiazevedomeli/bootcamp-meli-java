package dh.meli.qabugs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(String message) {
        super(message);
    }
}
