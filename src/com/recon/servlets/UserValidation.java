package com.recon.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import com.recon.utils.HibernateUtil;
import com.recon.utils.AcqHostUtils;

import org.hibernate.Session;
import org.json.JSONObject;

public class UserValidation
{	
	private JSONObject jsonObject;
	private boolean isValid;
	private String errorCode;
	private String errorMessage;
	
	public UserValidation()
	{
		super();
	}
	public UserValidation(JSONObject jsonObject){
		this.jsonObject = jsonObject;
	}
	public boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public boolean checkLoginDetails(String userId, String partnerId, String password)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String q1 = null;	
		Session session = new HibernateUtil().getSession();
		Connection conn = session.connection();

		try
		{	
			if (conn != null)
			{
				if (partnerId != null && partnerId.equalsIgnoreCase("NA"))
				{					
					q1 = "select * from tbl_mstuser where USERID=? and password=?";
				}
				else
				{
					q1 = "select * from api_user_master where userid=? and password=?";
				}
				System.out.println(partnerId+" :: "+q1);
				ps = conn.prepareStatement(q1);
				ps.setString(1, userId);
				ps.setString(2, password);
				rs = ps.executeQuery();
				if (rs != null && rs.next())
				{
					return true;
				}				
			}
			return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (ps != null)
				{
					ps.close();
					ps = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (Exception e)
			{				
				e.printStackTrace();
			}
		}
	}
	
