package com.recon.formclasses;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class DisputeAdjForm extends ActionForm
{
	private long id; 
	private String report_date; 
	private String dispute_raise_date; 
	private String dispute_raised_settlement_date; 
	private String case_number; 
	private String function_code; 
	private String function_code_and_description;
	private String transaction_sequence_number; 
	private String tag_id; 
	private String tid; 
	private String transaction_date_time; 
	private String reader_read_date_time; 
	private String transaction_settlement_date; 
	private String transaction_amount; 
	private String settlement_amount; 
	private String settlement_currency_code; 
	private String note; 
	private String transaction_id; 
	private String transaction_type; 
	private String merchant_id; 
	private String lane_id; 
	private String merchant_type; 
	private String sub_merchant_type; 
	private String transaction_status; 
	private String tag_status; 
	private String avc; 
	private String wim; 
	private String originator_point; 
	private String acquirer_id; 
	private String transaction_orig_institution_pid; 
	private String acquirer_name_and_country; 
	private String iin; 
	private String transaction_destination_institution_pid; 
	private String issuer_name_and_country; 
	private String vehicle_registration_number; 
	private String vehicle_class; 
	private String vehicle_type; 
	private String financial_non_financial_indicator; 
	private String dispute_reason_code; 
	private String dispute_reason_code_description; 
	private String disputed_amount; 
	private String full_partial_indicator; 
	private String member_message_text; 
	private String document_indicator; 
	private String document_attached_date; 
	private String deadline_date; 
	private String days_to_act; 
	private String direction_of_dispute;
	
	private FormFile file;
	private String fileName;
	private String dispatch;
	
	private String cycledate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public String getDispute_raise_date() {
		return dispute_raise_date;
	}

	public void setDispute_raise_date(String dispute_raise_date) {
		this.dispute_raise_date = dispute_raise_date;
	}

	public String getDispute_raised_settlement_date() {
		return dispute_raised_settlement_date;
	}

	public void setDispute_raised_settlement_date(String dispute_raised_settlement_date) {
		this.dispute_raised_settlement_date = dispute_raised_settlement_date;
	}

	public String getCase_number() {
		return case_number;
	}

	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}

	public String getFunction_code() {
		return function_code;
	}

	public void setFunction_code(String function_code) {
		this.function_code = function_code;
	}

	public String getFunction_code_and_description() {
		return function_code_and_description;
	}

	public void setFunction_code_and_description(String function_code_and_description) {
		this.function_code_and_description = function_code_and_description;
	}

	public String getTransaction_sequence_number() {
		return transaction_sequence_number;
	}

	public void setTransaction_sequence_number(String transaction_sequence_number) {
		this.transaction_sequence_number = transaction_sequence_number;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTransaction_date_time() {
		return transaction_date_time;
	}

	public void setTransaction_date_time(String transaction_date_time) {
		this.transaction_date_time = transaction_date_time;
	}

	public String getReader_read_date_time() {
		return reader_read_date_time;
	}

	public void setReader_read_date_time(String reader_read_date_time) {
		this.reader_read_date_time = reader_read_date_time;
	}

	public String getTransaction_settlement_date() {
		return transaction_settlement_date;
	}

	public void setTransaction_settlement_date(String transaction_settlement_date) {
		this.transaction_settlement_date = transaction_settlement_date;
	}

	public String getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(String transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getSettlement_amount() {
		return settlement_amount;
	}

	public void setSettlement_amount(String settlement_amount) {
		this.settlement_amount = settlement_amount;
	}

	public String getSettlement_currency_code() {
		return settlement_currency_code;
	}

	public void setSettlement_currency_code(String settlement_currency_code) {
		this.settlement_currency_code = settlement_currency_code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getLane_id() {
		return lane_id;
	}

	public void setLane_id(String lane_id) {
		this.lane_id = lane_id;
	}

	public String getMerchant_type() {
		return merchant_type;
	}

	public void setMerchant_type(String merchant_type) {
		this.merchant_type = merchant_type;
	}

	public String getSub_merchant_type() {
		return sub_merchant_type;
	}

	public void setSub_merchant_type(String sub_merchant_type) {
		this.sub_merchant_type = sub_merchant_type;
	}

	public String getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}

	public String getTag_status() {
		return tag_status;
	}

	public void setTag_status(String tag_status) {
		this.tag_status = tag_status;
	}

	public String getAvc() {
		return avc;
	}

	public void setAvc(String avc) {
		this.avc = avc;
	}

	public String getWim() {
		return wim;
	}

	public void setWim(String wim) {
		this.wim = wim;
	}

	public String getOriginator_point() {
		return originator_point;
	}

	public void setOriginator_point(String originator_point) {
		this.originator_point = originator_point;
	}

	public String getAcquirer_id() {
		return acquirer_id;
	}

	public void setAcquirer_id(String acquirer_id) {
		this.acquirer_id = acquirer_id;
	}

	public String getTransaction_orig_institution_pid() {
		return transaction_orig_institution_pid;
	}

	public void setTransaction_orig_institution_pid(String transaction_orig_institution_pid) {
		this.transaction_orig_institution_pid = transaction_orig_institution_pid;
	}

	public String getAcquirer_name_and_country() {
		return acquirer_name_and_country;
	}

	public void setAcquirer_name_and_country(String acquirer_name_and_country) {
		this.acquirer_name_and_country = acquirer_name_and_country;
	}

	public String getIin() {
		return iin;
	}

	public void setIin(String iin) {
		this.iin = iin;
	}

	public String getTransaction_destination_institution_pid() {
		return transaction_destination_institution_pid;
	}

	public void setTransaction_destination_institution_pid(String transaction_destination_institution_pid) {
		this.transaction_destination_institution_pid = transaction_destination_institution_pid;
	}

	public String getIssuer_name_and_country() {
		return issuer_name_and_country;
	}

	public void setIssuer_name_and_country(String issuer_name_and_country) {
		this.issuer_name_and_country = issuer_name_and_country;
	}

	public String getVehicle_registration_number() {
		return vehicle_registration_number;
	}

	public void setVehicle_registration_number(String vehicle_registration_number) {
		this.vehicle_registration_number = vehicle_registration_number;
	}

	public String getVehicle_class() {
		return vehicle_class;
	}

	public void setVehicle_class(String vehicle_class) {
		this.vehicle_class = vehicle_class;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getFinancial_non_financial_indicator() {
		return financial_non_financial_indicator;
	}

	public void setFinancial_non_financial_indicator(String financial_non_financial_indicator) {
		this.financial_non_financial_indicator = financial_non_financial_indicator;
	}

	public String getDispute_reason_code() {
		return dispute_reason_code;
	}

	public void setDispute_reason_code(String dispute_reason_code) {
		this.dispute_reason_code = dispute_reason_code;
	}

	public String getDispute_reason_code_description() {
		return dispute_reason_code_description;
	}

	public void setDispute_reason_code_description(String dispute_reason_code_description) {
		this.dispute_reason_code_description = dispute_reason_code_description;
	}

	public String getDisputed_amount() {
		return disputed_amount;
	}

	public void setDisputed_amount(String disputed_amount) {
		this.disputed_amount = disputed_amount;
	}

	public String getFull_partial_indicator() {
		return full_partial_indicator;
	}

	public void setFull_partial_indicator(String full_partial_indicator) {
		this.full_partial_indicator = full_partial_indicator;
	}

	public String getMember_message_text() {
		return member_message_text;
	}

	public void setMember_message_text(String member_message_text) {
		this.member_message_text = member_message_text;
	}

	public String getDocument_indicator() {
		return document_indicator;
	}

	public void setDocument_indicator(String document_indicator) {
		this.document_indicator = document_indicator;
	}

	public String getDocument_attached_date() {
		return document_attached_date;
	}

	public void setDocument_attached_date(String document_attached_date) {
		this.document_attached_date = document_attached_date;
	}

	public String getDeadline_date() {
		return deadline_date;
	}

	public void setDeadline_date(String deadline_date) {
		this.deadline_date = deadline_date;
	}

	public String getDays_to_act() {
		return days_to_act;
	}

	public void setDays_to_act(String days_to_act) {
		this.days_to_act = days_to_act;
	}

	public String getDirection_of_dispute() {
		return direction_of_dispute;
	}

	public void setDirection_of_dispute(String direction_of_dispute) {
		this.direction_of_dispute = direction_of_dispute;
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
