package com.hoegernet.wrsvpdf.fileio;

/**
 * This class saves the staffel-File for use in different panels
 * 
 * Copyright 2008 Hoegernet IT Services
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: FileMemory
 * 
 *         created: 06.03.2008
 * 
 */
public class FileMemory {
	
	/**
	 * instance
	 */
	private static FileMemory instance = null;
	

	/**
	 * get singelton instance
	 * 
	 * @return instance
	 */
	public static FileMemory getInstance() {
		if (FileMemory.instance == null) {
			FileMemory.instance = new FileMemory();
		}
		return FileMemory.instance;
	}
	

	private String staffelFile = "";
	

	/**
	 * private constructor
	 */
	private FileMemory() {
		// private constructor stub
	}
	
	/**
	 * @param staffelFile
	 */
	public void setStaffelFile(final String staffelFile) {
		this.staffelFile = staffelFile;
	}
	
	/**
	 * @return -
	 */
	public String getStaffelFile() {
		return this.staffelFile;
	}
	
}
