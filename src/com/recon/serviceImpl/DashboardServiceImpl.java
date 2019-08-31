package com.recon.serviceImpl;

import java.util.List;
import java.util.Map;

import com.recon.dao.DashboardDao;
import com.recon.daoImpl.DashboardDaoImpl;
import com.recon.service.DashboardService;

public class DashboardServiceImpl implements  DashboardService
{
	public Map<String, Object> getDashBoardDetails(String userId)
	{
		DashboardDao dashboardDao = new DashboardDaoImpl();
		return dashboardDao.getDashBoardDetails(userId);
	}
	                                                  
}
