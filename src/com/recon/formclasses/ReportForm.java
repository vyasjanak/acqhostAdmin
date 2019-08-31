package com.recon.formclasses;

import org.apache.struts.action.ActionForm;

public class ReportForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String from_date;
	private String to_Date;
	private String rep;
	private String id;
	
	
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_Date() {
		return to_Date;
	}
	public void setTo_Date(String to_Date) {
		this.to_Date = to_Date;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	
	

}
