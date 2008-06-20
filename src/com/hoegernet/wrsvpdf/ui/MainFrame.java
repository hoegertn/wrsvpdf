package com.hoegernet.wrsvpdf.ui;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import com.hoegernet.swt.bricks.container.CompositeBrick;
import com.hoegernet.swt.bricks.container.ExpandBarBrick;
import com.hoegernet.swt.bricks.container.MyShell;
import com.hoegernet.swt.bricks.container.SashFormBrick;
import com.hoegernet.wrsvpdf.Configuration;
import com.hoegernet.wrsvpdf.ui.panels.AllGamesPanel;
import com.hoegernet.wrsvpdf.ui.panels.ClubPanel;
import com.hoegernet.wrsvpdf.ui.panels.GamePanel;
import com.hoegernet.wrsvpdf.ui.panels.GymPanel;
import com.hoegernet.wrsvpdf.ui.panels.PlainPanel;
import com.hoegernet.wrsvpdf.ui.panels.RankingPanel;
import com.hoegernet.wrsvpdf.ui.panels.TeamPanel;
import com.hoegernet.wrsvpdf.ui.panels.WRSVPanel;

/**
 * type: com.hoegernet.wrsvpdf->MainFrame
 *
 * @author Thorsten Hoeger
 * created: 16.09.2007
 * file: MainFrame.java
 *
 */
public class MainFrame extends MyShell {

	/**
	 * type: com.hoegernet.wrsvpdf->PanelType
	 *
	 * @author Thorsten Hoeger
	 * created: 22.07.2007
	 * file: MainFrame.java
	 *
	 */
	public enum PanelType {
		/**	 */
		START,
		/**	 */
		WRSV,
		/**	 */
		TEAMS,
		/**	 */
		GYM,
		/**	 */
		CLUBS,
		/**	 */
		RANKING,
		/**	 */
		SPIELTAG,
		/**	 */
		SPIELTAG_DIR;
	}

	private SashFormBrick sfb = null;

	private MainPanel frame = null;

	/**
	 * Default constructor
	 */
	public MainFrame() {
		super();
	}

	@Override
	protected Point getSize() {
		return new Point(900,600);
	}

	@Override
	protected String getTitle() {
		return "WRSV Spielplandruck - Version " + Configuration.VERSION_NORMAL;
	}

	@Override
	protected Image getIcon() {
		return new Image(null, "images" + File.separatorChar + "pdf.jpg");
	}

	@Override
	protected void createContents(Composite parent) {
		this.sfb = new SashFormBrick(parent, SWT.BORDER) {
			@Override
			protected void createContents(Composite form) {
				new Expand(form, SWT.V_SCROLL, ExpandBarBrick.DEFAULT, MainFrame.this);
				MainFrame.this.frame = new PlainPanel(form, SWT.FILL, CompositeBrick.DEFAULT);
			}
		};
		this.sfb.setWeights(new int[] {30, 70});
	}


	/**
	 * @param type
	 */
	public void setActivePanel(PanelType type) {
		if (this.frame != null) {
			this.frame.dispose();
		}

		switch (type) {
		case START:
			this.frame = new PlainPanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		case CLUBS:
			this.frame = new ClubPanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		case GYM:
			this.frame = new GymPanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		case SPIELTAG:
			this.frame = new GamePanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		case SPIELTAG_DIR:
			this.frame = new AllGamesPanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		case TEAMS:
			this.frame = new TeamPanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		case WRSV:
			this.frame = new WRSVPanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		case RANKING:
			this.frame = new RankingPanel(this.sfb, SWT.FILL, CompositeBrick.DEFAULT);
			break;
		}
		this.sfb.setWeights(new int[] {30, 70});
	}

}

