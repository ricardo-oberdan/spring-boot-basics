package com.oberdan.listavip.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontradoException extends RuntimeException {
	
	public NaoEncontradoException(String message) {
		super(message);
	}

}
