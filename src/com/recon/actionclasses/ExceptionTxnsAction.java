package com.recon.actionclasses;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.recon.formclasses.Txns;
import com.recon.utils.DBConnectionHandler;
import com.recon.dao.TxnsDao;

public class ExceptionTxnsAction extends DispatchAction
{
	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		Txns txnForm = (Txns) form;
		TxnsDao txnDao = new TxnsDao();
		System.out.println("In ExceptionTxnsAction Exception Transactions ...");
		List extxnslist = txnDao.getExceptionTransactions();
		if(!extxnslist.isEmpty())
		{
			//request.setAttribute("success", true);
			request.setAttribute("extxnslist", extxnslist);
			System.out.println("ExceptionTxnsAction.java List of Exception Transactions :: "+extxnslist.size());
			txnForm.reset();
			return mapping.findForward("add");
		}
		else
		{
			request.setAttribute("failure", true);
			System.out.println("ExceptionTxnsAction.java Exception Transactions list is empty");
		}
		return mapping.findForward("add");
		//return mapping.findForward("add");
	}
	
	
	public static String latestDate()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
        List<Date> dates = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
		
        String ondate;
        Date date=null;
        Date latest=null;
        String latestDate = null;
		try
		{
			String sql = "SELECT on_date FROM npci_recon_status";
			conn = new DBConnectionHandler().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
	        while (rs.next()) {
	        	ondate = (rs.getString(1));
	        	
	        	 date = originalFormat.parse(ondate);
			     System.out.println("Old Format :   " + originalFormat.format(date));
			     System.out.println("New Format :   " + targetFormat.format(date));
			     ondate = targetFormat.format(date);
	        	date = targetFormat.parse(ondate);
	        	System.out.println("date :"+date);
	        	dates.add(date);
	        }
		}
		catch(Exception e)
		{
			System.out.println("Error while getting date : "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try
			{  
				if (rs != null) 
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
        
		if(dates.isEmpty())
		{
			System.out.println("Dates are empty");
			//latestDate = "";
		}
		else
		{
			latest = Collections.max(dates);
			//date = df.format(latest);
			latestDate = df.format(latest);
			//latestDate = targetFormat.parse(date);
		}
        return latestDate;
	}
	
	public static void main(String[] args) {
		String latdate = latestDate();
		System.out.println("LAtest date "+latdate);
	}
}