	public UserValidation validateCreateWalletParams(UserValidation userValidation)
	{		
		userValidation.setIsValid(false);
		
		/*if (!jsonObject.has("soleId") || jsonObject.getString("soleId") == null || jsonObject.getString("soleId").equals(""))
		{ 
			userValidation.setErrorCode("EE"); 
			userValidation.setErrorMessage("Sole Id is Null/Blank.");
		}
		else if (!jsonObject.has("custName") || jsonObject.getString("custName") == null || jsonObject.getString("custName").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Customer Name is Null/Blank.");
		}
		else if (!jsonObject.has("contactPerson") || jsonObject.getString("contactPerson") == null || jsonObject.getString("contactPerson").equals(""))
		{ 
			userValidation.setErrorCode("EE");	
			userValidation.setErrorMessage("Contact Person is Null/Blank.");
		}
		else if (!jsonObject.has("phone") || jsonObject.getString("phone") == null || jsonObject.getString("phone").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Mobile Number is Null/Blank.");
		}
		else if (!jsonObject.has("emailId") || jsonObject.getString("emailId") == null || jsonObject.getString("emailId").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Email Id is Null/Blank.");
		}
		else if (!jsonObject.has("address") || jsonObject.getString("address") == null || jsonObject.getString("address").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Address is Null/Blank.");
		}
		else if (!jsonObject.has("state") || jsonObject.getString("state") == null || jsonObject.getString("state").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("State is Null/Blank.");
		}
		else if (!jsonObject.has("city") || jsonObject.getString("city") == null || jsonObject.getString("city").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("City is Null/Blank.");
		}
		else if (!jsonObject.has("pincode") || jsonObject.getString("pincode") == null || jsonObject.getString("pincode").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Pin Code is Null/Blank.");
		}
		else if (!jsonObject.has("aadharNo") || jsonObject.getString("aadharNo") == null || jsonObject.getString("aadharNo").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Aadhar Number is Null/Blank.");
		}
		else if (!jsonObject.has("aadharDoc") || jsonObject.getString("aadharDoc") == null || jsonObject.getString("aadharDoc").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Aadhar Doc is Null/Blank.");
		}
		else if (!jsonObject.has("panNo") || jsonObject.getString("panNo") == null || jsonObject.getString("panNo").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Pan Number is Null/Blank.");
		}
		else if (!jsonObject.has("panDoc") || jsonObject.getString("panDoc") == null || jsonObject.getString("panDoc").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Pan Doc is Null/Blank.");
		}
		else if (!jsonObject.has("otherDoc") || jsonObject.getString("otherDoc") == null || jsonObject.getString("otherDoc").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Other Doc is Null/Blank.");
		}
		else if (!jsonObject.has("accType") || jsonObject.getString("accType") == null || jsonObject.getString("accType").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Account Type is Null/Blank.");
		}
		else if (!jsonObject.has("accountNo") || jsonObject.getString("accountNo") == null || jsonObject.getString("accountNo").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Account Number is Null/Blank.");
		}
		else if (!jsonObject.has("bankName") || jsonObject.getString("bankName") == null || jsonObject.getString("bankName").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Bank Name is Null/Blank.");
		}
		else if (!jsonObject.has("ifscCode") || jsonObject.getString("ifscCode") == null || jsonObject.getString("ifscCode").equals(""))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("IFSC Code is Null/Blank.");
		}*/
		
		String reqFields[] = {"soleId","custName","contactPerson","phone","emailId","address","state","city","pincode","aadharNo","aadharDoc","panNo","panDoc","otherDoc","accType","accountNo","bankName","ifscCode"};
		String isNullResponse = AcqHostUtils.null2Known(reqFields,jsonObject);
		
		if(isNullResponse != null && !isNullResponse.equals("NOTNULL"))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage(isNullResponse);
		}
		else if (jsonObject.getString("phone").length() != 10)
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Mobile Number must be of length 10.");
		}
		else if (jsonObject.getString("aadharNo").length() != 12)
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Aadhar Number must be of length 12.");
		}
		else if (jsonObject.getString("panNo").length() != 10)
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("PAN Number must be of length 10.");
		}
		else if (jsonObject.getString("aadharDoc").equalsIgnoreCase("NA"))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Aadhar Doc cannot be NA.");
		}
		else if (jsonObject.getString("panDoc").equalsIgnoreCase("NA"))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("PAN Doc cannot be NA.");
		}
		else if (jsonObject.getString("pincode").length() != 6)
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Pin Code must be of length 6.");
		}
		/*else
		{
			WalletMasterService walletMasterService = new WalletMasterServiceImpl();
			List<Object> checkMobileNo = walletMasterService.findByProperty("userid", jsonObject.getString("phone"), "TblMstuser");
			
			if(checkMobileNo != null && checkMobileNo.size() > 0)
			{							
				userValidation.setErrorCode("EE");
				userValidation.setErrorMessage("Mobile Number '"+jsonObject.getString("phone")+"' already exists in the System.");
			}
			else
			{										
				userValidation.setIsValid(true);					
			}	    		  
		}*/
		return userValidation;
	}
	
	public UserValidation validateTransactionParams(UserValidation userValidation)
	{		
		userValidation.setIsValid(false);
		/*if(!jsonObject.has("mobile") || jsonObject.getString("mobile") == null || jsonObject.getString("mobile").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Mobile Number is Null/Blank.");
		}
		else if(!jsonObject.has("walletId") || jsonObject.getString("walletId") == null || jsonObject.getString("walletId").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Wallet Id is Null/Blank.");
		}
		else if(!jsonObject.has("amount") || jsonObject.getString("amount") == null || jsonObject.getString("amount").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Amount is Null/Blank.");
		}
		else if(!jsonObject.has("paymode") || jsonObject.getString("paymode") == null || jsonObject.getString("paymode").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Paymode is Null/Blank.");
		}
		else if(!jsonObject.has("remarks") || jsonObject.getString("remarks") == null || jsonObject.getString("remarks").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Remarks is Null/Blank.");
		}
		else if(!jsonObject.has("partnerId") || jsonObject.getString("partnerId") == null || jsonObject.getString("partnerId").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Partner Id is Null/Blank.");
		}
		else if(!jsonObject.has("partnerRefNo") || jsonObject.getString("partnerRefNo") == null || jsonObject.getString("partnerRefNo").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Partner Reference Number is Null/Blank.");
		}
		else if(!jsonObject.has("productId") || jsonObject.getString("productId") == null || jsonObject.getString("productId").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Product Id is Null/Blank.");
		}
		else if(!jsonObject.has("UDF1") || jsonObject.getString("UDF1") == null || jsonObject.getString("UDF1").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("UDF1 is Null/Blank.");
		}
		else if(!jsonObject.has("UDF2") || jsonObject.getString("UDF2") == null || jsonObject.getString("UDF2").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("UDF2 is Null/Blank.");
		}
		else if(!jsonObject.has("UDF3") || jsonObject.getString("UDF3") == null || jsonObject.getString("UDF3").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("UDF3 is Null/Blank.");
		}
		else if(!jsonObject.has("UDF4") || jsonObject.getString("UDF4") == null || jsonObject.getString("UDF4").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("UDF4 is Null/Blank.");
		}
		else if(!jsonObject.has("UDF5") || jsonObject.getString("UDF5") == null || jsonObject.getString("UDF5").equals(""))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("UDF5 is Null/Blank.");
		}*/
		
		String reqFields[] = {"mobile","walletId","amount","paymode","remarks","partnerId","partnerRefNo","productId","UDF1","UDF2","UDF3","UDF4","UDF5"};
		String isNullResponse = AcqHostUtils.null2Known(reqFields,jsonObject);
		
		if(isNullResponse != null && !isNullResponse.equalsIgnoreCase("NOTNULL"))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage(isNullResponse);
		}
		else if (!(jsonObject.getString("ttype").equalsIgnoreCase("DEBIT") || jsonObject.getString("ttype").equalsIgnoreCase("CREDIT") || jsonObject.getString("ttype").equalsIgnoreCase("GetWalletDetails")))
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Invalid Transaction Type");
		}
		else if (!(jsonObject.getString("UDF1").equalsIgnoreCase("SALE") || jsonObject.getString("UDF1").equalsIgnoreCase("TOPUP")
								|| jsonObject.getString("UDF1").equalsIgnoreCase("REFUND") || jsonObject.getString("UDF1").equalsIgnoreCase("VOID")
								|| jsonObject.getString("UDF1").equalsIgnoreCase("REVERSAL") || jsonObject.getString("UDF1").equalsIgnoreCase("CASHBACK")
								|| jsonObject.getString("UDF1").equalsIgnoreCase("CHARGEBACK") || jsonObject.getString("UDF1").equalsIgnoreCase("OFFERS") || jsonObject.getString("UDF1").equalsIgnoreCase("W2W")))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Invalid Transaction Identifier");
		}
		else if (jsonObject.getString("ttype").equalsIgnoreCase("CREDIT") && !(jsonObject.getString("UDF1").equalsIgnoreCase("TOPUP")
				|| jsonObject.getString("UDF1").equalsIgnoreCase("REFUND") || jsonObject.getString("UDF1").equalsIgnoreCase("VOID")
				|| jsonObject.getString("UDF1").equalsIgnoreCase("CASHBACK") || jsonObject.getString("UDF1").equalsIgnoreCase("CHARGEBACK")
				|| jsonObject.getString("UDF1").equalsIgnoreCase("OFFERS")))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Invalid Transaction Identifier '"+jsonObject.getString("UDF1")+"' used for CREDIT Transaction Type.");
		}
		else if (jsonObject.getString("ttype").equalsIgnoreCase("DEBIT") && !(jsonObject.getString("UDF1").equalsIgnoreCase("SALE")
				|| jsonObject.getString("UDF1").equalsIgnoreCase("REVERSAL")))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Invalid Transaction Identifier '"+jsonObject.getString("UDF1")+"' used for DEBIT Transaction Type.");
		}
		else if (jsonObject.getString("UDF1").equalsIgnoreCase("W2W") && (jsonObject.getString("UDF2").length() != 15))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Invalid Destination Wallet Id");
		}
		else if (jsonObject.getString("mobile").length() != 10)
		{ 
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Mobile Number must be of length 10.");
		}
		else if(!isValidAmount(jsonObject.getString("amount")))
		{
			userValidation.setErrorCode("EE");
			userValidation.setErrorMessage("Invalid Amount.");
		}
		else
		{
			userValidation.setIsValid(true);
		}
		
		return userValidation;
	}
	
	/*private String null2Known(String[] reqFields)
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
			e.printStackTrace();
		}
		return errorResponse;
	}*/
	
	private boolean isValidAmount(String txn_amount)
	{
		try
		{
			Double d = Double.valueOf(txn_amount);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("RequestHandler.java ::: isValidAmount() :: DateTime received in Request is : "+txn_amount+" And Exception Occurred : "+e.getMessage());
		}
		return false;
	}
}
