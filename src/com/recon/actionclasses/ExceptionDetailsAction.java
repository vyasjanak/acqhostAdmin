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
import org.json.JSONObject;

import com.recon.daoImpl.ExceptionDetailDaoImpl;
import com.recon.formclasses.ExceptionDetailForm;
import com.recon.utils.GenericUtils;
import com.recon.utils.NPCIXMLParser;

/**
 * Servlet implementation class exceptiontype
 */
public class ExceptionDetailsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException 
	{	
		ExceptionDetailForm exceptionDetailForm = (ExceptionDetailForm) form;
		
		String actionName = exceptionDetailForm.getActionName();	
		
		System.out.println("ExceptionDetailsAction.java ::: actionName  :: "+actionName);
		
		if(actionName != null && !actionName.isEmpty())
		{			
			JSONObject jsonObject = null;
			List<List<String>> walletInfo = null;
			List<String> headerNames = null;
			List<String> walletData = null;			
			
			String tagid = request.getParameter("tagid");
			String tid = request.getParameter("tid");
			String vno = request.getParameter("vehicle_no");
			String exce_type = request.getParameter("exce_type");
						
			System.out.println("ExceptionDetailsAction.java ::: tagid =  "+tagid+"    tid =  "+tid+"    vno  =  "+vno+"    exce_type  =  "+exce_type);
			
			ExceptionDetailDaoImpl obj = new ExceptionDetailDaoImpl();
			
			if(actionName.equalsIgnoreCase("SEARCH"))
			{
				jsonObject = obj.manageTagException(tagid, tid, vno, exce_type, actionName);
				
				if (jsonObject != null && jsonObject.has("resp_msg"))
				{
					if (jsonObject.getInt("status") != -1 && jsonObject.getInt("status") != 2)
					{
						if (jsonObject.getString("operation").equalsIgnoreCase("SEARCH"))
						{
							headerNames = new ArrayList<String>();
							headerNames.add("Id");
							headerNames.add("TAG ID");
							headerNames.add("Exception Code");
							headerNames.add("Message Id");
							headerNames.add("NPCI Updated Time");

							request.setAttribute("headerNames", headerNames);

							walletData = new ArrayList<String>();
							walletData.add(jsonObject.getString("id").toString());
							walletData.add(jsonObject.getString("tag_id").toString());
							walletData.add(jsonObject.getString("exe_code").toString());
							walletData.add(jsonObject.getString("msg_id").toString());
							walletData.add(jsonObject.getString("npci_updated_date").toString());

							walletInfo = new ArrayList<List<String>>();
							walletInfo.add(walletData);

							request.setAttribute("walletInfo", walletInfo);
						} 
						else 
						{
							exceptionDetailForm.setMessage("Error");
							request.setAttribute("getErrorMsg", "Invalid Opeartion Type ''"+jsonObject.getString("operation")+"' Received in Response.Only Search Operation is Allowed");
						}
					}
					else 
					{
						exceptionDetailForm.setMessage("Error");
						request.setAttribute("getErrorMsg", jsonObject.getString("resp_msg"));
					}
				}
				else 
				{
					exceptionDetailForm.setMessage("Error");
					request.setAttribute("getErrorMsg", "resp_msg field is missing in Response.");
				}				
			}
			else
			{
				if(tagid == null || tagid.isEmpty() || tid.equalsIgnoreCase("NA"))
				{
					if((tid != null && !tid.isEmpty()  && !tid.equalsIgnoreCase("NA")) || (vno != null && !vno.isEmpty() && !vno.equalsIgnoreCase("NA")))
					{
						tagid = obj.getTagId(tid,vno);				
					}
					else
					{
						System.out.println("ExceptionDetailsAction.java ::: Invalid Input Received : {"+tid+","+vno+"}");
					}
				}			
				
				if (tagid != null && !tagid.isEmpty() && !tagid.equalsIgnoreCase("NA"))
				{				
					//Add tag in NPCI MAPPER's Exception List
					String issuerSwitchUrl = GenericUtils.getPropertyValue("issuerSwitchUrl");
					String reqParams = "opid="+actionName+"&tagId="+tagid+"&seqNum=1"+"&excCode="+exce_type+"&ttype=ReqMngException";
					
					String respXML = GenericUtils.httpServerCall(issuerSwitchUrl, reqParams);	
					
					if(respXML != null)
					{
						try 
						{
							Map<String,String> parsedXml = new NPCIXMLParser().parseData(respXML);
							
							
							String npciRespResult = parsedXml.get("TxnRespTagResult");
							
							if(npciRespResult != null && npciRespResult.equalsIgnoreCase("SUCCESS"))
							{
								jsonObject = obj.manageTagException(tagid, tid, vno, exce_type, actionName);
								
								if (jsonObject != null && jsonObject.has("resp_msg"))
								{
									if (jsonObject.getInt("status") != -1 && jsonObject.getInt("status") != 2)
									{
										if (jsonObject.getString("operation").equalsIgnoreCase("ADD") || jsonObject.getString("operation").equalsIgnoreCase("REMOVE"))
										{
											exceptionDetailForm.setMessage("Resp");
											request.setAttribute("getRespMsg", jsonObject.getString("resp_msg"));
										} 
										else 
										{
											exceptionDetailForm.setMessage("Error");
											request.setAttribute("getErrorMsg", "Invalid Opeartion Type ''"+jsonObject.getString("operation")+"' Received in Response.Only ADD/DELETE Operation is Allowed");
										}
									}
									else 
									{
										exceptionDetailForm.setMessage("Error");
										request.setAttribute("getErrorMsg", jsonObject.getString("resp_msg"));
									}
								}
								else 
								{
									exceptionDetailForm.setMessage("Error");
									request.setAttribute("getErrorMsg", "ERROR!!!resp_msg field is missing in Response.");
								}
							}
							else
							{
								exceptionDetailForm.setMessage("Error");
								request.setAttribute("getErrorMsg", "Fail to "+actionName+" Tag in/from Exception List of NPCI MAPPER.");
							}							
						} 
						catch (Exception e)
						{							
							System.out.println("ExceptionDetailsAction.java ::: Error Occurred : "+e.getMessage());
							e.printStackTrace();
							exceptionDetailForm.setMessage("Error");
							request.setAttribute("getErrorMsg", "Somethimg went Wrong : "+e.getMessage());
						}
					}
					else
					{
						exceptionDetailForm.setMessage("Error");
						request.setAttribute("getErrorMsg", "Error while getting Response from NPCI.");
					}
				}
				else
				{
					System.out.println("ExceptionDetailsAction.java ::: Tag Id is Missing/Null/Blank/NA : "+tagid);
					exceptionDetailForm.setMessage("Error");
					request.setAttribute("getErrorMsg", "Could not process request to NPCI since Tag Id is Not Found.");
				}
			}							
		}
		
        return mapping.findForward("success");
	}
}
