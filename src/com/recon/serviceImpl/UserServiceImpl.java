package com.recon.serviceImpl;

import com.recon.dao.UserDao;
import com.recon.daoImpl.UserDaoImpl;
import com.recon.entities.TblMerchantMaster;
import com.recon.entities.TblMstuser;
import com.recon.service.UserService;

public class UserServiceImpl implements UserService {
	public TblMstuser loginInformation(TblMstuser tblMstuser){
		UserDao userDao = new UserDaoImpl();
		return  userDao.loginInformation(tblMstuser);
	}
	
	public int saveSignupData(TblMerchantMaster tblMstmerchant, String merchantId) {
		UserDao userDao = new UserDaoImpl();
		return  userDao.saveSignupData(tblMstmerchant, merchantId);
	}
	
	public String getMerchantId() {
		UserDao userDao = new UserDaoImpl();
		return  userDao.getMerchantId();
	}
	
	public int changePassword(String userId, String oldPassword, String newPassword) {
		UserDao userDao = new UserDaoImpl();
		return  userDao.changePassword(userId, oldPassword, newPassword);
	}
}
