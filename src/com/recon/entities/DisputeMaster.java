package com.recon.entities;

public class DisputeMaster 
{
	private long id;
	private String acq_txn_id;
	private String toll_txn_id;
	private String toll_plaza_id;
	private String dispute_type;
	private float amount;
	private String adjustment_type;
	private String dispute_desc;
	private String evidence_doc;
	private String status;
	private String date_time;
	private String remark;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAcq_txn_id() {
		return acq_txn_id;
	}
	public void setAcq_txn_id(String acq_txn_id) {
		this.acq_txn_id = acq_txn_id;
	}
	public String getToll_txn_id() {
		return toll_txn_id;
	}
	public void setToll_txn_id(String toll_txn_id) {
		this.toll_txn_id = toll_txn_id;
	}
	public String getToll_plaza_id() {
		return toll_plaza_id;
	}
	public void setToll_plaza_id(String toll_plaza_id) {
		this.toll_plaza_id = toll_plaza_id;
	}
	public String getDispute_type() {
		return dispute_type;
	}
	public void setDispute_type(String dispute_type) {
		this.dispute_type = dispute_type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getAdjustment_type() {
		return adjustment_type;
	}
	public void setAdjustment_type(String adjustment_type) {
		this.adjustment_type = adjustment_type;
	}
	public String getDispute_desc() {
		return dispute_desc;
	}
	public void setDispute_desc(String dispute_desc) {
		this.dispute_desc = dispute_desc;
	}
	public String getEvidence_doc() {
		return evidence_doc;
	}
	public void setEvidence_doc(String evidence_doc) {
		this.evidence_doc = evidence_doc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	//to generate bulk csv as NPCI format and need new table
	private String reason_code;
	private String function_code;
	private String reason_code_type;
	private String full_par_indicator;
	
	private String tag_id; 
	//private String function_code ;
	private String txn_time; 
	//private String acq_txn_id; 
	private String issuer_id; 
	private String acquirer_id; 
	private String txn_amount; 
	//private String reason_code; 
	//private String toll_plaza_id; 
	private String full_partial_indicator; 
	private String tid; 
	private String mmt;
	//private String toll_txn_id; 
	private String txn_type; 
	//private String dispute_desc; 
	//private String evidence_doc; 
	//private String status; 
	private String rodt; 
	public String getReason_code() {
		return reason_code;
	}
	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}
	public String getFunction_code() {
		return function_code;
	}
	public void setFunction_code(String function_code) {
		this.function_code = function_code;
	}
	public String getReason_code_type() {
		return reason_code_type;
	}
	public void setReason_code_type(String reason_code_type) {
		this.reason_code_type = reason_code_type;
	}
	public String getFull_par_indicator() {
		return full_par_indicator;
	}
	public void setFull_par_indicator(String full_par_indicator) {
		this.full_par_indicator = full_par_indicator;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public String getTxn_time() {
		return txn_time;
	}
	public void setTxn_time(String txn_time) {
		this.txn_time = txn_time;
	}
	public String getIssuer_id() {
		return issuer_id;
	}
	public void setIssuer_id(String issuer_id) {
		this.issuer_id = issuer_id;
	}
	public String getAcquirer_id() {
		return acquirer_id;
	}
	public void setAcquirer_id(String acquirer_id) {
		this.acquirer_id = acquirer_id;
	}
	public String getTxn_amount() {
		return txn_amount;
	}
	public void setTxn_amount(String txn_amount) {
		this.txn_amount = txn_amount;
	}
	public String getFull_partial_indicator() {
		return full_partial_indicator;
	}
	public void setFull_partial_indicator(String full_partial_indicator) {
		this.full_partial_indicator = full_partial_indicator;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getMmt() {
		return mmt;
	}
	public void setMmt(String mmt) {
		this.mmt = mmt;
	}
	public String getTxn_type() {
		return txn_type;
	}
	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}
	public String getRodt() {
		return rodt;
	}
	public void setRodt(String rodt) {
		this.rodt = rodt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
