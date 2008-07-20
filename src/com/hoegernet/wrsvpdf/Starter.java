/**
 *
 */
package com.hoegernet.wrsvpdf;

import com.hoegernet.common.logger.Logger;
import com.hoegernet.wrsvpdf.fileio.FileIORegistry;
import com.hoegernet.wrsvpdf.fileio.impl.FlatFileImport;
import com.hoegernet.wrsvpdf.ui.MainFrame;

/**
 * Main Class for WRSV-PDF.<br>
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: Starter
 * 
 *         created: 15.11.2007
 * 
 */
public class Starter {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger.getInstance().addFileLogger(Configuration.LOG_FILENAME, true);
		Logger.getInstance().redirectSysout();
		Logger.getInstance().redirectSyserr();
		Logger.getInstance().setLogLevel(Configuration.LOG_LEVEL);
		
		Logger.getInstance().logInfo("Starter", "Launching PDF Generator [build:" + Configuration.VERSION_FULL + "] ...");
		
		FileIORegistry.getInstance().setImporter(new FlatFileImport());
		
		new MainFrame();
	}
	
}
