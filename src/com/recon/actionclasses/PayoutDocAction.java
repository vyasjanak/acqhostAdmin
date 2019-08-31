package com.recon.actionclasses;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.recon.dao.DisputeRaiseDao;
import com.recon.daoImpl.payoutDAOImpl;
import com.recon.formclasses.DisputeRaiseForm;
import com.recon.formclasses.PayoutGenerationForm;

public class PayoutDocAction extends DispatchAction{
	

	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		/*String fileName = request.getParameter("fileName");
		String filePath = "E:/PG/Apr-May/disputedTxnsDocs/"; //+File.separator+fileName;
		//request.setAttribute("filePath", filePath);
		
		File file1 = new File(filePath);
        //File[] files = file1.listFiles();
        List fileList = new ArrayList<>();
        File[] files = file1.listFiles();
        for(File f: files){
        	fileList.add(f.getName());
            System.out.println("List of files ::"+f.getName());
        }
        request.setAttribute("fileList", fileList);*/
		
		/*DisputeRaiseDao disputeRaiseDao=new DisputeRaiseDao();
		List disputetxnslist = null;
		disputetxnslist = disputeRaiseDao.getDisputeDoc();
		System.out.println("Dipsuted docs ::"+disputetxnslist);
		request.setAttribute("disputetxnslist", disputetxnslist);*/
		
		return mapping.findForward("add");
	}
	
	public ActionForward getTransactionsUsingDate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		//DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
		PayoutGenerationForm payoutgenerationForm =(PayoutGenerationForm) form ;
					
		System.out.println("DownloadPayoutAction---->");
			
		String from_date = payoutgenerationForm.getFrom_date();
		String to_date = payoutgenerationForm.getTo_date();
		payoutDAOImpl plazadao = new payoutDAOImpl();
		plazadao.payoutDetailsUpdate();
		if(from_date !=null && to_date !=null){
			boolean result;
			result =plazadao.insertPayoutData(from_date ,to_date);
			String output =result ? "Inserted Successufuly " : "Not Inserted ";
			System.out.println(output);
		}
	
		System.out.println("from_date ::"+from_date + " to_date ::"+to_date);
		DisputeRaiseDao disputeraiseDao = new DisputeRaiseDao();
		List disputetxnslist = disputeraiseDao.getPayoutByDate(from_date, to_date);
		if (!disputetxnslist.isEmpty())
		{
			request.setAttribute("disputetxnslist", disputetxnslist);
			System.out.println("List of between date disputed txns ::"+disputetxnslist);
			//disputeRaiseForm.setDisputeList(disputetxnslist);
			payoutgenerationForm.reset();
			//plazadao.payoutDetailsUpdaet();
			return mapping.findForward("add");
			
		}
		else
		{
			System.out.println("Between date Txns not found");
			request.setAttribute("datefailure", true);
			payoutgenerationForm.reset();
		}
		//plazadao.payoutDetailsUpdaet();
		return mapping.findForward("add");
	}
	

	public ActionForward downloadDoc(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		System.out.println("In downloadDoc");
		return mapping.findForward("add");
	}
	


}
