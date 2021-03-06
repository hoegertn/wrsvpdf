/**
 *
 */
package com.hoegernet.wrsvpdf.ui;

import java.io.File;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
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
public abstract class GOButtonBrick extends PushButtonBrick {
	
	/**
	 * @param parent
	 * @param label
	 * @param defName
	 */
	public GOButtonBrick(final Composite parent, final String label, final String defName) {
		super(parent, label);
		this.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(final SelectionEvent e) {
				//
			}
			
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final FileDialog dialog = new FileDialog(GOButtonBrick.this.getShell(), SWT.SAVE);
				dialog.setFileName(defName);
				final String file = dialog.open();
				if (file != null) {
					if (new File(file).exists()) {
						final MessageBox msg = new MessageBox(GOButtonBrick.this.getShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
						msg.setText("Warnung");
						msg.setMessage("Datei existiert bereits! Überschreiben?");
						
						if (msg.open() == SWT.NO) {
							return;
						}
					}
					GOButtonBrick.this.createReport(file);
				}
			}
		});
	}
	
	/**
	 * @param parent
	 * @param defName
	 */
	public GOButtonBrick(final Composite parent, final String defName) {
		this(parent, "", defName);
		this.setImage(new Image(null, "images" + File.separatorChar + "go.jpg"));
	}
	
	@Override
	protected void checkSubclass() {
		// super.checkSubclass();
	}
	
	/**
	 * @param fileName
	 */
	public void createReport(final String fileName) {
		final Runnable job = new Runnable() {
			
			@Override
			public void run() {
				Logger.getInstance().logInfo("FileOutput", "Writing WRSV report to file: " + fileName);
				try {
					JasperExportManager.exportReportToPdfFile(GOButtonBrick.this.getReport(), fileName);
					Logger.getInstance().logInfo("FileOutput", "Writing DONE");
					
					final MessageBox msg = new MessageBox(GOButtonBrick.this.getShell(), SWT.ICON_INFORMATION | SWT.OK);
					msg.setText("Generierung");
					msg.setMessage("Datei " + fileName + " erfolgreich erstellt");
					msg.open();
					
				} catch (final Exception ex) {
					ex.printStackTrace();
					Logger.getInstance().logError("FileOutput", "Writing failed: " + ex.getMessage());
					final MessageBox msg = new MessageBox(GOButtonBrick.this.getShell(), SWT.ICON_ERROR | SWT.OK);
					msg.setText("Generierung");
					msg.setMessage("Datei " + fileName + " fehlgeschlagen!\n " + ex.getMessage());
					msg.open();
					
				}
			}
		};
		BusyIndicator.showWhile(this.getDisplay(), job);
	}
	
	protected abstract JasperPrint getReport() throws PdfGeneratorException;
}
