package com.hoegernet.wrsvpdf.types;

/**
 * Copyright 2007 Hoegernet IT Services
 * @author Thorsten Höger
 *
 * Projekt: com.hoegernet.wrsvpdf
 * Type: Staffel
 *
 * created: 15.11.2007
 *
 */
public class Staffel {

	private String title = "";
	private String name = "";
	private String staffelleiter_name = "";
	private String staffelleiter_strasse = "";
//	private String staffelleiter_ort = "";
	private String staffelleiter_telfax = "";
	private String staffelleiter_mail = "";
	private String regelungen = "";

	/**
	 *
	 */
	public Staffel() {
		// Auto-generated constructor stub
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the staffelleiter_name
	 */
	public String getStaffelleiter_name() {
		return this.staffelleiter_name;
	}

	/**
	 * @param staffelleiter_name the staffelleiter_name to set
	 */
	public void setStaffelleiter_name(String staffelleiter_name) {
		this.staffelleiter_name = staffelleiter_name;
	}

	/**
	 * @return the staffelleiter_strasse
	 */
	public String getStaffelleiter_strasse() {
		return this.staffelleiter_strasse;
	}

	/**
	 * @param staffelleiter_strasse the staffelleiter_strasse to set
	 */
	public void setStaffelleiter_strasse(String staffelleiter_strasse) {
		this.staffelleiter_strasse = staffelleiter_strasse;
	}

	/**
	 * @return the staffelleiter_telfax
	 */
	public String getStaffelleiter_telfax() {
		return this.staffelleiter_telfax;
	}

	/**
	 * @param staffelleiter_telfax the staffelleiter_telfax to set
	 */
	public void setStaffelleiter_telfax(String staffelleiter_telfax) {
		this.staffelleiter_telfax = staffelleiter_telfax;
	}

	/**
	 * @return the staffelleiter_mail
	 */
	public String getStaffelleiter_mail() {
		return this.staffelleiter_mail;
	}

	/**
	 * @param staffelleiter_mail the staffelleiter_mail to set
	 */
	public void setStaffelleiter_mail(String staffelleiter_mail) {
		this.staffelleiter_mail = staffelleiter_mail;
	}

	/**
	 * @return the regelungen
	 */
	public String getRegelungen() {
		return this.regelungen;
	}

	/**
	 * @param regelungen the regelungen to set
	 */
	public void setRegelungen(String regelungen) {
		this.regelungen = regelungen;
	}

}
