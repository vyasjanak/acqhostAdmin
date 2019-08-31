package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.recon.dao.ReconMastersDao;
import com.recon.entities.TblMstmenu;
import com.recon.entities.TblMstrole;
import com.recon.entities.TblMstuser;
import com.recon.service.GeneralService;
import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.utils.HibernateUtil;

public class ReconMastersDaoImpl extends HibernateUtil implements ReconMastersDao {

	
	public List<String> getColumnNames() {
		List<String> columnNames = null;
		Session session = getSession();
		try {
			String queryString =  null;
			SQLQuery queryObject = null;
			
			queryString = "select Column_Name from information_schema.columns where  table_name='tbl_tmprecon' and table_schema='prod30oct' and column_name not in ('id','FileId','IsException','Exception','Counter')";
			queryObject = session.createSQLQuery(queryString);
			
			
			columnNames = queryObject.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return columnNames;
	}

	public int createRole(String roleName, String menuId,
			String inStatus, String createdBy) {
		int status = -1;
		CallableStatement callableStatement = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try
		{
			if(con != null)
			{
				con.setAutoCommit(false);
				String query = "{call pro_InsertRole(?,?,?,?)}";
				callableStatement = con.prepareCall(query);
				callableStatement.setString(1, roleName);
				callableStatement.setString(2, menuId);
				callableStatement.setString(3, inStatus);
				callableStatement.setString(4, createdBy);
				
				callableStatement.executeUpdate();
				con.commit(); 
				status = 0;
			}
			System.out.println("status---->"+status);
		} catch (Exception e) {
			e.printStackTrace();
			status = -1;
		} finally {
			session.close();
			try {
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				status = -1;
			}
		}
		
		return status;
	}

	public int createUser(String userId, String fullName,String emailId, String contactNo, 
			String roleId, String password, String adminName) {
		int status = -1;
		CallableStatement callableStatement = null;
		//PreparedStatement ps = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try 
		{
			if(con != null)
			{
				con.setAutoCommit(false);
				String query = "{call pro_insertUser(?,?,?,?,?,?,?)}";
				callableStatement = con.prepareCall(query);
				callableStatement.setString(1, userId);
				callableStatement.setString(2, fullName);
				callableStatement.setString(3, emailId);
				callableStatement.setString(4, contactNo);
				callableStatement.setInt(5, Integer.parseInt(roleId));
				callableStatement.setString(6, password);
				callableStatement.setString(7, adminName);
				/*callableStatement.setString(8, solId);*/
				
				callableStatement.executeUpdate();
				con.commit();
				rs = callableStatement.getResultSet();
				if (rs != null && rs.next())
				{
					status = Integer.parseInt(rs.getString("Ret"));					
				}
			}			
			System.out.println("status ---> "+status);
			/*if(status == 0)
			{
				GeneralService generalService = new GeneralServiceImpl();
				
				String bodyText = "Dear "+ fullName+",<br>";
		    	  bodyText += "<br><b>Greetings from 1Pay!!!!!</b><br>";
		    	  bodyText += "<br>Your Wallet Admin Account has been created successfully.<br>";
		    	  bodyText += "<br>Your User Id is <b>"+userId+"</b>.<br>";
		    	  bodyText += "<br>Your Account's Login details are as follows: <br>";
		    	  bodyText += "<br><b>User/Login Id   	: </b>"+userId+"</i><br>";
		    	  bodyText += "<br><b>Login Password 	: </b>"+generalService.decrypt(password)+"</i><br>";			    	  
		    	  bodyText += "<br><a href = http://1Pay.tech/WalletAdmin/login_signin.jsp>Click here</a> to Login to your 1Pay portal.<br>";			   			    
		    	  bodyText += "<br>If you have any questions, please contact us on <font color='red'>noreply_pgsupport@1pay.in</font>.<br>";
		    	  bodyText += "<br><br><br><br><br><b>Best Regards,</b>";
		    	  bodyText += "<br>Team 1Pay";
		    	  bodyText += "<br><a href = www.1pay.in>www.1pay.in</a><br>";
				status = generalService.sendMail(emailId+",suraj.ambavale@1pay.in","Wallet Admin User Created Successfully - "+userId, "noreply_pgsupport@1pay.in", bodyText);
			}*/
		}
		catch (Exception e)
		{
			System.out.println("ReconMastersDaoImpl ::: createUser() :: Exception while Creating User --> "+e.getMessage());
			status = -1;
		}
		finally 
		{
			session.close();
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (callableStatement != null)
				{
					callableStatement.close();
					callableStatement = null;
				}
				/*if (ps != null)
				{
					ps.close();
					ps = null;
				}*/
				if (con != null)
				{
					con.close();
					con = null;
				}
			}
			catch (SQLException e)
			{
				System.out.println("ReconMastersDaoImpl ::: createUser() :: Exception while Closing Connection/Seesion --> "+e.getMessage());
			}
		}
		
		return status;
	}
	
	
	public List<List<String>> getUserListByDefault() {
		
		List<List<String>> userData = null;
		List<String> userList = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_GetUserListByDefault()}";
			
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null) {
				userData = new ArrayList<List<String>>();
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					headerNames.add(rsmd.getColumnLabel(i));
					
				}
				userData.add(headerNames);
				while (rs.next()) {
					userList = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						userList.add(rs.getString(rsmd.getColumnLabel(i)));
						
					}
					userData.add(userList);
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
		
		return userData;
	}

	public int deleteRole(String roleId) {
		int status = -1;
		CallableStatement callableStatement = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try 
		{
			if(con != null)
			{
				con.setAutoCommit(false);
				String query = "{call pro_DeleteRole(?)}";
				callableStatement = con.prepareCall(query);
				callableStatement.setInt(1, Integer.parseInt(roleId));
				
				callableStatement.executeUpdate();
				con.commit();  
				status = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = -1;
		} finally {
			session.close();
			try {
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				status = -1;
			}
		}
		
		return status;
	}

	public int deleteUser(String userId) {
		int status = -1;
		CallableStatement callableStatement = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try
		{
			if(con != null)
			{
				con.setAutoCommit(false);
				String query = "{call pro_DeleteUser(?)}";
				System.out.println("query =  "+query);
				callableStatement = con.prepareCall(query);
				callableStatement.setString(1, userId);
				
				callableStatement.executeUpdate();
				con.commit(); 
				status = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = -1;
		} finally {
			session.close();
			try {
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				status = -1;
			}
		}
		
		return status;
	}

	public List<TblMstmenu> getMenus() {
		List<TblMstmenu> menuData = new ArrayList<TblMstmenu>();
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_GetMenu()}";
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			if (rs != null) {
				while (rs.next()) {
					TblMstmenu tblMstmenu = new TblMstmenu();
					tblMstmenu.setMenuId(Integer.parseInt(rs.getString("MenuId")));
					tblMstmenu.setMenuName(rs.getString("MenuName"));
					menuData.add(tblMstmenu);
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
		
		return menuData;
	}

	public int updateRole(String roleId, String roleName, String menuId,
			String inStatus, String createdBy) {
		int status = -1;
		CallableStatement callableStatement = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try
		{
			if(con != null)
			{
				con.setAutoCommit(false);
				String query = "{call pro_UpdateRole(?,?,?,?,?)}";
				callableStatement = con.prepareCall(query);
				callableStatement.setInt(1, Integer.parseInt(roleId));
				callableStatement.setString(2, roleName);
				/*callableStatement.setInt(3, 0);*/
				callableStatement.setString(3, menuId);
				callableStatement.setString(4, inStatus);
				callableStatement.setString(5, createdBy);
				
				callableStatement.executeUpdate();			
				con.commit(); 
				status = 0;
			}
			System.out.println("status---->"+status);
		} catch (Exception e) {
			e.printStackTrace();
			status = -1;
		} finally {
			session.close();
			try {
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				status = -1;
			}
		}
		
		return status;
	}

	public int updateUser(String userId, String fullName, String emailId, String contactNo,
			String roleId, String password, String modifiedBy) {
		int status = -1;
		CallableStatement callableStatement = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try
		{
			if(con != null)
			{
				con.setAutoCommit(false);
				String query = "{call pro_UpdateUser(?,?,?,?,?,?,?)}";
				callableStatement = con.prepareCall(query);
				callableStatement.setString(1, userId);
				callableStatement.setString(2, fullName);
				callableStatement.setString(3, emailId);
				callableStatement.setString(4, contactNo);				
				callableStatement.setInt(5, Integer.parseInt(roleId));
				callableStatement.setString(6, password);
				callableStatement.setString(7, modifiedBy);
				
				
				callableStatement.executeUpdate();
				con.commit(); 
				status = 0;
			}
			System.out.println("status---->"+status);
		} catch (Exception e) {
			e.printStackTrace();
			status = -1;
		} finally {
			session.close();
			try {
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				status = -1;
			}
		}
		
		return status;
	}
	
	public List<List<String>> getUserList(String userId, String fullName, String emailId, String roleId) {
		List<List<String>> userData = null;
		List<String> userList = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try
		{
			
			String query = "{call pro_GetUserList(?,?,?,?)}";
			callableStatement = con.prepareCall(query);
			/*callableStatement.setString(1, solId);*/
			callableStatement.setString(1, userId);
			callableStatement.setString(2, fullName);
			callableStatement.setString(3, emailId);
			callableStatement.setString(4, roleId);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null) {
				userData = new ArrayList<List<String>>();
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					headerNames.add(rsmd.getColumnLabel(i));
				}
				userData.add(headerNames);
				while (rs.next()) {
					userList = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						userList.add(rs.getString(rsmd.getColumnLabel(i)));
					}
					userData.add(userList);
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
		
		return userData;
	}
	public List<List<String>> getRoleList() {
		List<List<String>> roleData = null;
		List<String> roleList = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_GetRoleList()}";
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null) {
				roleData = new ArrayList<List<String>>();
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					headerNames.add(rsmd.getColumnLabel(i));
				}
				roleData.add(headerNames);
				while (rs.next()) {
					roleList = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						roleList.add(rs.getString(rsmd.getColumnLabel(i)));
					}
					roleData.add(roleList);
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
		
		return roleData;
	}
	
	@SuppressWarnings("unchecked")
	public List<TblMstuser> getUserData(String propertyName, String value) {
		
		Session session = getSession();
		List<TblMstuser> userData = null;
		try {
			
			String queryString =  null;
			Query queryObject = null;
			if (propertyName != null) {
				queryString = "from TblMstuser as model where model."
					+ propertyName + "= ? and model.isDeleted = ?";
				queryObject = session.createQuery(queryString);
				queryObject.setParameter(0, value);
				queryObject.setParameter(1, "N");
			} else {
				queryString = "from TblMstuser as model where model.isDeleted = 'N'";
				queryObject = session.createQuery(queryString);
			}
			
			userData = queryObject.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return userData;
	}
	
	@SuppressWarnings("unchecked")
	public List<TblMstrole> getRoleData(String propertyName, String value) {
		Session session = getSession();
		List<TblMstrole> roleData = new ArrayList<TblMstrole>();
		try {
			Integer roleId = Integer.parseInt(value);
			TblMstrole tblMstrole = (TblMstrole)session.get(TblMstrole.class, roleId);
			roleData.add(tblMstrole);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return roleData;
	}
	
	@SuppressWarnings("unchecked")
	public List<TblMstrole> getRoles() {
		
		Session session = getSession();
		List<TblMstrole> roleList = null;
		try {
			
			String queryString =  null;
			Query queryObject = null;
			
			queryString = "from TblMstrole as model where model.isDeleted = 'N'";
			queryObject = session.createQuery(queryString);
			
			
			roleList = queryObject.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return roleList;
	}
	
	public List<TblMstuser> getSearchUserData(String propertyName, String value) {
		
		Session session = getSession();
		List<TblMstuser> userData = null;
		try {
			
			String queryString =  null;
			Query queryObject = null;
			
			if (propertyName != null && propertyName.equals("userid")) 
			{				
				
				
				queryString = "from TblMstuser as model where model."
					+ propertyName + " = ? and model.isDeleted = ? order by date(model.createdOn) desc";
				
				queryObject = session.createQuery(queryString);
				System.out.println("Value to Set : "+value);
				queryObject.setParameter(0, value);				
				queryObject.setParameter(1, "N");	
				
			} 
			
			else if (propertyName != null && propertyName.equals("fullName")) 
			{				
				System.out.println("PropertyName  "+propertyName);
				queryString = "from TblMstuser as model where model."
					+ propertyName + " = ? and model.isDeleted = ? order by date(model.createdOn) desc";
				
				queryObject = session.createQuery(queryString);
				System.out.println("Value to Set : "+value);
				queryObject.setParameter(0, value);				
				queryObject.setParameter(1, "N");	
				
			} 
			
			
			userData = queryObject.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return userData;
	}
}
