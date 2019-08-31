package com.recon.actionclasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

/*import com.recon.dao.AcqDisputeRaiseDao;
import com.recon.dao.DisputeDao;*/
import com.recon.dao.DisputeRaiseDao;
import com.recon.entities.AcqRequestPay;
//import com.recon.entities.AcqRequestPay;
import com.recon.entities.RequestPay;
import com.recon.formclasses.DisputeRaiseForm;
import com.recon.utils.GenericUtils;

public class DisputeRaiseAction extends DispatchAction
{
	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
		ArrayList reasonCodeList1 = new ArrayList();
		ArrayList reasonCodeList2 = new ArrayList();
		ArrayList reasonCodeList3 = new ArrayList();
		ArrayList reasonCodeList4 = new ArrayList();
		ArrayList reasonCodeList5 = new ArrayList();
		ArrayList reasonCodeList6 = new ArrayList();
		reasonCodeList1 = DisputeRaiseDao.getReasonList1();//list for debit chargeback
		reasonCodeList2 = DisputeRaiseDao.getReasonList2();//list for credit chargeback
		reasonCodeList3 = DisputeRaiseDao.getReasonList3();//list for re-presentment
		reasonCodeList4 = DisputeRaiseDao.getReasonList4();//list for debit adj
		reasonCodeList5 = DisputeRaiseDao.getReasonList5();//list for credit adj
		reasonCodeList6 = DisputeRaiseDao.getReasonList6();//list for Pre-compliance and Compliance
		disputeRaiseForm.setReasonCodeList1(reasonCodeList1);
		disputeRaiseForm.setReasonCodeList2(reasonCodeList2);
		disputeRaiseForm.setReasonCodeList3(reasonCodeList3);
		disputeRaiseForm.setReasonCodeList4(reasonCodeList4);
		disputeRaiseForm.setReasonCodeList5(reasonCodeList5);
		disputeRaiseForm.setReasonCodeList6(reasonCodeList6);
		
