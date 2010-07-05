/**
 *
 */
package com.hoegernet.wrsvpdf.exceptions;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: IllegalArgumentException
 * 
 *         created: 18.01.2008
 * 
 */
public class IllegalArgumentException extends PdfGeneratorException {
	
	private static final long serialVersionUID = 5790462224214115599L;
	

	/**
	 * Create new IllegalArgumentException.
	 * 
	 * @param message - Exception description
	 */
	public IllegalArgumentException(final String message) {
		super(message);
	}
}
