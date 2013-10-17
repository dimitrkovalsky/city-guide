package com.guide.city.exceptions;

public class ApplicationException extends Exception{
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException() {
		super();
	}
	
	public ApplicationException(Exception cause) {
		super(cause);
	}
	
	public ApplicationException(String message, Exception cause) {
		super(cause);
	}
}
