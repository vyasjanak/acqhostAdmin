package com.recon.formclasses;

import org.apache.struts.action.ActionForm;

public class ExceptionDetailForm extends ActionForm {
	
	
	private String message;
	private String tagid;
	private String tid;
	private String vehicle_no;
	private String exce_type;
	private String actionName;

	
	
	
	
	public String getExce_type() {
		return exce_type;
	}
	public void setExce_type(String exce_type) {
		this.exce_type = exce_type;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTagid() {
		return tagid;
	}
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
	
	
	
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	

	
}
