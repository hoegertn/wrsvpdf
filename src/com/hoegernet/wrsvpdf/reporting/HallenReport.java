package com.hoegernet.wrsvpdf.reporting;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JasperPrint;

import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.Halle;
import com.hoegernet.wrsvpdf.types.Staffel;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: ClubReport
 * 
 *         created: 15.06.2009
 * 
 */
public class HallenReport extends AbstractGenerator {
	
	/**
	 * @param staffel
	 * @param hallen
	 * @return Report
	 * @throws PdfGeneratorException
	 */
	public static JasperPrint createReport(final Staffel staffel, final Halle[] hallen) throws PdfGeneratorException {
		AbstractGenerator.assertNull(staffel, "Staffel mustn't be null");
		
		final Vector<Object[]> vecjas = new Vector<Object[]>();
		
		for (final Halle h : hallen) {
			vecjas.add(new String[] {h.getName(), h.getStrasse(), h.getOrt(), h.getTel(), h.getVerein()});
		}
		
		final String[] columns = new String[] {"name", "strasse", "ort", "tel", "verein"};
		
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("writerVersion", Configuration.VERSION_FULL);
		parameters.put("title", staffel.getTitle());
		parameters.put("staffelname", staffel.getName());
		
		return AbstractGenerator.print(Configuration.REPORT_GYM, parameters, vecjas, columns, (staffel.getTitle().length() > Configuration.MAX_TITLE_LENGTH));
	}
	
}
