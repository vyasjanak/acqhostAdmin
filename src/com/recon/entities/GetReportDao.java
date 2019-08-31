package com.recon.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.recon.utils.DBConnectionHandler;
import com.recon.utils.DateConverter;





public class GetReportDao {
	private HttpServletResponse response;
	
    public void setResponse(HttpServletResponse response) throws IOException {
        // response.sendRedirect("error.jsp");
        this.response = response; 
    }

	public List<List<String>> getData(String displayName,String fromDate,String toDate) throws IOException {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String Query = null;
		
		List<List<String>> users = null;
		try {
			con = new DBConnectionHandler().getConnection();
			// System.out.println("Display Name = "+displayName);
			if(con != null)
			{
			String query1 = "SELECT * FROM report_master WHERE Display_Name = '"+displayName+"'";
			System.out.println("Query 1 = "+query1);
			preparedStatement = con.prepareStatement(query1);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			
			if (rs.next())
		      {
		        Query = rs.getString("Query");		       
		        System.out.println("Query = " +Query);		        
		      }
			rs.close();
			preparedStatement.close();
			System.out.println(displayName);
			if(!displayName.equals("Transaction Report")){
				
				if(fromDate!=null && toDate!= null){
					Query = Query+" where created_on >='"+DateConverter.dateConvert(fromDate)+"'and created_on<='"+DateConverter.dateConvert(toDate)+"'";
				}
				else{
					Query = Query+";";
				}
				
			}
			else{
				if(fromDate!=null && toDate!= null){
					Query = Query+" where txn_posted_time >='"+DateConverter.dateConvert(fromDate)+"'and txn_posted_time<='"+DateConverter.dateConvert(toDate)+"'";
				}
				else{
					Query = Query+";";
				}
			}
			
			System.out.println(Query);
			if(Query != null)
			{
			preparedStatement = con.prepareStatement(Query);
			preparedStatement.execute();
			
			rs = preparedStatement.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null) 
			{
				users = new ArrayList<List<String>>();
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) 
				{
					headerNames.add(rsmd.getColumnLabel(i));
				}
				users.add(headerNames);
				
			while (rs.next()) 
			{
				
				List<String> usersData = new ArrayList<String>();
				/*usersData.add(rs.getString("cust_id"));
				usersData.add(rs.getString("reference_no")); 
				usersData.add(rs.getString("pg_reference_no")); */
				
				for(int i=1 ; i <= headerNames.size() ; i++)
				{
					usersData.add(rs.getString(i));
				}
				users.add(usersData);				
			}
			
			}
			}
			else
			{ 
				System.out.println("Query is null for Display Values");		
				/* setResponse(response);
				 response.sendRedirect("error.jsp");*/
				
			}
		}
			else
			{
				System.out.println("DB connection is null !!!");
			}
	} catch (Exception e) {
			System.err.println("error getting in GetReportDao  :  " + e);
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
		return users;

	   
}
}
