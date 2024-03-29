package com.dh.meli.perolas.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JewelNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerJewelNotFound(JewelNotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(JewelBadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerJewelBadRequest(JewelBadRequestException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                    HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<ExceptionDetails> handleInternalServerError(InternalServerError ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        return new ResponseEntity<>(
                    ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .title("Campos inválidos")
                        .message(ex.getClass().getName())
                        .fields(errors.stream().map(
                                FieldError::getField).collect(Collectors.joining("; ")))
                        .fieldsMessages(errors.stream().map(
                                FieldError::getDefaultMessage).collect(Collectors.joining("; ")))
                        .build()
                , status
        );
    }
}



















