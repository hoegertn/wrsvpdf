package com.hoegernet.wrsvpdf.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2007 Hoegernet IT Services
 * @author Thorsten Höger
 *
 * Projekt: com.hoegernet.wrsvpdf
 * Type: Tabelle
 *
 * created: 15.11.2007
 *
 */
public class Tabelle {

	private String year = "";
	
	private String staffel = "";
	
	private String headline = "";
	
	private List<RankingPos> table = new ArrayList<RankingPos>();
	
	/**
	 * 
	 */
	public Tabelle() {
		// Auto-generated constructor stub
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return this.year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the staffel
	 */
	public String getStaffel() {
		return this.staffel;
	}

	/**
	 * @param staffel the staffel to set
	 */
	public void setStaffel(String staffel) {
		this.staffel = staffel;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return this.headline;
	}

	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the table
	 */
	public List<RankingPos> getTable() {
		return this.table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(List<RankingPos> table) {
		this.table = table;
	}

}
