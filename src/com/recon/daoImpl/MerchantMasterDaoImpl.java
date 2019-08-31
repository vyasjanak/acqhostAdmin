package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.recon.dao.MerchantMasterDao;
import com.recon.entities.TblMstrole;
import com.recon.entities.TblMstuser;
import com.recon.entities.MDRMaster;
import com.recon.entities.TblAccountMaster;
import com.recon.entities.TblAddressMaster;
import com.recon.entities.TblMerchantMaster;
import com.recon.service.GeneralService;
import com.recon.service.MerchantMasterService;
import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.serviceImpl.MerchantMasterServiceImpl;
import com.recon.utils.HibernateUtil;
import com.recon.utils.AcqHostUtils;
import com.recon.utils.DBConnectionHandler;

public class MerchantMasterDaoImpl  extends HibernateUtil implements MerchantMasterDao
{	
	public List<Object> findByProperty(String propertyName, Object value, String entityName) 
	{
		Session session = getSession();
		String queryString = null;
		Query queryObject = null;
		
		try
		{
			if (propertyName != null && !propertyName.equals(""))
			{
				// System.out.println("Inside the findByProperty Method Execute IF");
				queryString = "from "+entityName+" as model where model."
						+ propertyName + "= ?";
				// System.out.println("queryString = "+queryString+"    ID  "+value);
				queryObject = session.createQuery(queryString);
				queryObject.setParameter(0, value);
			} 
			else
			{
				// System.out.println("Inside the findByProperty Method Execute Else");
				queryString = "from "+entityName;
				queryObject = session.createQuery(queryString);
			}
			
			return queryObject.list();
			
		}
		catch (RuntimeException re)
		{
			throw re;
		} 
		finally 
		{
			session.close();
		}
	}
	
