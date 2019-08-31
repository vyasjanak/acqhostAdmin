package com.recon.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class GenericDateUtils 
{
	public static String todaysDateTime()
	{
		Date currentDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strCurrentDate = df.format(currentDate);
		return strCurrentDate;
		/*Date currentDate = GregorianCalendar.getInstance().getTime();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = formatter.format(currentDate);
		return date;*/
	}
	 public static String dateConvertToRecon(String oldDate)
	  {
	    try
	    {
	      //System.out.println("BEFORE..." + oldDate);
	      //oldDate = "22-04-2018 12:10:40";
	      
	      DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	      Date date = formatter.parse(oldDate);
	      SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	      String finalString = newFormat.format(date);
	      System.out.println(finalString);
	      
	      return finalString;
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }
	 public static void main(String[] args) {
		 System.out.println("New Date : "+todaysDateTime());
	}
}
