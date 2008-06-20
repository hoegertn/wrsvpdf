/**
 *
 */
package com.hoegernet.wrsvpdf.exceptions;

/**
 * Copyright 2007 Hoegernet IT Services
 * @author Thorsten Höger
 *
 * Projekt: com.hoegernet.wrsvpdf
 * Type: ParseException
 *
 * created: 18.01.2008
 *
 */
public class ParseException extends PdfGeneratorException {

	private static final long serialVersionUID = -6689964929519380647L;

	/**
	 * @param message
	 */
	public ParseException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ParseException(String message, Throwable cause) {
		super(message, cause);
	}

}
