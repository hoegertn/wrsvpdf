package com.hoegernet.wrsvpdf.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.hoegernet.wrsvpdf.exceptions.FileIOException;

/**
 * type: com.hoegernet.wrsvpdf->FileIO
 *
 * @author Thorsten Hoeger
 * created: 22.07.2007
 * file: FileIO.java
 *
 */
public class FileIO {

	/**
	 * @param filename
	 * @return String[]
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
			return lines.toArray(new String[]{});
		} catch (Exception e) {
			throw new FileIOException("Error reading file: " + filename, e);
		}
	}

	/**
	 * @param line
	 * @return String[]
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
	 * @param line
	 * @return Fields
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
	 * @param s
	 * @return String without "
	 */
	public static String cleanQuotes(String s) {
		String ret = s;
		if ((ret.length() > 0) && ret.substring(0, 1).equals("\"")) {
			ret = ret.substring(1);
		}
		if ((ret.length() > 1) && ret.substring(ret.length()-1).equals("\"")) {
			ret = ret.substring(0, ret.length()-1);
		}
		ret = ret.trim();
		return ret;
	}

	/**
	 * @param line
	 * @return Spiel
	 */
	public static String[] getSpielFromLine(String line) {
		int dot = line.indexOf(".");
		int minus = line.indexOf("-");

		String[] res = new String[3];

		res[0] = FileIO.cleanQuotes(line.substring(0, dot));
		res[1] = FileIO.cleanQuotes(line.substring(dot+1, minus));
		res[2] = FileIO.cleanQuotes(line.substring(minus+1));

		return res;
	}

}
