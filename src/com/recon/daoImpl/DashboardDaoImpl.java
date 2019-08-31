package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.recon.dao.DashboardDao;
import com.recon.utils.HibernateUtil;

public class DashboardDaoImpl extends HibernateUtil implements DashboardDao 
{	
	@SuppressWarnings("deprecation")
	public Map<String, Object> getDashBoardDetails(String userId) {
		
		//Map<String, Object> dashboardData = new HashMap<String, Object>();
		Map<String, Object> dashboardMap = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try 
		{
			System.out.println("INside the get Dashboard Detail");
			/*
			String query = "{call pro_DashBoardSummary(?)}";
			callableStatement = con.prepareCall(query);
			callableStatement.setString(1, userId);
			callableStatement.execute();
			rs = callableStatement.getResultSet();
			if (rs != null && rs.next())
			{
				dashboardMap = new HashMap<String, Object>();
				dashboardMap.put("yesTxnVal", rs.getString("yesTxnVal"));
				dashboardMap.put("yesTxnCnt", rs.getString("yesTxnCnt"));				
				dashboardMap.put("todTxnVal", rs.getString("todTxnVal"));
				dashboardMap.put("todTxnCnt", rs.getString("todTxnCnt"));
				dashboardMap.put("totalWallets", rs.getString("totalWallets"));
				dashboardMap.put("activeWallets", rs.getString("activeWallets"));
				dashboardMap.put("totalBalance", rs.getString("totalBalance"));
				//dashboardData.put("dashboardSummary",dashboardMap);
				
			}
     	*/} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			session.close();
			try
			{
				if (rs != null) rs.close();
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return dashboardMap;
	}
	
}
