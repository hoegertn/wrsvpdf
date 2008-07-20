package com.hoegernet.wrsvpdf.types;

/**
 * Copyright 2007 Hoegernet IT Services
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: WRSVPerson
 * 
 *         created: 15.11.2007
 * 
 */
public class WRSVPerson {
	
	private String jobTitle = "";
	
	private String name = "";
	private String strasse = "";
	private String ort = "";
	
	private String tel = "";
	private String fax = "";
	private String mail = "";
	

	/**
	 * 
	 */
	public WRSVPerson() {
		// Auto-generated constructor stub
	}
	
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}
	
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the strasse
	 */
	public String getStrasse() {
		return this.strasse;
	}
	
	/**
	 * @param strasse the strasse to set
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	/**
	 * @return the ort
	 */
	public String getOrt() {
		return this.ort;
	}
	
	/**
	 * @param ort the ort to set
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	/**
	 * @return the tel
	 */
	public String getTel() {
		return this.tel;
	}
	
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * @return the fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * @return the mail
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
