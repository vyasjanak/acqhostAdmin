package com.recon.actionclasses;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.recon.formclasses.RequestDetailForm;
import com.recon.utils.GenericUtils;
import com.recon.utils.NPCIXMLParser;

public class RequestDetailsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		// System.out.println(" In RequestDetailsAction  ::::: ");
		/*HttpSession session = request.getSession(true);
		String UserName = session.getAttribute("username").toString();
		
		System.out.println("In RequestDetailsAction  User Name  :   "+UserName);*/
		
		RequestDetailForm requestDetailForm = (RequestDetailForm) form;
		
		// ExceptionDetailForm requestDetailForm = (ExceptionDetailForm) form;
		String actionName = requestDetailForm.getActionName();
		
		System.out.println("RequestDetailsAction.java ::: Action Name : "+actionName);
		String tagid = request.getParameter("tagid");
		String tid = request.getParameter("tid");
		String vno = request.getParameter("vehicle_no");
		
		if (actionName != null && actionName.equalsIgnoreCase("search"))
		{
			List<List<String>> vehicleInfo = null;
			List<String> headerNames = null;
			List<String> vehicleData = null;	
			
			System.out.println("RequestDetailsAction.java ::: In side If actionName =  "+actionName);
			System.out.println("RequestDetailsAction.java ::: tagid =  "+tagid+"    TID =  "+tid+"    vno  =  "+vno);
			
			String issuerSwitchUrl = GenericUtils.getPropertyValue("issuerSwitchUrl");
			String reqParams = "TID="+tid+"&tagId="+tagid+"&vehNo="+vno+"&ttype=tagDetails";
			
			String respXML = GenericUtils.httpServerCall(issuerSwitchUrl, reqParams);
			
			/*String respXML = "<Txn id=\"00000000001234560301\" note=\"\" orgTxnId=\"\" refId=\"\" refUrl=\"\" ts=\"2016-08-10T14:28:22\" type=\"FETCH\">"
					+"<Resp respCode=\"000\" result=\"SUCCESS\" successReqCnt=\"1\" totReqCnt=\"1\" ts=\"2016-08-10T19:57:02\">"
					+"<Vehicle errCode=\"000\">"
					+"<VehicleDetails>"
					+"<Detail name=\"TAGID\" value=\"34161FA82032D69802008A60\"/>"
					+"<Detail name=\"REGNUMBER\" value=\"ZZ00BB007\"/>"
					+"<Detail name=\"TID\" value=\"34161FA82032D69802008A60\"/>"
					+"<Detail name=\"VEHICLECLASS\" value=\"VC1\"/>"
					+"<Detail name=\"TAGSTATUS\" value=\"A\"/>"
					+"<Detail name=\"ISSUEDATE\" value=\"2016-06-11\"/>"
					+"<Detail name=\"EXCCODE\" value=\"01\"/>"
					+"<Detail name=\"BANKID\" value=\"617292\"/>"
					+"<Detail name=\"COMVEHICLE\" value=\"F\"/>"
					+"</VehicleDetails>"
					+"</Vehicle>"
					+"</Resp>"
					+"</Txn>";*/	
			
			if(respXML != null)
			{
				try 
				{
					Map<String,String> parsedXml = new NPCIXMLParser().parseData(respXML);								
					if(parsedXml != null && parsedXml.get("TxnRespresult").toString().equalsIgnoreCase("SUCCESS"))
					{
						parsedXml = new NPCIXMLParser().parseData(respXML.substring(respXML.indexOf("<Vehicle"),respXML.indexOf("</Vehicle>")+10));
						
						if(parsedXml != null && parsedXml.size() == 9)
						{
							headerNames = new ArrayList<String>();
							headerNames.add("TAGID");
							headerNames.add("TID");
							headerNames.add("REGNUMBER");
							headerNames.add("VEHICLECLASS");
							headerNames.add("TAGSTATUS");							
							headerNames.add("ISSUEDATE");
							headerNames.add("EXCCODE");
							headerNames.add("COMVEHICLE");						
							headerNames.add("BANKID");
	
							request.setAttribute("headerNames", headerNames);
	
							vehicleData = new ArrayList<String>();
							vehicleData.add(parsedXml.get("TAGID").toString());
							vehicleData.add(parsedXml.get("TID").toString());
							vehicleData.add(parsedXml.get("REGNUMBER").toString());
							vehicleData.add(parsedXml.get("VEHICLECLASS").toString());
							vehicleData.add(parsedXml.get("TAGSTATUS").toString());							
							vehicleData.add(parsedXml.get("ISSUEDATE").toString());
							vehicleData.add(parsedXml.get("EXCCODE").toString());									
							vehicleData.add(parsedXml.get("COMVEHICLE").toString());						
							vehicleData.add(parsedXml.get("BANKID").toString());
	
							vehicleInfo = new ArrayList<List<String>>();
							vehicleInfo.add(vehicleData);
	
							request.setAttribute("vehicleInfo", vehicleInfo);
						}
						else
						{
							requestDetailForm.setMessage("Error");
							request.setAttribute("getErrorMsg", "Error while parsing Vehicle Details.");
						}
					}
					else
					{
						requestDetailForm.setMessage("Error");
						request.setAttribute("getErrorMsg", "Error while parsing NPCI Response.");
					}
				} 
				catch (Exception e)
				{							
					System.out.println("RequestDetailsAction.java ::: Error Occurred : "+e.getMessage());
					e.printStackTrace();
					requestDetailForm.setMessage("Error");
					request.setAttribute("getErrorMsg", "Somethimg went Wrong : "+e.getMessage());
				}
			}
			else
			{
				requestDetailForm.setMessage("Error");
				request.setAttribute("getErrorMsg", "Error while getting Response from NPCI.");
			}
		}
		 
        return mapping.findForward("success");
	}
}
