package com.indbank.indbankrestfulwebservices.auth.jwt;

public class AuthenticationException extends RuntimeException {
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}
