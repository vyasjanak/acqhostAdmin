package com.recon.service;

import java.util.List;
import java.util.Map;

public interface MenuService {
	
	public Map<String, List<String>>  getMenuByRole(Integer  roleId);
}
