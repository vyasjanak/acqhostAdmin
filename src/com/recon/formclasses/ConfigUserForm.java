package com.recon.formclasses;

import org.apache.struts.action.ActionForm;

public class ConfigUserForm extends ActionForm {
	private String actionName;
	private String message;
	private String userId;
	private String userName;
	private String contactNo;
	private String email;
	/*private String group;*/
	private String role;
	private String password;
	private String selectedGroup;
	private String selectedRole;
	/*private String sol_id;*/
	
	public String getSelectedGroup() {
		return selectedGroup;
	}
	public void setSelectedGroup(String selectedGroup) {
		this.selectedGroup = selectedGroup;
	}
	public String getSelectedRole() {
		return selectedRole;
	}
	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
