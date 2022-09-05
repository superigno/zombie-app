package com.gino.zombie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Gino
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ZombieException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZombieException(String errorMessage) {
		super(errorMessage);
	}

	public ZombieException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
