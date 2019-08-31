package com.recon.entities;

import java.sql.Timestamp;

/**
 * TblMstmenu entity. @author MyEclipse Persistence Tools
 */

public class TblMstmenu implements java.io.Serializable {

	// Fields

	private Integer menuId;
	private String menuName;
	private String menuLink;
	private Integer pmenuId;
	/*private Integer isActive;
	private Integer position;*/
	private Timestamp createdOn;
	private String createdBy;
	private Timestamp modifiedOn;
	private String modifiedBy;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public TblMstmenu() {
	}

	/** full constructor */
	public TblMstmenu(String menuName, String menuLink, Integer pmenuId,
			  Timestamp createdOn,
			String createdBy, Timestamp modifiedOn, String modifiedBy,
			String isDeleted) {
		this.menuName = menuName;
		this.menuLink = menuLink;
		this.pmenuId = pmenuId;
		
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuLink() {
		return this.menuLink;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	public Integer getPmenuId() {
		return this.pmenuId;
	}

	public void setPmenuId(Integer pmenuId) {
		this.pmenuId = pmenuId;
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

}