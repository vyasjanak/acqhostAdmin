package com.recon.actionclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.recon.daoImpl.GeneralDaoImpl;
import com.recon.daoImpl.MerchantMasterDaoImpl;
import com.recon.entities.DropdownBean;
import com.recon.entities.MDRMaster;
import com.recon.entities.TblAccountMaster;
import com.recon.entities.TblStateMaster;

import com.recon.entities.TblAddressMaster;

import com.recon.entities.TblMerchantMaster;

import com.recon.formclasses.MerchantMasterForm;
import com.recon.service.GeneralService;
import com.recon.service.IdService;

import com.recon.service.MerchantMasterService;
import com.recon.serviceImpl.GeneralServiceImpl;

import com.recon.serviceImpl.MerchantMasterServiceImpl;
import com.recon.utils.AcqHostUtils;
import com.recon.utils.AuditTrail;
import com.recon.utils.DBConnectionHandler;

public class MerchantMasterAction extends Action
{
	
	private static final String NUMERIC_STRING = "0123456789";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException, IllegalAccessException, InvocationTargetException 
	{
		
		HttpSession session = request.getSession(true);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		MerchantMasterService merchantMasterService = new MerchantMasterServiceImpl();

		GeneralDaoImpl daoipml = new GeneralDaoImpl();
		List<DropdownBean> bankNames = daoipml.getBankNames();
		request.setAttribute("bankNames", bankNames);
		
		MerchantMasterForm merchantMasterForm = (MerchantMasterForm) form;
		String actionName = merchantMasterForm.getActionName();
		 if (actionName != null && actionName.equals("addNew")) {
			return mapping.findForward("addNew");
		 }

		if (actionName != null && actionName.equals("createMerchant")) 
		{
		
			System.out.println("MerchantMasterAction.java ::: createMerchant ");
			String location[] = merchantMasterForm.getLocation().split(",");
			
			// System.out.println("City : "+location[0]+" :: State : "+location[1]);
			String createdBy = (String)session.getAttribute("username");
			IdService idservice = new IdService();
			String merchantId = idservice.createMerchantId();
			String activaction_key = AcqHostUtils.randomAlphaNumeric(16);
			System.out.println("activaction_key "+activaction_key+"  activaction_key length "+activaction_key.length());
			
			// Merchant_Master
			TblMerchantMaster tblMerchantMaster = new TblMerchantMaster();
			
			tblMerchantMaster.setMerchant_id(merchantId);
			tblMerchantMaster.setActivaction_key(activaction_key);
			tblMerchantMaster.setMerchant_name(merchantMasterForm.getCust_name());
			tblMerchantMaster.setContact_person(merchantMasterForm.getContact_person());
			tblMerchantMaster.setContact_number(merchantMasterForm.getPhone());
			tblMerchantMaster.setEmail_id(merchantMasterForm.getEmail_id());
			tblMerchantMaster.setCreated_on(timestamp);
			tblMerchantMaster.setCreated_by(createdBy);
			 tblMerchantMaster.setIs_deleted("N");
			 
			// tblWalletMaster.setApproved_on(timestamp);
			// tblWalletMaster.setApproved_by(createdBy);

			// AddressMaster
			TblAddressMaster tblAddressMaster = new TblAddressMaster();
			
			tblAddressMaster.setEntity_id(merchantId);
			tblAddressMaster.setAddress1(merchantMasterForm.getAddress1());
			tblAddressMaster.setAddress2(merchantMasterForm.getAddress1());
			tblAddressMaster.setCity(location[0]);
			tblAddressMaster.setState(location[1]);	
			tblAddressMaster.setPin(merchantMasterForm.getPin());
			tblAddressMaster.setCreatedOn(timestamp);
			tblAddressMaster.setCreatedBy(createdBy);
			//tblAddressMaster.setModifiedOn(timestamp);
			//tblAddressMaster.setModifiedBy(createdBy);
			//tblAddressMaster.setIsDeleted("N");
			
			// Bharat MDR
			System.out.println("From Date : "+request.getParameter("from_date"));
			System.out.println("TO Date   : "+request.getParameter("to_date"));
			
			
			MDRMaster mdrMaster = new MDRMaster();
			
			System.out.println("From Date : "+merchantMasterForm.getFrom_date());
			System.out.println("TO Date   : "+merchantMasterForm.getTo_date());
			
			mdrMaster.setMerchant_id(merchantId);
			mdrMaster.setBase_mdr(merchantMasterForm.getBase_mdr());
			mdrMaster.setTsp_mdr(merchantMasterForm.getTsp_mdr());
			mdrMaster.setMdr_type(merchantMasterForm.getMdr_type());
			Date fromDate = null;
			Date toDate = null;
			try {
				fromDate = sdf.parse(merchantMasterForm.getFrom_date());
				toDate = sdf.parse(merchantMasterForm.getTo_date());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			// mdrMaster.setFrom_date(merchantMasterForm.getFrom_date());
			// mdrMaster.setTo_date(merchantMasterForm.getTo_date());
			
			Timestamp fromDateTS = new Timestamp(fromDate.getTime());
			Timestamp toDateTS = new Timestamp(toDate.getTime());
			
			mdrMaster.setFrom_date(fromDateTS);
			mdrMaster.setTo_date(toDateTS);
			
			mdrMaster.setIs_active(merchantMasterForm.getIs_active());
			
			// AccountMaster
			TblAccountMaster tblAccountMaster = new TblAccountMaster();
			
			tblAccountMaster.setMerchant_id(merchantId);
			tblAccountMaster.setAccount_number(merchantMasterForm.getAccount_number());
			tblAccountMaster.setBank_name(merchantMasterForm.getBank_name());
			tblAccountMaster.setAcc_type(merchantMasterForm.getAcc_type());
			tblAccountMaster.setIfsc_code(merchantMasterForm.getIFSC()+merchantMasterForm.getIfsc_code());
			System.out.println("While Insert IFSC "+merchantMasterForm.getIFSC());
			tblAccountMaster.setCreated_on(timestamp);
			tblAccountMaster.setCreated_by(createdBy);
			

		 int status = merchantMasterService.saveOrUpdateMerchant("save",tblMerchantMaster,tblAddressMaster,mdrMaster,tblAccountMaster);
			/*int status = 1;*/
			System.out.println("status------>"+status);

			if (status == 1) 
			{
				merchantMasterForm.setMessage("CS");
				
				Map hm = new HashMap();
				hm.put("USERID", createdBy);
				hm.put("ROLEID", "2");
				hm.put("NAME", merchantMasterForm.getCust_name());
				hm.put("EMAIL", merchantMasterForm.getEmail_id());
				hm.put("CONTACTNO", merchantMasterForm.getMobileNo());
				hm.put("CONTACTPERSON", merchantMasterForm.getContact_person());
				
				hm.put("ADDRESS1", merchantMasterForm.getAddress1());
				hm.put("ADDRESS2", merchantMasterForm.getLocation());
				hm.put("CITY", location[0]);
				hm.put("STATE", location[1]);
				hm.put("PIN", merchantMasterForm.getPin());
				
				hm.put("STATUS", "SUCCESS");
				
				
				Connection con = DBConnectionHandler.getConnection();
				AuditTrail auditTrail = new AuditTrail();
				auditTrail.addAuditData(con, createdBy, merchantId, "CONCESSIONERCREATE","CONCESSIONERCREATESUCCESS", hm);
				
				merchantMasterForm.reset();
			}
			else if(status == -1) 
			{
				merchantMasterForm.setMessage("CF");
			}
			else if(status == -2) 
			{
				merchantMasterForm.setMessage("EM");
			}
			else
			{
				merchantMasterForm.setMessage("EE");
			}
		}
		
		
		else if (actionName != null && actionName.equals("edit")) {
			
			String id = merchantMasterForm.getId();
			
			List<Object> merchants = merchantMasterService.findByProperty("id", Integer.parseInt(id), "TblMerchantMaster");
			
			if (merchants != null && merchants.size() > 0) {
				TblMerchantMaster tblMerchantMaster = (TblMerchantMaster)merchants.get(0);
				
				String merchantId = tblMerchantMaster.getMerchant_id();
				// System.out.println("while Edit  MerchantID : "+merchantId+"    ID : "+id);
				merchantMasterForm.setMerchantId(merchantId);
				merchantMasterForm.setId(id);
				merchantMasterForm.setCust_name(tblMerchantMaster.getMerchant_name());
				
				merchantMasterForm.setContact_person(tblMerchantMaster.getContact_person());
				merchantMasterForm.setEmail_id(tblMerchantMaster.getEmail_id());
				merchantMasterForm.setPhone(tblMerchantMaster.getContact_number());
				
				
				TblAddressMaster tblAddressMaster = (TblAddressMaster)merchantMasterService.findByProperty("entity_id", merchantId, "TblAddressMaster").get(0); 
				merchantMasterForm.setAddress1(tblAddressMaster.getAddress1());
				String city = tblAddressMaster.getCity();
				String state = tblAddressMaster.getState();
				merchantMasterForm.setLocation(city+","+state);
				// merchantMasterForm.setLocation(tblAddressMaster.getAddress2());
				
				merchantMasterForm.setPin(tblAddressMaster.getPin());
				// merchantMasterForm.setState(tblAddressMaster.getState());
				// merchantMasterForm.setCity(tblAddressMaster.getCity());
				
				
				
				/*	List<Object> objMerchantMdrs = merchantMasterService.findByProperty("merchantId", merchantId, "TblMerchantMdr");
				List<TblMerchantMdr> merchantMdrs = new ArrayList<TblMerchantMdr>();
				for (int i = 0; i < objMerchantMdrs.size(); i++) {
					TblMerchantMdr merchantMdr = (TblMerchantMdr)objMerchantMdrs.get(i);
					merchantMdrs.add(merchantMdr);
				}
				request.setAttribute("merchantMdrs", merchantMdrs);
				*/
				
				MDRMaster mdrMaster = (MDRMaster)merchantMasterService.findByProperty("merchant_id", merchantId, "MDRMaster").get(0);
				
				merchantMasterForm.setBase_mdr(mdrMaster.getBase_mdr());
				merchantMasterForm.setTsp_mdr(mdrMaster.getTsp_mdr());
				merchantMasterForm.setMdr_type(mdrMaster.getMdr_type());
				
				String efromDate  = "";
				String etoDate  = "";
				Date fDate = new Date(mdrMaster.getFrom_date().getTime());
				Date tDate = new Date(mdrMaster.getTo_date().getTime());
				efromDate = sdf.format(fDate);
				etoDate = sdf.format(tDate);
				System.out.println("Edit From Date String "+efromDate);
				System.out.println("Edit To Date String "+etoDate);
				merchantMasterForm.setFrom_date(efromDate);
				//merchantMasterForm.setFrom_date(fromDate);
				//merchantMasterForm.setTo_date(toDate);
				merchantMasterForm.setIs_active(mdrMaster.getIs_active());
				
				
				TblAccountMaster tblAccountMaster = (TblAccountMaster)merchantMasterService.findByProperty("merchant_id", merchantId, "TblAccountMaster").get(0);
				
				merchantMasterForm.setAccount_number(tblAccountMaster.getAccount_number());
				merchantMasterForm.setBank_name(tblAccountMaster.getBank_name());
				merchantMasterForm.setAcc_type(tblAccountMaster.getAcc_type());
				String ifsc_code_str = tblAccountMaster.getIfsc_code();
				String IFSC = ifsc_code_str.substring(0,4);
				String ifsc_code = ifsc_code_str.substring(4);
					System.out.println("IFSC :::  "+ifsc_code_str.substring(0,4)); // 0 to 4 character
				   System.out.println("ifsc_code  :::  "+ifsc_code_str.substring(4));  // after 4 character
				   
				merchantMasterForm.setIFSC(IFSC);  
				merchantMasterForm.setIfsc_code(ifsc_code);
				
			}
			
			request.setAttribute("edit","edit");
			return mapping.findForward("addNew");
		}
		
		else if (actionName != null && actionName.equals("updateMerchant")) {
			String createdBy = (String)session.getAttribute("username");
			
			String id = merchantMasterForm.getId();
		//	System.out.println("createdBy    "+createdBy+"    Id    "+id);
			
			List<Object> merchants = merchantMasterService.findByProperty("id", Integer.parseInt(id), "TblMerchantMaster"); 
			if (merchants != null && merchants.size() > 0) {
				
				TblMerchantMaster tblMerchantMaster = (TblMerchantMaster)merchants.get(0);
				
				String merchantId = tblMerchantMaster.getMerchant_id();
				tblMerchantMaster.setMerchant_id(merchantId);
				tblMerchantMaster.setMerchant_name(merchantMasterForm.getCust_name());
				tblMerchantMaster.setContact_person(merchantMasterForm.getContact_person());
				tblMerchantMaster.setContact_number(merchantMasterForm.getPhone());
				tblMerchantMaster.setEmail_id(merchantMasterForm.getEmail_id());
				tblMerchantMaster.setCreated_on(timestamp);
				tblMerchantMaster.setCreated_by(createdBy);
				tblMerchantMaster.setIs_deleted("N");
				
				// Address
				String location[] = merchantMasterForm.getLocation().split(",");
				System.out.println("City : "+location[0]+" :: State : "+location[1]);
				
				TblAddressMaster tblAddressMaster = (TblAddressMaster)merchantMasterService.findByProperty("entity_id", merchantId, "TblAddressMaster").get(0); 
				tblAddressMaster.setEntity_id(merchantId);
				tblAddressMaster.setAddress1(merchantMasterForm.getAddress1());
				tblAddressMaster.setAddress2(merchantMasterForm.getAddress1());
				tblAddressMaster.setCity(location[0]);
				tblAddressMaster.setState(location[1]);	
				tblAddressMaster.setPin(merchantMasterForm.getPin());
				// tblAddressMaster.setCreatedOn(timestamp);
				// tblAddressMaster.setCreatedBy(createdBy);
				
				
				MDRMaster mdrMaster = (MDRMaster)merchantMasterService.findByProperty("merchant_id", merchantId, "MDRMaster").get(0);
				mdrMaster.setMerchant_id(merchantId);
				mdrMaster.setBase_mdr(merchantMasterForm.getBase_mdr());
				mdrMaster.setTsp_mdr(merchantMasterForm.getTsp_mdr());
				Date fromDate = null;
				Date toDate = null;
				try {
					fromDate = sdf.parse(merchantMasterForm.getFrom_date());
					toDate = sdf.parse(merchantMasterForm.getTo_date());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Timestamp fromDateTS = new Timestamp(fromDate.getTime());
				Timestamp toDateTS = new Timestamp(toDate.getTime());
				
				mdrMaster.setFrom_date(fromDateTS);
				mdrMaster.setTo_date(toDateTS);
				//mdrMaster.setFrom_date(merchantMasterForm.getFrom_date());
				//mdrMaster.setTo_date(merchantMasterForm.getTo_date());
				mdrMaster.setMdr_type(merchantMasterForm.getMdr_type());
				mdrMaster.setIs_active(merchantMasterForm.getIs_active());
				
				
				TblAccountMaster tblAccountMaster = (TblAccountMaster)merchantMasterService.findByProperty("merchant_id", merchantId, "TblAccountMaster").get(0);
			
				tblAccountMaster.setMerchant_id(merchantId);
				tblAccountMaster.setAccount_number(merchantMasterForm.getAccount_number());
				tblAccountMaster.setBank_name(merchantMasterForm.getBank_name());
				tblAccountMaster.setAcc_type(merchantMasterForm.getAcc_type());
				tblAccountMaster.setIfsc_code(merchantMasterForm.getIFSC()+merchantMasterForm.getIfsc_code());
				tblAccountMaster.setCreated_on(timestamp);
				tblAccountMaster.setCreated_by(createdBy);
				
				int status = merchantMasterService.saveOrUpdateMerchant("update", tblMerchantMaster, tblAddressMaster, mdrMaster,tblAccountMaster);
				if (status == 1) {
					merchantMasterForm.setMessage("US");
					
					Map hm = new HashMap();
					hm.put("USERID", createdBy);
					hm.put("ROLEID", "2");
					hm.put("NAME", merchantMasterForm.getCust_name());
					hm.put("EMAIL", merchantMasterForm.getEmail_id());
					hm.put("CONTACTNO", merchantMasterForm.getMobileNo());
					hm.put("CONTACTPERSON", merchantMasterForm.getContact_person());
					
					hm.put("ADDRESS1", merchantMasterForm.getAddress1());
					hm.put("ADDRESS2", merchantMasterForm.getLocation());
					hm.put("CITY", location[0]);
					hm.put("STATE", location[1]);
					hm.put("PIN", merchantMasterForm.getPin());
					
					hm.put("STATUS", "SUCCESS");
					
					
					Connection con = DBConnectionHandler.getConnection();
					AuditTrail auditTrail = new AuditTrail();
					auditTrail.addAuditData(con, createdBy, merchantId, "CONCESSIONERUPDATE","CONCESSIONERUPDATESUCCESS", hm);
					
					
				} else {
					merchantMasterForm.setMessage("UF");
				}
				System.out.println("status------>"+status);
			}
		}
		
		else if (actionName != null && actionName.equals("delete")) {
			// System.out.println("Merchant Deleted");
			String id = merchantMasterForm.getId();
			// int status = merchantService.deleteMerchant(id);
			MerchantMasterDaoImpl merchantDao = new MerchantMasterDaoImpl();
			int status = merchantDao.deleteMerchant(id);
			if (status == 1) {
				merchantMasterForm.setMessage("DS");
			} else {
				merchantMasterForm.setMessage("DF");
			}
			
		}
		
	
		getMerchantData(merchantMasterForm, request);  // Default List
		return mapping.findForward("success");
	}

	
	private void getMerchantData(MerchantMasterForm merchantMasterForm, HttpServletRequest request) {
		
		MerchantMasterDaoImpl merchantDao = new MerchantMasterDaoImpl();
		List<List<String>> merchantData = merchantDao.getMerchantDetails(merchantMasterForm.getSearchMid(),merchantMasterForm.getSearchMname());  // ifsc replace merchant Id
		if(merchantData != null && merchantData.size() > 1) { 
			List<String> headerNames =  merchantData.get(0);
			request.setAttribute("headerNames", headerNames);
			merchantData.remove(0);
		} else {
			merchantData = null;
			merchantMasterForm.setMessage("NoData");
		}
		
		request.setAttribute("merchantData", merchantData);
	}
	
	
}
