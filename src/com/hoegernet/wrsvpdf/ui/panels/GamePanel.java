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
import com.hoegernet.wrsvpdf.reporting.Generator;
import com.hoegernet.wrsvpdf.types.Spieltag;
import com.hoegernet.wrsvpdf.types.Staffel;
import com.hoegernet.wrsvpdf.types.Team;
import com.hoegernet.wrsvpdf.ui.GOButtonBrick;
import com.hoegernet.wrsvpdf.ui.MainPanel;

/**
 * type: com.hoegernet.wrsvpdf->WRSVPanel
 *
 * @author Thorsten Hoeger
 * created: 24.07.2007
 * file: WRSVPanel.java
 *
 */
public class GamePanel extends MainPanel {

	private TextFieldBrick staffelText;

	private TextFieldBrick gameText;

	private TextFieldBrick teamText;

	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 */
	public GamePanel(Composite parent, int style, int formstyle) {
		super(parent, style, formstyle);
	}

	@Override
	protected void createPanelContents(Composite parent) {
		new LabelBrick(parent, SWT.NONE, "Staffel ausw�hlen");
		this.staffelText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		this.staffelText.setText(FileMemory.getInstance().getStaffelFile());
		new FileSelectButtonBrick(parent, this.staffelText, "*.rbs");

		new LabelBrick(parent, SWT.NONE, "Mannschaftsdatei ausw�hlen");
		this.teamText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		new FileSelectButtonBrick(parent, this.teamText, "*.rbm");

		new LabelBrick(parent, SWT.NONE, "Spieltag ausw�hlen");
		this.gameText = new TextFieldBrick(parent, SWT.BORDER, TextFieldBrick.NONE, "", Text.LIMIT, 200);
		new FileSelectButtonBrick(parent, this.gameText, "*.rbt");

		new LabelBrick(parent, SWT.NONE, "PDF erstellen");
		new GOButtonBrick(parent, "Spieltag.pdf") {
			@Override
			protected JasperPrint getReport() throws PdfGeneratorException {
				FileMemory.getInstance().setStaffelFile(GamePanel.this.staffelText.getText());

				Staffel staffel = FileIORegistry.getImporter().loadStaffelFromFile(GamePanel.this.staffelText.getText());
				Spieltag game = FileIORegistry.getImporter().loadSpieltagFromFile(GamePanel.this.gameText.getText());
				Team[] teams = FileIORegistry.getImporter().loadTeamsFromFile(GamePanel.this.teamText.getText());
				return Generator.createSpieltagReport(staffel, game, teams);
			}
		};

	}

}