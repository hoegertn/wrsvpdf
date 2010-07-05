package com.hoegernet.wrsvpdf.reporting;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JasperPrint;

import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.WRSVPerson;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: ClubReport
 * 
 *         created: 15.06.2009
 * 
 */
public class WRSVReport extends AbstractGenerator {
	
	/**
	 * @param staffel
	 * @param personen
	 * @return Report
	 * @throws PdfGeneratorException
	 */
	public static JasperPrint createReport(final Staffel staffel, final WRSVPerson[] personen) throws PdfGeneratorException {
		AbstractGenerator.assertNull(staffel, "Staffel mustn't be null");
		
		final Vector<Object[]> vecjas = new Vector<Object[]>();
		
		for (final WRSVPerson w : personen) {
			vecjas.add(new String[] {w.getJobTitle(), w.getName(), w.getStrasse(), w.getOrt(), w.getTel(), w.getFax(), w.getMail()});
		}
		
		final String[] columns = new String[] {"jobtitle", "person", "strasse", "ort", "telefon", "telefax", "email"};
		
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("title", staffel.getTitle());
		
		return AbstractGenerator.print(Configuration.REPORT_WRSV, parameters, vecjas, columns, (staffel.getTitle().length() > Configuration.MAX_TITLE_LENGTH));
	}
	
}
