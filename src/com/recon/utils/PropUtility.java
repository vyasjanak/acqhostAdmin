package com.recon.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class PropUtility 
{
	 public static String getNameString(String name) {
	       String finalName = null;
	    	try {
	            	Properties prop = new Properties();
	                InputStream inputStream = PropUtility.class.getClassLoader().getResourceAsStream("/name.properties");
	                prop.load(inputStream);
	                finalName = prop.getProperty(name);
	                System.out.println("finalName :: "+finalName);
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return finalName;
	    }
	       
	    public static void main(String args[] ) throws Exception {
	    	
	    	PropUtility.getNameString("rawDataFile1");
	    }
}
