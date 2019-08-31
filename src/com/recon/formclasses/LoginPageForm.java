/** @(#)UserPageForm.java
 * Version : 1.0
 * Date: 2 April 2008
 *
 * Copyright (c) 2007-2012 Mann-India Technologies Pvt. Ltd.
 * B-267 A, First Floor, GK-I New Delhi-110048, India
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Mann-India Technologies Pvt. Ltd.("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you
 * entered into with Mann-India Technologies Pvt. Ltd.
 * 
 * @author Ashish Jaiswal
 * 
 */
 
/* 
   Project : Corporate Intranet
   Module  : Administration
   Program : UserPageForm.java
   Description : User Sign Up Information
 
 
   REVISION HISTORY
 
    S.No.  : 
    Author  : 
    Version              : 1.0
    Date of Revision     : 
    Defect Id            :
    Revision Details     : Initial Release
*/

package com.recon.formclasses;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class LoginPageForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private String username;
	private String password;
	private String actionName;
	private String loginStatus;
	private String message;
	
	private String merchantId;
	private String merchantName;
	private String businessName;
	private String businessCategory;
	private String contactPerson;
	private String contactNumber;
	private String emailId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String pin;
	private String emailForgotPass;
	
	
	
	public String getEmailForgotPass() {
		return emailForgotPass;
	}
	public void setEmailForgotPass(String emailForgotPass) {
		this.emailForgotPass = emailForgotPass;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
    public void resetLoginForm(ActionMapping mapping, HttpServletRequest request) {
    	this.actionName = null;
        setActionName(null);
        super.reset(mapping, request);
    }
}
