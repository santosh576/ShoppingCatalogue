package com.ShoppingCatalogue.Exceptions;

public class ResponseException {

	public String requestURI;
	public String message;
	
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
