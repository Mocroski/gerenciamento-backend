package com.devmocroski.backend.responses;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

	private LocalDateTime timestamp;
	
	private int status;
	
	private String message;
}
