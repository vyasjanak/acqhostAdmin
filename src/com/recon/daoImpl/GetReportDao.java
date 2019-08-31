package com.recon.daoImpl;

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

	public List<List<String>> getData(String rep, String toDate,String fromDate) throws IOException {
		// System.out.println("ID :: "+rep+"  fromDate  ::  "+fromDate+"  toDate  ::: "+toDate);
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String Query = null;
		String DisplayNameValue = null;
		List<String> DisplayName = new ArrayList<String>();
		
		String filter=null;
		String date_colName=null;  // for 'from' to 'to' date 
		
		List<List<String>> users = null;
		try {
			con = new DBConnectionHandler().getConnection();
			if(con != null)
			{
			String query1 = "SELECT * FROM report_master WHERE id = '"+rep+"'";
			System.out.println("Query 1 = "+query1);
			preparedStatement = con.prepareStatement(query1);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			
			if (rs.next())
		      {
				DisplayNameValue = rs.getString("Display_Name");
		        Query = rs.getString("Query");
		        filter = rs.getString("Filter");
				date_colName = rs.getString("Filter1");
		       
		        System.out.println("Display Name Value ::: "+DisplayNameValue +"          Query = " +Query);
		        DisplayName.add(DisplayNameValue);
		       
		      }
			rs.close();
			preparedStatement.close();
			
			if(fromDate!=null && toDate!= null){
				fromDate=fromDate+" 00:00:00";
				toDate=toDate+" 23:59:59";
				
				Query = Query+" WHERE "+date_colName+" BETWEEN '"+fromDate+"' and '"+toDate+"'";
			}
			else{
				Query = Query+";";
			}
			System.out.println("");
			System.out.println("Excute Query  :::: "+Query);
			System.out.println("");
			
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
				
				users.add(DisplayName);   // index is 0
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) 
				{
					headerNames.add(rsmd.getColumnLabel(i));  
				}
				users.add(headerNames);  // index is 1
				
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
				System.out.println("Query is null for ID Values");		
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
