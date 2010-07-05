package com.hoegernet.wrsvpdf.types;

/**
 * Copyright 2007 Hoegernet IT Services
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: Verein
 * 
 *         created: 15.11.2007
 * 
 */
public class Verein {
	
	private String name = "";
	private String person = "";
	private String strasse = "";
	private String ort = "";
	private String tel = "";
	private String fax = "";
	private String mail = "";
	

	/**
	 * 
	 */
	public Verein() {
		// Auto-generated constructor stub
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
	public void setName(final String name) {
		this.name = name;
	}
	
	/**
	 * @return the person
	 */
	public String getPerson() {
		return this.person;
	}
	
	/**
	 * @param person the person to set
	 */
	public void setPerson(final String person) {
		this.person = person;
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
	public void setStrasse(final String strasse) {
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
	public void setOrt(final String ort) {
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
	public void setTel(final String tel) {
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
	public void setFax(final String fax) {
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
	public void setMail(final String mail) {
		this.mail = mail;
	}
	
}
