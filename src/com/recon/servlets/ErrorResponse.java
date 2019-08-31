package com.recon.servlets;

import java.text.ParseException;

import org.apache.poi.util.SystemOutLogger;
import org.json.JSONObject;

public class ErrorResponse
{

	JSONObject job;
	
	public String generateError(String message, String refnumber, String errorCode)
	{
		job = new JSONObject();
		job.put("status", errorCode);
		job.put("ref_number", refnumber);
		job.put("resp_msg", message);
		return job.toString();
	}
	public static void main(String args[])
	{
		ErrorResponse errorResponse = new ErrorResponse();
		try
		{
			String arr[] = {"Resp_code","ref_number","error_msage"};
			JSONObject resp = new JSONObject(errorResponse.generateError("abc", "poi", "sdf"));
			for(int i=0 ; i<arr.length ; i++)
			{
				if(resp.has(arr[i]) && resp.getString(arr[i]) != null && !resp.getString(arr[i]).equals(""))
				{
					System.out.println(arr[i]+" :: "+resp.getString(arr[i]));
				}
			}
			
			//System.out.println(resp.has("resp_code")+" :: "+resp.has("resp_code1"));
		}
		catch (ParseException e)
		{			
			e.printStackTrace();
		}
	}

	
}
