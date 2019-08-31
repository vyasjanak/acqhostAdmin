package com.recon.entities;

public class RequestPay 
{
	private int id;
	private String message_identifier; 
	private String txn_timestamp;
	private String org_id;
	private String txn_id;
	/*private String desc_txn;*/
	/*private String cust_ref_id;*/
	/*private String txn_url;*/
	private String txn_type;
	private String txn_ref_id;
	private String original_txn_id;
	private String tag_id;
	private String tid;
	/*private String merchant_id;*/
	/*private String merchant_type;*/
	private String avc;
	private String wim;
	private String toll_plaza_id;
	private String toll_plaza_name;
	private String toll_geo_code;
	private String toll_plaza_type;
	private String plaza_reader_id;
	/*private String issuer_Id;*/
	private int txn_amount;
	private String acquirer_id;
	private String vehicle_no;
	private String is_commercial;
	/*private String sign_data;
	private String public_key_cvv;
	private String vehicle_auth;*/
	private int resp_status;
	private String resp_time;
	private String resp_id;
	private String cbs_reference_no;
	private String cbs_response_date;
	private String exception_code;
	private String recon_status;
	private String txn_time;
	
	public int getId() {
		return id;
	}
	public String getMessage_identifier() {
		return message_identifier;
	}
	public String getTxn_timestamp() {
		return txn_timestamp;
	}
	public String getOrg_id() {
		return org_id;
	}
	public String getTxn_id() {
		return txn_id;
	}
	/*public String getDesc_txn() {
		return desc_txn;
	}*/
	/*public String getCust_ref_id() {
		return cust_ref_id;
	}*/
	/*public String getTxn_url() {
		return txn_url;
	}*/
	public String getTxn_type() {
		return txn_type;
	}
	public String getTxn_ref_id() {
		return txn_ref_id;
	}
	public String getOriginal_txn_id() {
		return original_txn_id;
	}
	public String getTag_id() {
		return tag_id;
	}
	public String getTid() {
		return tid;
	}
	/*public String getMerchant_id() {
		return merchant_id;
	}*/
	/*public String getMerchant_type() {
		return merchant_type;
	}*/
	public String getAvc() {
		return avc;
	}
	public String getWim() {
		return wim;
	}
	public String getToll_plaza_id() {
		return toll_plaza_id;
	}
	public String getToll_plaza_name() {
		return toll_plaza_name;
	}
	
	public String getToll_geo_code() {
		return toll_geo_code;
	}
	public String getToll_plaza_type() {
		return toll_plaza_type;
	}
	public String getPlaza_reader_id() {
		return plaza_reader_id;
	}
	/*public String getIssuer_Id() {
		return issuer_Id;
	}*/
	public int getTxn_amount() {
		return txn_amount;
	}
	public String getAcquirer_id() {
		return acquirer_id;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public String getIs_commercial() {
		return is_commercial;
	}
	/*public String getSign_data() {
		return sign_data;
	}
	public String getPublic_key_cvv() {
		return public_key_cvv;
	}
	public String getVehicle_auth() {
		return vehicle_auth;
	}*/
	public int getResp_status() {
		return resp_status;
	}
	public String getResp_time() {
		return resp_time;
	}
	public String getResp_id() {
		return resp_id;
	}
	public String getCbs_reference_no() {
		return cbs_reference_no;
	}
	public String getCbs_response_date() {
		return cbs_response_date;
	}
	public String getException_code() {
		return exception_code;
	}
	public String getRecon_status() {
		return recon_status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMessage_identifier(String message_identifier) {
		this.message_identifier = message_identifier;
	}
	public void setTxn_timestamp(String txn_timestamp) {
		this.txn_timestamp = txn_timestamp;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}
	/*public void setDesc_txn(String desc_txn) {
		this.desc_txn = desc_txn;
	}*/
	/*public void setCust_ref_id(String cust_ref_id) {
		this.cust_ref_id = cust_ref_id;
	}*/
	/*public void setTxn_url(String txn_url) {
		this.txn_url = txn_url;
	}*/
	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}
	public void setTxn_ref_id(String txn_ref_id) {
		this.txn_ref_id = txn_ref_id;
	}
	public void setOriginal_txn_id(String original_txn_id) {
		this.original_txn_id = original_txn_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	/*public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}*/
	/*public void setMerchant_type(String merchant_type) {
		this.merchant_type = merchant_type;
	}*/
	public void setAvc(String avc) {
		this.avc = avc;
	}
	public void setWim(String wim) {
		this.wim = wim;
	}
	public void setToll_plaza_id(String toll_plaza_id) {
		this.toll_plaza_id = toll_plaza_id;
	}
	public void setToll_plaza_name(String toll_plaza_name) {
		this.toll_plaza_name = toll_plaza_name;
	}
	public void setToll_geo_code(String toll_geo_code) {
		this.toll_geo_code = toll_geo_code;
	}
	public void setToll_plaza_type(String toll_plaza_type) {
		this.toll_plaza_type = toll_plaza_type;
	}
	public void setPlaza_reader_id(String plaza_reader_id) {
		this.plaza_reader_id = plaza_reader_id;
	}
	/*public void setIssuer_Id(String issuer_Id) {
		this.issuer_Id = issuer_Id;
	}*/
	public void setTxn_amount(int txn_amount) {
		this.txn_amount = txn_amount;
	}
	public void setAcquirer_id(String acquirer_id) {
		this.acquirer_id = acquirer_id;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public void setIs_commercial(String is_commercial) {
		this.is_commercial = is_commercial;
	}
	/*public void setSign_data(String sign_data) {
		this.sign_data = sign_data;
	}
	public void setPublic_key_cvv(String public_key_cvv) {
		this.public_key_cvv = public_key_cvv;
	}
	public void setVehicle_auth(String vehicle_auth) {
		this.vehicle_auth = vehicle_auth;
	}*/
	public void setResp_status(int resp_status) {
		this.resp_status = resp_status;
	}
	public void setResp_time(String resp_time) {
		this.resp_time = resp_time;
	}
	public void setResp_id(String resp_id) {
		this.resp_id = resp_id;
	}
	public void setCbs_reference_no(String cbs_reference_no) {
		this.cbs_reference_no = cbs_reference_no;
	}
	public void setCbs_response_date(String cbs_response_date) {
		this.cbs_response_date = cbs_response_date;
	}
	public void setException_code(String exception_code) {
		this.exception_code = exception_code;
	}
	public void setRecon_status(String recon_status) {
		this.recon_status = recon_status;
	}
	public String getTxn_time() {
		return txn_time;
	}
	public void setTxn_time(String txn_time) {
		this.txn_time = txn_time;
	}
}
