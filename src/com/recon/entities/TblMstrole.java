package com.recon.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TblMstrole entity. @author MyEclipse Persistence Tools
 */

public class TblMstrole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rolename;
	/*private String level;*/
	private String menuId;
	private String status;
	/*private Integer groupId;*/
	private Timestamp createdOn;
	private String createdBy;
	private Timestamp modifiedOn;
	private String modifiedBy;
	private String isDeleted;
	private String approved_by;
	private Timestamp approved_on;
	
	/*private Set tblMstusers = new HashSet(0);*/

	// Constructors

	/** default constructor */
	public TblMstrole() {
	}

	/** full constructor */
	public TblMstrole(String rolename, String menuId,
			String status, Timestamp createdOn,
			String createdBy, Timestamp modifiedOn, String modifiedBy,
			String isDeleted) {     /*Set tblMstusers*/
		this.rolename = rolename;
		
		this.menuId = menuId;
		this.status = status;
		
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.isDeleted = isDeleted;
		/*this.tblMstusers = tblMstusers;*/
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getApproved_by() {
		return approved_by;
	}

	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	public Timestamp getApproved_on() {
		return approved_on;
	}

	public void setApproved_on(Timestamp approved_on) {
		this.approved_on = approved_on;
	}

	

}