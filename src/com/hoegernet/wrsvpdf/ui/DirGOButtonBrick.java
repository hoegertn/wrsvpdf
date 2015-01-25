/**
 *
 */
package com.hoegernet.wrsvpdf.ui;

import java.io.File;
import java.util.List;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.MessageBox;

import com.hoegernet.common.logger.Logger;
import com.hoegernet.swt.bricks.buttons.PushButtonBrick;
import com.hoegernet.wrsvpdf.exceptions.PdfGeneratorException;

/**
 * type: SWTTest->PushButtonBrick
 * 
 * @author Thorsten Hoeger created: 22.07.2007 file: PushButtonBrick.java
 * 
 */
public abstract class DirGOButtonBrick extends PushButtonBrick {
	
	/**
	 * @param parent
	 * @param label
	 */
	public DirGOButtonBrick(final Composite parent, final String label) {
		super(parent, label);
		this.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(final SelectionEvent e) {
				//
			}
			
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final DirectoryDialog dialog = new DirectoryDialog(DirGOButtonBrick.this.getShell(), SWT.SAVE);
				final String file = dialog.open();
				if (file != null) {
					DirGOButtonBrick.this.createReport(file);
				}
			}
		});
	}
	
	/**
	 * @param parent
	 */
	public DirGOButtonBrick(final Composite parent) {
		this(parent, "");
		this.setImage(new Image(null, "images" + File.separatorChar + "go.jpg"));
	}
	
	@Override
	protected void checkSubclass() {
		// super.checkSubclass();
	}
	
	/**
	 * @param dirName
	 */
	public void createReport(final String dirName) {
		final Runnable job = new Runnable() {
			
			@Override
			public void run() {
				try {
					String dir = dirName;
					if (!dir.endsWith("\\")) {
						dir += "\\";
					}
					final List<JasperPrint> reports = DirGOButtonBrick.this.getReports();
					
					for (final JasperPrint print : reports) {
						JasperExportManager.exportReportToPdfFile(print, dir + print.getName() + ".pdf");
					}
					
					final MessageBox msg = new MessageBox(DirGOButtonBrick.this.getShell(), SWT.ICON_INFORMATION | SWT.OK);
					msg.setText("Generierung");
					msg.setMessage("Dateien in Verzeichnis " + dirName + " erfolgreich erstellt");
					msg.open();
					
				} catch (final Exception ex) {
					ex.printStackTrace();
					Logger.getInstance().logError("FileOutput", "Writing failed: " + ex.getMessage());
					final MessageBox msg = new MessageBox(DirGOButtonBrick.this.getShell(), SWT.ICON_ERROR | SWT.OK);
					msg.setText("Generierung");
					msg.setMessage("Dateien aus Verzeichnis " + dirName + " fehlgeschlagen!\n " + ex.getMessage());
					msg.open();
				}
			}
		};
		BusyIndicator.showWhile(this.getDisplay(), job);
	}
	
	protected abstract List<JasperPrint> getReports() throws PdfGeneratorException;
}
