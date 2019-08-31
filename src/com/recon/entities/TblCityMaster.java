package com.recon.entities;

/**
 * TblCityMaster entity. @author MyEclipse Persistence Tools
 */

public class TblCityMaster implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String stateCode;
	private String cityDesc;

	// Constructors

	/** default constructor */
	public TblCityMaster() {
	}

	/** full constructor */
	public TblCityMaster(String stateCode, String cityDesc) {
		this.stateCode = stateCode;
		this.cityDesc = cityDesc;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCityDesc() {
		return this.cityDesc;
	}

	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}

}