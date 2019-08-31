package com.recon.dao;

import java.util.List;
import java.util.Map;

public interface MenuDao {
	public Map<String, List<String>>  getMenuByRole(Integer  roleId);
}
