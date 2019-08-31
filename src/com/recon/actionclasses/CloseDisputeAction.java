package com.recon.actionclasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.recon.dao.DisputeDao;
import com.recon.dao.DisputeRaiseDao;
import com.recon.entities.RequestPay;
import com.recon.formclasses.DisputeRaiseForm;
import com.recon.utils.GenericDateUtils;

public class CloseDisputeAction extends DispatchAction
{
	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		/*DisputeRaiseDao disputeRaiseDao=new DisputeRaiseDao();
		List disputetxnslist = null;
		disputetxnslist = disputeRaiseDao.getDisputeTxns();
		System.out.println("Dipsuted txns ::"+disputetxnslist);
		request.setAttribute("disputetxnslist", disputetxnslist);*/
		return mapping.findForward("add");
	}
	
	
	public ActionForward getTransactionsUsingDate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
					
		System.out.println("CloseDisputeAction---->");
			
		String from_date = disputeRaiseForm.getFrom_date();
		String to_date = disputeRaiseForm.getTo_date();
	
		DisputeRaiseDao disputeraiseDao = new DisputeRaiseDao();
		List disputetxnslist = disputeraiseDao.getTransactionsByDate(from_date, to_date);
		if (!disputetxnslist.isEmpty())
		{
			request.setAttribute("disputetxnslist", disputetxnslist);
			System.out.println("List of between date disputed txns ::"+disputetxnslist);
			disputeRaiseForm.reset();
		}
		else
		{
			System.out.println("Between date Txns not found");
			request.setAttribute("datefailure", true);
			disputeRaiseForm.reset();
		}
		
		return mapping.findForward("add");
	}
	
	public ActionForward updateTransactionStatus(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
					
		System.out.println("CloseDisputeAction---->updateTransactionStatus()");
		String acqTxnId = disputeRaiseForm.getAcq_txn_id();
		String amount = disputeRaiseForm.getTxn_amount();
		amount = amount.substring(0,amount.length()-2);
		System.out.println("Acq txn Id :: "+acqTxnId);
		DisputeRaiseDao disputeraiseDao = new DisputeRaiseDao();
		String result = disputeraiseDao.updateTransaction(disputeRaiseForm.getId());
		if (result.equalsIgnoreCase("success") && acqTxnId!=null && amount!=null)
		{
			disputeraiseDao.addToRecon(acqTxnId, amount);
			request.setAttribute("success", true);
			System.out.println("Status updated successfully :: updateTransactionStatus()");
			disputeRaiseForm.reset();
		}
		else
		{
			System.out.println("Status can not be updated, Something is wrong please check");
			request.setAttribute("failure", true);
			disputeRaiseForm.reset();
		}
		
		return mapping.findForward("add");
	}
	
}


