package com.commerce.microcommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProduitGratuitException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6386438030231024088L;

	public ProduitGratuitException(String s) {
		super(s);
	}

}
