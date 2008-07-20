package com.hoegernet.wrsvpdf.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.hoegernet.wrsvpdf.exceptions.FileIOException;

/**
 * 
 * @author Thorsten Höger
 * 
 *         Projekt: com.hoegernet.wrsvpdf/ Type: FileIO
 * 
 *         created: 20.07.2008
 * 
 */
public class FileIO {
	
	/**
	 * Read lines from file into a string array.
	 * 
	 * @param filename - filename to be loaded from
	 * @return String[] - String Array with lines of file
	 * @throws FileIOException
	 */
	public static String[] getLinesFromFile(String filename) throws FileIOException {
		List<String> lines = new ArrayList<String>();
		
		String thisLine;
		try {
			FileInputStream fin = new FileInputStream(filename);
			BufferedReader myInput = new BufferedReader(new InputStreamReader(fin));
			while ((thisLine = myInput.readLine()) != null) {
				lines.add(thisLine);
			}
			myInput.close();
			fin.close();
			return lines.toArray(new String[] {});
		} catch (Exception e) {
			throw new FileIOException("Error reading file: " + filename, e);
		}
	}
	
	/**
	 * Read field from single line into string array.
	 * 
	 * @param line - line to be parsed
	 * @return String[] - String Array with fields
	 */
	public static String[] getFieldsFromLine(String line) {
		String[] fields = line.split("\",\"");
		
		for (int i = 0; i < fields.length; i++) {
			String f = fields[i];
			f = FileIO.cleanQuotes(f);
			fields[i] = f;
		}
		
		return fields;
	}
	
	/**
	 * Read field from single line into string array. same as getFieldsFromLine
	 * but doesn't expect quotes around fields
	 * 
	 * @param line - line to be parsed
	 * @return String[] - String Array with fields
	 */
	public static String[] getFieldsFromLineWithoutQuotes(String line) {
		String[] fields = line.split(",");
		
		for (int i = 0; i < fields.length; i++) {
			String f = fields[i];
			f = FileIO.cleanQuotes(f);
			fields[i] = f;
		}
		
		return fields;
	}
	
	/**
	 * Removes leading and trailing quotes.
	 * 
	 * @param s - string to clean
	 * @return String without quote
	 */
	public static String cleanQuotes(String s) {
		String ret = s;
		if ((ret.length() > 0) && ret.substring(0, 1).equals("\"")) {
			ret = ret.substring(1);
		}
		if ((ret.length() > 1) && ret.substring(ret.length() - 1).equals("\"")) {
			ret = ret.substring(0, ret.length() - 1);
		}
		ret = ret.trim();
		return ret;
	}
	
	/**
	 * Parse Single game from line
	 * 
	 * @param line - line to be parsed
	 * @return String Array containing detailed Info about Game
	 */
	public static String[] getSpielFromLine(String line) {
		int dot = line.indexOf(".");
		int minus = line.indexOf("-");
		
		String[] res = new String[3];
		
		res[0] = FileIO.cleanQuotes(line.substring(0, dot));
		res[1] = FileIO.cleanQuotes(line.substring(dot + 1, minus));
		res[2] = FileIO.cleanQuotes(line.substring(minus + 1));
		
		return res;
	}
	
}
