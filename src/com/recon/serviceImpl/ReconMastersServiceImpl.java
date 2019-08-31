package com.recon.serviceImpl;

import java.util.List;

import com.recon.dao.ReconMastersDao;
import com.recon.daoImpl.ReconMastersDaoImpl;
import com.recon.entities.DropdownBean;
import com.recon.entities.TblMstmenu;
import com.recon.entities.TblMstrole;
import com.recon.entities.TblMstuser;
import com.recon.service.ReconMastersService;

public class ReconMastersServiceImpl implements ReconMastersService
{
	public List<String> getColumnNames() {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getColumnNames();
	}

	public int createRole(String roleName, String menuId,
			String status, String createdBy) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.createRole(roleName, menuId, status, createdBy);
	}
	
	public int updateRole(String roleId, String roleName, String menuId,
			String status, String createdBy) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.updateRole(roleId, roleName, menuId, status, createdBy);
	}

	public int createUser(String userId, String fullName, String emailId, String contactNo,
			String roleId, String password, String adminName) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.createUser(userId, fullName, emailId, contactNo, roleId, password, adminName);
	}
	
	public int updateUser(String userId, String fullName, String emailId, String contactNo,
			String roleId, String password, String modifiedBy) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.updateUser(userId, fullName, emailId, contactNo, roleId, password, modifiedBy);
	}
	

	public int deleteRole(String roleId) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.deleteRole(roleId);
	}

	public int deleteUser(String userId) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.deleteUser(userId);
	}

	public List<TblMstmenu> getMenus() {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getMenus();
	}

	

	
	
	public List<List<String>> getUserList(String userId, String fullName, String emailId, String roleId) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getUserList(userId, fullName, emailId, roleId);
	}
	
	public List<List<String>> getRoleList() {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getRoleList();
	}
	
	public List<TblMstuser> getUserData(String propertyName, String value) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getUserData(propertyName, value);
	}
	
	public List<TblMstrole> getRoleData(String propertyName, String value) {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getRoleData(propertyName, value);
	}
	
	public List<TblMstrole> getRoles() {
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getRoles();
	}

	public List<TblMstuser> getSearchUserData(String propertyName, String value){  
		ReconMastersDao reconMastersDao = new ReconMastersDaoImpl();
		return reconMastersDao.getSearchUserData(propertyName, value);
		}
}
