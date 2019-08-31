package com.recon.formclasses;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class Dispute extends ActionForm  
{
	private String report_Date;
	private String debit_credit_Adjustment_Date;
	private String debit_credit_Adjustment_Settlement_Date;
	private String case_Number;
	private String function_code_and_Description;	
	private String transaction_Sequence_Number;	
	private String tag_ID;	
	private String transaction_Date;	
	private String transaction_Settlement_Date;	
	private String rRN;	
	private String transaction_Type;	
	private String merchant_ID;	
	private String tID;	
	private String transaction_Status;	
	private String tAG_Status;	
	private String aVC;	
	private String transaction_Currency_Code;	
	private String settlement_Amount;	
	private String debit_credit_Adjustment_Full_Partial_Indicator;	
	private String originator_Point;	
	private String acquirer_ID;	
	private String transaction_Originator_Institution_PID;
	private String acquirer_Name_and_Country;
	private String iIN;
	private String transaction_Destination_Institution_PID;
	private String issuer_Name_and_Country;	
	private String vehicle_Registration_Number;
	private String vehicle_Class;	
	private String vehicle_Type;
	private String merchant_type;
	private String sub_Merchant_Type;	
	private String financial_Non_Financial_Indicator;
	private String debit_credit_Adjustment_Reason_Code;	
	private String debit_credit_Adjustment_Code_description;
	private String debit_credit_Adjustment_Amount;
	private String document_Indicator;
	private String document_Attached_Date;
	private String days_Aged;	
	
	private FormFile file;
	private String fileName;
	private String dispatch;
	
	private String cycledate;
	
	public String getReport_Date() {
		return report_Date;
	}
	public void setReport_Date(String report_Date) {
		this.report_Date = report_Date;
	}
	public String getDebit_credit_Adjustment_Date() {
		return debit_credit_Adjustment_Date;
	}
	public void setDebit_credit_Adjustment_Date(String debit_credit_Adjustment_Date) {
		this.debit_credit_Adjustment_Date = debit_credit_Adjustment_Date;
	}
	public String getDebit_credit_Adjustment_Settlement_Date() {
		return debit_credit_Adjustment_Settlement_Date;
	}
	public void setDebit_credit_Adjustment_Settlement_Date(String debit_credit_Adjustment_Settlement_Date) {
		this.debit_credit_Adjustment_Settlement_Date = debit_credit_Adjustment_Settlement_Date;
	}
	public String getCase_Number() {
		return case_Number;
	}
	public void setCase_Number(String case_Number) {
		this.case_Number = case_Number;
	}
	public String getFunction_code_and_Description() {
		return function_code_and_Description;
	}
	public void setFunction_code_and_Description(String function_code_and_Description) {
		this.function_code_and_Description = function_code_and_Description;
	}
	public String getTransaction_Sequence_Number() {
		return transaction_Sequence_Number;
	}
	public void setTransaction_Sequence_Number(String transaction_Sequence_Number) {
		this.transaction_Sequence_Number = transaction_Sequence_Number;
	}
	public String getTag_ID() {
		return tag_ID;
	}
	public void setTag_ID(String tag_ID) {
		this.tag_ID = tag_ID;
	}
	public String getTransaction_Date() {
		return transaction_Date;
	}
	public void setTransaction_Date(String transaction_Date) {
		this.transaction_Date = transaction_Date;
	}
	public String getTransaction_Settlement_Date() {
		return transaction_Settlement_Date;
	}
	public void setTransaction_Settlement_Date(String transaction_Settlement_Date) {
		this.transaction_Settlement_Date = transaction_Settlement_Date;
	}
	public String getrRN() {
		return rRN;
	}
	public void setrRN(String rRN) {
		this.rRN = rRN;
	}
	public String getTransaction_Type() {
		return transaction_Type;
	}
	public void setTransaction_Type(String transaction_Type) {
		this.transaction_Type = transaction_Type;
	}
	public String getMerchant_ID() {
		return merchant_ID;
	}
	public void setMerchant_ID(String merchant_ID) {
		this.merchant_ID = merchant_ID;
	}
	public String gettID() {
		return tID;
	}
	public void settID(String tID) {
		this.tID = tID;
	}
	public String getTransaction_Status() {
		return transaction_Status;
	}
	public void setTransaction_Status(String transaction_Status) {
		this.transaction_Status = transaction_Status;
	}
	public String gettAG_Status() {
		return tAG_Status;
	}
	public void settAG_Status(String tAG_Status) {
		this.tAG_Status = tAG_Status;
	}
	public String getaVC() {
		return aVC;
	}
	public void setaVC(String aVC) {
		this.aVC = aVC;
	}
	public String getTransaction_Currency_Code() {
		return transaction_Currency_Code;
	}
	public void setTransaction_Currency_Code(String transaction_Currency_Code) {
		this.transaction_Currency_Code = transaction_Currency_Code;
	}
	public String getSettlement_Amount() {
		return settlement_Amount;
	}
	public void setSettlement_Amount(String settlement_Amount) {
		this.settlement_Amount = settlement_Amount;
	}
	public String getDebit_credit_Adjustment_Full_Partial_Indicator() {
		return debit_credit_Adjustment_Full_Partial_Indicator;
	}
	public void setDebit_credit_Adjustment_Full_Partial_Indicator(String debit_credit_Adjustment_Full_Partial_Indicator) {
		this.debit_credit_Adjustment_Full_Partial_Indicator = debit_credit_Adjustment_Full_Partial_Indicator;
	}
	public String getOriginator_Point() {
		return originator_Point;
	}
	public void setOriginator_Point(String originator_Point) {
		this.originator_Point = originator_Point;
	}
	public String getAcquirer_ID() {
		return acquirer_ID;
	}
	public void setAcquirer_ID(String acquirer_ID) {
		this.acquirer_ID = acquirer_ID;
	}
	public String getTransaction_Originator_Institution_PID() {
		return transaction_Originator_Institution_PID;
	}
	public void setTransaction_Originator_Institution_PID(String transaction_Originator_Institution_PID) {
		this.transaction_Originator_Institution_PID = transaction_Originator_Institution_PID;
	}
	public String getAcquirer_Name_and_Country() {
		return acquirer_Name_and_Country;
	}
	public void setAcquirer_Name_and_Country(String acquirer_Name_and_Country) {
		this.acquirer_Name_and_Country = acquirer_Name_and_Country;
	}
	public String getiIN() {
		return iIN;
	}
	public void setiIN(String iIN) {
		this.iIN = iIN;
	}
	public String getTransaction_Destination_Institution_PID() {
		return transaction_Destination_Institution_PID;
	}
	public void setTransaction_Destination_Institution_PID(String transaction_Destination_Institution_PID) {
		this.transaction_Destination_Institution_PID = transaction_Destination_Institution_PID;
	}
	public String getIssuer_Name_and_Country() {
		return issuer_Name_and_Country;
	}
	public void setIssuer_Name_and_Country(String issuer_Name_and_Country) {
		this.issuer_Name_and_Country = issuer_Name_and_Country;
	}
	public String getVehicle_Registration_Number() {
		return vehicle_Registration_Number;
	}
	public void setVehicle_Registration_Number(String vehicle_Registration_Number) {
		this.vehicle_Registration_Number = vehicle_Registration_Number;
	}
	public String getVehicle_Class() {
		return vehicle_Class;
	}
	public void setVehicle_Class(String vehicle_Class) {
		this.vehicle_Class = vehicle_Class;
	}
	public String getVehicle_Type() {
		return vehicle_Type;
	}
	public void setVehicle_Type(String vehicle_Type) {
		this.vehicle_Type = vehicle_Type;
	}
	public String getMerchant_type() {
		return merchant_type;
	}
	public void setMerchant_type(String merchant_type) {
		this.merchant_type = merchant_type;
	}
	public String getSub_Merchant_Type() {
		return sub_Merchant_Type;
	}
	public void setSub_Merchant_Type(String sub_Merchant_Type) {
		this.sub_Merchant_Type = sub_Merchant_Type;
	}
	public String getFinancial_Non_Financial_Indicator() {
		return financial_Non_Financial_Indicator;
	}
	public void setFinancial_Non_Financial_Indicator(String financial_Non_Financial_Indicator) {
		this.financial_Non_Financial_Indicator = financial_Non_Financial_Indicator;
	}
	
	public String getDebit_credit_Adjustment_Reason_Code() {
		return debit_credit_Adjustment_Reason_Code;
	}
	public void setDebit_credit_Adjustment_Reason_Code(String debit_credit_Adjustment_Reason_Code) {
		this.debit_credit_Adjustment_Reason_Code = debit_credit_Adjustment_Reason_Code;
	}
	public String getDebit_credit_Adjustment_Code_description() {
		return debit_credit_Adjustment_Code_description;
	}
	public void setDebit_credit_Adjustment_Code_description(String debit_credit_Adjustment_Code_description) {
		this.debit_credit_Adjustment_Code_description = debit_credit_Adjustment_Code_description;
	}
	public String getDebit_credit_Adjustment_Amount() {
		return debit_credit_Adjustment_Amount;
	}
	public void setDebit_credit_Adjustment_Amount(String debit_credit_Adjustment_Amount) {
		this.debit_credit_Adjustment_Amount = debit_credit_Adjustment_Amount;
	}
	public String getDocument_Indicator() {
		return document_Indicator;
	}
	public void setDocument_Indicator(String document_Indicator) {
		this.document_Indicator = document_Indicator;
	}
	public String getDocument_Attached_Date() {
		return document_Attached_Date;
	}
	public void setDocument_Attached_Date(String document_Attached_Date) {
		this.document_Attached_Date = document_Attached_Date;
	}
	public String getDays_Aged() {
		return days_Aged;
	}
	public void setDays_Aged(String days_Aged) {
		this.days_Aged = days_Aged;
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
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	
	
	public String getCycledate() {
		return cycledate;
	}
	public void setCycledate(String cycledate) {
		this.cycledate = cycledate;
	}
		
	public void reset() {
		this.file=null;
		this.cycledate=null;
	}
}
