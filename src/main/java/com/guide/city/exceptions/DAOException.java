package com.guide.city.exceptions;

public class DAOException extends ApplicationException
{
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException() {
		super();
	}
	
	public DAOException(Exception cause) {
		super(cause);
	}
	
	public DAOException(String message, Exception cause) {
		super(cause);
	}	
}
