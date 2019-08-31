
package com.recon.actionclasses;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

import com.recon.entities.TblMstuser;
import com.recon.formclasses.LoginPageForm;
import com.recon.service.GeneralService;
import com.recon.service.MenuService;
import com.recon.service.UserService;
import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.serviceImpl.MenuServiceImpl;
import com.recon.serviceImpl.UserServiceImpl;
import com.recon.utils.AuditTrail;
import com.recon.utils.DBConnectionHandler;


public class LoginPageAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			 {
		
		HttpSession session = request.getSession(true);
		String key = "fail";
		LoginPageForm loginPageForm = (LoginPageForm) form;
		
		String actionName = request.getParameter("actionName");
		System.out.println("ActionName----->"+actionName);
		
		if (actionName != null && actionName.equals("loginPage")) 
		{		
			TblMstuser tblMstuser =  new TblMstuser();
			
			GeneralService generalService = new GeneralServiceImpl();
			String password = generalService.crypt(loginPageForm.getPassword());
			
			tblMstuser.setUserid(loginPageForm.getUsername());
			tblMstuser.setPassword(password);
			
			UserService userService = new UserServiceImpl();
			tblMstuser = userService.loginInformation(tblMstuser);
			if (tblMstuser == null)
			{
				key = "fail";
				request.setAttribute("loginStatus", false);
				loginPageForm.setMessage("Invalid Username Or Password");
			}
			else if (tblMstuser.getRole_id() != null){
				request.setAttribute("loginStatus", true);
				loginPageForm.setMessage("");
				session.setAttribute("username", loginPageForm.getUsername());
				session.setAttribute("fullname", tblMstuser.getFullName());
				session.setAttribute("roleid", tblMstuser.getRole_id());
				 MenuService menuService =  new MenuServiceImpl();
				Map<String, List<String>> menuMap = menuService.getMenuByRole(tblMstuser.getRole_id());
				session.setAttribute("menuMap", menuMap);
				
				/* DashboardService dashboardService = new DashboardServiceImpl();
				Map<String, Object> dashboardData = dashboardService.getDashBoardDetails(loginPageForm.getUsername());
				Map<String, Object> dashboardMap = (Map<String, Object>)dashboardData.get("dashboardSummary");
				List<List<String>> lineChartData = (List<List<String>>)dashboardData.get("lineChartData");
				Map<String, Object> pieChartData = (Map<String, Object>)dashboardData.get("pieChartData");
				request.setAttribute("dashboardData", dashboardMap);
				request.setAttribute("lineChartData", lineChartData);
				request.setAttribute("pieChartData", pieChartData);*/
				
				
				Map hm = new HashMap();
				hm.put("USERID", loginPageForm.getUsername());
				hm.put("FULLNAME", tblMstuser.getFullName());
				hm.put("ROLEID", tblMstuser.getRole_id());
				hm.put("STATUS", "SUCCESS");
				
				
				Connection con = DBConnectionHandler.getConnection();
				AuditTrail auditTrail = new AuditTrail();
				auditTrail.addAuditData(con, loginPageForm.getUsername(), loginPageForm.getUsername(), "USERLOGIN","LOGINSUCCESS", hm);
				
				key = "success";
			}
			
			
			loginPageForm.resetLoginForm(mapping, request);
		} 	
		else if (actionName != null && actionName.equals("forgot"))
		{
			key = "forgot";
		} 
		else
		{
			loginPageForm.setMessage("");
		}
		
		return mapping.findForward(key);
	}
}
