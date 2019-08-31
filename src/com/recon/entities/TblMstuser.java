package com.recon.entities;

import java.sql.Timestamp;

/**
 * TblMstuser entity. @author MyEclipse Persistence Tools
 */

public class TblMstuser implements java.io.Serializable {

	// Fields

	private String userid;
	/*private TblMstgroup tblMstgroup;
	private TblMstrole tblMstrole;*/
	private Integer role_id;
	private String fullName;
	private String password;
	private String isActive;
	private Timestamp lastLogin;
	private String lastLoginIp;
	private Timestamp createdOn;
	private String createdBy;
	private Timestamp modifiedOn;
	private String modifiedBy;
	private String isDeleted;
	private String emailId;
	private String contactNo;
	/*private String isFirstLogin;*/

	// Constructors

	/** default constructor */
	public TblMstuser() {
	}

	/** full constructor */
	public TblMstuser(TblMstrole tblMstrole,
			String fullName, String password, String isActive,
			Timestamp lastLogin, String lastLoginIp, Timestamp createdOn,
			String createdBy, Timestamp modifiedOn, String modifiedBy,
			String isDeleted, String emailId, String contactNo) {
		/*this.tblMstgroup = tblMstgroup;
		this.tblMstrole = tblMstrole;*/
		this.fullName = fullName;
		this.password = password;
		this.isActive = isActive;
		this.lastLogin = lastLogin;
		this.lastLoginIp = lastLoginIp;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.isDeleted = isDeleted;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	/*public TblMstgroup getTblMstgroup() {
		return this.tblMstgroup;
	}

	public void setTblMstgroup(TblMstgroup tblMstgroup) {
		this.tblMstgroup = tblMstgroup;
	}

	public TblMstrole getTblMstrole() {
		return this.tblMstrole;
	}

	public void setTblMstrole(TblMstrole tblMstrole) {
		this.tblMstrole = tblMstrole;
	}*/

	
	

	
	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	
	public String getFullName() {
		return this.fullName;
	}
	

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/*public String getIsFirstLogin() {
		return isFirstLogin;
	}

	public void setIsFirstLogin(String isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}
	*/
	

}