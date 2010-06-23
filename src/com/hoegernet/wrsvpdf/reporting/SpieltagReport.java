package com.hoegernet.wrsvpdf.reporting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class SpieltagReport extends AbstractGenerator {
	
	/**
	 * @param staffel
	 * @param tag
	 * @param teams
	 * @param reporting
	 * @return Report
	 * @throws PdfGeneratorException
	 */
	public static JasperPrint createReport(final Staffel staffel, final Spieltag tag, final Team[] teams, final boolean reporting) throws PdfGeneratorException {
		AbstractGenerator.assertNull(staffel, "Staffel mustn't be null");
		AbstractGenerator.assertNull(tag, "Tag mustn't be null");
		
		final Vector<Object[]> vecjas = new Vector<Object[]>();
		
		final List<String[]> games = tag.getGames();
		
		for (final String[] g : games) {
			vecjas.add(g);
		}
		
		final String[] columns = new String[] {"number", "team1", "team2", "goal1", "goal2"};
		
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("title", staffel.getTitle());
		parameters.put("staffelname", staffel.getName());
		parameters.put("headline", tag.getTitle());
		parameters.put("datum", tag.getDatum());
		parameters.put("zeit", tag.getZeit());
		parameters.put("ort", tag.getOrt());
		parameters.put("halle", tag.getHalle_name());
		parameters.put("strasse", tag.getHalle_strasse() + ", " + tag.getHalle_ort());
		parameters.put("telefon", tag.getHalle_tel());
		
		String teamsLine = "";
		final List<Team> actualTeams = new ArrayList<Team>();
		int len = 0;
		for (final String team : tag.getTeams()) {
			actualTeams.add(SpieltagReport.getTeamFromName(teams, team));
			teamsLine += team + ", ";
			len += team.length() + 2;
			if (len > 65) {
				teamsLine += "\n";
				len = 0;
			}
		}
		teamsLine = teamsLine.substring(0, teamsLine.length() - 2);
		
		parameters.put("teams", teamsLine);
		
		final JasperPrint jprint = AbstractGenerator.print(Configuration.REPORT_SPIELTAG, parameters, vecjas, columns, (staffel.getTitle().length() > Configuration.MAX_TITLE_LENGTH));
		jprint.setName(tag.getTitle());
		
		if (reporting) {
			AbstractGenerator.concatReport(jprint, ReportingReport.createReport(staffel, tag, actualTeams.toArray(new Team[actualTeams.size()])));
		}
		return jprint;
	}
	
	private static Team getTeamFromName(final Team[] teams, final String name) throws PdfGeneratorException {
		for (final Team team : teams) {
			if (team.getName().equals(name)) {
				return team;
			}
		}
		throw new PdfGeneratorException("No Team found for name: " + name);
	}
	
}
