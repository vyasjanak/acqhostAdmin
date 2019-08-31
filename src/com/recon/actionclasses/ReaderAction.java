
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


import com.recon.daoImpl.ReaderDAOImpl;
import com.recon.daoImpl.plazaDAOImpl;
import com.recon.entities.DropdownBean;
import com.recon.entities.Reader;
import com.recon.formclasses.ReaderForm;
import com.recon.utils.AuditTrail;
import com.recon.utils.DBConnectionHandler;



public class ReaderAction extends Action {

	private static final ReaderForm Form = null;

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		
		HttpSession session = request.getSession(true);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String status = null;
		
		ReaderDAOImpl readerDao = new ReaderDAOImpl();
		List<DropdownBean> tollids = readerDao.getTollIds();
		request.setAttribute("tollids", tollids);
		
		ReaderForm readerForm = (ReaderForm) form ;
		
		
		
		
		String action = readerForm.getActionName();
		String readerId = readerForm.getReaderId();
		String isActive = readerForm.getIsActive();
		String tollPlazaId = readerForm.getTollplazaId();
		String laneId = readerForm.getLaneId();		
		String createdOn = timestamp.toString();
		String createdBy = (String)session.getAttribute("username");
		String approvedOn = "0";
		String approvedBy = (String)session.getAttribute("username");
		
		if(action != null){
			if(action.equalsIgnoreCase("add")){	
				
				Reader read = new Reader();
				read.setReaderId(readerId);
				read.setTollplazaId(tollPlazaId);
				read.setLaneId(laneId);
				read.setIsActive(isActive);
				read.setCreatedOn(createdOn);
				read.setCreatedBy(createdBy);
				read.setApprovedOn(approvedOn);
				read.setApprovedBy(approvedBy);	
			//	read.setId(Id);
				String msg =null;
				status = readerDao.addReader(read);
				if(status.equals("1")){
					msg = "SE";
					
					Map hm = new HashMap();
					hm.put("TOLLPLAZAID", tollPlazaId);
					hm.put("READERID", readerId);
					hm.put("LANEID", laneId);
					
					hm.put("STATUS", "SUCCESS");
					
					Connection con = DBConnectionHandler.getConnection();
					AuditTrail auditTrail = new AuditTrail();
					auditTrail.addAuditData(con, createdBy, readerId, "ADDREADER","ADDSUCCESS", hm); 
				}
				else{
					msg = "EE";
				}	
				readerForm.setMessage(msg);		
				// return mapping.findForward("success");
			}
		}
		else{
				// return mapping.findForward("fail");
		}		
	
		
		
		List<List<String>> readerData = readerDao.getReaderDetails();  // Showing Data
 		if(readerData != null && readerData.size() > 1) { 
 			List<String> headerNames =  readerData.get(0);
 			System.out.println("Header Name Reader Master ::: "+headerNames);
 			request.setAttribute("headerNames", headerNames);
 			readerData.remove(0);
 		} else {
 			readerData = null;
 			readerForm.setMessage("NoData");
 		}
 		
 		request.setAttribute("readerData", readerData);
 		
		return mapping.findForward("success");
	}
}
