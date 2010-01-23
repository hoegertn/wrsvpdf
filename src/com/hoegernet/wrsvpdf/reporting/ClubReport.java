package com.hoegernet.wrsvpdf.reporting;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JasperPrint;

import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Verein;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: ClubReport
 * 
 *         created: 15.06.2009
 * 
 */
public class ClubReport extends AbstractGenerator {
	
	/**
	 * @param staffel
	 * @param vereine
	 * @return Report
	 * @throws PdfGeneratorException
	 */
	public static JasperPrint createReport(final Staffel staffel, final Verein[] vereine) throws PdfGeneratorException {
		AbstractGenerator.assertNull(staffel, "Staffel mustn't be null");
		
		final Vector<Object[]> vecjas = new Vector<Object[]>();
		
		for (final Verein v : vereine) {
			vecjas.add(new String[] {v.getName(), v.getPerson(), v.getStrasse(), v.getOrt(), v.getTel(), v.getFax(), v.getMail()});
		}
		
		final String[] columns = new String[] {"name", "person", "strasse", "ort", "telefon", "telefax", "email"};
		
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("title", staffel.getTitle());
		parameters.put("staffelname", staffel.getName());
		
		return AbstractGenerator.print(Configuration.REPORT_CLUB, parameters, vecjas, columns, (staffel.getTitle().length() > Configuration.MAX_TITLE_LENGTH));
	}
	
}
