package com.recon.actionclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.recon.daoImpl.GetReportDao;
import com.recon.formclasses.ReportForm;
import com.recon.service.ReportService;
import com.recon.serviceImpl.ReportServiceImpl;

public class ReportAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		ReportForm reportForm = (ReportForm) form;
		String toDate = request.getParameter("to_date");	
		String fromDate = request.getParameter("from_date");
		String rep = request.getParameter("rep");
		
		System.out.println("ReportAction :::   ID  :::  "+rep+"   toDate ::: "+toDate +"   fromDate ::: "+fromDate);
		
		session.setAttribute("rep", rep);
		request.setAttribute("rep", rep);
		
		
		GetReportDao obj = new GetReportDao();
	       
		List<List<String>> result = obj.getData(rep,toDate,fromDate);
		
		if (result != null && result.size() >=1) {
			List<String> assign_value = result.get(0);
			String valueDisplay = assign_value.toString();
			String DisplayName = valueDisplay.substring(1, valueDisplay.length()-1);
			
			request.setAttribute("DisplayName", DisplayName);
			
			System.out.println(" Getting DisplayName  : " +result.get(0));
			System.out.println(" DisplayName =  "+DisplayName);
			result.remove(0);
		}
		
		
			if (result != null && result.size() >=1) {
			List<String> headerNames = result.get(0);
			
			request.setAttribute("headerNames", headerNames);
			System.out.println(" headerNames : " +result.get(0));
			result.remove(0);
		}
		/*	for(int i = 0; i< result.size() ; i++)
			{
				System.out.println(" values : " +result.get(i));
			}
		*/
		// System.out.println(" Result values : " +result);
		request.setAttribute("resultData", result);
	
		
		
		return mapping.findForward("success");
	}
	
	
}
