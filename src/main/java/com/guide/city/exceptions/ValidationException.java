package com.guide.city.exceptions;

public class ValidationException extends ApplicationException
{

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException() {
        super();
    }

    public ValidationException(Exception cause) {
        super(cause);
    }

    public ValidationException(String message, Exception cause) {
        super(cause);
    }
}