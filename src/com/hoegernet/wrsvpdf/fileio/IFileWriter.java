package com.hoegernet.wrsvpdf.fileio;

import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.Halle;
import com.hoegernet.wrsvpdf.types.Spieltag;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Tabelle;
import com.hoegernet.wrsvpdf.types.Team;
import com.hoegernet.wrsvpdf.types.Verein;

/**
 * Copyright 2007 Hoegernet IT Services
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: IFileWriter
 * 
 *         created: 18.01.2008
 * 
 */
public interface IFileWriter {
	
	/**
	 * @param staffel
	 * @param pdfFileName
	 * @throws PdfGeneratorException
	 */
	public void writeWRSVReport(Staffel staffel, String pdfFileName) throws PdfGeneratorException;
	
	/**
	 * @param staffel
	 * @param vereine
	 * @param pdfFileName
	 * @throws PdfGeneratorException
	 */
	public void writeClubReport(Staffel staffel, Verein[] vereine, String pdfFileName) throws PdfGeneratorException;
	
	/**
	 * @param staffel
	 * @param teams
	 * @param pdfFileName
	 * @throws PdfGeneratorException
	 */
	public void writeTeamReport(Staffel staffel, Team[] teams, String pdfFileName) throws PdfGeneratorException;
	
	/**
	 * @param staffel
	 * @param hallen
	 * @param pdfFileName
	 * @throws PdfGeneratorException
	 */
	public void writeHallenReport(Staffel staffel, Halle[] hallen, String pdfFileName) throws PdfGeneratorException;
	
	/**
	 * @param tabelle
	 * @param pdfFileName
	 * @throws PdfGeneratorException
	 */
	public void writeRankingReport(Tabelle tabelle, String pdfFileName) throws PdfGeneratorException;
	
	/**
	 * @param staffel
	 * @param tag
	 * @param pdfFileName
	 * @throws PdfGeneratorException
	 */
	public void writeSpieltagReport(Staffel staffel, Spieltag tag, String pdfFileName) throws PdfGeneratorException;
	
}