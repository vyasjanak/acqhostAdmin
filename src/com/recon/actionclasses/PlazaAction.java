
package com.recon.actionclasses;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import org.json.JSONArray;
import org.json.JSONObject;


import com.recon.daoImpl.plazaDAOImpl;
import com.recon.entities.DropdownBean;
import com.recon.entities.Plaza;
import com.recon.formclasses.PlazaForm;
import com.recon.utils.AuditTrail;

import com.recon.utils.DBConnectionHandler;




public class PlazaAction extends Action {

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession(true);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String key="success";
		String status = null;

		
		PlazaForm plazaForm = (PlazaForm) form;
		plazaDAOImpl plazadao = new plazaDAOImpl();
		
		List<DropdownBean> merchantids = plazadao.getMerchantIds();
		request.setAttribute("merchants", merchantids);
		
		// PlazaForm plazaForm = (PlazaForm) form;
		String id = plazaForm.getId();
		String toll_plaza_id = plazaForm.getToll_plaza_id();
		String merchant_id = plazaForm.getMerchant_id();
		String toll_name = plazaForm.getToll_name();
		String location = plazaForm.getLocation();
		String contact_person = plazaForm.getContact_person();
		String email_id = plazaForm.getEmailid();
		String contact_number = plazaForm.getContactNo();
		String toll_geo_code = plazaForm.getGeoCode();
		String toll_plaza_type = plazaForm.getTollType();
		String settlementType = plazaForm.getSettlementType();
		// System.out.println(" Insert settlementType :::::  "+settlementType);
		
		String acno = plazaForm.getAccountNo();
		String ifsc_code = plazaForm.getIfscCode();
		String bankName = plazaForm.getBankName();
		String acc_type = plazaForm.getAcc_type();
		String add1 = plazaForm.getAdd1();
		String add2 = plazaForm.getAdd2();
		String state = plazaForm.getState();
		String city = plazaForm.getCity();
		String pin = plazaForm.getPin();
		
		String is_active = "1";		
		String created_by = (String)session.getAttribute("username");
		String created_on = timestamp.toString();
		String approved_on = "0";
		String approved_by = (String)session.getAttribute("username");
		String action = plazaForm.getActionName();
		
		
		Plaza plaza = new Plaza();
	    plaza.setId(id);
	    plaza.setToll_plaza_id(toll_plaza_id);
	    plaza.setMerchant_id(merchant_id);
	    plaza.setToll_name(toll_name);
	    plaza.setLocation(location);
	    plaza.setContact_person(contact_person);
	    plaza.setEmailid(email_id);
	    plaza.setContactNo(contact_number);
	    plaza.setGeoCode(toll_geo_code);
	    plaza.setTollType(toll_plaza_type);
	    plaza.setIsActive(is_active);
	    plaza.setSettlementType(settlementType);
	    
	    plaza.setCreatedBy(created_by);
	    plaza.setCreatedOn(created_on);
	    plaza.setApprovedOn(approved_on);
	    plaza.setApprovedBy(approved_by);
	   // plaza.setPlazaid(plazaid);// for approval
	    plaza.setAdd1(add1);
	    plaza.setAdd2(add2);
	    plaza.setState(state);
	    plaza.setCity(city);
	    plaza.setPin(pin);
	    plaza.setAcno(acno);
	    plaza.setIfsc(ifsc_code);
	    plaza.setBankName(bankName);
	    plaza.setAcc_type(acc_type);
	    
