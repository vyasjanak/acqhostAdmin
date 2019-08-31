package com.recon.service;

import com.recon.utils.HibernateUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.Session;

public class IdService extends HibernateUtil{
	
	
	public String createMerchantId() 
	{
		String merchantId = null;
		
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_createMerchantId()}";
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
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
		
		System.out.println("Merchant ID for acqhost from procedure : "+merchantId);
		return merchantId;
	}
	
	
	public String createPlaza_userId() 
	{
		String plazaUserId = null;
		
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_createPlazaId()}";
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			if (rs != null && rs.next()) {
				plazaUserId = rs.getString(1);
			//	System.out.println("Plaza USer ID in Procedure :: "+plazaUserId);
				
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
		
		// System.out.println("Plaza User ID for acqhost from procedure : "+plazaUserId);
		return plazaUserId;
	}
	

}
