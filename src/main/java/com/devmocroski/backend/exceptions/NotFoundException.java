package com.devmocroski.backend.exceptions;

public class NotFoundException extends CustomException{

	public NotFoundException() {
		super("Não existem usuarios cadastrados");
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
