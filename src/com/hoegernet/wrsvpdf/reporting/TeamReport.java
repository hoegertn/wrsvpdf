package com.hoegernet.wrsvpdf.reporting;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JasperPrint;

import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Team;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: ClubReport
 * 
 *         created: 15.06.2009
 * 
 */
public class TeamReport extends AbstractGenerator {
	
	/**
	 * @param staffel
	 * @param teams
	 * @return Report
	 * @throws PdfGeneratorException
	 */
	public static JasperPrint createReport(Staffel staffel, Team[] teams) throws PdfGeneratorException {
		AbstractGenerator.assertNull(staffel, "Staffel mustn't be null");
		
		Vector<Object[]> vecjas = new Vector<Object[]>();
		
		for (Team t : teams) {
			vecjas.add(new String[] {t.getName(), t.getPlayer1(), t.getPlayer2(), t.getDate1(), t.getDate2()});
		}
		
		String[] columns = new String[] {"teamname", "player1", "player2", "year1", "year2"};
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("title", staffel.getTitle());
		parameters.put("staffelname", staffel.getName());
		
		parameters.put("name", staffel.getStaffelleiter_name());
		parameters.put("strasseort", staffel.getStaffelleiter_strasse());
		parameters.put("telfax", staffel.getStaffelleiter_telfax());
		parameters.put("mail", staffel.getStaffelleiter_mail());
		
		JasperPrint jprint = AbstractGenerator.print(Configuration.REPORT_TEAM, parameters, vecjas, columns);
		AbstractGenerator.concatReport(jprint, RulesReport.createReport(staffel));
		return jprint;
	}
}
