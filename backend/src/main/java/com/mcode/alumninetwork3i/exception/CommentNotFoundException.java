package com.mcode.alumninetwork3i.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException() {
    }

    public CommentNotFoundException(String message) {
        super(message);
    }
}
