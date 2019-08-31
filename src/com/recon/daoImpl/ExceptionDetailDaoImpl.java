package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;
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
		//Session session = new HibernateUtil().getSession();
		SessionImpl sessionImpl = null;
		Connection con = null;
		
		try 
		{
			sessionImpl = (SessionImpl) new HibernateUtil().getSession();
			
			con = sessionImpl.connection();
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
					con.commit();
					String parsedXml = new XMLParser().createFinalResponse(callableStatement.getString(6), "Response");
					resp = new JSONObject(parsedXml.toString());
					/*try
					{
						//con.commit();
						String parsedXml = new XMLParser().createFinalResponse(callableStatement.getString(6), "Response");
						resp = new JSONObject(parsedXml.toString());
					} 
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						resp = new JSONObject();
						resp.put("operation",operation);
						resp.put("status",-1);
						resp.put("resp_msg",e.getMessage());
					}*/
					
					/*resp.put("operation","ADD");
					resp.put("status",1);*/
				}
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			resp = new JSONObject();
			try 
			{
				resp.put("operation",operation);
				resp.put("status",-1);
				resp.put("resp_msg",e.getMessage());
			} 
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
				if (sessionImpl != null)
					sessionImpl.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally 
			{
				rs = null; callableStatement = null; con = null; sessionImpl = null;
			}
		}
		
		return resp;
	}
	
	public String getTagId(String tid,String vno)
	{
		String tagId = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//Session session = new HibernateUtil().getSession();
		SessionImpl sessionImpl = null;
		Connection con = null;
		String query = null;
		
		try 
		{
			sessionImpl = (SessionImpl) new HibernateUtil().getSession();
			
			con = sessionImpl.connection();
			
			if(con != null)
			{				
				if(tid != null && !tid.isEmpty() && !tid.equalsIgnoreCase("NA"))
				{	
					query = "select tag_id from vehicle_tag_linking where tid = ?";
					ps = con.prepareStatement(query);
					ps.setString(1, tid);
					rs = ps.executeQuery();
				}
				else if(vno != null && !vno.isEmpty() && !vno.equalsIgnoreCase("NA"))
				{
					query = "select tag_id from vehicle_tag_linking where vehicle_number = ?";
					ps = con.prepareStatement(query);
					ps.setString(1, vno);
					rs = ps.executeQuery();
				}		
				else
				{
					System.out.println("ExceptionDetailDaoImpl.java ::: getTagId() :: Invalid Input Received");
				}
				
				if(rs != null && rs.next())
				{
					tagId = rs.getString("tag_id");					
				}
				
				System.out.println("ExceptionDetailDaoImpl.java ::: getTagId() :: Query : '"+query+"' And Tag Id : '"+tagId+"'");
			}
		}
		catch (Exception e)
		{
			System.out.println("ExceptionDetailDaoImpl.java ::: getTagId() :: Error Occurred while fetching Tag Id : "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{	
				if (rs != null)
					rs.close();
				if (ps != null) 
					ps.close();
				if (con != null)
					con.close();
				if (sessionImpl != null)
					sessionImpl.close();
			}
			catch (SQLException e)
			{
				System.out.println("ExceptionDetailDaoImpl.java ::: getTagId() :: Error Occurred while Closing Connections : "+e.getMessage());
				e.printStackTrace();
			}
			finally 
			{
				rs = null; ps = null; con = null; sessionImpl = null;
			}
		}
		
		return tagId;
	}
}
