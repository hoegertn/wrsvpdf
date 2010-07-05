/**
 *
 */
package com.hoegernet.wrsvpdf.ui.panels;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JasperPrint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.hoegernet.swt.bricks.LabelBrick;
import com.hoegernet.swt.bricks.TextFieldBrick;
import com.hoegernet.swt.bricks.buttons.CheckBoxButtonBrick;
import com.hoegernet.swt.bricks.buttons.DirSelectButtonBrick;
import com.hoegernet.swt.bricks.buttons.FileSelectButtonBrick;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;
import com.hoegernet.wrsvpdf.fileio.FileIORegistry;
import com.hoegernet.wrsvpdf.fileio.FileMemory;
import com.hoegernet.wrsvpdf.reporting.SpieltagReport;
import com.hoegernet.wrsvpdf.types.Spieltag;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Team;
import com.hoegernet.wrsvpdf.ui.DirGOButtonBrick;
import com.hoegernet.wrsvpdf.ui.MainPanel;

/**
 * type: com.hoegernet.wrsvpdf->WRSVPanel
 * 
 * @author Thorsten Hoeger created: 24.07.2007 file: WRSVPanel.java
 * 
 */
public class AllGamesPanel extends MainPanel {
	
	private TextFieldBrick staffelText;
	
	private TextFieldBrick gameText;
	
	private TextFieldBrick teamText;
	
	private CheckBoxButtonBrick chkReport;
	

	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 */
	public AllGamesPanel(final Composite parent, final int style, final int formstyle) {
		super(parent, style, formstyle);
	}
	
	@Override
	protected void createPanelContents(final Composite parent) {
		new LabelBrick(parent, SWT.NONE, "Staffel auswählen");
		this.staffelText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		this.staffelText.setText(FileMemory.getInstance().getStaffelFile());
		new FileSelectButtonBrick(parent, this.staffelText, "*.rbs");
		
		new LabelBrick(parent, SWT.NONE, "Mannschaftsdatei auswählen");
		this.teamText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		new FileSelectButtonBrick(parent, this.teamText, "*.rbm");
		
		new LabelBrick(parent, SWT.NONE, "Spieltagordner auswählen");
		this.gameText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		new DirSelectButtonBrick(parent, this.gameText, "Ordner wählen");
		
		new LabelBrick(parent, SWT.NONE, "Berichtsbogen?");
		this.chkReport = new CheckBoxButtonBrick(parent, "");
		new LabelBrick(parent, SWT.NONE, "");
		
		new LabelBrick(parent, SWT.NONE, "PDF erstellen");
		new DirGOButtonBrick(parent) {
			
			@Override
			protected List<JasperPrint> getReports() throws PdfGeneratorException {
				FileMemory.getInstance().setStaffelFile(AllGamesPanel.this.staffelText.getText());
				
				final List<JasperPrint> res = new ArrayList<JasperPrint>();
				final Team[] teams = FileIORegistry.getImporter().loadTeamsFromFile(AllGamesPanel.this.teamText.getText());
				
				final File dir = new File(AllGamesPanel.this.gameText.getText());
				if (dir.isDirectory()) {
					final File[] files = dir.listFiles(new FilenameFilter() {
						
						public boolean accept(final File directory, final String name) {
							return name.endsWith(".rbt");
						}
					});
					
					final Staffel staffel = FileIORegistry.getImporter().loadStaffelFromFile(AllGamesPanel.this.staffelText.getText());
					
					for (final File tag : files) {
						final Spieltag game = FileIORegistry.getImporter().loadSpieltagFromFile(tag.getAbsolutePath());
						res.add(SpieltagReport.createReport(staffel, game, teams, AllGamesPanel.this.chkReport.getSelection()));
					}
				}
				
				return res;
			}
		};
		
	}
	
}
