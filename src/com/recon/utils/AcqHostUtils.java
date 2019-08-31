package com.recon.utils;

import org.json.JSONObject;

import com.recon.daoImpl.GeneralDaoImpl;

public class AcqHostUtils 
{
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final String ALPHA_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String NUMERIC_STRING = "0123456789";
	
	public static String randomAlphaNumeric(int count) 
	{
		StringBuilder builder = new StringBuilder();
		while (count-- != 0)
		{
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static String randomAlpha(int count) 
	{
		StringBuilder builder = new StringBuilder();
		while (count-- != 0)
		{
			int character = (int)(Math.random()*ALPHA_STRING.length());
			builder.append(ALPHA_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static String randomNumeric(int count) 
	{
		StringBuilder builder = new StringBuilder();
		while (count-- != 0)
		{
			int character = (int)(Math.random()*NUMERIC_STRING.length());
			builder.append(NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static String null2Known(String[] reqFields, JSONObject jsonObject)
	{
		String errorResponse = "NOTNULL";
		try
		{				
			for(int i=0 ; i<reqFields.length ; i++)
			{				
				if(!jsonObject.has(reqFields[i]) || jsonObject.getString(reqFields[i]) == null || jsonObject.getString(reqFields[i]).equals(""))
				{
					errorResponse = "Request Field '"+reqFields[i]+"' is Missing/Null/Blank.";
				}
			}
			
			//System.out.println(resp.has("resp_code")+" :: "+resp.has("resp_code1"));
		}
		catch (Exception e)
		{			
			System.out.println("WalletUtils.java ::: Error Occurred during Validation :: "+e.getMessage());
		}
		return errorResponse;
	}
	
	public static void main(String args[])
	{
		System.out.println(AcqHostUtils.randomAlphaNumeric(8));
		System.out.println(AcqHostUtils.randomNumeric(1));
		System.out.println(AcqHostUtils.randomAlpha(2));
		//System.out.println(new GeneralDaoImpl().decrypt("ZU7iUi4oFC2XZ2vr1ugA9w=="));
	}
}
