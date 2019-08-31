package com.recon.entities;

/**
 * TblStateMaster entity. @author MyEclipse Persistence Tools
 */

public class TblStateMaster implements java.io.Serializable {

	// Fields

	private String stateCode;
	private String stateDesc;

	// Constructors

	/** default constructor */
	public TblStateMaster() {
	}

	/** full constructor */
	public TblStateMaster(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	// Property accessors

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateDesc() {
		return this.stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

}