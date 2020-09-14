package com.ShoppingCatalogue.Exceptions;

public class UserMessage extends RuntimeException{
	
	

	private static final long serialVersionUID = 1L;
public String message;


public UserMessage(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}


}
