package com.recon.entities;

import java.sql.Timestamp;

/**
 * TblMstaddress entity. @author MyEclipse Persistence Tools
 */

public class TblAddressMaster implements java.io.Serializable {

	// Fields

	private Integer id;
	private String entity_id;
	private String address1;
	private String address2;
	private String state;
	private String city;
	private String pin;
	private Timestamp createdOn;
	private String createdBy;
	
	// private String stateId;
	// private String cityId;
	// private Timestamp modifiedOn;
	// private String modifiedBy;
	// private String isDeleted;

	// Property accessors


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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(String entity_id) {
		this.entity_id = entity_id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	

}