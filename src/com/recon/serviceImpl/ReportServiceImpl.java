package com.recon.serviceImpl;

import java.util.List;
import java.util.Map;

import com.recon.dao.ReportDao;
import com.recon.daoImpl.ReportDaoImpl;
import com.recon.service.ReportService;

public class ReportServiceImpl implements ReportService {

	public List<List<String>> getReportData(String repType, String fromDate, String toDate, String mobileNo, String walletId, String solId)
	{
		ReportDao reportDao = new ReportDaoImpl();
		return reportDao.getReportData(repType, fromDate, toDate, mobileNo, walletId, solId);
	}
	
	public Map<String, String> viewData(String id) {
		ReportDao reportDao = new ReportDaoImpl();
		return reportDao.viewData(id);
	}

}
