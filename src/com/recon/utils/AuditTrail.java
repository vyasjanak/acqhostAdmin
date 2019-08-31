package com.recon.utils;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AuditTrail {


	public boolean addAuditData(Connection con,String userId,String entityId,String moduleId, String actionDesc,Map<String,String> userData)
	{

		Statement stmt = null;
		
		try
		{
			String data="<UserData>";
			
			for (Map.Entry entry : userData.entrySet()) {
			    System.out.println(entry.getKey() + " = " + entry.getValue());
			    data=data+"<"+entry.getKey()+">"+entry.getValue()+"</"+entry.getKey()+">";
			}
			
			/*for(int i=0;i<userData.size();i++){
				System.out.println("DATA >>>>" +data);
				data=data+"<Value"+i+">"+userData.get(i).+"</Value>"+i+">";
			}*/
			 data=data+"</UserData>";
			String sql = "insert into audit_trail (user_id,module_id,action_desc,date_time,entity_id,user_data) "
					+ "values('"+userId+"','"+moduleId+"','"+actionDesc+"',now(),'"+entityId+"','"+data+"');";
			System.out.println("sql :::: "+sql);
			if (con != null) {

				stmt = con.createStatement();
				stmt.executeUpdate(sql);

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

			try
			{
				if (stmt != null)

					if (con != null)
						con.close();
			}
			catch (Exception localSQLException7) {
			}
		}
		return true;

	}

}
