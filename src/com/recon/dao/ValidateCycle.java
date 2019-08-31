package com.recon.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.recon.utils.DBConnectionHandler;

public class ValidateCycle {

	public static boolean validateCycle(String sDate,int rCycle) {
		boolean reconDone = false;
		Connection con = null;
		Statement stmt=null;
		ResultSet rs = null;
		int checkCycle=2;
		try
		{
			con = new DBConnectionHandler().getConnection();
			String checkDate = getpreviousDate(sDate);
			if(rCycle==2){
				checkCycle=1;
				checkDate=sDate;
				
			}
			String sql = "select * from npci_recon_status where on_date='"+checkDate+"' and cycle='"+checkCycle+"'";
			System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				reconDone=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try
			{  
				if (rs != null) 
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return reconDone;
		
	}
	
	public static String getpreviousDate(String sDate) throws Exception{
		 	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//("yyyy-MM-dd");

	        // Parse the given date string into a Date object.
	        // Note: This can throw a ParseException.
	        Date reconDate = dateFormat.parse(sDate);

	        // Use the Calendar class to subtract one day
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(reconDate);
	        calendar.add(Calendar.DAY_OF_YEAR, -1);

	        // Use the date formatter to produce a formatted date string
	        Date previousDate = calendar.getTime();
	        String result = dateFormat.format(previousDate);

	        return result;
	}
	
	public static boolean validateCBSCycle(String sDate,int rCycle) {
		boolean reconDone = false;
		Connection con = null;
		Statement stmt=null;
		ResultSet rs = null;
		int checkCycle=2;
		try
		{
			con = new DBConnectionHandler().getConnection();
			String checkDate = getpreviousDate(sDate);
			/*if(countDates()>2)
			{*/
				if(rCycle==2){
					checkCycle=1;
					checkDate=sDate;
				}
			/*}
			else //if(countDates()==0)
			{
				checkCycle=rCycle;
				checkDate=sDate;
			}*/
			String sql = "select * from cbs_recon_status where on_date='"+checkDate+"' and cycle='"+checkCycle+"'";
			System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				reconDone=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try
			{  
				if (rs != null) 
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return reconDone;
		
	}
	
	public static int countDates()
	{
		//String sql = "SELECT COUNT(*) CNT FROM npci_recon_status GROUP BY on_date where on_date = '"+on_date+"'";// HAVING CNT > 1";
		String sql = "SELECT on_date, COUNT(*) CNT FROM cbs_recon_status ";
		Connection con = null; 
		Statement stmt = null;
		ResultSet rs = null;
		int count=0;		
		try
		{
			con = new DBConnectionHandler().getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
				count = rs.getInt("CNT");
		}
		catch(Exception e){System.out.println("Error in count : "+e.getMessage());
		e.printStackTrace();
		}
		finally
		{ 
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
						con.close();	
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return count;
	}
		
	public static void main(String[] args) {
		System.out.println("count "+countDates());
	}
}