	public int saveOrUpdateMerchant(String operation, TblMerchantMaster tblMerchantMaster, TblAddressMaster tblAddressMaster, MDRMaster mdrMaster, TblAccountMaster tblAccountMaster)
	{
		int status = 0;
		Session session = getSession();
		
		String merchantId = tblMerchantMaster.getMerchant_id();
		
		try
		{
			if (operation != null && operation.equals("save"))
			{																	
					Transaction tx = session.beginTransaction();
					 
					 session.merge(tblMerchantMaster);
					 session.merge(tblAddressMaster);
					 session.merge(mdrMaster);
					 session.merge(tblAccountMaster);
					 
					
					// session.save(tblMerchantMaster);
					
					
					TblMstuser tblMstuser = new TblMstuser();
					 tblMstuser.setUserid(tblMerchantMaster.getMerchant_id());
					
					 MerchantMasterService merchantMasterService = new MerchantMasterServiceImpl();
					//  TblMstgroup tblMstgroup = (TblMstgroup)merchantMasterService.findByProperty("groupid", Integer.parseInt("1"), "TblMstgroup").get(0);
					// tblMstuser.setTblMstgroup(tblMstgroup);
					// TblMstrole tblMstrole = (TblMstrole)merchantMasterService.findByProperty("roleid", Integer.parseInt("2"), "TblMstrole").get(0);
					// tblMstuser.setTblMstrole(tblMstrole);
					// tblMstuser.setFullName(tblWalletMaster.getCust_name());
					tblMstuser.setEmailId(tblMerchantMaster.getEmail_id()); 
					tblMstuser.setRole_id(2);
					tblMstuser.setFullName(tblMerchantMaster.getMerchant_name());
					tblMstuser.setContactNo(tblMerchantMaster.getContact_number());
					tblMstuser.setIsActive("1");
					tblMstuser.setLastLogin(tblMerchantMaster.getCreated_on());
					tblMstuser.setLastLoginIp("NA");
					tblMstuser.setCreatedBy(tblMerchantMaster.getCreated_by());
					tblMstuser.setCreatedOn(tblMerchantMaster.getCreated_on());
					tblMstuser.setModifiedBy(tblMerchantMaster.getCreated_by());
					tblMstuser.setModifiedOn(tblMerchantMaster.getCreated_on());
					
					tblMstuser.setIsDeleted("N");
					
					GeneralService generalService = new GeneralServiceImpl();
					
					String password = AcqHostUtils.randomAlphaNumeric(8);
					System.out.println("Password = "+password);
					password = generalService.crypt(password);
					
					tblMstuser.setPassword(password);
					
					session.save(tblMstuser);
					 System.out.println("{"+tblMerchantMaster.getMerchant_id()+","+password+"}");
					
					tx.commit();
					System.out.println("Commit For Save Merchant");
					status = 1;
				
					String bodyText = "Dear "+ tblMerchantMaster.getMerchant_name()+",<br>";
					
			    	  bodyText += "<br><b>Greetings from 1Pay!!!!!</b><br>";
			    	 /* bodyText += "<br>Your Wallet Account has been created successfully.<br>";*/
			    	  bodyText += "<br>Your Concessioner Id is <b>"+tblMerchantMaster.getMerchant_id()+"</b>.<br>";
			    	  bodyText += "<br>Your Login details are as follows: <br>";
			    	  bodyText += "<br><b>User/Login Id   	: </b>"+tblMerchantMaster.getMerchant_id()+"</i><br>";
			    	  bodyText += "<br><b> Password 	: </b>"+generalService.decrypt(password)+"</i><br>";			    	  
			    	  bodyText += "<br><a href = http://192.168.1.99:8080/acqhostMerchant/login_signin.jsp>Click here</a> to Login to your acqhost portal.<br>";			   			    
			    	  bodyText += "<br>If you have any questions, please contact us on <font color='red'>sales@1pay.in</font>.<br>";
			    	  bodyText += "<br><br><br><br><br><b>Best Regards,</b>";
			    	  bodyText += "<br>Team 1Pay";
			    	  bodyText += "<br><a href = www.1pay.in>www.1pay.in</a><br>";
					 status = generalService.sendMail(tblMerchantMaster.getEmail_id()+",bharat.choudhary@1pay.in","Concessioner Created Successfully ", "noreply_pgsupport@1pay.in", bodyText);
				}
			
			
			if (operation != null && operation.equals("update"))
			{														
				// System.out.println("beginTransaction for update record.");
				System.out.println("Merchant ID For update begin transaction "+merchantId);
					Transaction tx = session.beginTransaction();
					 /*session.merge(tblAddressMaster);
					 session.merge(tblAccountMaster);
					 session.merge(tblMerchantMaster);*/
					
					 tblMerchantMaster.setMerchant_id(merchantId);
					 session.merge(tblMerchantMaster);
				     tblAddressMaster.setEntity_id(merchantId);
					 session.merge(tblAddressMaster);
					 mdrMaster.setMerchant_id(merchantId);
					 session.merge(mdrMaster);
					 
					 tblAccountMaster.setMerchant_id(merchantId);
					 session.merge(tblAccountMaster);
					 
					 
					 
					/*TblMstuser tblMstuser = new TblMstuser();
					 tblMstuser.setUserid(tblMerchantMaster.getMerchant_id());
					
					 MerchantMasterService merchantMasterService = new MerchantMasterServiceImpl();
					
					tblMstuser.setEmailId(tblMerchantMaster.getEmail_id()); 
					tblMstuser.setRole_id(2);
					tblMstuser.setFullName(tblMerchantMaster.getMerchant_name());
					tblMstuser.setContactNo(tblMerchantMaster.getContact_number());
					tblMstuser.setIsActive("1");
					tblMstuser.setLastLogin(tblMerchantMaster.getCreated_on());
					tblMstuser.setLastLoginIp("NA");
					tblMstuser.setCreatedBy(tblMerchantMaster.getCreated_by());
					tblMstuser.setCreatedOn(tblMerchantMaster.getCreated_on());
					tblMstuser.setModifiedBy(tblMerchantMaster.getCreated_by());
					tblMstuser.setModifiedOn(tblMerchantMaster.getCreated_on());
					
					tblMstuser.setIsDeleted("N");
					
					session.save(tblMstuser);*/
					
					tx.commit();
					System.out.println("Commit For Update Merchant");
					status = 1;
				}
			
		}
		catch(Exception e)
		{
			System.out.println("MerchantMasterDaoImpl.java ::: saveOrUpdateMerchant() :: Error Occurred --> "+e.getMessage());
			e.printStackTrace();
			session.getTransaction().rollback();
			status = -1;
			PreparedStatement ps = null;
			Connection con = session.connection();
			if (con != null)
			{
				try
				{
					/*String srNo = walletIdDetails.get(1);
					
					String updateQuery = "update serial_master set sr_value=? WHERE sr_name=? and sr_value=?";
					
					ps = con.prepareStatement(updateQuery);
					ps.setInt(1, Integer.parseInt(srNo)-1);
					
					ps.setInt(3, Integer.parseInt(srNo));
					ps.executeUpdate();
					
					con.commit();
					System.out.println("WalletMasterDaoImpl.java ::: saveOrUpdateWallet() :: Serial Number to Decrement : "+srNo);*/
				} 
				catch (Exception e1)
				{
					System.out.println("MerchantMasterDaoImpl.java ::: saveOrUpdateMerchant() :: Error Occurred while decrementing Serial Master : "+e1.getMessage());					
				}
				finally
				{
					try 
					{						
						if(ps!=null)
						{
							ps.close();
							ps = null;
						}				
						if(con != null)
						{
							con.close();
							con = null;
						}
					}
					catch (SQLException localSQLException4)
					{
						System.out.println("MerchantMasterDaoImpl.java ::: saveOrUpdateMerchant() :: Error Occurred while closing Connection : "+localSQLException4.getMessage());
					}
				}
			}									
		}
		finally
		{
			//walletIdDetails = null;
			session.close();
		}
		
		return status;
	}
	
	
	public List<List<String>> getMerchantDetails(String searchMid ,String searchMname) {
		List<List<String>> merchants = null;
		List<String> merchantList = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		// System.out.println("DAO getMerchantDetails() :::   Merchant ID : "+searchMid);
		// System.out.println("DAO getMerchantDetails() :::   Merchant Name : "+searchMname);
		try {
			String query = "{call pro_MerchantList(?,?)}";
			callableStatement = con.prepareCall(query);
			callableStatement.setString(1, searchMid);
			callableStatement.setString(2, searchMname);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null) {
				merchants = new ArrayList<List<String>>();
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					headerNames.add(rsmd.getColumnLabel(i));
				}
				merchants.add(headerNames);
				while (rs.next()) {
					merchantList = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						merchantList.add(rs.getString(rsmd.getColumnLabel(i)));
					}
					merchants.add(merchantList);
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
		
		return merchants;
	} 
	
	
	public  int deleteMerchant(String Id) {
		// System.out.println("ID for Delete "+Id);
		int status;
		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();
			Query qry = session.createQuery("update TblMerchantMaster p set p.is_deleted='Y' where p.id="+Id);
			
	        int res = qry.executeUpdate();
			tx.commit();
			status = 1;
		} catch (Exception e) {
			status = 0;
			e.printStackTrace();
		} finally{
			session.close();
		}
		return status;
		
	}


	

	public String getIFSC(String bank_name) throws Exception {
		
		String IFSC = null;
		
		Connection con = null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		String query = null;
		
		try {
			con = new DBConnectionHandler().getConnection();
			
			query = "select ifsc_code from bank_master where bank_name = ? ";
			ps = con.prepareStatement(query);
			ps.setString(1, bank_name);
			rs = ps.executeQuery();
			
			while (rs.next()) {               
				IFSC = rs.getString(1);        
			
			 System.out.println("IFSC Code MerchantMasterDaoImpl = " + IFSC);
			                                  // Print the column values
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return IFSC;
	}
}
