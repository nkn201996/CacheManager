package com.licious.cache.exceptions;
public class NotFoundException extends RuntimeException {
    public NotFoundException(String k) {
        super("key-not-found: key='" + k + "'");
    }
}
