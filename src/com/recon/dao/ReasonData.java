package com.recon.dao;

public class ReasonData {


    private String reason_code;

    private String reason_desc;

    ReasonData(String reason_code, String reason_desc)
    {
        this.reason_code = reason_code;
        this.reason_desc = reason_desc;
    }

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public String getReason_desc() {
		return reason_desc;
	}

	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}

}
