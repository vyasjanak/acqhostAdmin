package com.recon.service;

import com.recon.entities.TblMerchantMaster;
import com.recon.entities.TblMstuser;

public interface UserService {
	public TblMstuser loginInformation(TblMstuser tblMstuser);
	public int saveSignupData(TblMerchantMaster tblMstmerchant, String merchantId);
	public String getMerchantId();
	public int changePassword(String userId, String oldPassword, String newPassword);
}
