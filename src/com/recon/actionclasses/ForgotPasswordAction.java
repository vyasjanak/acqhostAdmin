package com.recon.actionclasses;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.recon.formclasses.LoginPageForm;
import com.recon.service.GeneralService;
import com.recon.serviceImpl.GeneralServiceImpl;

public class ForgotPasswordAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String key = "success";

		HttpSession session = request.getSession();
		
		LoginPageForm loginPageForm = (LoginPageForm) form;
		
		String actionName = loginPageForm.getActionName();
		System.out.println("Forgot : "+actionName);
		
		if (actionName != null && actionName.equals("login"))
		{
			key = "login";
		} 
		else if (actionName != null && actionName.equals("save")) {
			
			String mobileNo = loginPageForm.getEmailForgotPass();	
			if(!mobileNo.equals(""))
			{
				GeneralService generalService =  new GeneralServiceImpl();				
				int status = generalService.forgetPass(mobileNo);
				if (status == 1) {
					loginPageForm.setMessage("SES");
					System.out.println("OTP send successfully----->"+status);
				} else if (status == 2) {
					loginPageForm.setMessage("IMN");
				} else if (status == -1) {
					loginPageForm.setMessage("SEF");
				}else if(status == 3){
					loginPageForm.setMessage("MNA");
				}
			}else{
				loginPageForm.setMessage("Blank");
			}
						
			session.setAttribute("loaderCode", 1);
			key = "success";
			 
		}
		
		return mapping.findForward(key);
	}	
}
