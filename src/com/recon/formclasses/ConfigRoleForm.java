package com.recon.formclasses;

import org.apache.struts.action.ActionForm;

public class ConfigRoleForm extends ActionForm {
	private String actionName;
	private String message;
	private String roleId;
	private String roleName;
	
	private String menuId;
	private String status;
	
	private String selectedMenus;
	private String selectedGroup;
	
	// un use but getting Error
	private String group;
	private String level;
	
	
	
	
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSelectedGroup() {
		return selectedGroup;
	}
	public void setSelectedGroup(String selectedGroup) {
		this.selectedGroup = selectedGroup;
	}
	public String getSelectedMenus() {
		return selectedMenus;
	}
	public void setSelectedMenus(String selectedMenus) {
		this.selectedMenus = selectedMenus;
	}
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
