package com.gino.zombie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Gino
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidMovementException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMovementException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidMovementException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
