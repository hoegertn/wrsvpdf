package com.hoegernet.wrsvpdf.reporting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JasperPrint;

import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.Spieltag;
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
public class ReportingReport extends AbstractGenerator {
	
	/**
	 * @param staffel
	 * @param tag
	 * @param teams
	 * @return Report
	 * @throws PdfGeneratorException
	 */
	public static JasperPrint createReport(Staffel staffel, Spieltag tag, Team[] teams) throws PdfGeneratorException {
		AbstractGenerator.assertNull(staffel, "Staffel mustn't be null");
		AbstractGenerator.assertNull(tag, "Tag mustn't be null");
		
		Vector<Object[]> vecjas = new Vector<Object[]>();
		
		Arrays.sort(teams, new Comparator<Team>() {
			
			public int compare(Team o1, Team o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for (Team t : teams) {
			String[] arr = new String[] {t.getName(), t.getPlayer1(), t.getPlayer2()};
			vecjas.add(arr);
		}
		
		String[] columns = new String[] {"teamname", "player1", "player2"};
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("title", staffel.getTitle());
		parameters.put("staffelname", staffel.getName());
		parameters.put("header", tag.getTitle());
		parameters.put("ort", tag.getOrt());
		
		return AbstractGenerator.print(Configuration.REPORT_REPORTING, parameters, vecjas, columns);
	}
	
}
