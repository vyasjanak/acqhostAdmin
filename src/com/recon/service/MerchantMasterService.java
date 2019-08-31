package com.recon.service;

import java.util.List;

import com.recon.entities.MDRMaster;
import com.recon.entities.TblAccountMaster;
import com.recon.entities.TblAddressMaster;

import com.recon.entities.TblMerchantMaster;


public interface MerchantMasterService
{	
	public List<Object> findByProperty(String propertyName, Object value, String entityName);
	public int saveOrUpdateMerchant(String operation, TblMerchantMaster tblWalletMaster, TblAddressMaster tblAddressMaster, MDRMaster mdrMaster, TblAccountMaster tblAccountMaster);
	/*public List<List<String>> getKycDocDetails (String mobileNo, String walletID, String solId);*/
}
