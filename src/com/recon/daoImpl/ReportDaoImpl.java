package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.recon.dao.ReportDao;
import com.recon.utils.HibernateUtil;

public class ReportDaoImpl extends HibernateUtil implements ReportDao
{
	public List<List<String>> getReportData(String repType, String fromDate, String toDate, String mobileNo, String walletId, String solId)
	{
		List<List<String>> reportData = null;
		List<String> reportList = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		try 
		{
			if (con != null)
			{
				String query = "{call pro_getReportData(?,?,?,?,?,?)}";
				callableStatement = con.prepareCall(query);
				callableStatement.setInt(1, Integer.parseInt(repType));
				//callableStatement.setString(2, userId);
				callableStatement.setString(2, fromDate);
				callableStatement.setString(3, toDate);
				callableStatement.setString(4, mobileNo);
				callableStatement.setString(5, walletId);
				callableStatement.setString(6, solId);
				callableStatement.execute();
				rs = callableStatement.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				if (rs != null) {
					reportData = new ArrayList<List<String>>();
					List<String> headerNames = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						headerNames.add(rsmd.getColumnLabel(i));
					}
					reportData.add(headerNames);
					while (rs.next()) {
						reportList = new ArrayList<String>();
						for (int i = 1; i <= columnCount; i++) {
							reportList.add(rs.getString(rsmd.getColumnLabel(i)));
						}
						reportData.add(reportList);
					}
				} 
			}
		}
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
		return reportData;
	}
	
	public Map<String, String> viewData(String id) {
		Map<String, String> reportData = null;
		
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_TransactionDetails(?)}";
			callableStatement = con.prepareCall(query);
			callableStatement.setInt(1, Integer.parseInt(id));
			callableStatement.execute();
			
			
			 
			rs = callableStatement.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null && rs.next())
			{
				reportData = new HashMap<String, String>();
				for (int i = 1; i <= columnCount; i++)
				{
					reportData.put(rsmd.getColumnLabel(i),rs.getString(rsmd.getColumnLabel(i)));
				}
			}
		}
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
		
		return reportData;
	}
}
