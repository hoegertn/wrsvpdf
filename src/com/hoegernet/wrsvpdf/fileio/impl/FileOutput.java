package com.hoegernet.wrsvpdf.fileio.impl;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.hoegernet.common.logger.Logger;
import com.hoegernet.wrsvpdf.exceptions.FileIOException;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.fileio.FileIORegistry;
import com.hoegernet.wrsvpdf.fileio.IFileWriter;
import com.hoegernet.wrsvpdf.reporting.Generator;
import com.hoegernet.wrsvpdf.types.Halle;
import com.hoegernet.wrsvpdf.types.Spieltag;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Tabelle;
import com.hoegernet.wrsvpdf.types.Team;
import com.hoegernet.wrsvpdf.types.Verein;
import com.hoegernet.wrsvpdf.types.WRSVPerson;

/**
 * type: com.hoegernet.wrsvpdf->FileOutput
 *
 * @author Thorsten Hoeger
 * created: 23.07.2007
 * file: FileOutput.java
 *
 */
@Deprecated
public class FileOutput implements IFileWriter {

	public void writeWRSVReport(Staffel staffel, String pdfFileName) throws PdfGeneratorException {
		Logger.getInstance().logInfo("FileOutput", "Writing WRSV report to file: " + pdfFileName);

		WRSVPerson[] wrsv = FileIORegistry.getImporter().loadWRSVPersonenFromFile("wrsv.ini");
		JasperPrint jp = Generator.createWRSVReport(staffel, wrsv);
		try {
			JasperExportManager.exportReportToPdfFile(jp, pdfFileName);
			Logger.getInstance().logInfo("FileOutput", "Writing DONE");
		} catch (JRException ex) {
			Logger.getInstance().logError("FileOutput", "Writing failed: " + ex.getMessage());
			throw new FileIOException("Error writing file: " + pdfFileName, ex);
		}
	}

	public void writeClubReport(Staffel staffel, Verein[] vereine, String pdfFileName) throws PdfGeneratorException {
		Logger.getInstance().logInfo("FileOutput", "Writing Club report to file: " + pdfFileName);
		JasperPrint jp = Generator.createClubReport(staffel, vereine);
		try {
			JasperExportManager.exportReportToPdfFile(jp, pdfFileName);
			Logger.getInstance().logInfo("FileOutput", "Writing DONE");
		} catch (JRException ex) {
			Logger.getInstance().logError("FileOutput", "Writing failed: " + ex.getMessage());
			throw new FileIOException("Error writing file: " + pdfFileName, ex);
		}
	}

	public void writeTeamReport(Staffel staffel, Team[] teams, String pdfFileName) throws PdfGeneratorException {
		Logger.getInstance().logInfo("FileOutput", "Writing Team report to file: " + pdfFileName);
		JasperPrint jp = Generator.createTeamReport(staffel, teams);
		try {
			JasperExportManager.exportReportToPdfFile(jp, pdfFileName);
			Logger.getInstance().logInfo("FileOutput", "Writing DONE");
		} catch (JRException ex) {
			Logger.getInstance().logError("FileOutput", "Writing failed: " + ex.getMessage());
			throw new FileIOException("Error writing file: " + pdfFileName, ex);
		}
	}

	public void writeHallenReport(Staffel staffel, Halle[] hallen, String pdfFileName) throws PdfGeneratorException {
		Logger.getInstance().logInfo("FileOutput", "Writing Hallen report to file: " + pdfFileName);
		JasperPrint jp = Generator.createHallenReport(staffel, hallen);
		try {
			JasperExportManager.exportReportToPdfFile(jp, pdfFileName);
			Logger.getInstance().logInfo("FileOutput", "Writing DONE");
		} catch (JRException ex) {
			Logger.getInstance().logError("FileOutput", "Writing failed: " + ex.getMessage());
			throw new FileIOException("Error writing file: " + pdfFileName, ex);
		}
	}

	public void writeRankingReport(Tabelle tabelle, String pdfFileName) throws PdfGeneratorException {
		Logger.getInstance().logInfo("FileOutput", "Writing Ranking report to file: " + pdfFileName);
		JasperPrint jp = Generator.createRankingReport(tabelle);
		try {
			JasperExportManager.exportReportToPdfFile(jp, pdfFileName);
			Logger.getInstance().logInfo("FileOutput", "Writing DONE: ");
		} catch (JRException ex) {
			Logger.getInstance().logError("FileOutput", "Writing failed: " + ex.getMessage());
			throw new FileIOException("Error writing file: " + pdfFileName, ex);
		}
	}

	public void writeSpieltagReport(Staffel staffel, Spieltag tag, String pdfFileName) throws PdfGeneratorException {
		Logger.getInstance().logInfo("FileOutput", "Writing Spieltag report to file: " + pdfFileName);
		JasperPrint jp = Generator.createSpieltagReport(staffel, tag, null);
		try {
			JasperExportManager.exportReportToPdfFile(jp, pdfFileName);
			Logger.getInstance().logInfo("FileOutput", "Writing DONE");
		} catch (JRException ex) {
			Logger.getInstance().logError("FileOutput", "Writing failed" + ex.getMessage());
			throw new FileIOException("Error writing file: " + pdfFileName, ex);
		}
	}

}
