package com.alura.challenge.backend3.exception;

public class EmailInUseException extends Exception {
	public EmailInUseException(String errorMessage) {
		super(errorMessage);
	}
}
