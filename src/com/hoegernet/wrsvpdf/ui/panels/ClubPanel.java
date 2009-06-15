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
import com.hoegernet.wrsvpdf.fileio.FileMemory;
import com.hoegernet.wrsvpdf.reporting.ClubReport;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Verein;
import com.hoegernet.wrsvpdf.ui.GOButtonBrick;
import com.hoegernet.wrsvpdf.ui.MainPanel;

/**
 * type: com.hoegernet.wrsvpdf->WRSVPanel
 * 
 * @author Thorsten Hoeger created: 24.07.2007 file: WRSVPanel.java
 * 
 */
public class ClubPanel extends MainPanel {
	
	private TextFieldBrick staffelText;
	
	private TextFieldBrick clubText;
	

	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 */
	public ClubPanel(Composite parent, int style, int formstyle) {
		super(parent, style, formstyle);
	}
	
	@Override
	protected void createPanelContents(Composite parent) {
		new LabelBrick(parent, SWT.NONE, "Staffel auswählen");
		this.staffelText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		this.staffelText.setText(FileMemory.getInstance().getStaffelFile());
		new FileSelectButtonBrick(parent, this.staffelText, "*.rbs");
		
		new LabelBrick(parent, SWT.NONE, "Vereinsdatei auswählen");
		this.clubText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		new FileSelectButtonBrick(parent, this.clubText, "*.rbv");
		
		new LabelBrick(parent, SWT.NONE, "PDF erstellen");
		new GOButtonBrick(parent, "Vereine.pdf") {
			
			@Override
			protected JasperPrint getReport() throws PdfGeneratorException {
				FileMemory.getInstance().setStaffelFile(ClubPanel.this.staffelText.getText());
				
				Staffel staffel = FileIORegistry.getImporter().loadStaffelFromFile(ClubPanel.this.staffelText.getText());
				Verein[] clubs = FileIORegistry.getImporter().loadClubsFromFile(ClubPanel.this.clubText.getText());
				return ClubReport.createReport(staffel, clubs);
			}
		};
		
	}
	
}
