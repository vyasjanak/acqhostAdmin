package com.recon.servlets;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.json.JSONObject;

import com.recon.servlets.XMLParser;
import com.recon.utils.HibernateUtil;

public class ExceptionDetailDaoImpl 
{
	public JSONObject manageTagException(String tagid,String tid,String vno,String exce_type,String operation) 
	{
		JSONObject resp = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = new HibernateUtil().getSession();
		
		Connection con = null;
		
		try 
		{
			con = session.connection();
			if(con != null)
			{
				con.setAutoCommit(false);
				String query = "{call pr_add_excep(?,?,?,?,?,?)}";
				
				callableStatement = con.prepareCall(query);
				
				callableStatement.setString(1, tagid);
				callableStatement.setString(2, tid);
				callableStatement.setString(3, vno);
				callableStatement.setString(4, exce_type);
				callableStatement.setString(5, operation);
				callableStatement.registerOutParameter(6, Types.VARCHAR);
				
				callableStatement.execute();
				 
				if(operation.equalsIgnoreCase("SEARCH"))
				{
					rs = callableStatement.getResultSet();
					if(rs != null && rs.next())
					{
						resp = new JSONObject();
						resp.put("operation",operation);
						resp.put("resp_msg","Data Found.");
						resp.put("status",1);
						resp.put("id",rs.getString("id"));
						resp.put("tag_id",rs.getString("tag_id"));
						resp.put("exe_code",rs.getString("exe_code"));
						resp.put("msg_id",rs.getString("msg_id"));
						resp.put("npci_updated_date",rs.getString("npci_updated_date"));
					}
					else
					{
						resp = new JSONObject();
						resp.put("operation",operation);
						resp.put("status",2);
						resp.put("resp_msg","No Data Found for the Entered Tag Id/TID/Vehicle Number and Exception Code "+exce_type);
					}
				}
				else
				{
					try
					{
						con.commit();
						String parsedXml = new XMLParser().createFinalResponse(callableStatement.getString(6), "Response");
						resp = new JSONObject(parsedXml.toString());
					} 
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						resp.put("operation",operation);
						resp.put("status",-1);
						resp.put("resp_msg",e.getMessage());
					}
					
					/*resp.put("operation","ADD");
					resp.put("status",1);*/
				}
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			resp = new JSONObject();
			resp.put("operation",operation);
			resp.put("status",-1);
			resp.put("resp_msg",e.getMessage());
		}
		finally
		{
			try 
			{	
				if (rs != null)
					rs.close();
				if (callableStatement != null) 
					callableStatement.close();
				if (con != null) 
					con.close();
				if (session != null)
					session.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally 
			{
				rs = null; callableStatement = null; con = null; session = null;
			}
		}
		
		return resp;
	}
	

}
