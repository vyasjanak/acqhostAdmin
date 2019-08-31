package com.recon.formclasses;

import java.util.Date;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class Txns extends ActionForm  
{
	private String transaction_Sequence_Number;
	private String transaction_ID;
	private String message_ID;
	private String note;
	private String reference_ID;
	private String reference_URL;
	private String transaction_Date_and_Time;
	private String transaction_Type;
	private String original_transaction_ID;
	private String tag_ID;
	private String tID;
	private String aVC;
	private String wim;
	private String merchant_Id;
	private String merchant_Type;
	private String sub_Merchant_Type;
	private String lane_Id;
	private String lane_Direction;
	private String lane_Reader_ID;
	private String parking_Floor;
	private String parking_Zone;
	private String parking_Slot;
	private String parking_Reader_ID;
	private String reader_Read_Date_and_Time;
	private String signature_Data;
	private String signature_Authentication;
	private String ePC_Verified;
	private String proc_Restriction_Res;
	private String vehicle_Auth;
	private String public_Key_CVV;
	private String reader_Transaction_Counter;
	private String reader_Transaction_Status;
	private String payer_Address;
	private String issuer_ID;
	private String payer_Code;
	private String payer_name;
	private String payer_Type;
	private String transaction_Amount;
	private String currency_Code;
	private String payee_Address;
	private String acquirer_ID;
	private String payee_Code;
	private String payee_name;
	private String payee_Type;	
	private String response_Code;
	private String transaction_Status;
	private String approval_Number;
	private String payee_Error_Code;
	private String settled_Amount;
	private String settled_Currency;
	private String account_Type;
	private String available_Balance;
	private String ledger_Balance;
	private String account_Number;
	private String customer_Name;
	private String initiated_By;
	private String initiated_Time;
	private String last_Updated_By;
	private String last_Updated_Time;
	private String vehicle_Registration_number;
	private String vehicle_Class;
	private String vehicle_Type;
	private String tag_status;
	private String tag_Issue_Date;
	
	private FormFile file;
	private String fileName;
	private String dispatch;
	
	private String cycle;
	private String cycledate;
	
	private long id;
	private String reason;
	private String process_date;
	private String txn_time;
	
	public String getTransaction_Sequence_Number() {
		return transaction_Sequence_Number;
	}
	public void setTransaction_Sequence_Number(String transaction_Sequence_Number) {
		this.transaction_Sequence_Number = transaction_Sequence_Number;
	}
	public String getTransaction_ID() {
		return transaction_ID;
	}
	public void setTransaction_ID(String transaction_ID) {
		this.transaction_ID = transaction_ID;
	}
	public String getMessage_ID() {
		return message_ID;
	}
	public void setMessage_ID(String message_ID) {
		this.message_ID = message_ID;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getReference_ID() {
		return reference_ID;
	}
	public void setReference_ID(String reference_ID) {
		this.reference_ID = reference_ID;
	}
	public String getReference_URL() {
		return reference_URL;
	}
	public void setReference_URL(String reference_URL) {
		this.reference_URL = reference_URL;
	}
	public String getTransaction_Date_and_Time() {
		return transaction_Date_and_Time;
	}
	public void setTransaction_Date_and_Time(String transaction_Date_and_Time) {
		this.transaction_Date_and_Time = transaction_Date_and_Time;
	}
	public String getTransaction_Type() {
		return transaction_Type;
	}
	public void setTransaction_Type(String transaction_Type) {
		this.transaction_Type = transaction_Type;
	}
	public String getOriginal_transaction_ID() {
		return original_transaction_ID;
	}
	public void setOriginal_transaction_ID(String original_transaction_ID) {
		this.original_transaction_ID = original_transaction_ID;
	}
	public String getTag_ID() {
		return tag_ID;
	}
	public void setTag_ID(String tag_ID) {
		this.tag_ID = tag_ID;
	}
	public String gettID() {
		return tID;
	}
	public void settID(String tID) {
		this.tID = tID;
	}
	public String getaVC() {
		return aVC;
	}
	public void setaVC(String aVC) {
		this.aVC = aVC;
	}
	public String getWim() {
		return wim;
	}
	public void setWim(String wim) {
		this.wim = wim;
	}
	public String getMerchant_Id() {
		return merchant_Id;
	}
	public void setMerchant_Id(String merchant_Id) {
		this.merchant_Id = merchant_Id;
	}
	public String getMerchant_Type() {
		return merchant_Type;
	}
	public void setMerchant_Type(String merchant_Type) {
		this.merchant_Type = merchant_Type;
	}
	public String getSub_Merchant_Type() {
		return sub_Merchant_Type;
	}
	public void setSub_Merchant_Type(String sub_Merchant_Type) {
		this.sub_Merchant_Type = sub_Merchant_Type;
	}
	public String getLane_Id() {
		return lane_Id;
	}
	public void setLane_Id(String lane_Id) {
		this.lane_Id = lane_Id;
	}
	public String getLane_Direction() {
		return lane_Direction;
	}
	public void setLane_Direction(String lane_Direction) {
		this.lane_Direction = lane_Direction;
	}
	public String getLane_Reader_ID() {
		return lane_Reader_ID;
	}
	public void setLane_Reader_ID(String lane_Reader_ID) {
		this.lane_Reader_ID = lane_Reader_ID;
	}
	public String getParking_Floor() {
		return parking_Floor;
	}
	public void setParking_Floor(String parking_Floor) {
		this.parking_Floor = parking_Floor;
	}
	public String getParking_Zone() {
		return parking_Zone;
	}
	public void setParking_Zone(String parking_Zone) {
		this.parking_Zone = parking_Zone;
	}
	public String getParking_Slot() {
		return parking_Slot;
	}
	public void setParking_Slot(String parking_Slot) {
		this.parking_Slot = parking_Slot;
	}
	public String getParking_Reader_ID() {
		return parking_Reader_ID;
	}
	public void setParking_Reader_ID(String parking_Reader_ID) {
		this.parking_Reader_ID = parking_Reader_ID;
	}
	public String getReader_Read_Date_and_Time() {
		return reader_Read_Date_and_Time;
	}
	public void setReader_Read_Date_and_Time(String reader_Read_Date_and_Time) {
		this.reader_Read_Date_and_Time = reader_Read_Date_and_Time;
	}
	public String getSignature_Data() {
		return signature_Data;
	}
	public void setSignature_Data(String signature_Data) {
		this.signature_Data = signature_Data;
	}
	public String getSignature_Authentication() {
		return signature_Authentication;
	}
	public void setSignature_Authentication(String signature_Authentication) {
		this.signature_Authentication = signature_Authentication;
	}
	public String getePC_Verified() {
		return ePC_Verified;
	}
	public void setePC_Verified(String ePC_Verified) {
		this.ePC_Verified = ePC_Verified;
	}
	public String getProc_Restriction_Res() {
		return proc_Restriction_Res;
	}
	public void setProc_Restriction_Res(String proc_Restriction_Res) {
		this.proc_Restriction_Res = proc_Restriction_Res;
	}
	public String getVehicle_Auth() {
		return vehicle_Auth;
	}
	public void setVehicle_Auth(String vehicle_Auth) {
		this.vehicle_Auth = vehicle_Auth;
	}
	public String getPublic_Key_CVV() {
		return public_Key_CVV;
	}
	public void setPublic_Key_CVV(String public_Key_CVV) {
		this.public_Key_CVV = public_Key_CVV;
	}
	public String getReader_Transaction_Counter() {
		return reader_Transaction_Counter;
	}
	public void setReader_Transaction_Counter(String reader_Transaction_Counter) {
		this.reader_Transaction_Counter = reader_Transaction_Counter;
	}
	public String getReader_Transaction_Status() {
		return reader_Transaction_Status;
	}
	public void setReader_Transaction_Status(String reader_Transaction_Status) {
		this.reader_Transaction_Status = reader_Transaction_Status;
	}
	public String getPayer_Address() {
		return payer_Address;
	}
	public void setPayer_Address(String payer_Address) {
		this.payer_Address = payer_Address;
	}
	public String getIssuer_ID() {
		return issuer_ID;
	}
	public void setIssuer_ID(String issuer_ID) {
		this.issuer_ID = issuer_ID;
	}
	public String getPayer_Code() {
		return payer_Code;
	}
	public void setPayer_Code(String payer_Code) {
		this.payer_Code = payer_Code;
	}
	public String getPayer_name() {
		return payer_name;
	}
	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	public String getPayer_Type() {
		return payer_Type;
	}
	public void setPayer_Type(String payer_Type) {
		this.payer_Type = payer_Type;
	}
	public String getTransaction_Amount() {
		return transaction_Amount;
	}
	public void setTransaction_Amount(String transaction_Amount) {
		this.transaction_Amount = transaction_Amount;
	}
	public String getCurrency_Code() {
		return currency_Code;
	}
	public void setCurrency_Code(String currency_Code) {
		this.currency_Code = currency_Code;
	}
	public String getPayee_Address() {
		return payee_Address;
	}
	public void setPayee_Address(String payee_Address) {
		this.payee_Address = payee_Address;
	}
	public String getAcquirer_ID() {
		return acquirer_ID;
	}
	public void setAcquirer_ID(String acquirer_ID) {
		this.acquirer_ID = acquirer_ID;
	}
	public String getPayee_Code() {
		return payee_Code;
	}
	public void setPayee_Code(String payee_Code) {
		this.payee_Code = payee_Code;
	}
	public String getPayee_name() {
		return payee_name;
	}
	public void setPayee_name(String payee_name) {
		this.payee_name = payee_name;
	}
	public String getPayee_Type() {
		return payee_Type;
	}
	public void setPayee_Type(String payee_Type) {
		this.payee_Type = payee_Type;
	}
	public String getResponse_Code() {
		return response_Code;
	}
	public void setResponse_Code(String response_Code) {
		this.response_Code = response_Code;
	}
	public String getTransaction_Status() {
		return transaction_Status;
	}
	public void setTransaction_Status(String transaction_Status) {
		this.transaction_Status = transaction_Status;
	}
	public String getApproval_Number() {
		return approval_Number;
	}
	public void setApproval_Number(String approval_Number) {
		this.approval_Number = approval_Number;
	}
	public String getPayee_Error_Code() {
		return payee_Error_Code;
	}
	public void setPayee_Error_Code(String payee_Error_Code) {
		this.payee_Error_Code = payee_Error_Code;
	}
	public String getSettled_Amount() {
		return settled_Amount;
	}
	public void setSettled_Amount(String settled_Amount) {
		this.settled_Amount = settled_Amount;
	}
	public String getSettled_Currency() {
		return settled_Currency;
	}
	public void setSettled_Currency(String settled_Currency) {
		this.settled_Currency = settled_Currency;
	}
	public String getAccount_Type() {
		return account_Type;
	}
	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}
	public String getAvailable_Balance() {
		return available_Balance;
	}
	public void setAvailable_Balance(String available_Balance) {
		this.available_Balance = available_Balance;
	}
	public String getLedger_Balance() {
		return ledger_Balance;
	}
	public void setLedger_Balance(String ledger_Balance) {
		this.ledger_Balance = ledger_Balance;
	}
	public String getAccount_Number() {
		return account_Number;
	}
	public void setAccount_Number(String account_Number) {
		this.account_Number = account_Number;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getInitiated_By() {
		return initiated_By;
	}
	public void setInitiated_By(String initiated_By) {
		this.initiated_By = initiated_By;
	}
	public String getInitiated_Time() {
		return initiated_Time;
	}
	public void setInitiated_Time(String initiated_Time) {
		this.initiated_Time = initiated_Time;
	}
	public String getLast_Updated_By() {
		return last_Updated_By;
	}
	public void setLast_Updated_By(String last_Updated_By) {
		this.last_Updated_By = last_Updated_By;
	}
	public String getLast_Updated_Time() {
		return last_Updated_Time;
	}
	public void setLast_Updated_Time(String last_Updated_Time) {
		this.last_Updated_Time = last_Updated_Time;
	}
	public String getVehicle_Registration_number() {
		return vehicle_Registration_number;
	}
	public void setVehicle_Registration_number(String vehicle_Registration_number) {
		this.vehicle_Registration_number = vehicle_Registration_number;
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
	public String getTag_status() {
		return tag_status;
	}
	public void setTag_status(String tag_status) {
		this.tag_status = tag_status;
	}
	public String getTag_Issue_Date() {
		return tag_Issue_Date;
	}
	public void setTag_Issue_Date(String tag_Issue_Date) {
		this.tag_Issue_Date = tag_Issue_Date;
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
	
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getCycledate() {
		return cycledate;
	}
	public void setCycledate(String cycledate) {
		this.cycledate = cycledate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getProcess_date() {
		return process_date;
	}
	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}
	
	private Date rec_date;
	private int total_rec;
	private int total_match;
	private int total_mismatch;
	private int already_recon;
	private String remark;
	
	
	public Date getRec_date() {
		return rec_date;
	}
	public void setRec_date(Date rec_date) {
		this.rec_date = rec_date;
	}
	public int getTotal_rec() {
		return total_rec;
	}
	public void setTotal_rec(int total_rec) {
		this.total_rec = total_rec;
	}
	public int getTotal_match() {
		return total_match;
	}
	public void setTotal_match(int total_match) {
		this.total_match = total_match;
	}
	public int getTotal_mismatch() {
		return total_mismatch;
	}
	public void setTotal_mismatch(int total_mismatch) {
		this.total_mismatch = total_mismatch;
	}
	public int getAlready_recon() {
		return already_recon;
	}
	public void setAlready_recon(int already_recon) {
		this.already_recon = already_recon;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void reset() {
		this.file=null;
		this.cycledate=null;
		this.cycle=null;
	}
	public String getTxn_time() {
		return txn_time;
	}
	public void setTxn_time(String txn_time) {
		this.txn_time = txn_time;
	}
}
