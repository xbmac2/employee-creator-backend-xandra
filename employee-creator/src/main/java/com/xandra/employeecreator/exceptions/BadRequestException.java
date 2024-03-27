package com.xandra.employeecreator.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final HttpStatus statusCode = HttpStatus.BAD_REQUEST;
	
	public <T> BadRequestException(String message) {
		super(String.format("%s", message));
	}
	
	public static HttpStatus getStatusCode() {
		return statusCode;
	}

}
