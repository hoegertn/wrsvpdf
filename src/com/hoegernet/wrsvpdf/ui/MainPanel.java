package com.hoegernet.wrsvpdf.ui;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.hoegernet.swt.bricks.ImageBrick;
import com.hoegernet.swt.bricks.container.CompositeBrick;

/**
 * type: com.hoegernet.wrsvpdf->MainPanel
 * 
 * @author Thorsten Hoeger created: 24.07.2007 file: MainPanel.java
 * 
 */
public abstract class MainPanel extends CompositeBrick {
	
	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 */
	public MainPanel(final Composite parent, final int style, final int formstyle) {
		super(parent, style, formstyle);
	}
	
	@Override
	protected void createContents(final Composite parent) {
		this.setBackground(new Color(this.getShell().getDisplay(), 255, 255, 255));
		this.setBackgroundMode(SWT.INHERIT_FORCE);
		
		final Image image = new Image(null, "images" + File.separatorChar + "header.jpg");
		new ImageBrick(parent, SWT.NONE, image);
		
		new CompositeBrick(parent, SWT.NONE, CompositeBrick.THREE_COL) {
			
			@Override
			protected void createContents(final Composite panel) {
				MainPanel.this.createPanelContents(panel);
			}
		};
	}
	
	protected abstract void createPanelContents(Composite parent);
	
}
