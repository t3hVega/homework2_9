package com.homework.homework29.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NameStartsWithLowerCase extends RuntimeException {
    public NameStartsWithLowerCase(String exception) {
        super(exception);
    }
}
