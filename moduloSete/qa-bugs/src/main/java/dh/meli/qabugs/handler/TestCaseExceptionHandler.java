package dh.meli.qabugs.handler;

import dh.meli.qabugs.exceptions.TestCaseBadRequestException;
import dh.meli.qabugs.exceptions.TestCaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TestCaseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TestCaseNotFoundException.class)
    public ResponseEntity<TestCaseExceptionsDetails> handleTestCaseNotFoundException(TestCaseNotFoundException exception) {
        return new ResponseEntity<>(
                TestCaseExceptionsDetails.builder()
                        .message(exception.getMessage())
                        .errorType("NOT_FOUND")
                        .statusCode(404)
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(TestCaseBadRequestException.class)
    public ResponseEntity<TestCaseExceptionsDetails> handleTestCaseBadRequestException(TestCaseBadRequestException exception) {
        return new ResponseEntity<>(
                TestCaseExceptionsDetails.builder()
                        .message(exception.getMessage())
                        .errorType("BAD_REQUEST")
                        .statusCode(400)
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }
}
