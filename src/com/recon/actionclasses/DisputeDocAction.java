package com.recon.actionclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.DownloadAction;
import org.apache.struts.actions.DownloadAction.FileStreamInfo;
import org.apache.struts.upload.FormFile;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


import com.itextpdf.text.pdf.ByteBuffer;
import com.recon.dao.DisputeDao;
import com.recon.dao.DisputeRaiseDao;
import com.recon.entities.DisputeMaster;
import com.recon.formclasses.DisputeRaiseForm;

import com.recon.utils.GenericDateUtils;
import com.recon.utils.PropUtility;

public class DisputeDocAction extends DispatchAction
{
	List<DisputeMaster> disputetxnslist = null;
	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		return mapping.findForward("add");
	}
	
	public ActionForward getTransactionsUsingDate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
					
		System.out.println("DisputeDocAction---->");
			
		String from_date = disputeRaiseForm.getFrom_date();
		String to_date = disputeRaiseForm.getTo_date();
	
		DisputeRaiseDao disputeraiseDao = new DisputeRaiseDao();
		disputetxnslist = disputeraiseDao.getTransactionsByDate(from_date, to_date);
		if (!disputetxnslist.isEmpty())
		{
			request.setAttribute("disputetxnslist", disputetxnslist);
			System.out.println("List of between date disputed txns ::"+disputetxnslist);
			//disputeRaiseForm.setDisputeList(disputetxnslist);
			
			/*response.setContentType("application/csv");
			String csvFile = "dispute.csv";
	        FileWriter writer = new FileWriter(csvFile);
	        
	       // CSVUtils.writeLine(writer, Arrays.asList("a", "b", "c", "d"));
	        
	        writer.flush();
	        writer.close();*/
			
			disputeRaiseForm.reset();
			return mapping.findForward("add");
			
		}
		else
		{
			System.out.println("Between date Txns not found");
			request.setAttribute("datefailure", true);
			disputeRaiseForm.reset();
		}
		
		return mapping.findForward("add");
	}
	

	public void downloadCSV(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		//String conString = "000NGSB1830001";//000NGSB1830001 18207 00
		String bankParticipantId = PropUtility.getNameString("bankParticipantId");
		String date = new SimpleDateFormat("yyDDD").format(new Date());
		response.setContentType("text/csv");
        String fileName =  bankParticipantId+date+"00"+".csv";  
        
        try{
	        response.setHeader("Content-disposition", "attachment; " +
	                "filename=" + fileName);   
	        
	        ArrayList<String> rows = new ArrayList<String>();
	        rows.add("Tag_ID,Function_Code,Txn_Time,Txn_Id,Issuer_ID,Acquirer_ID,Txn_Amount,Reason_Code,Full_Partial_Indicator,Toll_Plaza_Id,TID,MMT,Internal Tracking Number");       
	        rows.add("\n");
	      
			System.out.println("DisputeDocAction---->downloadCSV()");
	        for(DisputeMaster dispute : disputetxnslist)
	        {
	        	rows.add(dispute.getTag_id()+","+dispute.getFunction_code()+","+dispute.getTxn_time()+","+dispute.getAcq_txn_id()+","+dispute.getIssuer_id()+","+dispute.getAcquirer_id()+","+
	        			dispute.getTxn_amount()+","+dispute.getReason_code()+","+dispute.getFull_par_indicator()+","+dispute.getToll_plaza_id()+","+dispute.getTid()+","+
	        			dispute.getMmt()+","+dispute.getToll_txn_id());
	        	rows.add("\n");
	        }
	        
	        Iterator<String> iter = rows.iterator();
	        while (iter.hasNext()){
	        	String outputString = (String) iter.next();
	        	response.getOutputStream().print(outputString);
	        }
	        response.getOutputStream().flush();
	        response.getOutputStream().close();
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	    //return mapping.findForward("add");
	}
}


