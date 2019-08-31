package com.recon.actionclasses;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import com.recon.daoImpl.MerchantMasterDaoImpl;
import com.recon.entities.TblAccountMaster;
import com.recon.entities.TblMstuser;
import com.recon.service.GeneralService;
import com.recon.service.MerchantMasterService;
import com.recon.service.ReportService;
import com.recon.service.UserService;

import com.recon.serviceImpl.GeneralServiceImpl;
import com.recon.serviceImpl.ReportServiceImpl;
import com.recon.serviceImpl.UserServiceImpl;

import com.recon.servlets.UserValidation;


public class AjaxAction extends Action{
	  
	@Override
	  public ActionForward execute(ActionMapping mapping, ActionForm form,
	      HttpServletRequest request, HttpServletResponse response)
	      throws Exception {
		  
		  HttpSession session = request.getSession(true);
		  String username = (String)session.getAttribute("username");
	    
		  PrintWriter out = response.getWriter();
		  
	      String type = request.getParameter("type");
	      System.out.println("AjaxAction.java ::: Action Type -------> "+type);
	      
	     
	       
	     
	       if (type != null && type.equals("changePassword"))
	      {
	    	  String status = "C";
	    	  String oldPassword = request.getParameter("oldPassword");
	    	  GeneralService generalService = new GeneralServiceImpl();
			  oldPassword = generalService.crypt(oldPassword);
				
	    	  UserService userService = new UserServiceImpl();
	    	  
	    	  TblMstuser tblMstuser = new TblMstuser();
	    	  tblMstuser.setUserid(username);
	    	  tblMstuser.setPassword(oldPassword);
	    	  
	    	  tblMstuser = userService.loginInformation(tblMstuser);
	    	  if (tblMstuser == null) {
	    		  status = "";
	    	  }
	    	  out.print(status);
	      }
	       
	       else if (type != null && type.equals("getIFSC")) {
	    	   
	    	   System.out.println("AjaxAction getIFSC");
		    	  String status = "N";
		    	  String bank_name = request.getParameter("bank_name");
		    	  MerchantMasterDaoImpl merchantMasterDao = new MerchantMasterDaoImpl();
		    	 // status = merchantService.validateSPBankCategory(spId, instrumentId, bankId,categoryId);
		    	  status = merchantMasterDao.getIFSC(bank_name);
		    	   out.print(status);
		      } 
	      
	      
	       
	      return null;
	    }
}
