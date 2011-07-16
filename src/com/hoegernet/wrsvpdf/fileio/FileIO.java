package com.hoegernet.wrsvpdf.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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
	public static String[] getLinesFromFile(final String filename) throws FileIOException {
		final List<String> lines = new ArrayList<String>();
		
		String thisLine;
		try {
			final FileInputStream fin = new FileInputStream(filename);
			final BufferedReader myInput = new BufferedReader(new InputStreamReader(fin, Charset.forName("Cp1252")));
			while ((thisLine = myInput.readLine()) != null) {
				lines.add(thisLine);
			}
			myInput.close();
			fin.close();
			return lines.toArray(new String[] {});
		} catch (final Exception e) {
			throw new FileIOException("Error reading file: " + filename, e);
		}
	}
	
	/**
	 * Read field from single line into string array.
	 * 
	 * @param line - line to be parsed
	 * @return String[] - String Array with fields
	 */
	public static String[] getFieldsFromLine(final String line) {
		final String[] fields = line.split("\",\"");
		
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
	public static String[] getFieldsFromLineWithoutQuotes(final String line) {
		final String[] fields = line.split(",");
		
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
	public static String cleanQuotes(final String s) {
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
	public static String[] getSpielFromLine(final String line) {
		final String[] arr = FileIO.getFieldsFromLineWithoutQuotes(line);
		
		final String game = arr[0];
		String goal1 = "__";
		String goal2 = "__";
		
		if (arr.length == 3) {
			if (arr[1].equals("-2")) {
				goal1 = "__";
			} else if (arr[1].equals("-1")) {
				goal1 = "0:5";
			} else {
				goal1 = arr[1];
			}
			
			if (arr[2].equals("-2")) {
				goal2 = "__";
			} else if (arr[2].equals("-1")) {
				goal2 = "0:5";
			} else {
				goal2 = arr[2];
			}
		}
		
		final int dot = game.indexOf(".");
		final int minus = game.indexOf(" - ");
		
		final String[] res = new String[5];
		
		res[0] = FileIO.cleanQuotes(game.substring(0, dot));
		res[1] = FileIO.cleanQuotes(game.substring(dot + 1, minus));
		res[2] = FileIO.cleanQuotes(game.substring(minus + 3));
		res[3] = goal1;
		res[4] = goal2;
		
		return res;
	}
	
}
