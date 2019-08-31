package com.recon.daoImpl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;

import com.recon.dao.GeneralDao;
import com.recon.entities.DropdownBean;
import com.recon.service.GeneralService;
import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.utils.DBConnectionHandler;
import com.recon.utils.HibernateUtil;

public class GeneralDaoImpl extends HibernateUtil implements GeneralDao
{
	
	private static SecretKeySpec secretKey;
    private static byte[] key;
    String user1 ="noreply_pgsupport@1pay.in";
    String pass = "no_reply1";

public int sendMail(String to, String subject, String from, String mailBody)
{		
		int status = 0;		
		String host = "smtp.gmail.com";

		// Get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.user", user1);
		properties.setProperty("mail.smtp.password", pass);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "false");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.port", "465");
		
		//Session session = Session.getDefaultInstance(properties);
		Session session = Session.getDefaultInstance(properties, 
			    new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(
			                user1, pass);// Specify the Username and the PassWord
			        }
			    });

		// compose the message
		try 
		{	
			System.out.println("GeneralDaoImpl.java ::: sendMail() :: Mail Params are : {"+to+","+from+","+subject+","+mailBody+"}");
			String[] recipientList = to.split(",");
			
			MimeMessage message = new MimeMessage(session);			
			message.setFrom(new InternetAddress(from));
			for (int i=0 ; i < recipientList.length ; i++)
			{
				System.out.println("GeneralDaoImpl.java ::: sendMail() :: Mail Recipients TO are : "+recipientList[i].toString());
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientList[i].toString()));
			}
			message.setSubject(subject);
			message.setContent(mailBody, "text/html");

			// Send message
			Transport.send(message);
			status = 1;
			System.out.println("GeneralDaoImpl.java ::: sendMail() :: Mail sent successfully and Status --> "+status);

		}
		catch (MessagingException mex)
		{
			status = -2;
			System.out.println("GeneralDaoImpl.java ::: sendMail() :: Error in mail sending and Status --> "+status);
		}
		return status;

	}
	

public List<DropdownBean> getBankNames() {
	List<DropdownBean> bankNames = new ArrayList<DropdownBean>();
	CallableStatement callableStatement = null;
	ResultSet rs = null;
	Connection con = null;
	
	try {
		con = new DBConnectionHandler().getConnection();
		String query = "{call pro_BankName()}";
		callableStatement = con.prepareCall(query);
		
		callableStatement.execute();
		 
		rs = callableStatement.getResultSet();
		
		if (rs != null) {
			while (rs.next()) {
				DropdownBean dropdownBean = new DropdownBean();
				dropdownBean.setCode(rs.getString("ifsc_code"));
				dropdownBean.setName(rs.getString("bank_name"));
				bankNames.add(dropdownBean);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		// session.close();
		try {
			if (rs != null) rs.close();
			if (callableStatement != null) callableStatement.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return bankNames;
}


	public void sendSMS(String sText, String c_mobile_no)
	{
		// TODO Auto-generated method stub
		try 
		{
			String sURL = "http://162.144.77.2:8000/Sendsms?";

			URL obj = new URL(sURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			
			String urlParameters = "user=1pay&password=pay123&sender=TESTIB"
					+ "&dest="+c_mobile_no+"&authkey=14015&msgtype=0&intl=0&text="+ URLEncoder.encode(sText);
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + sURL);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());
		} 
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ProtocolException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*public Map<String, String> getMailUserDetails(String email) {
		Map<String, String> data = null;
		CallableStatement callableStatement = null;
		org.hibernate.Session session = getSession();
		Connection con = session.connection();
		ResultSet rs = null;
		
		try {
			String query = "{call pro_GetUserLoginDetails(?)}";
			callableStatement = con.prepareCall(query);
			callableStatement.setString(1, email);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			if (rs != null && rs.next()) {
				data = new HashMap<String, String>();
				data.put("userId", rs.getString("USERID"));
				data.put("password", rs.getString("password"));
				data.put("API_Key",rs.getString("transaction_key"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			try {
				if (rs != null) rs.close();
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}*/
	
	public String crypt(String value) {
		String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
		try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            /*System.out.println("encrypted string: "
                    + Base64.encodeBase64String(encrypted));*/

            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
	}
	
	public String decrypt(String encrypted) {
		
		String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
		try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;   
	}
	
	public List<DropdownBean> getMerchantIds() {
		List<DropdownBean> serviceProviders = new ArrayList<DropdownBean>();
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		org.hibernate.Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_MerchantIdList()}";
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			if (rs != null) {
				while (rs.next()) {
					DropdownBean dropdownBean = new DropdownBean();
					dropdownBean.setCode(rs.getString("MerchantId"));
					dropdownBean.setName(rs.getString("merchant_name"));
					serviceProviders.add(dropdownBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			try {
				if (rs != null) rs.close();
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return serviceProviders;
	}
	// Pratik Bhat Wallet
	public int forgetPass(String mobileNo)
	{
	  	Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    PreparedStatement ps2 = null;
	    int status = 0;
	    org.hibernate.Session session = getSession();
	    if(checkMobile(mobileNo))
	    {
		    String generatedString = RandomStringUtils.randomAlphanumeric(10);
		    System.out.println(generatedString);		    
		    String password = crypt(generatedString);
		    System.out.println(password);		       
		    try
		    {
		      conn = session.connection();
			  String q2 = "Update tbl_mstuser SET is_first_login = 0,password=? where ContactNo =?";
		      ps2 = conn.prepareStatement(q2);
		      ps2.setString(1, password);	
		      ps2.setString(2, mobileNo);	
		      ps2.executeUpdate();
		      status = 1;
		    }
		    catch(Exception e)
		    {
		    	status = -1;
		    	e.printStackTrace();
		    }
		    try
		    {
		    	String SMStxt ="Your password is "+generatedString+"";
				//sendSMS(SMStxt, mobileNo);
			}
		    catch (Exception e1)
		    {
				// TODO Auto-generated catch block
				status = 2;
				e1.printStackTrace();
			}
	    }
	    else
	    {
	    	status=3;
	    }  
		    return status;
	}
	
	public boolean checkMobile(String mobileNo){
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    PreparedStatement ps2 = null;
	    org.hibernate.Session session = getSession();
	    conn = session.connection();
	    try{
		    //String sql ="SELECT * FROM user_master where userid=? and password=? and is_active=1";
	    	String sql ="SELECT * FROM tbl_mstuser where ContactNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,mobileNo);						
			rs = ps.executeQuery();
			if(rs.next())
			{
				return true;//take him to dahboard
			}
			else
			{
				return false; //back to loging screen 
			}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }	
	   return false; 
	}
	
	
	
	
	
	public static void main(String args[]) {
		System.out.println(new GeneralDaoImpl().decrypt("9eUXrO5y3sBdQ0HqM9dTeg=="));
		//System.out.println(new GeneralDaoImpl().randomPass());		
	}
}
