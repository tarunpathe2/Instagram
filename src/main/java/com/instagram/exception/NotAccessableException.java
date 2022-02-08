package com.instagram.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class NotAccessableException extends RuntimeException{

	public NotAccessableException(String message)
	{
		super(message);
	}
}
