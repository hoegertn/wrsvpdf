package com.hoegernet.wrsvpdf.reporting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JasperPrint;

import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.types.RankingPos;
import com.hoegernet.wrsvpdf.types.Tabelle;

/**
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: ClubReport
 * 
 *         created: 15.06.2009
 * 
 */
public class RankingReport extends AbstractGenerator {
	
	/**
	 * @param tabelle
	 * @return Report
	 * @throws PdfGeneratorException
	 */
	public static JasperPrint createReport(final Tabelle tabelle) throws PdfGeneratorException {
		AbstractGenerator.assertNull(tabelle, "Tabelle mustn't be null");
		
		final Vector<Object[]> vecjas = new Vector<Object[]>();
		
		final List<RankingPos> ranks = tabelle.getTable();
		
		for (final RankingPos r : ranks) {
			vecjas.add(new String[] {r.getPos(), r.getName(), r.getSpiele(), r.getTore_pos(), r.getTore_neg(), r.getDiff(), r.getPkt()});
		}
		
		final String[] columns = new String[] {"platz", "name", "spiele", "tore_pos", "tore_neg", "diff", "pkt"};
		
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("title", tabelle.getYear());
		parameters.put("staffelname", tabelle.getStaffel());
		parameters.put("headline", tabelle.getHeadline());
		
		return AbstractGenerator.print(Configuration.REPORT_RANKING, parameters, vecjas, columns, (tabelle.getStaffel().length() > Configuration.MAX_TITLE_LENGTH));
	}
	
}
