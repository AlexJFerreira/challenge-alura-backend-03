package com.alura.challenge.backend3.exception;

public class EmptyFileException extends Exception {
    public EmptyFileException(String errorMessage) {
        super(errorMessage);
    }
}
