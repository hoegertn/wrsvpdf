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
	
	protected static void assertNull(final Object o, final String message) throws com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException {
		if (o == null) {
			throw new com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException(message);
		}
	}
	
	protected static void assertEmpty(final String o, final String message) throws com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException {
		AbstractGenerator.assertEmpty(o, message);
		if (o.isEmpty()) {
			throw new com.hoegernet.wrsvpdf.exceptions.IllegalArgumentException(message);
		}
	}
	
	protected static JasperPrint print(final String fileName, final Map<String, String> parameters, final Vector<Object[]> vecjas, final String[] columns, final boolean large) throws PdfGeneratorException {
		JasperReport jr;
		JasperPrint jprint = null;
		try {
			parameters.put("writerVersion", Configuration.VERSION_FULL);
			parameters.put("datetime", new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
			
			if (large) {
				jr = JasperCompileManager.compileReport(fileName + "_large.jrxml");
			} else {
				jr = JasperCompileManager.compileReport(fileName + ".jrxml");
			}
			
			jprint = JasperFillManager.fillReport(jr, parameters, new HoegernetDataSource(vecjas, columns));
		} catch (final Exception ex) {
			throw new PdfGeneratorException(ex);
		}
		
		return jprint;
	}
	
	protected static void concatReport(final JasperPrint master, final JasperPrint extarReport) {
		for (final Object obj : extarReport.getPages()) {
			if (obj instanceof JRPrintPage) {
				master.addPage((JRPrintPage) obj);
			}
		}
	}
}
