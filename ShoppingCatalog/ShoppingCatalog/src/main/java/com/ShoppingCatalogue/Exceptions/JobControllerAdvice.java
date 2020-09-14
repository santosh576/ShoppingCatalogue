package com.ShoppingCatalogue.Exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class JobControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserMessage.class)
	public @ResponseBody ResponseException noremainingbudget(final Exception e,final HttpServletRequest request)
	{
		ResponseException rex=new ResponseException();
		rex.setRequestURI(request.getRequestURI());
		rex.setMessage(e.getMessage());
		return rex;
	}

}
