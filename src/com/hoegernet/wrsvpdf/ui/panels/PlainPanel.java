/**
 * 
 */
package com.hoegernet.wrsvpdf.ui.panels;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.hoegernet.swt.bricks.LabelBrick;
import com.hoegernet.wrsvpdf.ui.MainPanel;

/**
 * type: com.hoegernet.wrsvpdf->WRSVPanel
 * 
 * @author Thorsten Hoeger created: 24.07.2007 file: WRSVPanel.java
 * 
 */
public class PlainPanel extends MainPanel {
	
	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 */
	public PlainPanel(Composite parent, int style, int formstyle) {
		super(parent, style, formstyle);
	}
	
	@Override
	protected void createPanelContents(Composite parent) {
		new LabelBrick(parent, SWT.NONE, "Aktion auswählen");
	}
	
}
