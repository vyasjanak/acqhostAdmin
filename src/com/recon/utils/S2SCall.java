package com.recon.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class S2SCall
{	
	static
	{
	    disableSslVerification();
	}
	
	public static String secureServerCall(String sURL, String data)
	{
		// TODO Auto-generated method stub
		
		String line = null;	
		BufferedReader br = null;
		StringBuffer respString = null;
		
		System.out.println("S2SCall.java ::: secureServerCall() :: Posting URL : " +sURL+" , Request Data : "+data);
		
		try
		{
			URL obj = new URL(sURL);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	
			//add reuqest header
		
			con.setRequestMethod("POST");
			con.addRequestProperty("Content-Type", "text/plain;charset=UTF-8");
			con.addRequestProperty("Content-Length", data.getBytes().length+"");
			con.setDoOutput(true);
			con.connect();
	
			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
			//System.out.println(new SimpleDateFormat("dd-MM-YYYY HH:mm:ss").format(new Date())+" ::: Data length :: " + data.getBytes().length);
			wr.write(data);
			wr.flush();
	
			respString = new StringBuffer(); 
			
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK)
			{
				System.out.println("S2SCall.java ::: secureServerCall() :: HTTP OK");
				br = new BufferedReader(new
						InputStreamReader(con.getInputStream()));
	
				while((line = br.readLine()) != null)
				{
					System.out.println("S2SCall.java ::: secureServerCall() :: Response : "+line);
					respString.append(line);
				}
				
				br.close();
				
				return respString.toString();
			}
		}
		catch (Exception e)
		{				
			System.out.println("S2SCall.java ::: secureServerCall() :: Error Occurred while Processing Request : "+e.getMessage());
			e.printStackTrace();
		}
		/*JSONObject jsonObject = new JSONObject();
		jsonObject.put("returnCode", "0");
		jsonObject.put("returnMsg", "Success");*/
		
		return null;
	}
	
	private static void disableSslVerification()
	{
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[]
	        {
	        	new X509TrustManager()
		        {
		            public X509Certificate[] getAcceptedIssuers() 
		            {
		                return null;
		            }
		            public void checkClientTrusted(X509Certificate[] certs, String authType)
		            {
		            }
		            public void checkServerTrusted(X509Certificate[] certs, String authType)
		            {
		            }
		        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier()
	        {
	            public boolean verify(String hostname, SSLSession session)
	            {
	                return true;
	            }
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        System.out.println("S2SCall.java ::: disableSslVerification() :: Error Occurred while disabling SSL Verification : "+e.getMessage());
	    } 
	}


}
