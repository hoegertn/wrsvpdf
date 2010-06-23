/**
 *
 */
package com.hoegernet.wrsvpdf.ui.panels;

import net.sf.jasperreports.engine.JasperPrint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.hoegernet.swt.bricks.LabelBrick;
import com.hoegernet.swt.bricks.TextFieldBrick;
import com.hoegernet.swt.bricks.buttons.FileSelectButtonBrick;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.fileio.FileIORegistry;
import com.hoegernet.wrsvpdf.reporting.RankingReport;
import com.hoegernet.wrsvpdf.types.Tabelle;
import com.hoegernet.wrsvpdf.ui.GOButtonBrick;
import com.hoegernet.wrsvpdf.ui.MainPanel;

/**
 * type: com.hoegernet.wrsvpdf->WRSVPanel
 * 
 * @author Thorsten Hoeger created: 24.07.2007 file: WRSVPanel.java
 * 
 */
public class RankingPanel extends MainPanel {
	
	private TextFieldBrick rankingText;
	

	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 */
	public RankingPanel(final Composite parent, final int style, final int formstyle) {
		super(parent, style, formstyle);
	}
	
	@Override
	protected void createPanelContents(final Composite parent) {
		new LabelBrick(parent, SWT.NONE, "Tabellendatei auswählen");
		this.rankingText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		new FileSelectButtonBrick(parent, this.rankingText, "*.rbr");
		
		new LabelBrick(parent, SWT.NONE, "PDF erstellen");
		new GOButtonBrick(parent, "Tabelle.pdf") {
			
			@Override
			protected JasperPrint getReport() throws PdfGeneratorException {
				final Tabelle tabelle = FileIORegistry.getImporter().loadRankingFromFile(RankingPanel.this.rankingText.getText());
				return RankingReport.createReport(tabelle);
			}
		};
		
	}
	
}
