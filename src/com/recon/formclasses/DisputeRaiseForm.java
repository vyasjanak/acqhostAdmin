package com.recon.formclasses;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


public class DisputeRaiseForm extends ActionForm  
{
	private long id;
	private String txn_id;
	private String tag_id;
	private String vehicle_no;
	private String dispatch;
	
	private String amount;
	private String reason;
	private FormFile file;
	private String fileName;
	
	private String from_date;
	private String to_date;
	private String original_txn_id;
	private String txn_amount;
	
	public String getTxn_amount() {
		return txn_amount;
	}
	public void setTxn_amount(String txn_amount) {
		this.txn_amount = txn_amount;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTxn_id() {
		return txn_id;
	}
	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public void reset() {
		this.txn_id=null;
		this.tag_id=null;
		this.vehicle_no=null;
		this.file=null;
		this.fileName=null;
		this.amount=null;
		this.reason=null;
		this.from_date=null;
		this.to_date=null;
		this.original_txn_id=null;
	}
	
	private List disputeList;
	public List getDisputeList() {
		return disputeList;
	}
	public void setDisputeList(List disputeList) {
		this.disputeList = disputeList;
	}
	private String acq_txn_id;
	public String getAcq_txn_id() {
		return acq_txn_id;
	}
	public void setAcq_txn_id(String acq_txn_id) {
		this.acq_txn_id = acq_txn_id;
	}
	
	private String toll_txn_id, toll_plaza_id, dispute_type, adjustment_type, dispute_desc;

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
	public String getOriginal_txn_id() {
		return original_txn_id;
	}
	public void setOriginal_txn_id(String original_txn_id) {
		this.original_txn_id = original_txn_id;
	}
	//to generate bulk csv as NPCI format and need new table
	private String reason_code;
	private String function_code;
	private String reason_code_type;
	private String full_par_indicator;
	private String reason_desc;
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
	public String getReason_desc() {
		return reason_desc;
	}
	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}
	
	private ArrayList reasonCodeList1;
	private ArrayList reasonCodeList2;
	private ArrayList reasonCodeList3;
	private ArrayList reasonCodeList4;
	private ArrayList reasonCodeList5;
	private ArrayList reasonCodeList6;
	
	public ArrayList getReasonCodeList1() {
		return reasonCodeList1;
	}
	public void setReasonCodeList1(ArrayList reasonCodeList1) {
		this.reasonCodeList1 = reasonCodeList1;
	}
	public ArrayList getReasonCodeList2() {
		return reasonCodeList2;
	}
	public void setReasonCodeList2(ArrayList reasonCodeList2) {
		this.reasonCodeList2 = reasonCodeList2;
	}
	public ArrayList getReasonCodeList3() {
		return reasonCodeList3;
	}
	public void setReasonCodeList3(ArrayList reasonCodeList3) {
		this.reasonCodeList3 = reasonCodeList3;
	}
	public ArrayList getReasonCodeList4() {
		return reasonCodeList4;
	}
	public void setReasonCodeList4(ArrayList reasonCodeList4) {
		this.reasonCodeList4 = reasonCodeList4;
	}
	public ArrayList getReasonCodeList5() {
		return reasonCodeList5;
	}
	public void setReasonCodeList5(ArrayList reasonCodeList5) {
		this.reasonCodeList5 = reasonCodeList5;
	}
	public ArrayList getReasonCodeList6() {
		return reasonCodeList6;
	}
	public void setReasonCodeList6(ArrayList reasonCodeList6) {
		this.reasonCodeList6 = reasonCodeList6;
	}
}
