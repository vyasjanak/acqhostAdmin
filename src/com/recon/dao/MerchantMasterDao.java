package com.recon.dao;

import java.util.List;

import com.recon.entities.DropdownBean;
import com.recon.entities.MDRMaster;
import com.recon.entities.TblCityMaster;
import com.recon.entities.TblAccountMaster;
import com.recon.entities.TblAddressMaster;
import com.recon.entities.TblMerchantMaster;

public interface MerchantMasterDao 
{
	public List<Object> findByProperty(String propertyName, Object value, String entityName);
	public int saveOrUpdateMerchant(String operation, TblMerchantMaster tblMerchanttMaster, TblAddressMaster tblAddressMaster, MDRMaster mdrMaster , TblAccountMaster tblWalletAccountMaster);
	/*public List<List<String>> getKycDocDetails (String mobileNo, String walletID, String solId);*/
}
