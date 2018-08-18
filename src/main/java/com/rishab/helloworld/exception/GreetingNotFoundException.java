package com.rishab.helloworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GreetingNotFoundException extends RuntimeException {
    public GreetingNotFoundException(Long greetingId) {
        super("Could not find greeting id " + Long.toString(greetingId));
    }
}
