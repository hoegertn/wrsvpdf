package com.hoegernet.wrsvpdf.exceptions;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: PdfGeneratorException
 * 
 *         created: 18.01.2008
 * 
 */
public class PdfGeneratorException extends Exception {
	
	private static final long serialVersionUID = 2548481751377264429L;
	

	/**
	 * Create new PdfGeneratorException.
	 * 
	 * @param message - Exception description
	 */
	public PdfGeneratorException(final String message) {
		super(message);
	}
	
	/**
	 * Create new PdfGeneratorException.
	 * 
	 * @param message - Exception description
	 * @param cause - Root Cause of this exception
	 */
	public PdfGeneratorException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Create new PdfGeneratorException.
	 * 
	 * @param cause - Root Cause of this exception
	 */
	public PdfGeneratorException(final Throwable cause) {
		super(cause);
	}
	
}
