/**
 *
 */
package com.hoegernet.wrsvpdf.exceptions;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: ParseException
 * 
 *         created: 18.01.2008
 * 
 */
public class ParseException extends PdfGeneratorException {
	
	private static final long serialVersionUID = -6689964929519380647L;
	

	/**
	 * Create new ParseException.
	 * 
	 * @param message - Exception description
	 */
	public ParseException(final String message) {
		super(message);
	}
	
	/**
	 * Create new ParseException.
	 * 
	 * @param message - Exception description
	 * @param cause - Root Cause of this exception
	 */
	public ParseException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
}
