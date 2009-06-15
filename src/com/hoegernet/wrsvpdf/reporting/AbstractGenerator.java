package com.hoegernet.wrsvpdf.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import com.hoegernet.jaspertools.HoegernetDataSource;
import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: AbstractGenerator
 * 
 *         created: 15.06.2009
 * 
 */
public abstract class AbstractGenerator {
	
	/**
	 * @param o - assert that o is not null
	 * @param message - message to throw
	 * @throws com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException
	 */
	protected static void assertNull(Object o, String message) throws com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException {
		if (o == null) {
			throw new com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException(message);
		}
	}
	
	/**
	 * @param o - String to check
	 * @param message - message to throw
	 * @throws com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException
	 */
	protected static void assertEmpty(String o, String message) throws com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException {
		AbstractGenerator.assertEmpty(o, message);
		if (o.isEmpty()) {
			throw new com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException(message);
		}
	}
	
	/**
	 * @param fileName
	 * @param parameters
	 * @param vecjas
	 * @param columns
	 * @return JasperPrint
	 * @throws PdfGeneratorException
	 */
	protected static JasperPrint print(String fileName, Map<String, String> parameters, Vector<Object[]> vecjas, String[] columns) throws PdfGeneratorException {
		JasperReport jr;
		JasperPrint jprint = null;
		try {
			parameters.put("writerVersion", Configuration.VERSION_FULL);
			parameters.put("datetime", new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
			
			jr = JasperCompileManager.compileReport(fileName);
			jprint = JasperFillManager.fillReport(jr, parameters, new HoegernetDataSource(vecjas, columns));
		} catch (Exception ex) {
			throw new PdfGeneratorException(ex);
		}
		
		return jprint;
	}
	
	protected static void concatReport(JasperPrint master, JasperPrint extarReport) {
		for (Object obj : extarReport.getPages()) {
			if (obj instanceof JRPrintPage) {
				master.addPage((JRPrintPage) obj);
			}
		}
	}
}
