package com.recon.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnectionHandler {
	
	public static Connection getConnection()
	{
		Connection conn = null;
		DataSource ds = null;
		try
		{
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/getDB1");
			if (ds != null)
				conn = ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	
	/*	
	    public static Connection getConnection()
		{		
				Connection conn = null;
				try
				{
					 Class.forName("com.mysql.jdbc.Driver");
					 String connectionUrl = "jdbc:mysql://localhost:3306/acqhost";	//data1";//netcdata1
					 // String connectionUrl = "jdbc:mysql://192.168.1.99:3306/acqhost";
					 
					 String dbUser = "root";
					 String dbPwd = "root";
					 conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
				}catch (Exception e) {
					e.printStackTrace();
				}
				return conn;		
		}
	*/
	
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.DAYS);
	}
}
