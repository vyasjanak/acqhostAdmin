package com.recon.actionclasses;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.recon.daoImpl.UserDaoImpl;
import com.recon.formclasses.ChangePasswordForm;
import com.recon.service.GeneralService;
import com.recon.service.UserService;
import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.serviceImpl.UserServiceImpl;
import com.recon.utils.AuditTrail;

import com.recon.utils.DBConnectionHandler;

public class ChangePasswordAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		ChangePasswordForm changePasswordForm = (ChangePasswordForm) form;
		
		String key = "success";
		String actionName = changePasswordForm.getActionName();
		if (actionName != null && actionName.equals("save"))
		{
			String userId = (String)session.getAttribute("username");
			int status = -1;
			
			String oldPassword = changePasswordForm.getOldPassword();
			String newPassword = changePasswordForm.getNewPassword();
			String confPassword = changePasswordForm.getConfPassword();
			
			if (oldPassword != null && newPassword != null && confPassword != null)
			{
				if (!oldPassword.equalsIgnoreCase(newPassword))
				{
					if (newPassword.equals(confPassword)) 
					{
						GeneralService generalService = new GeneralServiceImpl();
						oldPassword = generalService.crypt(oldPassword);
						newPassword = generalService.crypt(newPassword);
						UserService userService = new UserServiceImpl();
						status = userService.changePassword(userId, oldPassword, newPassword);
						if (status == 1)
						{
							changePasswordForm.setMessage("PassChangedSucc");
							String roleid = session.getAttribute("roleid").toString();
							
							Map hm = new HashMap();
							hm.put("USERID", userId);
							hm.put("ROLEID", roleid);
							hm.put("STATUS", "SUCCESS");
							
							
							Connection con = DBConnectionHandler.getConnection();
							AuditTrail auditTrail = new AuditTrail();
							auditTrail.addAuditData(con, userId, userId, "USERCHANGEPASSWORD","CHANGESUCCESS", hm);
						}
						else
						{
							changePasswordForm.setMessage("PassChangedFail");
						} 
					}
					else 
					{
						changePasswordForm.setMessage("PassMismatch");
					} 
				}
				else 
				{
					changePasswordForm.setMessage("SamePassword");
				} 
			}
			else
			{
				changePasswordForm.setMessage("PassFieldsNull");
			}
		}
		else if (actionName != null && actionName.equals("login"))
		{
			key = "login";
			session.removeAttribute("username");
	        session.invalidate();
		}
		
		return mapping.findForward(key);
	}
}
