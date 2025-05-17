package com.e_commerce.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloabalExceptionhandler {
	
	@ExceptionHandler(NoResourceFoundException.class)
	public String handle() {
		return "404.html";
	}

}
