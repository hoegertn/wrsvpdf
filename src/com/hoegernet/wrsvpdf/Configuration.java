package com.hoegernet.wrsvpdf;

import java.io.File;

import com.hoegernet.common.logger.ELogLevel;

/**
 * This File provides version information.<br>
 *
 * Copyright 2007 Hoegernet IT Services
 * @author Thorsten Höger
 *
 * Projekt: com.hoegernet.wrsvpdf
 * Type: Configuration
 *
 * created: 18.01.2008
 *
 */
public interface Configuration {

	/**  */
	public final static int VERSION_MAJOR = 2;
	/**  */
	public final static int VERSION_MINOR = 1;
	/**  */
	public final static int VERSION_REVISION = 1;
	/**  */
	public final static String VERSION_RELEASE_DATE = "2008-07-12";
	/**  */
	public final static String VERSION_SVN_REVISION = "@SVN@";
	/**  */
	public final static String VERSION_NORMAL = Configuration.VERSION_MAJOR + "." + Configuration.VERSION_MINOR + "." + Configuration.VERSION_REVISION;
	/**  */
	public final static String VERSION_FULL = Configuration.VERSION_NORMAL + "_" + Configuration.VERSION_RELEASE_DATE + "#" + Configuration.VERSION_SVN_REVISION;

	/**  */
	public final static String CONTACT_EMAIL = "admin@hoegernet.de";
	/**  */
	public final static ELogLevel LOG_LEVEL = ELogLevel.INFO;
	/**  */
	public final static String LOG_FILENAME = "wrsv.log";

	/**  */
	public final static String REPORT_DIRECTORY = "reports";
	/**  */
	public final static String IMAGE_DIRECTORY = "images";

	/**  */
	public final static String REPORT_CLUB = Configuration.REPORT_DIRECTORY + File.separatorChar + "clublist.jrxml";
	/**  */
	public final static String REPORT_REPORTING = Configuration.REPORT_DIRECTORY + File.separatorChar + "dayreport.jrxml";
	/**  */
	public final static String REPORT_GYM = Configuration.REPORT_DIRECTORY + File.separatorChar + "gymlist.jrxml";
	/**  */
	public final static String REPORT_RANKING = Configuration.REPORT_DIRECTORY + File.separatorChar + "ranking.jrxml";
	/**  */
	public final static String REPORT_SPIELTAG = Configuration.REPORT_DIRECTORY + File.separatorChar + "spieltag.jrxml";
	/**  */
	public final static String REPORT_TEAM = Configuration.REPORT_DIRECTORY + File.separatorChar + "teamlist.jrxml";
	/**  */
	public final static String REPORT_WRSV = Configuration.REPORT_DIRECTORY + File.separatorChar + "wrsv.jrxml";

}
