package com.recon.entities;

public class PayoutMaster {
	
	private long id;
	private String Conn_id;
	private String toll_plaza_id;
	private String txn_count;
	private String total_amount;
	private String net_amount;
	private String hdfc_amount;
	private String acq_amount;
	private String to_date;
	private String from_date;
	//private String date_time;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConn_id() {
		return Conn_id;
	}
	public void setConn_id(String conn_id) {
		Conn_id = conn_id;
	}
	public String getToll_plaza_id() {
		return toll_plaza_id;
	}
	public void setToll_plaza_id(String toll_plaza_id) {
		this.toll_plaza_id = toll_plaza_id;
	}
	public String getTxn_count() {
		return txn_count;
	}
	public void setTxn_count(String txn_count) {
		this.txn_count = txn_count;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getNet_amount() {
		return net_amount;
	}
	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}
	public String getHdfc_amount() {
		return hdfc_amount;
	}
	public void setHdfc_amount(String hdfc_amount) {
		this.hdfc_amount = hdfc_amount;
	}
	public String getAcq_amount() {
		return acq_amount;
	}
	public void setAcq_amount(String acq_amount) {
		this.acq_amount = acq_amount;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	
}
