package com.commerce.microcommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrovableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3867452135185097921L;

	/**
	 * 
	 */


	public ProduitIntrovableException(String s) {
		super(s);
	}

}
