package com.recon.entities;

import java.sql.Timestamp;

public class MDRMaster implements java.io.Serializable {
	
	private Integer id;
	private String merchant_id;
	private Double base_mdr;
	private Double tsp_mdr;	
	private String mdr_type;
	private Timestamp from_date;
	private Timestamp to_date;
	private String is_active;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
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
	public String getMdr_type() {
		return mdr_type;
	}
	public void setMdr_type(String mdr_type) {
		this.mdr_type = mdr_type;
	}
	public Timestamp getFrom_date() {
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
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

}
