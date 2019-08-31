package com.recon.serviceImpl;

import java.util.List;


import com.recon.dao.MerchantMasterDao;

import com.recon.daoImpl.MerchantMasterDaoImpl;
import com.recon.entities.MDRMaster;
import com.recon.entities.TblAccountMaster;
import com.recon.entities.TblAddressMaster;

import com.recon.entities.TblMerchantMaster;
import com.recon.service.MerchantMasterService;

public class MerchantMasterServiceImpl implements MerchantMasterService
{	
	public List<Object> findByProperty(String propertyName, Object value, String entityName)
	{
		MerchantMasterDao merchantMasterDao = new MerchantMasterDaoImpl();
		return merchantMasterDao.findByProperty(propertyName, value, entityName);
	}
	
	public int saveOrUpdateMerchant(String operation, TblMerchantMaster tblMerchantMaster, TblAddressMaster tblAddressMaster,MDRMaster  mdrMaster,TblAccountMaster tblAccountMaster)
	{
		MerchantMasterDao merchantMasterDao = new MerchantMasterDaoImpl();
		return merchantMasterDao.saveOrUpdateMerchant(operation,tblMerchantMaster,tblAddressMaster,mdrMaster,tblAccountMaster);
	}
	
	/*public List<List<String>> getMerchantDetails(String fromDate, String toDate , String searchMid ,String searchMname) {
		WalletMasterDaoImpl merchantDao = new WalletMasterDaoImpl();
		return merchantDao.getMerchantDetails(searchMid , searchMname);
	}*/
	
	/*public List<List<String>> getKycDocDetails (String mobileNo, String walletID, String solId)
	{
		MerchantMasterDao merchantMasterDao = new MerchantMasterDaoImpl();
		return merchantMasterDao.getKycDocDetails (mobileNo, walletID, solId);
	}*/
}
