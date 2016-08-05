package com.walmart.ticketservice.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author Veda
 *
 *Class PropertyReader that reads the properties file and provide the information required by the application.
 */
@SuppressWarnings("unchecked")
public class PropertyReader {
	
	/**
	 * Fields to store state of the PropertyReader.
	 */
	private static final String PROPERTIES = "ticketservice.properties";
	@SuppressWarnings("rawtypes")
	static Map hsMap = new HashMap<String, String>();
	static {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(PROPERTIES));
			hsMap.putAll(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The method returns a String that represents the value for corresponding key in the hashmap. 
	 * @param strKey the Sting object that represents the key in the hashmap.
	 */
	public static String fnGetValue(String strKey) {
		return (String) hsMap.get(strKey);
	}
	
	/**
	 * The method returns a String from the trace stack.
	 * 
	 */
	public static String stackTraceToString(Throwable e) {
		String result = null;
	    final StringWriter sw = new StringWriter();
	    final PrintWriter pw = new PrintWriter(sw, true);
	    e.printStackTrace(pw);
	    if(sw.getBuffer().toString().length()>2000)
	    	result = sw.getBuffer().toString().substring(0, 1999);
	    else
	    	result = sw.getBuffer().toString();
	    return result;
	}
		
}
