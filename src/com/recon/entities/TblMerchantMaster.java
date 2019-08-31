package com.recon.entities;

import java.sql.Timestamp;
import java.util.Set;

public class TblMerchantMaster 
{
	private Integer id;
	private String is_deleted;
	private String merchant_id;
	private String merchant_name;
	
	private String contact_person;
	private String contact_number;
	private String email_id;
	private String activaction_key;
	private String created_by;
	private Timestamp created_on;
	private String approved_by;
	private Timestamp approved_on;
	// private String isDeleted;
	
	
	
	public Integer getId() {
		return id;
	}
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Timestamp getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getActivaction_key() {
		return activaction_key;
	}
	public void setActivaction_key(String activaction_key) {
		this.activaction_key = activaction_key;
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
