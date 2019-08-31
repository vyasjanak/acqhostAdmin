package com.recon.formclasses;

import org.apache.struts.action.ActionForm;

public class DashboardForm extends ActionForm {
	private  String  yesSettAmt;
	private String yesRefAmt;
	private String yesPendtAmt;
	private String todTxnVal;
	private String todTxnCnt;
	public String getYesSettAmt() {
		return yesSettAmt;
	}
	public void setYesSettAmt(String yesSettAmt) {
		this.yesSettAmt = yesSettAmt;
	}
	public String getYesRefAmt() {
		return yesRefAmt;
	}
	public void setYesRefAmt(String yesRefAmt) {
		this.yesRefAmt = yesRefAmt;
	}
	public String getYesPendtAmt() {
		return yesPendtAmt;
	}
	public void setYesPendtAmt(String yesPendtAmt) {
		this.yesPendtAmt = yesPendtAmt;
	}
	public String getTodTxnVal() {
		return todTxnVal;
	}
	public void setTodTxnVal(String todTxnVal) {
		this.todTxnVal = todTxnVal;
	}
	public String getTodTxnCnt() {
		return todTxnCnt;
	}
	public void setTodTxnCnt(String todTxnCnt) {
		this.todTxnCnt = todTxnCnt;
	}
	
	
	

}
