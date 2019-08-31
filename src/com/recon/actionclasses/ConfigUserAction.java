package com.recon.actionclasses;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.recon.daoImpl.ReconMastersDaoImpl;
import com.recon.entities.TblMstrole;
import com.recon.entities.TblMstuser;
import com.recon.formclasses.ConfigUserForm;
import com.recon.service.GeneralService;
import com.recon.service.ReconMastersService;
import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.serviceImpl.ReconMastersServiceImpl;
import com.recon.utils.AuditTrail;

import com.recon.utils.DBConnectionHandler;

public class ConfigUserAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		ReconMastersService reconMastersService = new ReconMastersServiceImpl();
		ConfigUserForm configUserForm = (ConfigUserForm) form;
		/*configUserForm.setGroup("0");*/
		
		String actionName = configUserForm.getActionName();
		
		if (actionName != null && actionName.equals("add"))
		{
			System.out.println("actionName =  "+actionName);
			
			GeneralService generalService = new GeneralServiceImpl();
			String password = generalService.crypt(configUserForm.getPassword());
			int status = reconMastersService.createUser(configUserForm.getUserId(), configUserForm.getUserName(), configUserForm.getEmail(), configUserForm.getContactNo(), configUserForm.getRole(), password, username);
			if (status == 1)
			{
				configUserForm.setMessage("CS");
				
				Map hm = new HashMap();
				hm.put("USERID", configUserForm.getUserId());
				hm.put("ROLEID", configUserForm.getRole());
				hm.put("NAME", configUserForm.getUserName());
				hm.put("EMAIL", configUserForm.getEmail());
				hm.put("CONTACTNO", configUserForm.getContactNo());
				
				hm.put("STATUS", "SUCCESS");
				
				
				Connection con = DBConnectionHandler.getConnection();
				AuditTrail auditTrail = new AuditTrail();
				auditTrail.addAuditData(con, username, configUserForm.getUserId(), "CREATEUSER","USERCREATESUCCESS", hm);
				
			}
			else if (status == -1)
			{
				configUserForm.setMessage("CF");
			}
			else if (status == -2)
			{
				configUserForm.setMessage("ME");
			}
			else
			{
				configUserForm.setMessage("EE");
			}
		} 
		else if (actionName != null && actionName.equals("update"))
		{
			System.out.println("actionName =  "+actionName);
			GeneralService generalService = new GeneralServiceImpl();
			String password = generalService.crypt(configUserForm.getPassword());
			int status = reconMastersService.updateUser(configUserForm.getUserId(), configUserForm.getUserName(), configUserForm.getEmail(), configUserForm.getContactNo(), configUserForm.getRole(), password, username);
			if (status == 0)
			{
				configUserForm.setMessage("US");
				
				Map hm = new HashMap();
				hm.put("USERID", configUserForm.getUserId());
				hm.put("ROLEID", configUserForm.getRole());
				hm.put("NAME", configUserForm.getUserName());
				hm.put("EMAIL", configUserForm.getEmail());
				hm.put("CONTACTNO", configUserForm.getContactNo());
				
				hm.put("STATUS", "SUCCESS");
				
				
				Connection con = DBConnectionHandler.getConnection();
				AuditTrail auditTrail = new AuditTrail();
				auditTrail.addAuditData(con, username, configUserForm.getUserId(), "UPDATEUSER","USERUPDATEDSUCCESS", hm);
			}
			else
			{
				configUserForm.setMessage("UF");
			}
		}
		else if (actionName != null && actionName.equals("delete"))
		{
			System.out.println("actionName =  "+actionName);
			int status = reconMastersService.deleteUser(configUserForm.getUserId());
			if (status == 0)
			{
				configUserForm.setMessage("DS");
			}
			else
			{
				configUserForm.setMessage("DF");
			}
		}
		else if (actionName != null && actionName.equals("edit"))
		{
			System.out.println("actionName =  "+actionName);
			GeneralService generalService = new GeneralServiceImpl();
			List<TblMstuser> users = reconMastersService.getUserData("userid", configUserForm.getUserId());
			if (users != null && users.size() > 0)
			{
				TblMstuser tblMstuser = users.get(0);
				configUserForm.setUserId(tblMstuser.getUserid());
				configUserForm.setUserName(tblMstuser.getFullName());
				configUserForm.setEmail(tblMstuser.getEmailId());
				configUserForm.setContactNo(tblMstuser.getContactNo());
				/*configUserForm.setSol_id(tblMstuser.getSol_id());*/
				String role = tblMstuser.getRole_id().toString();			
				configUserForm.setSelectedRole(role);
				String password = generalService.decrypt(tblMstuser.getPassword());
				configUserForm.setPassword(password);				
			}
		}
		else if (actionName != null && actionName.equals("search"))
		{			
			List<List<String>> userData = reconMastersService.getUserList(configUserForm.getUserId(),configUserForm.getUserName(),configUserForm.getEmail(),configUserForm.getRole());
			
			if (userData != null && userData.size() > 0)
			{
				List<String> headerNames =  userData.get(0);
				request.setAttribute("headerNames", headerNames);
				userData.remove(0);			
			}
			else 
			{
				userData = null;
				configUserForm.setMessage("NoData");
			}
		
			request.setAttribute("userData", userData);
		}
		
		ReconMastersDaoImpl obj = new ReconMastersDaoImpl();
		List<List<String>> userData = obj.getUserListByDefault();
		
		if (userData != null && userData.size() > 0) {
			List<String> headerNames =  userData.get(0);
			request.setAttribute("headerNames", headerNames);
			userData.remove(0);
			System.out.println("headerNames in Action class "+headerNames);
			request.setAttribute("userData", userData);
		} 
		
		else {
			userData = null;
			configUserForm.setMessage("NoData");
		}
		
		List<TblMstrole> roles = reconMastersService.getRoles();
		request.setAttribute("roles", roles);
		
		return mapping.findForward("success");
	}
}
