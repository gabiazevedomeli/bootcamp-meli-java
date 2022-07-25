package com.dh.meli.perolas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JewelBadRequestException extends RuntimeException {
    public JewelBadRequestException(String message) {
        super(message);
    }
}
