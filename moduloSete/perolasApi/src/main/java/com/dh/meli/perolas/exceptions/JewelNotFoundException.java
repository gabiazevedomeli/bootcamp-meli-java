package com.dh.meli.perolas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JewelNotFoundException extends RuntimeException {
    public JewelNotFoundException(String message) {
        super(message);
    }
}
