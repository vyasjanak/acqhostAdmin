package com.recon.formclasses;

import org.apache.struts.action.ActionForm;

public class RequestDetailForm extends ActionForm {
	
	
	private String message;
	private String tagid;
	private String tid;
	private String epcid;
	private String vehicle_no;
	private String actionName;

	
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
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
	public String getEpcid() {
		return epcid;
	}
	public void setEpcid(String epcid) {
		this.epcid = epcid;
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
