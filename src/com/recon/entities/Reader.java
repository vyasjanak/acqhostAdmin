package com.recon.entities;

import java.io.Serializable;

public class Reader implements Serializable {

	private String readerId;
	private String tollplazaId;
	private String laneId;
	private String isActive;
	private String createdOn;
	private String createdBy;
	private String approvedOn;
	private String approvedBy;
	private String id;
	
	
	public Reader(){
		
	}
	
	public Reader(String readerId, String tollplazaId, String laneId, String isActive, String createdOn,
			String createdBy, String approvedOn, String approvedBy,String id) {
		//super();
		this.readerId = readerId;
		this.tollplazaId = tollplazaId;
		this.laneId = laneId;
		this.isActive = isActive;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.approvedOn = approvedOn;
		this.approvedBy = approvedBy;
		this.id =id;
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

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(String approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
