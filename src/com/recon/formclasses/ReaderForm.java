package com.recon.formclasses;

import org.apache.struts.action.ActionForm;

public class ReaderForm extends ActionForm{
	
	private String readerId;
	private String tollplazaId;
	private String laneId;
	private String isActive;
	private String actionName;
	private String message;
	private String Id;
	
	
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public String getTollplazaId() {
		return tollplazaId;
	}
	public void setTollplazaId(String tollplazaId) {
		this.tollplazaId = tollplazaId;
	}
	public String getLaneId() {
		return laneId;
	}
	public void setLaneId(String laneId) {
		this.laneId = laneId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	
	
	
	
	
}
