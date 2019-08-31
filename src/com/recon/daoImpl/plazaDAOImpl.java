package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.recon.entities.DropdownBean;
import com.recon.entities.Plaza;
import com.recon.service.GeneralService;
import com.recon.service.IdService;
import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.utils.AcqHostUtils;
import com.recon.utils.DBConnectionHandler;
import com.recon.utils.HibernateUtil;

public class plazaDAOImpl extends HibernateUtil {
	
	
	public String addPlaza(Plaza plaza) throws Exception{
		
		System.out.println("Toll id  ::  "+plaza.getToll_plaza_id()+" Account no  ::  "+ plaza.getAcno());
		
		String status = "-1";
		Connection con = null;
		PreparedStatement ps = null,ps1 = null,ps2 = null,ps3 = null;
		String query,query1,query2,query3 = null;
		
				// createTollPlazaUserId
				// IdService idservice = new IdService();
				 // String plazaUserId = idservice.createPlaza_userId();    // through Procedure
				 String plazaUserId = plaza.getToll_plaza_id();
		try {
			con = new DBConnectionHandler().getConnection();
			con.setAutoCommit(false);
			System.out.println("Set AutoCommit False");
			query = "INSERT INTO `toll_plaza_master`(`toll_plaza_id`,`merchant_id`,`toll_name`,`location`,`contact_person`,`email_id`,`contact_number`,`toll_geo_code`,`toll_plaza_type`,`is_active`,`settlement_type`,`created_on`,`created_by`,`approved_on`,`approved_by`)VALUES(?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?)";
			ps = con.prepareStatement(query);
			ps.setString(1, plaza.getToll_plaza_id());
			ps.setString(2, plaza.getMerchant_id());
			ps.setString(3, plaza.getToll_name());
			ps.setString(4, plaza.getLocation());
			ps.setString(5, plaza.getContact_person());
			ps.setString(6, plaza.getEmailid());
			ps.setString(7, plaza.getContactNo());
			ps.setString(8, plaza.getGeoCode());
			ps.setString(9, plaza.getTollType());
			ps.setString(10, plaza.getIsActive());
			ps.setString(11, plaza.getSettlementType());
			ps.setString(12, plaza.getCreatedBy());
			//ps.setString(12, plaza.getApprovedOn());
			ps.setString(13, plaza.getApprovedBy());			
			ps.executeUpdate();
			//address
			query1 ="INSERT INTO `address_master`(`entity_id`,`address1`,`address2`,`state`,`city`,`pin`,`created_by`)VALUES(?,?,?,?,?,?,?);";
			ps1 = con.prepareStatement(query1);
			ps1.setString(1, plaza.getToll_plaza_id());
			ps1.setString(2, plaza.getAdd1());
			ps1.setString(3, plaza.getAdd2());
			ps1.setString(4, plaza.getState());
			ps1.setString(5, plaza.getCity());
			ps1.setString(6, plaza.getPin());
			ps1.setString(7, plaza.getCreatedBy());
			ps1.executeUpdate();
			//account
			if((plaza.getAcno()== "") && (plaza.getIfsc()== "") && (plaza.getBankName()== "")){
				System.out.println("Toll Account will be settled from the details provided by Merchant");
			}else{
				String TollPlazaId = plaza.getToll_plaza_id();
				
				query2 = "INSERT INTO `account_master`(`merchant_id`,`account_number`,`acc_type`,`ifsc_code`,`bank_name`,`created_by`)VALUES(?,?,?,?,?,?);";
				ps2 = con.prepareStatement(query2);
				ps2.setString(1, TollPlazaId);
				ps2.setString(2, plaza.getAcno());
				ps2.setString(3, plaza.getAcc_type());
				ps2.setString(4, plaza.getIfsc());
				ps2.setString(5, plaza.getBankName());
				ps2.setString(6, plaza.getCreatedBy());
				ps2.executeUpdate();
				
			}
			
			
			GeneralService generalService = new GeneralServiceImpl();
			// String user_id = "P0000";
			// String append_userId = AcqHostUtils.randomNumeric(5);
			// String plazaUserId = user_id + append_userId;  // 10 digit
			System.out.println("plazaUserId    =  "+plazaUserId);
			String password = AcqHostUtils.randomAlphaNumeric(8);
			System.out.println("Password = "+password);
			password = generalService.crypt(password);
			System.out.println("Encripted Password = "+password);
			
			// user Master
			query3 = "INSERT INTO `user_master`(`user_id`,`role_id`,`full_name`,`password`,`email_id`,`contact_number`,`is_active`,`last_login_ip`,`created_on`,`created_by`,`is_deleted`) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
			ps3 = con.prepareStatement(query3);
			ps3.setString(1, plazaUserId);
			ps3.setString(2, "3");
			ps3.setString(3, plaza.getToll_name());
			ps3.setString(4, password);
			ps3.setString(5, plaza.getEmailid());
			ps3.setString(6, plaza.getContactNo());
			
			ps3.setString(7, "1");
			ps3.setString(8, "NA");
			ps3.setString(9, plaza.getCreatedOn());
			ps3.setString(10, plaza.getCreatedBy());
			ps3.setString(11, "N");
			
			ps3.executeUpdate();
			
			//ps.executeBatch();
			con.commit();
			status = "1";
			
			
			System.out.println("Commit For Save Plaza Details");
			
		
			String bodyText = "Dear "+ plaza.getToll_name()+",<br>";
			
	    	  bodyText += "<br><b>Greetings from 1Pay!!!!!</b><br>";
	    	  bodyText += "<br>Your Plaza Login details are as follows: <br>";
	    	  bodyText += "<br><b>User/Login Id   	: </b>"+plazaUserId+"</i><br>";
	    	  bodyText += "<br><b> Password 	: </b>"+generalService.decrypt(password)+"</i><br>";			    	  
	    	  bodyText += "<br><a href = http://192.168.1.99:8080/acqhostMerchant/login_signin.jsp>Click here</a> to Login to your acqhost portal.<br>";			   			    
	    	  bodyText += "<br>If you have any questions, please contact us on <font color='red'>sales@1pay.in</font>.<br>";
	    	  bodyText += "<br><br><br><br><br><b>Best Regards,</b>";
	    	  bodyText += "<br>Team 1Pay";
	    	  bodyText += "<br><a href = www.1pay.in>www.1pay.in</a><br>";
			 int statusEmail = generalService.sendMail(plaza.getEmailid(),"Plaza Created Successfully ", "noreply_pgsupport@1pay.in", bodyText);
			 
			 status = Integer.toString(statusEmail);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
				ps1.close();
				//ps2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
	public String approvePlaza(Plaza plaza) throws Exception{
		String status = "-1";
		Connection con = null;
		PreparedStatement ps = null;
		String query = null;
		try {
			con = new DBConnectionHandler().getConnection();
			query = "UPDATE `toll_plaza_master` SET approved_on=now(),approved_by=? where id=?";
			ps = con.prepareStatement(query);
			ps.setString(1, plaza.getApprovedBy());
			ps.setString(2, plaza.getPlazaid());
			ps.executeUpdate();
			
			status = "1";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
	public List<DropdownBean> getMerchantIds() {
		List<DropdownBean> serviceProviders = new ArrayList<DropdownBean>();
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		// org.hibernate.Session session = getSession();
		Connection con = null;
		
		try {
			con = new DBConnectionHandler().getConnection();
			String query = "{call pro_MerchantIdList()}";
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			if (rs != null) {
				while (rs.next()) {
					DropdownBean dropdownBean = new DropdownBean();
					dropdownBean.setCode(rs.getString("merchant_id"));
					dropdownBean.setName(rs.getString("MerchantName"));
					serviceProviders.add(dropdownBean);
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
		
		return serviceProviders;
	}

	public List<List<String>> getPlazaDetails() {
		// System.out.println("getPlazaDetails method");
		List<List<String>> plazaData = null;
		List<String> plazaList = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Connection con = null;
		//Session session = getSession();
		//Connection con = session.connection();
		
		try {
			con = new DBConnectionHandler().getConnection();
			String query = "{call pro_PlazaList()}";
			// System.out.println("calling Procedure");
			callableStatement = con.prepareCall(query);
			
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null) {
				plazaData = new ArrayList<List<String>>();
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					headerNames.add(rsmd.getColumnLabel(i));
				}
				plazaData.add(headerNames);
				while (rs.next()) {
					plazaList = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						plazaList.add(rs.getString(rsmd.getColumnLabel(i)));
					}
					plazaData.add(plazaList);
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
		
		return plazaData;
		
	}
	
	
	

	public List<String> getEditPlazaDetails(String id) {
		
			
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			Connection con = null;
			
			  List<String> editplaza = new ArrayList<String>();
			
			try {
				con = new DBConnectionHandler().getConnection();
				String query = "select t1.* , t2.* from toll_plaza_master t1 join address_master t2 on t1.toll_plaza_id = t2.entity_id where t1.id = "+id;
				System.out.println("While editing Id Tool Plaza ==  "+id);
				preparedStatement = con.prepareStatement(query);
				preparedStatement.execute();
				
				rs = preparedStatement.getResultSet();
				while (rs.next()) 
				{ 
					editplaza.add(rs.getString("id"));					
					editplaza.add(rs.getString("toll_plaza_id"));
					editplaza.add(rs.getString("merchant_id"));
					editplaza.add(rs.getString("toll_name"));
					editplaza.add(rs.getString("location"));
					editplaza.add(rs.getString("contact_person"));
					editplaza.add(rs.getString("email_id"));
					editplaza.add(rs.getString("contact_number"));
					editplaza.add(rs.getString("toll_geo_code"));
					editplaza.add(rs.getString("toll_plaza_type"));
					editplaza.add(rs.getString("settlement_type"));
					
					// Address Tabel
					editplaza.add(rs.getString("address1"));
					editplaza.add(rs.getString("address2"));
					editplaza.add(rs.getString("state"));
					editplaza.add(rs.getString("city"));
					editplaza.add(rs.getString("pin"));
					
					String settlementType = rs.getString("settlement_type");
					String tollPlazaId = rs.getString("toll_plaza_id");
					System.out.println("settlementType while fetching Data : "+settlementType);
					if(settlementType.equalsIgnoreCase("account"))
					{
						String query1 = "select t1.* , t2.* from toll_plaza_master t1 join account_master t2 on t1.toll_plaza_id = t2.merchant_id where t1.id= "+id;
						System.out.println("While editing getAccount Information Base on toll Plaza Id ==  "+tollPlazaId);
						preparedStatement = con.prepareStatement(query1);
						preparedStatement.execute();
						
						rs1 = preparedStatement.getResultSet();
						while (rs1.next()) 
						{ 
							editplaza.add(rs1.getString("bank_name"));
							editplaza.add(rs1.getString("account_number"));
							editplaza.add(rs1.getString("ifsc_code"));
							editplaza.add(rs1.getString("acc_type"));
						}
					}
					else
					{
						System.out.println("settlementType as  Merchant so didn't get Account Details");
					}
					
					
				}
				
			} catch (Exception e) {
				System.err.println("Error getting ServiceBankCategoryMapping :" + e);
			}
			finally{
				 try {
					if(rs != null) { rs.close(); rs=null; };
					 if(preparedStatement != null) preparedStatement.close();
					 if(con != null){ con.close(); con=null; }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return editplaza;
			
		}

	public String updatePlaza(Plaza plaza) {
		
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Connection con = null;
		String status = "-1";
		
		try {
			con = new DBConnectionHandler().getConnection();
			if(con != null)
			{
				con.setAutoCommit(false);
			String query = "{call pro_update_toll_plaza_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(query);
			 callableStatement.setString(1, plaza.getId());
			 callableStatement.setString(2, plaza.getToll_plaza_id());
			 
			 callableStatement.setString(3, plaza.getMerchant_id());
			 callableStatement.setString(4, plaza.getToll_name());
			 callableStatement.setString(5, plaza.getLocation());
			 callableStatement.setString(6, plaza.getContact_person());
			 callableStatement.setString(7, plaza.getEmailid());
			 callableStatement.setString(8, plaza.getContactNo());
			 callableStatement.setString(9, plaza.getGeoCode());
			 callableStatement.setString(10, plaza.getTollType());
			 callableStatement.setString(11, plaza.getSettlementType());
			 callableStatement.setString(12, plaza.getIsActive());
			// System.out.println("Settlement Type as a procedure argus " + plaza.getSettlementType() + " ID "+plaza.getId() );
			 // Address 
			 callableStatement.setString(13, plaza.getAdd1());
			 callableStatement.setString(14, plaza.getAdd2());
			 callableStatement.setString(15, plaza.getState());
			 callableStatement.setString(16, plaza.getCity());
			 callableStatement.setString(17, plaza.getPin());
			 
			 // Account Master
			 callableStatement.setString(18, plaza.getAcno());
			 callableStatement.setString(19, plaza.getIfsc());
			 callableStatement.setString(20, plaza.getBankName());
			 callableStatement.setString(21, plaza.getAcc_type());
			 
			
			callableStatement.executeUpdate();
			 con.commit();
			status = "1";
			
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
		
		return status;
	}

	public String deletePlazaDetails(String id) throws Exception {
		
		PreparedStatement preparedStatement = null;
	
		Connection con = null;

		String deleteSQL = "UPDATE toll_plaza_master SET is_active = '0' where id=?";

		try {
			con = new DBConnectionHandler().getConnection();
			preparedStatement = con.prepareStatement(deleteSQL);
			preparedStatement.setString(1, id);

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Plaza Details is deleted!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
		
		finally{
			 try {
				//if(rs != null) { rs.close(); rs=null; };
				 if(preparedStatement != null) preparedStatement.close();
				 if(con != null){ con.close(); con=null; }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "deletesuccess";
}
	}


