/**
 *
 */
package com.hoegernet.wrsvpdf.ui;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import com.hoegernet.swt.bricks.ExpandItemBrick;
import com.hoegernet.swt.bricks.ImageBrick;
import com.hoegernet.swt.bricks.buttons.LabelButtonBrickAdapter;
import com.hoegernet.swt.bricks.container.CompositeBrick;
import com.hoegernet.swt.bricks.container.ExpandBarBrick;
import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.ui.MainFrame.PanelType;

/**
 * type: com.hoegernet.wrsvpdf->Expand
 * 
 * @author Thorsten Hoeger created: 22.07.2007 file: Expand.java
 * 
 */
public class Expand extends ExpandBarBrick {
	
	/**
	 * @param parent
	 * @param style
	 * @param formstyle
	 * @param frame
	 */
	public Expand(final Composite parent, final int style, final int formstyle, final MainFrame frame) {
		super(parent, style, formstyle, frame);
	}
	
	@Override
	protected void createContents(final Composite parent) {
		final ExpandBarBrick bar = (ExpandBarBrick) parent;
		final Image pdf = new Image(null, "images" + File.separatorChar + "pdf.jpg");
		final Image ball = new Image(null, "images" + File.separatorChar + "ball.jpg");
		
		// First item
		final CompositeBrick actions = new CompositeBrick(bar, SWT.NONE, CompositeBrick.TWO_COL) {
			
			@Override
			public void createContents(final Composite expand) {
				final MainFrame frame = (MainFrame) Expand.this.getDesignatedObject();
				
				new ImageBrick(expand, SWT.NONE, ball);
				new WRSVExpandLabel(expand, "Verbandsadressen", PanelType.WRSV, frame);
				
				new ImageBrick(expand, SWT.NONE, ball);
				new WRSVExpandLabel(expand, "Vereine", PanelType.CLUBS, frame);
				
				new ImageBrick(expand, SWT.NONE, ball);
				new WRSVExpandLabel(expand, "Hallenverzeichnis", PanelType.GYM, frame);
				
				new ImageBrick(expand, SWT.NONE, ball);
				new WRSVExpandLabel(expand, "Mannschaften", PanelType.TEAMS, frame);
				
				new ImageBrick(expand, SWT.NONE, ball);
				new WRSVExpandLabel(expand, "Spieltag", PanelType.SPIELTAG, frame);
				
				new ImageBrick(expand, SWT.NONE, ball);
				new WRSVExpandLabel(expand, "Alle Spieltage", PanelType.SPIELTAG_DIR, frame);
				
				new ImageBrick(expand, SWT.NONE, ball);
				new WRSVExpandLabel(expand, "Tabelle", PanelType.RANKING, frame);
				
			}
		};
		
		// Second item
		final CompositeBrick help = new CompositeBrick(bar, SWT.NONE, CompositeBrick.TWO_COL) {
			
			@Override
			public void createContents(final Composite expand) {
				// new ImageBrick(expand, SWT.NONE, ball);
				// new LabelButtonBrickAdapter(expand, SWT.NONE, "Hilfe") {
				// @Override
				// protected void execute() {
				// // TODO Show help
				// }
				// @Override
				// public Color getHoverColor() {
				// return new Color(this.getDisplay(), 255, 0, 0);
				// }
				// };
				new ImageBrick(expand, SWT.NONE, ball);
				new LabelButtonBrickAdapter(expand, SWT.NONE, "Kontakt") {
					
					@Override
					protected void execute() {
						// TODO Kontakt
						final MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_INFORMATION | SWT.OK);
						msg.setText("Kontakt");
						msg.setMessage(Configuration.CONTACT_EMAIL);
						msg.open();
					}
					
					@Override
					public Color getHoverColor() {
						return new Color(this.getDisplay(), 255, 0, 0);
					}
				};
				new ImageBrick(expand, SWT.NONE, ball);
				new LabelButtonBrickAdapter(expand, SWT.NONE, "About") {
					
					@Override
					protected void execute() {
						// TODO About
						final MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_INFORMATION | SWT.OK);
						msg.setText("About");
						msg.setMessage("WRSV Spielplandruck - Version " + Configuration.VERSION_FULL);
						msg.open();
					}
					
					@Override
					public Color getHoverColor() {
						return new Color(this.getDisplay(), 255, 0, 0);
					}
				};
				new ImageBrick(expand, SWT.NONE, ball);
				new LabelButtonBrickAdapter(expand, SWT.NONE, "Schlieﬂen") {
					
					@Override
					protected void execute() {
						System.exit(0);
					}
					
					@Override
					public Color getHoverColor() {
						return new Color(this.getDisplay(), 255, 0, 0);
					}
				};
			}
		};
		
		new ExpandItemBrick(bar, SWT.NONE, 0, "PDF Erstellung", pdf, actions, true);
		new ExpandItemBrick(bar, SWT.NONE, 1, "Information", pdf, help, true);
	}
	
}
