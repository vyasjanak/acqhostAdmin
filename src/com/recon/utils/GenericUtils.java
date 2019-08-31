package com.recon.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class GenericUtils 
{
	private static final String PROP_FILE_NAME = "C:/netc_cert/netcIssuer.properties";
	
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
	      //System.out.println(finalString);
	      
	      return finalString;
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }
	 
	 public static String httpServerCall(String URL, String data)
		{
			String line = null;	
			BufferedReader br = null;
			StringBuffer respJson = null;
			
			System.out.println("GenericUtils.java ::: httpServerCall() :: Posting URL : " +URL+" , Request Data : "+data);
			try
			{
				URL url = new URL(URL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();

				con.setRequestMethod("POST");
				//con.addRequestProperty("Content-Type", "text/plain;charset=UTF-8");
				//con.addRequestProperty("Content-Length", data.getBytes().length+"");
				con.setDoOutput(true);
				con.connect();

				OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
				//System.out.println(new SimpleDateFormat("dd-MM-YYYY HH:mm:ss").format(new Date())+" ::: Data length :: " + data.getBytes().length);
				wr.write(data);
				wr.flush();

				respJson = new StringBuffer(); 
				
				if (con.getResponseCode() == HttpURLConnection.HTTP_OK)
				{
					System.out.println("GenericUtils.java ::: httpServerCall :: HTTP OK");
					br = new BufferedReader(new
							InputStreamReader(con.getInputStream()));

					while((line = br.readLine()) != null)
					{
						System.out.println(line);
						respJson.append(line);
					}
					
					br.close();
					
					return respJson.toString();
				}
			}
			catch (Exception e)
			{	
				e.printStackTrace();
				System.out.println("GenericUtils.java ::: httpServerCall :: Error Occurred while Processing Request : "+e.getMessage());
			}
			
			return null;
		}
	 
		public static String getPropertyValue(String variableName)
        {
                FileInputStream inputStream = null;
                String variableValue = null;             
                
                try
                {                         
                        File file = new File(PROP_FILE_NAME);
                        if(file != null && file.exists())
                        {
                                inputStream = new FileInputStream(file);                
         
                                if (inputStream != null)
                                {
                                        Properties prop = new Properties();
                                        prop.load(inputStream);
                                        variableValue = prop.getProperty(variableName);
                                        
                                        System.out.println("GenericUtils.java ::: getPropertyValue() :: Key : " + variableName + " ::: Value : " + variableValue);
                                } 
                        }
                        else
                        {
                                System.out.println("GenericUtils.java ::: getPropertyValue() :: Property file '" + PROP_FILE_NAME + "' not found in the Classpath");
                        }
                }
                catch (Exception e)
                {
                        System.out.println("GenericUtils.java ::: getPropertyValue() :: Exception : "+e.getMessage());
                } 
                finally
                {
                        try 
                        {
							if(inputStream != null)
							inputStream.close();
						} 
                        catch (IOException e)
                        {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        finally
                        {
                        	inputStream = null;
                        }
                }
                
                return variableValue;
        }


	 
	 public static void main(String[] args) {
		 System.out.println("New Date : "+todaysDateTime());
	}
}
