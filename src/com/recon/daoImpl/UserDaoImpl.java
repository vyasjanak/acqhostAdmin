package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.recon.dao.UserDao;
import com.recon.entities.TblMerchantMaster;
import com.recon.entities.TblMstuser;



import com.recon.utils.HibernateUtil;

public class UserDaoImpl extends HibernateUtil implements UserDao {
	
	public TblMstuser loginInformation(TblMstuser tblMstuser)
	{
		// System.out.println("loginInformation method before session");
		Session session = getSession();
		System.out.println("loginInformation method after session");
		try 
		{
			session.beginTransaction();
			
			System.out.println("Password" + tblMstuser.getPassword());
			String query = "from TblMstuser where userid='"
					+ tblMstuser.getUserid() + "' and password='"
					+ tblMstuser.getPassword() + "' and isActive='1' and isDeleted='N' and (role_id<>'2' or role_id<>'3')";
			System.out.println("query ======> " + query);
			List userInfo=session.createQuery(query).list();
			
			if(userInfo.size()>0)
			{
				tblMstuser=(TblMstuser)userInfo.get(0);
			}
			
			else
			{
				tblMstuser=null;
			}
		}
		catch (Exception e)
		{
			System.out.println("Inside Login Information method exception ");
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return tblMstuser;
	}
	
	/*public int saveSignupData(TblMstmerchant tblMstmerchant, String merchantId) {
		
		int status = 0;

		Session session = getSession();
		try 
		{
			Transaction tx = session.beginTransaction(); 
			tblMstmerchant.setMerchantId(merchantId);
			session.save(tblMstmerchant);
			session.flush();
			tx.commit();
			status = 1;
			TblMstuser tblMstuser = new TblMstuser();
			tblMstuser.setUserid(merchantId);
			
			WalletMasterService walletMasterService = new WalletMasterServiceImpl();
			TblMstgroup tblMstgroup = (TblMstgroup)walletMasterService.findByProperty("groupid", Integer.parseInt("2"), "TblMstgroup").get(0);
			tblMstuser.setTblMstgroup(tblMstgroup);
			
			TblMstrole tblMstrole = (TblMstrole)walletMasterService.findByProperty("roleid", Integer.parseInt("2"), "TblMstrole").get(0);
			tblMstuser.setTblMstrole(tblMstrole);
			tblMstuser.setFullName(tblMstmerchant.getMerchantName());
			tblMstuser.setIsActive("1");
			tblMstuser.setIsDeleted("N");
			
			GeneralService generalService = new GeneralServiceImpl();
			String password = tblMstmerchant.getMerchantName().split(" ")[0]+"@2017";
			password = generalService.crypt(password);
			
			tblMstuser.setPassword(password);
			
			
			status = saveUser(tblMstuser);
		} catch (Exception e) {
			System.out.println("Inside saveSignupData method exception ");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}*/
	
	public int saveUser(TblMstuser tblMstuser) {
		
		int status = 0;

		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction(); 
			session.save(tblMstuser);
			
			tx.commit();
			
			status = 1;
		} catch (Exception e) {
			System.out.println("Inside saveSignupData method exception ");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}
	
	public String getMerchantId() {
		String merchantId = null;
		
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_GetMerchantId()}";
			callableStatement = con.prepareCall(query);
			
			rs = callableStatement.executeQuery();
			 
			if (rs != null && rs.next()) {
				merchantId = rs.getString(1);
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
		
		return merchantId;
	}
	
	public int changePassword(String userId, String oldPassword, String newPassword) {
		int status = 0;
		Session session = getSession();
		try
		{
			Transaction tx = session.beginTransaction();
			
			TblMstuser tblMstuser = new TblMstuser();
			tblMstuser.setUserid(userId);
			tblMstuser.setPassword(oldPassword);
			tblMstuser = loginInformation(tblMstuser);
			tblMstuser.setPassword(newPassword);
			/*tblMstuser.setIsFirstLogin("N");*/
			tblMstuser.setModifiedBy(userId);
			tblMstuser.setModifiedOn(new Timestamp(System.currentTimeMillis()));
			
			session.update(tblMstuser);
			
			tx.commit();
			
			status = 1;
		} catch (Exception e) {
			status = -1;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}
	
	///Pratik Bhat For The wallet
		public String firstLogin(String userid)
		{
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String flag = null;
			Session session = getSession();
			try{
				
				con = session.connection();
				//String query ="Select first_login_flag from wallet_master where mobile_no=?";
				String query ="Select is_first_login from tbl_mstuser where USERID=?";
				ps =con.prepareStatement(query);
				ps.setString(1, userid);
				rs =ps.executeQuery();
					if(rs.next())
					{
						flag = rs.getString("isFirstLogin").toString();
					}
					
			}catch(Exception e){
				e.printStackTrace();
			}
			return flag;
		}
		public void changeFlag(String userid)
		{
		  	Connection conn = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    PreparedStatement ps2 = null;
		    Session session = getSession();
		    try
		    {
		    conn = session.connection();
			  String q2 = "Update tbl_mstuser SET is_first_login = 1 where USERID =?";
		      ps2 = conn.prepareStatement(q2);
		      ps2.setString(1, userid);		      
		      ps2.executeUpdate();
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
	  }	
	
	public static void main(String [] args){
		UserDaoImpl udi =new UserDaoImpl();
		String flag = udi.firstLogin("M0002");
		System.out.println(flag);
		
		/*String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder( 4 );
		   for( int i = 0; i < 4; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   System.out.println(sb.toString());
		   
		   String randomAlpha = sb.toString();
		
		List<Integer> numbers = new ArrayList<Integer>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }

	    Collections.shuffle(numbers);

	    String result = "";
	    for(int i = 0; i < 4; i++){
	        result += numbers.get(i).toString();
	    }
	    
	    String randomNo = randomAlpha+""+result;
	    
	    sb = new StringBuilder( 4 );
		   for( int i = 0; i < 4; i++ ) 
		      sb.append( randomNo.charAt( rnd.nextInt(randomNo.length()) ) );
		   System.out.println(sb.toString());
		   
		   randomAlpha = sb.toString();
	    
	    System.out.println(randomAlpha);*/
	}

	@Override
	public int saveSignupData(TblMerchantMaster tblMstmerchant, String merchantId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
