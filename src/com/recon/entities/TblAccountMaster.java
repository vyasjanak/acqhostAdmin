package com.recon.entities;

import java.sql.Timestamp;

/**
 * TblMerchantProduct entity. @author MyEclipse Persistence Tools
 */

public class TblAccountMaster implements java.io.Serializable {

	// Fields

	private Integer id;
	private String merchant_id;
	private String bank_name;
	private String account_number;	
	private String ifsc_code;
	private Timestamp created_on;
	private String created_by;
	private String acc_type;
	
	// Property accessors
	
	
	
	
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	
	public String getCreated_by() {
		return created_by;
	}
	
	public Timestamp getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	
	
	

}