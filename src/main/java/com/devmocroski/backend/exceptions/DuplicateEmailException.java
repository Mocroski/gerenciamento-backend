package com.devmocroski.backend.exceptions;

public class DuplicateEmailException extends CustomException {

	public DuplicateEmailException() {
		super("E-mail já cadastrado");
	}

	public DuplicateEmailException(String message) {
		super(message);
	}

	public DuplicateEmailException(String message, Throwable cause) {
		super(message, cause);
	}

}
