/**
 *
 */
package com.hoegernet.wrsvpdf.exceptions;

/**
 * Copyright 2007 Hoegernet IT Services
 * @author Thorsten Höger
 *
 * Projekt: com.hoegernet.wrsvpdf
 * Type: FileIOException
 *
 * created: 18.01.2008
 *
 */
public class FileIOException extends PdfGeneratorException {

	private static final long serialVersionUID = -7708960040975991879L;

	/**
	 * Create new FileIOException.
	 *
	 * @param message - Exception description
	 * @param cause - Root Cause of this exception
	 */
	public FileIOException(String message, Throwable cause) {
		super(message, cause);
	}



}
