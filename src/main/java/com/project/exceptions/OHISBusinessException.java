package com.project.exceptions;

public class OHISBusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusCode;
	private String message;

	public OHISBusinessException() {
		super();
	}
	
	public OHISBusinessException(String message, String statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OHISBusinessException [statusCode=" + statusCode + ", message=" + message + "]";
	}

}
