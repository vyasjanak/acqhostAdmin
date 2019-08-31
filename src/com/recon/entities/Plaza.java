package com.recon.entities;

import java.io.Serializable;

public class Plaza implements Serializable {
 private String id;	
 private String toll_plaza_id;
 private String merchant_id;
 private String toll_name;
 private String location;
 private String contact_person;
 private String emailid;
 private String contactNo;
 private String geoCode;
 private String tollType;
 private String isActive;
 private String settlementType;
 private String createdBy;
 private String createdOn;
 private String approvedOn;
 private String approvedBy;
 private String plazaid;
 private String acno;
 private String ifsc;
 private String bankName;
 private String acc_type;
 private String add1;
 private String add2;
 private String state;
 private String city;
 private String pin;
 
	public Plaza(){
 		
 	}
 
 	public Plaza(String id,String toll_plaza_id, String merchant_id, String toll_name, String location, String contact_person,
		String emailid, String contactNo, String geoCode, String tollType, String isActive, String settlementType,String createdBy,
		String createdOn, String approvedOn, String approvedBy, String plazaid, String acno, String ifsc,
		String bankName, String acc_type,String add1, String add2, String state, String city, String pin) {
	//super();
 	// this.id = id;	
	this.toll_plaza_id = toll_plaza_id;
	this.merchant_id = merchant_id;
	this.toll_name = toll_name;
	this.location = location;
	this.contact_person = contact_person;
	this.emailid = emailid;
	this.contactNo = contactNo;
	this.geoCode = geoCode;
	this.tollType = tollType;
	this.isActive = isActive;
	this.settlementType= settlementType;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.approvedOn = approvedOn;
	this.approvedBy = approvedBy;
	this.plazaid = plazaid;
	this.acno = acno;
	this.ifsc = ifsc;
	this.bankName = bankName;
	this.acc_type = acc_type;
	this.add1 = add1;
	this.add2 = add2;
	this.state = state;
	this.city = city;
	this.pin = pin;
}


 
	

 	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

public String getToll_plaza_id() {
	return toll_plaza_id;
}

public void setToll_plaza_id(String toll_plaza_id) {
	this.toll_plaza_id = toll_plaza_id;
}

public String getMerchant_id() {
	return merchant_id;
}

public void setMerchant_id(String merchant_id) {
	this.merchant_id = merchant_id;
}

public String getToll_name() {
	return toll_name;
}

public void setToll_name(String toll_name) {
	this.toll_name = toll_name;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getContact_person() {
	return contact_person;
}

public void setContact_person(String contact_person) {
	this.contact_person = contact_person;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public String getGeoCode() {
	return geoCode;
}

public void setGeoCode(String geoCode) {
	this.geoCode = geoCode;
}

public String getTollType() {
	return tollType;
}

public void setTollType(String tollType) {
	this.tollType = tollType;
}

public String getIsActive() {
	return isActive;
}

public void setIsActive(String isActive) {
	this.isActive = isActive;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getApprovedOn() {
	return approvedOn;
}

public void setApprovedOn(String approvedOn) {
	this.approvedOn = approvedOn;
}

public String getApprovedBy() {
	return approvedBy;
}

public void setApprovedBy(String approvedBy) {
	this.approvedBy = approvedBy;
}

public String getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(String createdOn) {
	this.createdOn = createdOn;
}

public String getPlazaid() {
	return plazaid;
}

public void setPlazaid(String plazaid) {
	this.plazaid = plazaid;
}

public String getAcno() {
	return acno;
}

public void setAcno(String acno) {
	this.acno = acno;
}

public String getIfsc() {
	return ifsc;
}

public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}

public String getBankName() {
	return bankName;
}

public void setBankName(String bankName) {
	this.bankName = bankName;
}

public String getAdd1() {
	return add1;
}

public void setAdd1(String add1) {
	this.add1 = add1;
}

public String getAdd2() {
	return add2;
}

public void setAdd2(String add2) {
	this.add2 = add2;
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
