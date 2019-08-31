package com.recon.entities;

public class AcqRequestPay 
{
	private int id; 
	private String message_identifier; 
	private String acq_txn_time; 
	private String org_id; 
	private String txn_id; 
	private String acq_id; 
	private String txn_type; 
	private String txn_ref_id; 
	private String original_txn_id; 
	private String tag_id; 
	private String tid; 
	private String avc; 
	private String wim; 
	private String toll_plaza_id; 
	private String toll_plaza_name; 
	private String toll_geo_code; 
	private String toll_plaza_type; 
	private String toll_plaza_lane_id; 
	private String toll_plaza_direction;
	private String plaza_reader_id; 
	private String reader_ts; 
	private double txn_amount; 
	private String txn_posted_time; 
	private String vehicle_no; 
	private String is_commercial; 
	private String resp_status; 
	private String resp_time; 
	private String resp_id; 
	private String cbs_reference_no; 
	private String cbs_response_date; 
	private String exception_code; 
	private String recon_status; 
	private String rodt; 
	private String error_code; 
	private String created_on;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage_identifier() {
		return message_identifier;
	}
	public void setMessage_identifier(String message_identifier) {
		this.message_identifier = message_identifier;
	}
	public String getAcq_txn_time() {
		return acq_txn_time;
	}
	public void setAcq_txn_time(String acq_txn_time) {
		this.acq_txn_time = acq_txn_time;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getTxn_id() {
		return txn_id;
	}
	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}
	public String getAcq_id() {
		return acq_id;
	}
	public void setAcq_id(String acq_id) {
		this.acq_id = acq_id;
	}
	public String getTxn_type() {
		return txn_type;
	}
	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}
	public String getTxn_ref_id() {
		return txn_ref_id;
	}
	public void setTxn_ref_id(String txn_ref_id) {
		this.txn_ref_id = txn_ref_id;
	}
	public String getOriginal_txn_id() {
		return original_txn_id;
	}
	public void setOriginal_txn_id(String original_txn_id) {
		this.original_txn_id = original_txn_id;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getAvc() {
		return avc;
	}
	public void setAvc(String avc) {
		this.avc = avc;
	}
	public String getWim() {
		return wim;
	}
	public void setWim(String wim) {
		this.wim = wim;
	}
	public String getToll_plaza_id() {
		return toll_plaza_id;
	}
	public void setToll_plaza_id(String toll_plaza_id) {
		this.toll_plaza_id = toll_plaza_id;
	}
	public String getToll_plaza_name() {
		return toll_plaza_name;
	}
	public void setToll_plaza_name(String toll_plaza_name) {
		this.toll_plaza_name = toll_plaza_name;
	}
	public String getToll_geo_code() {
		return toll_geo_code;
	}
	public void setToll_geo_code(String toll_geo_code) {
		this.toll_geo_code = toll_geo_code;
	}
	public String getToll_plaza_type() {
		return toll_plaza_type;
	}
	public void setToll_plaza_type(String toll_plaza_type) {
		this.toll_plaza_type = toll_plaza_type;
	}
	public String getToll_plaza_lane_id() {
		return toll_plaza_lane_id;
	}
	public void setToll_plaza_lane_id(String toll_plaza_lane_id) {
		this.toll_plaza_lane_id = toll_plaza_lane_id;
	}
	public String getToll_plaza_direction() {
		return toll_plaza_direction;
	}
	public void setToll_plaza_direction(String toll_plaza_direction) {
		this.toll_plaza_direction = toll_plaza_direction;
	}
	public String getPlaza_reader_id() {
		return plaza_reader_id;
	}
	public void setPlaza_reader_id(String plaza_reader_id) {
		this.plaza_reader_id = plaza_reader_id;
	}
	public String getReader_ts() {
		return reader_ts;
	}
	public void setReader_ts(String reader_ts) {
		this.reader_ts = reader_ts;
	}
	public double getTxn_amount() {
		return txn_amount;
	}
	public void setTxn_amount(double txn_amount) {
		this.txn_amount = txn_amount;
	}
	public String getTxn_posted_time() {
		return txn_posted_time;
	}
	public void setTxn_posted_time(String txn_posted_time) {
		this.txn_posted_time = txn_posted_time;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getIs_commercial() {
		return is_commercial;
	}
	public void setIs_commercial(String is_commercial) {
		this.is_commercial = is_commercial;
	}
	public String getResp_status() {
		return resp_status;
	}
	public void setResp_status(String resp_status) {
		this.resp_status = resp_status;
	}
	public String getResp_time() {
		return resp_time;
	}
	public void setResp_time(String resp_time) {
		this.resp_time = resp_time;
	}
	public String getResp_id() {
		return resp_id;
	}
	public void setResp_id(String resp_id) {
		this.resp_id = resp_id;
	}
	public String getCbs_reference_no() {
		return cbs_reference_no;
	}
	public void setCbs_reference_no(String cbs_reference_no) {
		this.cbs_reference_no = cbs_reference_no;
	}
	public String getCbs_response_date() {
		return cbs_response_date;
	}
	public void setCbs_response_date(String cbs_response_date) {
		this.cbs_response_date = cbs_response_date;
	}
	public String getException_code() {
		return exception_code;
	}
	public void setException_code(String exception_code) {
		this.exception_code = exception_code;
	}
	public String getRecon_status() {
		return recon_status;
	}
	public void setRecon_status(String recon_status) {
		this.recon_status = recon_status;
	}
	public String getRodt() {
		return rodt;
	}
	public void setRodt(String rodt) {
		this.rodt = rodt;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	
}
