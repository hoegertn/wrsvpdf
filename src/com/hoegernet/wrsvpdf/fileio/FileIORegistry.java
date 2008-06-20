/**
 *
 */
package com.hoegernet.wrsvpdf.fileio;

/**
 * Copyright 2007 Hoegernet IT Services
 * @author Thorsten Höger
 *
 * Projekt: com.hoegernet.wrsvpdf
 * Type: FileIORegistry
 *
 * created: 18.01.2008
 *
 */
public class FileIORegistry {

	/**
	 * instance
	 */
	private static FileIORegistry instance = null;

	/**
	 * get singelton instance
	 * @return instance
	 */
	public static FileIORegistry getInstance() {
		if (FileIORegistry.instance == null) {
			FileIORegistry.instance = new FileIORegistry();
		}
		return FileIORegistry.instance;
	}

	private IFileImporter importer;

	private IFileWriter writer;

	/**
	 * private constructor
	 */
	private FileIORegistry() {
		// private constructor stub
	}

	/**
	 * @return the importer
	 */
	public static IFileImporter getImporter() {
		return FileIORegistry.getInstance().importer;
	}

	/**
	 * @param importer the importer to set
	 */
	public void setImporter(IFileImporter importer) {
		this.importer = importer;
	}

	/**
	 * @return the writer
	 */
	public static IFileWriter getWriter() {
		return FileIORegistry.getInstance().writer;
	}

	/**
	 * @param writer the writer to set
	 */
	public void setWriter(IFileWriter writer) {
		this.writer = writer;
	}

}
