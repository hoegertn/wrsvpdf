package com.hoegernet.wrsvpdf.fileio;

import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.Halle;
import com.hoegernet.wrsvpdf.types.Spieltag;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Tabelle;
import com.hoegernet.wrsvpdf.types.Team;
import com.hoegernet.wrsvpdf.types.Verein;
import com.hoegernet.wrsvpdf.types.WRSVPerson;

/**
 * Copyright 2007 Hoegernet IT Services
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: IFileImporter
 * 
 *         created: 18.01.2008
 * 
 */
public interface IFileImporter {
	
	/**
	 * @param filename
	 * @return Staffel
	 * @throws PdfGeneratorException
	 */
	public Staffel loadStaffelFromFile(String filename) throws PdfGeneratorException;
	
	/**
	 * @param filename
	 * @return Hallenliste
	 * @throws PdfGeneratorException
	 */
	public Halle[] loadHallenFromFile(String filename) throws PdfGeneratorException;
	
	/**
	 * @param filename
	 * @return Mannschaftsliste
	 * @throws PdfGeneratorException
	 */
	public Team[] loadTeamsFromFile(String filename) throws PdfGeneratorException;
	
	/**
	 * @param filename
	 * @return Vereinsliste
	 * @throws PdfGeneratorException
	 */
	public Verein[] loadClubsFromFile(String filename) throws PdfGeneratorException;
	
	/**
	 * @param filename
	 * @return Spieltag
	 * @throws PdfGeneratorException
	 */
	public Spieltag loadSpieltagFromFile(String filename) throws PdfGeneratorException;
	
	/**
	 * @param filename
	 * @return Funktionaere
	 * @throws PdfGeneratorException
	 */
	public WRSVPerson[] loadWRSVPersonenFromFile(String filename) throws PdfGeneratorException;
	
	/**
	 * @param filename
	 * @return {@link Tabelle}
	 * @throws PdfGeneratorException
	 */
	public Tabelle loadRankingFromFile(String filename) throws PdfGeneratorException;
	
}