	   String msg = null;
	    if(action != null){
				    if(action.equals("addPlaza")){
				    	status = plazadao.addPlaza(plaza);
				    	if(status.equals("1")){
				    		msg = "PCS";
				    		
				    		Map hm = new HashMap();
							hm.put("USERID", created_by);
							hm.put("TOLLPLAZAID", toll_plaza_id);
							hm.put("TOLLNAME", toll_name);
							hm.put("EMAILID", email_id);
							hm.put("CONTACTNO", contact_number);
							hm.put("PLAZATYPE", toll_plaza_type);
							hm.put("lOCATION", location);
							
							hm.put("STATUS", "SUCCESS");
							
							
							Connection con = DBConnectionHandler.getConnection();
							AuditTrail auditTrail = new AuditTrail();
							auditTrail.addAuditData(con, created_by, toll_plaza_id, "CREATEPLAZA","CREATESUCCESS", hm);
				    		
				    		//plazaForm.reset();
				    	}
				    	else if(status.equals("-2"))
				    	{
				    		msg = "EM";
				    	}
				    	else{
				    		msg = "PCF";
				    	}
				    	plazaForm.setMessage(msg);
				    }		
				    
				    else if(action.equals("updatePlaza"))
				    {
				    	// System.out.println("Plaza form pass id while update ::: "+ plaza.getId());
				    	// System.out.println("Update Plaza Action");
				    	
				    	status = plazadao.updatePlaza(plaza);
				    	if(status.equals("1")){
				    		msg = "PUS";
				    		
				    		
				    		Map hm = new HashMap();
				    		hm.put("TOLLPLAZAID", toll_plaza_id);
							hm.put("TOLLNAME", toll_name);
							hm.put("EMAILID", email_id);
							hm.put("CONTACTNO", contact_number);
							hm.put("PLAZATYPE", toll_plaza_type);
							hm.put("lOCATION", location);
							
							hm.put("CONTACTPERSON", contact_person);
							hm.put("TOLLGEOCODE", toll_geo_code);
							hm.put("ADDRESS1", add1);
							hm.put("ADDRESS2", add2);
							hm.put("STATE", state);
							hm.put("CITY", city);
							hm.put("PIN", pin);
							
							hm.put("SETTLEMENTTYPE", settlementType);
							
							
							if(settlementType.equalsIgnoreCase("account"))
							{
								hm.put("ACCOUNTNO", acno);
								hm.put("IFSCCODE", ifsc_code);
								hm.put("BANKNAME", bankName);
								hm.put("ACCOUNTTYPE", acc_type);
							}
							
							hm.put("STATUS", "SUCCESS");
							
							
							Connection con = DBConnectionHandler.getConnection();
							AuditTrail auditTrail = new AuditTrail();
							auditTrail.addAuditData(con, created_by, toll_plaza_id, "UPDATEPLAZA","UPDATESUCCESS", hm);
				    		
							
				    		//plazaForm.reset();
				    	}
				    	
				    	else{
				    		msg = "PUF";
				    	}
				    	plazaForm.setMessage(msg);
				    	
				    }
				    
				    else if (action != null && action.equals("edit")) 
				    {
				    	
				    	List<String> editresult = plazadao.getEditPlazaDetails(plazaForm.getId());
				    	if (editresult != null && editresult.size() > 0) {
				    	
				    		// start with  id  which index is 0 
				    		// System.out.println("set id in plazaForm = "+String.valueOf(editresult.get(0)));
				    	plazaForm.setId(String.valueOf(editresult.get(0)));	
				    	
				    	plazaForm.setToll_plaza_id(String.valueOf(editresult.get(1)));
				    	plazaForm.setMerchant_id(String.valueOf(editresult.get(2)));
				    	plazaForm.setToll_name(String.valueOf(editresult.get(3)));
				    	plazaForm.setLocation(String.valueOf(editresult.get(4)));
				    	plazaForm.setContact_person(String.valueOf(editresult.get(5)));
				    	plazaForm.setEmailid(String.valueOf(editresult.get(6)));
				    	plazaForm.setContactNo(String.valueOf(editresult.get(7)));
				    	plazaForm.setGeoCode(String.valueOf(editresult.get(8)));
				    	plazaForm.setTollType(String.valueOf(editresult.get(9)));
				    	plazaForm.setSettlementType(String.valueOf(editresult.get(10)));
				    	// System.out.println("edit settlementType : "+ String.valueOf(editresult.get(10)));
				    	// Address 
				    	plazaForm.setAdd1(String.valueOf(editresult.get(11)));
				    	plazaForm.setAdd2(String.valueOf(editresult.get(12)));
				    	plazaForm.setState(String.valueOf(editresult.get(13)));
				    	plazaForm.setCity(String.valueOf(editresult.get(14)));
				    	plazaForm.setPin(String.valueOf(editresult.get(15)));
				    	
				    	if(editresult.size() > 16)
				    	{
				    		// System.out.println("editresult size greater then 16 as Account Details");
				    		plazaForm.setBankName(String.valueOf(editresult.get(16)));
				    		plazaForm.setAccountNo(String.valueOf(editresult.get(17)));
				    		plazaForm.setIfscCode(String.valueOf(editresult.get(18)));
				    		plazaForm.setAcc_type(String.valueOf(editresult.get(19)));
				    	}
				    	
				    	request.setAttribute("edit","edit");
				    	}
						return mapping.findForward("addNewPlazaForm");
				    }
				    		
				    
				    else if(action.equals("delete"))
				    {
				    	System.out.println("Delete Plaza");
						String result = plazadao.deletePlazaDetails(plazaForm.getId());

						if (result.equals("deletesuccess")) {
							plazaForm.setMessage("PDS");
							//plazaForm.reset();
						} else {
							plazaForm.setMessage("PDF");
						}
						// return mapping.findForward("success");
				    }
				    
				    else if(action.equals("addNewPlazaForm"))
				    {			    	
				    	return mapping.findForward("addNewPlazaForm");
				    }		
	    	}
	    	/*else{
	    	  return mapping.findForward("fail");	
	    	} */
	   
	 		
	 		List<List<String>> plazaData = plazadao.getPlazaDetails();  // Showing Data
	 		if(plazaData != null && plazaData.size() > 1) { 
	 			List<String> headerNames =  plazaData.get(0);
	 			request.setAttribute("headerNames", headerNames);
	 			plazaData.remove(0);
	 		} else {
	 			plazaData = null;
	 			plazaForm.setMessage("NoData");
	 		}
	 		
	 		request.setAttribute("plazaData", plazaData);
	 
	   return mapping.findForward("success");	
		
	}
}
