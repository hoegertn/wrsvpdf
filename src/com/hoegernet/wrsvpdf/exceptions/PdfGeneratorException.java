package com.hoegernet.wrsvpdf.exceptions;

/**
 * Copyright 2007 Hoegernet IT Services
 * @author Thorsten Höger
 *
 * Projekt: com.hoegernet.wrsvpdf
 * Type: PdfGeneratorException
 *
 * created: 18.01.2008
 *
 */
public class PdfGeneratorException extends Exception {

	private static final long serialVersionUID = 2548481751377264429L;

	/**
	 * @param message
	 */
	public PdfGeneratorException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PdfGeneratorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public PdfGeneratorException(Throwable cause) {
		super(cause);
	}


}
