package com.hoegernet.wrsvpdf;

import java.io.File;

import com.hoegernet.common.logger.ELogLevel;

/**
 * This File provides version information.<br>
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: Configuration
 * 
 *         created: 18.01.2008
 * 
 */
public interface Configuration {
	
	/**  */
	public final static String VERSION_MAJOR = "@MAJOR@";
	/**  */
	public final static String VERSION_MINOR = "@MINOR@";
	/**  */
	public final static String VERSION_REVISION = "@REVISION@";
	/**  */
	public final static String VERSION_RELEASE_DATE = "@RELDATE@";
	/**  */
	public final static String VERSION_SVN_REVISION = "@SVN@";
	/**  */
	public final static String VERSION_NORMAL = Configuration.VERSION_MAJOR + "." + Configuration.VERSION_MINOR + "." + Configuration.VERSION_REVISION;
	/**  */
	public final static String VERSION_FULL = Configuration.VERSION_NORMAL + "_" + Configuration.VERSION_RELEASE_DATE + "#" + Configuration.VERSION_SVN_REVISION;
	
	/**
	 * 
	 */
	public final static int MAX_TITLE_LENGTH = 28;
	
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
	public final static String REPORT_CLUB = Configuration.REPORT_DIRECTORY + File.separatorChar + "clublist";
	/**  */
	public final static String REPORT_REPORTING = Configuration.REPORT_DIRECTORY + File.separatorChar + "dayreport";
	/**  */
	public final static String REPORT_RULES = Configuration.REPORT_DIRECTORY + File.separatorChar + "rules";
	/**  */
	public final static String REPORT_GYM = Configuration.REPORT_DIRECTORY + File.separatorChar + "gymlist";
	/**  */
	public final static String REPORT_RANKING = Configuration.REPORT_DIRECTORY + File.separatorChar + "ranking";
	/**  */
	public final static String REPORT_SPIELTAG = Configuration.REPORT_DIRECTORY + File.separatorChar + "spieltag";
	/**  */
	public final static String REPORT_TEAM = Configuration.REPORT_DIRECTORY + File.separatorChar + "teamlist";
	/**  */
	public final static String REPORT_WRSV = Configuration.REPORT_DIRECTORY + File.separatorChar + "wrsv";
	
}
