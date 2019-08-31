package com.recon.formclasses;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class PayoutGenerationForm extends ActionForm{
	

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


}
