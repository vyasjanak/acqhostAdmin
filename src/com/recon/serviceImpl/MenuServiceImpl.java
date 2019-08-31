package com.recon.serviceImpl;

import java.util.List;
import java.util.Map;

import com.recon.dao.MenuDao;
import com.recon.daoImpl.MenuDaoImpl;
import com.recon.service.MenuService;

public class MenuServiceImpl implements MenuService {
	
	public Map<String, List<String>>  getMenuByRole(Integer  roleId) {
		MenuDao  menuDao = new MenuDaoImpl();
		return menuDao.getMenuByRole(roleId);
	}

}
