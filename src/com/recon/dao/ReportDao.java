package com.recon.dao;

import java.util.List;
import java.util.Map;

public interface ReportDao
{
	public List<List<String>> getReportData(String repType, String fromDate, String toDate, String mobileNo, String walletId, String solId);
	public Map<String, String> viewData(String id);
}
