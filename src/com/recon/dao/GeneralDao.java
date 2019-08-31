package com.recon.dao;

import java.util.List;

import com.recon.entities.DropdownBean;

public interface GeneralDao {
	public int sendMail(String to, String subject, String from, String bodyText);
	public void sendSMS(String sText, String mobile_no);
	public String crypt(String encrypt);
	public String decrypt(String encrypt);
	public List<DropdownBean> getMerchantIds();
	public int forgetPass(String mobileno);
}
