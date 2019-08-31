package com.recon.formclasses;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
import com.recon.entities.TblStateMaster;
import com.recon.entities.TblAccountMaster;
import com.recon.entities.TblCityMaster;

public class MerchantMasterForm extends ActionForm  
{
	private String id;
	private String actionName;
	private String merchantName;
	private String merchantId;
	private String searchMid;
	private String searchMname;
	
	private String message;
		
	private String cust_name;
	private String contact_person;
	private String phone;
	private String email_id;
    private FormFile merLogoDoc; 
	
	private String address1;
	private String location;
	private String pin;
	private String acc_status;

	private String aadhar_number;
	private FormFile aadhar_proof_doc;
	private String pan_number;
	private FormFile pan_proof_doc;
	private String sol_id;
	private FormFile other_doc;

	private String acc_type;
	private String account_number;
	private String IFSC;
	private String ifsc_code;
	private String bank_name;
	
	// MDR Tab
	private Double base_mdr;
	private Double tsp_mdr;
	//private Timestamp from_date;
	//private Timestamp to_date;
	
	private String from_date;
	private String to_date;
	
	private String mdr_type;
	private String is_active;
	
	
	//Used in Download KYC Docs 
	private String mobileNo;
	private String walletId;
	private String downloadFileName;
	

	
	
	
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public Double getBase_mdr() {
		return base_mdr;
	}
	public void setBase_mdr(Double base_mdr) {
		this.base_mdr = base_mdr;
	}
	public Double getTsp_mdr() {
		return tsp_mdr;
	}
	public void setTsp_mdr(Double tsp_mdr) {
		this.tsp_mdr = tsp_mdr;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	/*public Timestamp getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Timestamp from_date) {
		this.from_date = from_date;
	}
	public Timestamp getTo_date() {
		return to_date;
	}
	public void setTo_date(Timestamp to_date) {
		this.to_date = to_date;
	}*/
	public String getMdr_type() {
		return mdr_type;
	}
	public void setMdr_type(String mdr_type) {
		this.mdr_type = mdr_type;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	public String getSearchMid() {
		return searchMid;
	}


	public void setSearchMid(String searchMid) {
		this.searchMid = searchMid;
	}


	public String getSearchMname() {
		return searchMname;
	}


	public void setSearchMname(String searchMname) {
		this.searchMname = searchMname;
	}


	public String getMerchantName() {
		return merchantName;
	}


	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}


	public String getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	/*Personal Details*/
	
	
	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public FormFile getMerLogoDoc() {
		return merLogoDoc;
	}


	public void setMerLogoDoc(FormFile merLogoDoc) {
		this.merLogoDoc = merLogoDoc;
	}
	
	
	
	
/*address master*/
	
	


	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	/*kyc*/

	public String getAcc_status() {
		return acc_status;
	}

	public void setAcc_status(String acc_status) {
		this.acc_status = acc_status;
	}

	public String getAadhar_number() {
		return aadhar_number;
	}

	public void setAadhar_number(String aadhar_number) {
		this.aadhar_number = aadhar_number;
	}

	public FormFile getAadhar_proof_doc() {
		return aadhar_proof_doc;
	}

	public void setAadhar_proof_doc(FormFile aadhar_proof_doc) {
		this.aadhar_proof_doc = aadhar_proof_doc;
	}

	public String getPan_number() {
		return pan_number;
	}

	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}

	public FormFile getPan_proof_doc() {
		return pan_proof_doc;
	}

	public void setPan_proof_doc(FormFile pan_proof_doc) {
		this.pan_proof_doc = pan_proof_doc;
	}

	public String getSol_id() {
		return sol_id;
	}

	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}

	public FormFile getOther_doc() {
		return other_doc;
	}

	public void setOther_doc(FormFile other_doc) {
		this.other_doc = other_doc;
	}

	/*product*/
	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public void reset() 
	{
		this.cust_name = null;
		this.contact_person = null;
		this.phone = null;
		this.email_id = null;
		this.address1 = null;		
		this.location = null;
		this.pin = null; 
		this.acc_status = null;
		
		this.aadhar_number = null;
		this.aadhar_proof_doc = null;
		this.pan_number = null;
		this.pan_proof_doc = null;
		
		this.acc_type = null;
		this.account_number = null;
		this.bank_name = null;
		this.ifsc_code = null;
	}
	
	//Used in Download KYC Docs 
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	
	
}