		return mapping.findForward("add");
	}

	public ActionForward searchTransactions(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
		HttpSession session = request.getSession();//for merchant id
		String userId = (String)session.getAttribute("username");
		String roleId = session.getAttribute("roleid").toString();
		
		System.out.println("DisputeRaiseAction---->searchTransactions()");
			
		String txn_id = disputeRaiseForm.getTxn_id();
		String tag_id = disputeRaiseForm.getTag_id();
		String vehicle_no = disputeRaiseForm.getVehicle_no();
		DisputeRaiseDao disputeraiseDao = new DisputeRaiseDao();
		//AcqDisputeRaiseDao disputeraiseDao = new AcqDisputeRaiseDao();
		if(!disputeraiseDao.isDisputed(txn_id, tag_id, vehicle_no))
		{
			List txns = disputeraiseDao.getTransactions(txn_id, tag_id, vehicle_no, userId);
			System.out.println("*********DisputeRaiseAction---->searchTransactions()*********"+txns);
			if (!txns.isEmpty())
			{
				request.setAttribute("success", true);
				request.setAttribute("txns", txns);
				
				disputeRaiseForm.reset();
			}
			else
			{
				System.out.println("Txns not found");
				request.setAttribute("failure", true);
				disputeRaiseForm.reset();
			}
		}
		else
		{
			System.out.println("Already raised dispute");
			request.setAttribute("failuredispute", true);
			disputeRaiseForm.reset();
		}
		ArrayList reasonCodeList1 = new ArrayList();
		ArrayList reasonCodeList2 = new ArrayList();
		ArrayList reasonCodeList3 = new ArrayList();
		ArrayList reasonCodeList4 = new ArrayList();
		ArrayList reasonCodeList5 = new ArrayList();
		ArrayList reasonCodeList6 = new ArrayList();
		reasonCodeList1 = DisputeRaiseDao.getReasonList1();//list for debit chargeback
		reasonCodeList2 = DisputeRaiseDao.getReasonList2();//list for credit chargeback
		reasonCodeList3 = DisputeRaiseDao.getReasonList3();//list for re-presentment
		reasonCodeList4 = DisputeRaiseDao.getReasonList4();//list for debit adj
		reasonCodeList5 = DisputeRaiseDao.getReasonList5();//list for credit adj
		reasonCodeList6 = DisputeRaiseDao.getReasonList6();//list for Pre-compliance and Compliance
		disputeRaiseForm.setReasonCodeList1(reasonCodeList1);
		disputeRaiseForm.setReasonCodeList2(reasonCodeList2);
		disputeRaiseForm.setReasonCodeList3(reasonCodeList3);
		disputeRaiseForm.setReasonCodeList4(reasonCodeList4);
		disputeRaiseForm.setReasonCodeList5(reasonCodeList5);
		disputeRaiseForm.setReasonCodeList6(reasonCodeList6);
		return mapping.findForward("add");
	}
	
	
	public ActionForward disputeTxnsDoc(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
		
		ArrayList reasonCodeList1 = new ArrayList();
		ArrayList reasonCodeList2 = new ArrayList();
		ArrayList reasonCodeList3 = new ArrayList();
		ArrayList reasonCodeList4 = new ArrayList();
		ArrayList reasonCodeList5 = new ArrayList();
		ArrayList reasonCodeList6 = new ArrayList();
		reasonCodeList1 = DisputeRaiseDao.getReasonList1();//list for debit chargeback
		reasonCodeList2 = DisputeRaiseDao.getReasonList2();//list for credit chargeback
		reasonCodeList3 = DisputeRaiseDao.getReasonList3();//list for re-presentment
		reasonCodeList4 = DisputeRaiseDao.getReasonList4();//list for debit adj
		reasonCodeList5 = DisputeRaiseDao.getReasonList5();//list for credit adj
		reasonCodeList6 = DisputeRaiseDao.getReasonList6();//list for Pre-compliance and Compliance
		disputeRaiseForm.setReasonCodeList1(reasonCodeList1);
		disputeRaiseForm.setReasonCodeList2(reasonCodeList2);
		disputeRaiseForm.setReasonCodeList3(reasonCodeList3);
		disputeRaiseForm.setReasonCodeList4(reasonCodeList4);
		disputeRaiseForm.setReasonCodeList5(reasonCodeList5);
		disputeRaiseForm.setReasonCodeList6(reasonCodeList6);
		
		String result = null;	
		String txn_id = null;
		System.out.println("DisputeRaiseAction.disputeTxnsDoc()---->");
		txn_id = disputeRaiseForm.getTxn_id();
		System.out.println("Transaction id on which raise a dispute : "+txn_id);
		String filePath = null;
		String dispute_desc = disputeRaiseForm.getReason();
		int amount = Integer.parseInt(disputeRaiseForm.getAmount().trim());
		System.out.println("dispute desc : "+dispute_desc );
		String function_code = null, reason_code = null, reason_code_type = null, full_par_indicator = null;//, remark=null;
		function_code = disputeRaiseForm.getFunction_code();
		reason_code = disputeRaiseForm.getReason_code();
		reason_code_type = disputeRaiseForm.getReason_code_type();
		full_par_indicator = disputeRaiseForm.getFull_par_indicator();
		//remark = disputeRaiseForm.getReason();
		System.out.println("Function code, Reason_code, Reason_code_type, FPIndicator ::"+function_code+" "+reason_code+" "+reason_code_type+" "+full_par_indicator);
		
		DisputeRaiseDao disputeRaiseDao = new DisputeRaiseDao();
		if(disputeRaiseForm.getFile().getFileSize()==0 || disputeRaiseForm.getFile()==null)
		{
			filePath = "NA";
		}
		else
		{
			FormFile file = disputeRaiseForm.getFile();
			System.out.println("File is : "+ file);
		
			String extension = file.getFileName().substring(file.getFileName().lastIndexOf(".")+1);
			String extension1 = file.getFileName().substring(file.getFileName().lastIndexOf("."));
			System.out.println("File extension is "+ extension);
			String fileName1 = txn_id+extension1;
			if(extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("jpeg"))
			{
				File newFile = getFilePath(file, extension1, txn_id); 
				System.out.println("File is "+ newFile);	
				String path = getServlet().getServletContext().getRealPath("/");
				filePath = path.split("webapps")[0]+File.separator+"disputedTxnsDocs"+File.separator+fileName1;
				System.out.println("Specified path in disputeTxnsDoc() :: "+filePath);
			}
			else 
			{
				System.out.println("Document should be in .jpg or .pdf format");
				request.setAttribute("formatfailure", true);
				disputeRaiseForm.reset();
			}
		}
		//result = disputeRaiseDao.saveDisputeTxn(acq_txn_id, toll_txn_id, toll_plaza_id, dispute_type, amount , adjustment_type, dispute_desc, filePath, "Open", GenericUtils.todaysDateTime());
		//result = disputeRaiseDao.addToDisputeMaster(original_txn_id, (float)amount, dispute_desc, filePath, GenericUtils.todaysDateTime());
		result = disputeRaiseDao.addToDisputeMaster(txn_id, amount, dispute_desc, filePath, GenericUtils.todaysDateTime(), function_code, reason_code, reason_code_type, full_par_indicator);//, remark);
		if (result.equalsIgnoreCase("success"))
		{
			System.out.println("Dispute raised successfully");
			request.setAttribute("uploadsuccess", true);
			disputeRaiseForm.reset();
		}
		else
		{
			System.out.println("Dispute can not be raised & Documents can not be upload, please check file type, size etc");
			request.setAttribute("uploadfailure", true);
			disputeRaiseForm.reset();
		}
		
		return mapping.findForward("add");
	}
	
	
	
	private File getFilePath(FormFile formfile, String extension, String original_txn_id) throws IOException {
		//Get the servers upload directory real path name
		File file = null;
	    String path = getServlet().getServletContext().getRealPath("/");
		String filePath = path.split("webapps")[0]+File.separator+"disputedTxnsDocs";
	    //create the upload folder if not exists
	    File folder = new File(filePath);
	    if(!folder.exists()){
	    	folder.mkdir();
	    }
	    
	    String fileName = formfile.getFileName();
	    
	    System.out.println("File name is as ::"+fileName);
	    String fileName1 = original_txn_id+extension;
	    System.out.println("New File name will be ::"+fileName1);
	    
	    
	    if(!("").equals(fileName)){  
	    	
	        System.out.println("Server path:" +filePath);
	        File newFile = new File(filePath, fileName1);
              
	        if(newFile.exists()){
	        	newFile.delete();
	        }
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(formfile.getFileData());
            fos.flush();
            fos.close();
	          
	        file = newFile;
	        System.out.println("uploadedFilePath--->"+newFile.getAbsoluteFile());
	        System.out.println("uploadedFileName---->"+newFile.getName());
	    }
	    
	    return file;
	}
}


