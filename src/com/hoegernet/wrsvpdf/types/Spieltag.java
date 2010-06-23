package com.hoegernet.wrsvpdf.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2007 Hoegernet IT Services
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf Type: Spieltag
 * 
 *         created: 15.11.2007
 * 
 */
public class Spieltag {
	
	private String title = "";
	private String datum = "";
	private String zeit = "";
	private String ort = "";
	
	private String halle_name = "";
	private String halle_ort = "";
	private String halle_strasse = "";
	private String halle_tel = "";
	
	private List<String> teams = new ArrayList<String>();
	
	private List<String[]> games = new ArrayList<String[]>();
	

	/**
	 * 
	 */
	public Spieltag() {
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
	public void setTitle(final String title) {
		this.title = title;
	}
	
	/**
	 * @return the datum
	 */
	public String getDatum() {
		return this.datum;
	}
	
	/**
	 * @param datum the datum to set
	 */
	public void setDatum(final String datum) {
		this.datum = datum;
	}
	
	/**
	 * @return the zeit
	 */
	public String getZeit() {
		return this.zeit;
	}
	
	/**
	 * @param zeit the zeit to set
	 */
	public void setZeit(final String zeit) {
		this.zeit = zeit;
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
	 * @return the halle_name
	 */
	public String getHalle_name() {
		return this.halle_name;
	}
	
	/**
	 * @param halle_name the halle_name to set
	 */
	public void setHalle_name(final String halle_name) {
		this.halle_name = halle_name;
	}
	
	/**
	 * @return the halle_ort
	 */
	public String getHalle_ort() {
		return this.halle_ort;
	}
	
	/**
	 * @param halle_ort the halle_ort to set
	 */
	public void setHalle_ort(final String halle_ort) {
		this.halle_ort = halle_ort;
	}
	
	/**
	 * @return the halle_strasse
	 */
	public String getHalle_strasse() {
		return this.halle_strasse;
	}
	
	/**
	 * @param halle_strasse the halle_strasse to set
	 */
	public void setHalle_strasse(final String halle_strasse) {
		this.halle_strasse = halle_strasse;
	}
	
	/**
	 * @return the halle_tel
	 */
	public String getHalle_tel() {
		return this.halle_tel;
	}
	
	/**
	 * @param halle_tel the halle_tel to set
	 */
	public void setHalle_tel(final String halle_tel) {
		this.halle_tel = halle_tel;
	}
	
	/**
	 * @return the teams
	 */
	public List<String> getTeams() {
		return this.teams;
	}
	
	/**
	 * @param teams the teams to set
	 */
	public void setTeams(final List<String> teams) {
		this.teams = teams;
	}
	
	/**
	 * @return the games
	 */
	public List<String[]> getGames() {
		return this.games;
	}
	
	/**
	 * @param games the games to set
	 */
	public void setGames(final List<String[]> games) {
		this.games = games;
	}
	
}
