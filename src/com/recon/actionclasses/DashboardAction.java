
package com.recon.actionclasses;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.recon.formclasses.DashboardForm;
import com.recon.service.DashboardService;
import com.recon.serviceImpl.DashboardServiceImpl;


public class DashboardAction extends Action {

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		
		//DashboardForm dashboardForm = (DashboardForm) form;
		
		DashboardService dashboardService = new DashboardServiceImpl();
		
		//String userId = (String)session.getAttribute("username");
		Map<String, Object> dashboardData = dashboardService.getDashBoardDetails("admin");
		
		request.setAttribute("dashboardData", dashboardData);
		
		/*dashboardForm.setTodTxnCnt((String)dashboardData.get("todTxnCnt"));
		dashboardForm.setTodTxnVal((String)dashboardData.get("todTxnVal"));
		dashboardForm.setYesPendtAmt((String)dashboardData.get("yesPendtAmt"));
		dashboardForm.setYesRefAmt((String)dashboardData.get("yesRefAmt"));
		dashboardForm.setYesSettAmt((String)dashboardData.get("yesSettAmt"));*/
		
		return mapping.findForward("success");
	}
}
