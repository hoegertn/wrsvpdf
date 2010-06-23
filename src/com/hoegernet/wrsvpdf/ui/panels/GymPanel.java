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
import com.hoegernet.wrsvpdf.reporting.HallenReport;
import com.hoegernet.wrsvpdf.types.Halle;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.ui.GOButtonBrick;
import com.hoegernet.wrsvpdf.ui.MainPanel;

/**
 * type: com.hoegernet.wrsvpdf->WRSVPanel
 * 
 * @author Thorsten Hoeger created: 24.07.2007 file: WRSVPanel.java
 * 
 */
public class GymPanel extends MainPanel {
	
	private TextFieldBrick staffelText;
	
	private TextFieldBrick gymText;
	

	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 */
	public GymPanel(final Composite parent, final int style, final int formstyle) {
		super(parent, style, formstyle);
	}
	
	@Override
	protected void createPanelContents(final Composite parent) {
		new LabelBrick(parent, SWT.NONE, "Staffel auswählen");
		this.staffelText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		this.staffelText.setText(FileMemory.getInstance().getStaffelFile());
		new FileSelectButtonBrick(parent, this.staffelText, "*.rbs");
		
		new LabelBrick(parent, SWT.NONE, "Hallendatei auswählen");
		this.gymText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		new FileSelectButtonBrick(parent, this.gymText, "*.rbh");
		
		new LabelBrick(parent, SWT.NONE, "PDF erstellen");
		new GOButtonBrick(parent, "Hallen.pdf") {
			
			@Override
			protected JasperPrint getReport() throws PdfGeneratorException {
				FileMemory.getInstance().setStaffelFile(GymPanel.this.staffelText.getText());
				
				final Staffel staffel = FileIORegistry.getImporter().loadStaffelFromFile(GymPanel.this.staffelText.getText());
				final Halle[] gyms = FileIORegistry.getImporter().loadHallenFromFile(GymPanel.this.gymText.getText());
				return HallenReport.createReport(staffel, gyms);
			}
		};
	}
	
}
