package com.recon.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.recon.dao.MenuDao;
import com.recon.utils.HibernateUtil;

public class MenuDaoImpl extends HibernateUtil implements MenuDao {
	
	@SuppressWarnings("deprecation")
	public Map<String, List<String>>  getMenuByRole(Integer  roleId) {
		System.out.println("Inside method for get menu Detail Role ID = "+roleId);
		
		Session session = getSession();
		
		String queryString =  null;
		List result = null;
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		Map<String, List<String>> menuMap = new HashMap<String, List<String>>();
		try {
			
			/*queryString = "SELECT T1.MenuId ParentMenuId,T1.MenuName ParentMenuName,T2.* FROM " +
			"tbl_mstmenu T1 inner join tbl_mstmenu T2 on T1.menuId=T2.pmenuId " +
			"WHERE T2.IsActive=1 and T2.Is_Deleted='N' and FIND_IN_SET(T2.menuid, (select menuid from tbl_mstrole where roleid="+roleId+"));";
			*/
			
			queryString = "select T1.menu_id ParentMenuId, T1.menu_name ParentMenuName,T2.menu_name MenuName , T2.menu_link MenuLink,T2.* from menu_master T1 inner join menu_master T2 on T1.menu_id = T2.parent_menu_id where T2.is_deleted='N' and find_in_set(T2.menu_id,(select menu_id from role_master where role_id = "+roleId+"));";
					
			try{
				connection = session.connection();
				statement = connection.createStatement();
				
				 
	            rs = statement.executeQuery(queryString);
	            while ( rs.next() ) {
	            	String action = rs.getString("T2.MenuLink");
        			if (action == null || action.length() == 0){
        				action  = "javascript:void(0)";
        			}
	            	if (menuMap.get(rs.getString("ParentMenuName")) == null) {
	            		List<String> submenus = new ArrayList<String>();
	            		submenus.add(rs.getString("T2.MenuName")+"##"+action);
	            		menuMap.put(rs.getString("ParentMenuName"), submenus);
	            	} else {
	            		List<String> submenus = menuMap.get(rs.getString("ParentMenuName"));
	            		if (submenus !=  null && submenus.size() > 0) {
	            			submenus.add(rs.getString("T2.MenuName")+"##"+action);
	            		} else {
	            			submenus = new ArrayList<String>();
	            			submenus.add(rs.getString("T2.MenuName")+"##"+action);
	            		}
	            		menuMap.put(rs.getString("ParentMenuName"), submenus);
	            	}
	            	
	                //String parentMenuId = rs.getString("ParentMenuId");
	                //System.out.println(parentMenuId+"--"+rs.getString("ParentMenuName")+"--"+rs.getString("T2.MenuId")+"--"+rs.getString("T2.MenuName"));
	            }	
	            
	            System.out.println(menuMap);
			}catch (Exception e){}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
			try {
				if (rs != null) rs.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return menuMap;
	}
	
	public static void main(String args[]) {
		new MenuDaoImpl().getMenuByRole(1);
	}
}
