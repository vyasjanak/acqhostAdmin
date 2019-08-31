package com.recon.actionclasses;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.recon.entities.TblMstmenu;
import com.recon.entities.TblMstrole;
import com.recon.formclasses.ConfigRoleForm;
import com.recon.service.ReconMastersService;
import com.recon.serviceImpl.ReconMastersServiceImpl;

public class ConfigRoleAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		ReconMastersService reconMastersService = new ReconMastersServiceImpl();
		ConfigRoleForm configRoleForm = (ConfigRoleForm) form;
		/*configRoleForm.setGroup("0");
		configRoleForm.setLevel("");*/
		
		String actionName = configRoleForm.getActionName();
		
		if (actionName != null && actionName.equals("add")) {
			System.out.println("ConfigRoleAction actionName =   "+actionName);
			int status = reconMastersService.createRole(configRoleForm.getRoleName(), configRoleForm.getSelectedMenus(), 
					configRoleForm.getStatus(),username);
			if (status == 0) {
				configRoleForm.setMessage("CS");
			} else {
				configRoleForm.setMessage("CF");
			}
		} else if (actionName != null && actionName.equals("update")) {
			System.out.println("ConfigRoleAction actionName =   "+actionName);
			int status = reconMastersService.updateRole(configRoleForm.getRoleId(), configRoleForm.getRoleName(), configRoleForm.getSelectedMenus(), 
					configRoleForm.getStatus(),username);
			if (status == 0) {
				configRoleForm.setMessage("US");
			} else {
				configRoleForm.setMessage("UF");
			}
		} else if (actionName != null && actionName.equals("delete")) {
			System.out.println("ConfigRoleAction actionName =   "+actionName);
			int status = reconMastersService.deleteRole(configRoleForm.getRoleId());
			if (status == 0) {
				configRoleForm.setMessage("DS");
			} else {
				configRoleForm.setMessage("DF");
			}
		} else if (actionName != null && actionName.equals("edit")) {
			System.out.println("ConfigRoleAction actionName =   "+actionName);
			List<TblMstrole> roles = reconMastersService.getRoleData("roleid", configRoleForm.getRoleId());
			if (roles != null && roles.size() > 0) {
				TblMstrole tblMstrole = roles.get(0);
				configRoleForm.setRoleId(tblMstrole.getRoleid().toString());
				configRoleForm.setRoleName(tblMstrole.getRolename());
				//configRoleForm.setLevel(tblMstrole.getLevel());
				//configRoleForm.setSelectedGroup(tblMstrole.getGroupId().toString());
				configRoleForm.setSelectedMenus(tblMstrole.getMenuId());
				configRoleForm.setStatus(tblMstrole.getStatus());
			}
		}
		
		List<List<String>> roleData = reconMastersService.getRoleList();
		
		if (roleData != null && roleData.size() > 0) {
			List<String> headerNames =  roleData.get(0);
			request.setAttribute("headerNames", headerNames);
			roleData.remove(0);
		} else {
			roleData = null;
			configRoleForm.setMessage("NoData");
		}
		
		request.setAttribute("roleData", roleData);
		
		List<TblMstmenu> menus = reconMastersService.getMenus();
		request.setAttribute("menus", menus);
		
		return mapping.findForward("success");
	}
}
