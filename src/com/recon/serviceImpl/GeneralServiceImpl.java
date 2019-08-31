package com.recon.serviceImpl;

import java.util.List;

import com.recon.dao.GeneralDao;
import com.recon.daoImpl.GeneralDaoImpl;
import com.recon.entities.DropdownBean;
import com.recon.service.GeneralService;
import com.recon.utils.HibernateUtil;

public class GeneralServiceImpl extends HibernateUtil implements GeneralService {
	public int sendMail(String to, String subject, String from, String bodyText) {
		GeneralDao generalDao = new GeneralDaoImpl();
		return generalDao.sendMail(to, subject, from, bodyText);
	}
	
	public void sendSMS(String sText, String mobile_no)
	{
		GeneralDao generalDao = new GeneralDaoImpl();
		generalDao.sendSMS(sText,mobile_no);
	}
	
	public String crypt(String encrypt) {
		GeneralDao generalDao = new GeneralDaoImpl();
		return generalDao.crypt(encrypt);
	}
	public String decrypt(String encrypt) {
		GeneralDao generalDao = new GeneralDaoImpl();
		return generalDao.decrypt(encrypt);
	}
	public int forgetPass(String mobileno){
		GeneralDao generalDao = new GeneralDaoImpl();
		return generalDao.forgetPass(mobileno);
	}
	/* @Override
	public int sendMail(String to, String subject, String from, String bodyText) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void sendSMS(String sText, String mobile_no) {
		// TODO Auto-generated method stub
		
	}*/
}
