package com.oberdan.listavip.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<?> handleNaoEncontradoException(NaoEncontradoException nee) {
		NaoEncontradoDetails detalhes = NaoEncontradoDetails.Builder
			.newBuilder()
			.message(nee.getMessage())
			.status(HttpStatus.NOT_FOUND.value())
			.timestamp(new Date().getTime())
			.build();
		return new ResponseEntity<>(detalhes, HttpStatus.NOT_FOUND);
	}
}
