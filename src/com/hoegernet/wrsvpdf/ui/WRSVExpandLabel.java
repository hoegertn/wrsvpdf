/**
 *
 */
package com.hoegernet.wrsvpdf.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import com.hoegernet.swt.bricks.buttons.LabelButtonBrickAdapter;
import com.hoegernet.wrsvpdf.ui.MainFrame.PanelType;

/**
 * type: com.hoegernet.wrsvpdf->WRSVExpandLabel
 * 
 * @author Thorsten Hoeger created: 17.09.2007 file: WRSVExpandLabel.java
 * 
 */
public class WRSVExpandLabel extends LabelButtonBrickAdapter {
	
	private PanelType type = PanelType.START;
	
	private final MainFrame frame;
	

	/**
	 * @param parent
	 * @param text
	 * @param type
	 * @param frame
	 */
	public WRSVExpandLabel(final Composite parent, final String text, final PanelType type, final MainFrame frame) {
		super(parent, SWT.NONE, text);
		this.type = type;
		this.frame = frame;
	}
	
	@Override
	protected void execute() {
		this.frame.setActivePanel(this.type);
	}
	
	@Override
	public Color getHoverColor() {
		return new Color(this.getDisplay(), 255, 0, 0);
	}
	
}
