package com.guide.city.exceptions;

public class AuthenticationException extends ApplicationException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(Exception cause) {
        super(cause);
    }

    public AuthenticationException(String message, Exception cause) {
        super(cause);
    }
}