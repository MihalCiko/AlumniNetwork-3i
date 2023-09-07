package com.mcode.alumninetwork3i.exception;

public class EmptyPostException extends RuntimeException {
    public EmptyPostException() {
    }

    public EmptyPostException(String message) {
        super(message);
    }
}
