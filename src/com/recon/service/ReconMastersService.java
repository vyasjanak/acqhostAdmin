package com.recon.service;

import java.util.List;

import com.recon.entities.DropdownBean;
import com.recon.entities.TblMstmenu;
import com.recon.entities.TblMstrole;
import com.recon.entities.TblMstuser;

public interface ReconMastersService {
	public List<String> getColumnNames();
	
	public int createUser(String userId, String fullName, String emailId, String contactNo, String roleId, String password, String adminName);
	public int updateUser(String userId, String fullName, String emailId, String contactNo, String roleId, String password, String modifiedBy);
	public int deleteUser(String userId);
	public int createRole(String roleName , String menuId, String status, String createdBy);
	public int updateRole(String roleId, String roleName , String menuId, String status, String createdBy);
	public int deleteRole(String roleId);
	public List<TblMstmenu> getMenus();
	public List<List<String>> getUserList(String userId, String fullName, String emailId, String roleId);
	public List<List<String>> getRoleList();
	public List<TblMstuser> getUserData(String propertyName, String value);
	public List<TblMstrole> getRoleData(String propertyName, String value);
	public List<TblMstrole> getRoles();
	public List<TblMstuser> getSearchUserData(String propertyName, String value);   // bharat
}
