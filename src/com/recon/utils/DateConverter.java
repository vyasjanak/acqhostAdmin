package com.recon.utils;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter
{
  public static String dateConvert(String oldDate)
  {
    try
    {
      System.out.println("BEFORE..." + oldDate);
      
      DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
      Date date = formatter.parse(oldDate);
      SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
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
  
  public static String dateConvertTwo(String oldDate)
  {
    try
    {
      System.out.println("BEFORE..." + oldDate);
      
      DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      Date date = formatter.parse(oldDate);
      SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
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
}
